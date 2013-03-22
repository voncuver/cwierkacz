package com.tguzik.cwierkacz.common.configuration.reader;

import static com.google.common.collect.ImmutableList.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.loader.SqlDataObjectLoader;
import com.tguzik.cwierkacz.common.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.common.configuration.CacheConfiguration;
import com.tguzik.cwierkacz.common.configuration.CacheRegionConfiguration;
import com.tguzik.cwierkacz.common.configuration.InterfaceConfiguration;
import com.tguzik.cwierkacz.common.configuration.JobsConfiguration;
import com.tguzik.cwierkacz.common.configuration.ProcessorsConfiguration;
import com.tguzik.cwierkacz.common.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.common.configuration.SingleJobConfiguration;
import com.tguzik.cwierkacz.common.configuration.SingleProcessorConfiguration;
import com.tguzik.cwierkacz.common.configuration.ThreadPoolConfiguration;
import com.tguzik.cwierkacz.common.configuration.reader.ConfigurationReader;
import com.tguzik.cwierkacz.common.configuration.reader.XStreamConfigurationParser;
import com.tguzik.cwierkacz.component.postprocessor.artifacts.ArtifactsProcessor;
import com.tguzik.cwierkacz.component.postprocessor.email.EmailNotificationProcessor;
import com.tguzik.cwierkacz.component.postprocessor.history.HistoryProcessor;
import com.tguzik.cwierkacz.component.preprocessor.credentials.CredentialsValidationProcessor;
import com.tguzik.cwierkacz.component.processor.account.AccountCreatorProcessor;
import com.tguzik.cwierkacz.component.processor.account.AccountDeletionProcessor;
import com.tguzik.cwierkacz.component.processor.account.AccountModificationProcessor;
import com.tguzik.cwierkacz.component.processor.twitter.FetcherProcessor;
import com.tguzik.cwierkacz.component.processor.twitter.PosterProcessor;

public class ApplicationDevConfigurationReaderTest
{
    private static final String PATH = "conf/dev/";

    @Test
    public void testReading( ) {
        ApplicationConfiguration configuration = new ConfigurationReader(PATH).read();
        assertNotNull(configuration);
    }

    @Test
    public void testCacheConfiguration( ) {
        CacheConfiguration conf = read("cwierkacz.xml").getCacheConfiguration();
        assertNotNull(conf);

        assertEquals(2, conf.getRegionConfigs().size());
        verifyCacheConfig(conf.getRegionConfigs().get(0),
                          "DEFAULT",
                          5000,
                          true,
                          true,
                          false,
                          SqlDataObjectLoader.class);
        verifyCacheConfig(conf.getRegionConfigs().get(1), "TWEETS", 20000, null, null, null, null);
    }

    private void verifyCacheConfig( CacheRegionConfiguration conf,
                                    String name,
                                    Integer maxObjects,
                                    Boolean cacheable,
                                    Boolean preloadable,
                                    Boolean disabled,
                                    Class<?> dataLoader ) {
        assertNotNull(conf);
        assertEquals(name, conf.getName());
        assertEquals(maxObjects, conf.getMaxObjects());
        assertEquals(cacheable, conf.isCacheable());
        assertEquals(preloadable, conf.isPreloadable());
        assertEquals(disabled, conf.isDisabled());
        assertEquals(dataLoader, conf.getDataLoader());
    }

    @Test
    public void testMyBatisFactoryConfiguration( ) throws IOException {
        SqlSessionFactory session = new ConfigurationReader(PATH).getMyBatisSessionFactory();
        assertNotNull(session);
    }

    @Test
    public void testJobsConfiguration( ) {

        JobsConfiguration conf = read("jobs.xml").getJobConfigurations();
        assertNotNull(conf);

        assertEquals(5, conf.getJobs().size());
        verifySingleJob(conf.getJobs().get(0), "CREATE-SYSTEM-ACCOUNT", of(AC, SOH, SA, EN), EMPTYMAP);
        verifySingleJob(conf.getJobs().get(1), "MODIFY-SYSTEM-ACCOUNT", of(CV, AM, SOH, SA), EMPTYMAP);
        verifySingleJob(conf.getJobs().get(2), "DELETE-SYSTEM-ACCOUNT", of(CV, AD, SOH, SA), EMPTYMAP);
        verifySingleJob(conf.getJobs().get(3), "POST-TWEET", of(CV, TP, SOH, SA), EMPTYMAP);
        verifySingleJob(conf.getJobs().get(4), "FETCH-TWEETS", of(CV, TF, SOH, SA), EMPTYMAP);
    }

    private void verifySingleJob( SingleJobConfiguration job,
                                  String name,
                                  List<String> lifecycle,
                                  Map<String, String> properties ) {
        assertEquals(name, job.getName());
        assertEquals(lifecycle, job.getLifecycleStageNames());
        assertEquals(properties, job.getProperties());
    }

    @Test
    public void testProcessorsConfiguration( ) {
        ProcessorsConfiguration conf = read("processors.xml").getProcessorConfigurations();
        assertNotNull(conf);

        assertEquals(9, conf.getProcessors().size());
        verifySingleProcessor(conf.getProcessors().get(0), CV, CredentialsValidationProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(1),
                              EN,
                              EmailNotificationProcessor.class,
                              ImmutableMap.<String, String> builder()
                                          .put("smtpserver", "localhost")
                                          .put("smtpport", "12345")
                                          .put("smtplogin", "automation")
                                          .put("smtppassword", "password")
                                          .build());
        verifySingleProcessor(conf.getProcessors().get(2), SA, ArtifactsProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(3), SOH, HistoryProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(4), AC, AccountCreatorProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(5), AM, AccountModificationProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(6), AD, AccountDeletionProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(7), TP, PosterProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(8), TF, FetcherProcessor.class, EMPTYMAP);

    }

    private void verifySingleProcessor( SingleProcessorConfiguration conf,
                                        String name,
                                        Class<?> clazz,
                                        Map<String, String> properties ) {
        assertEquals(name, conf.getName());
        assertEquals(clazz, conf.getClazz());
        assertEquals(properties, conf.getProperties());
    }

    @Test
    public void testMainThreadPoolConfiguration( ) {
        ThreadPoolConfiguration conf = read("cwierkacz.xml").getMainThreadPoolConfiguration();
        assertNotNull(conf);

        assertEquals(10, conf.getMinPoolSize());
        assertEquals(100, conf.getMaxPoolSize());
        assertEquals(30, conf.getKeepAliveSeconds());
    }

    @Test
    public void testEndpointThreadPoolConfiguration( ) {
        ThreadPoolConfiguration conf = read("cwierkacz.xml").getEndpointThreadPoolConfiguration();
        assertNotNull(conf);

        assertEquals(5, conf.getMinPoolSize());
        assertEquals(100, conf.getMaxPoolSize());
        assertEquals(30, conf.getKeepAliveSeconds());
    }

    @Test
    public void testInterfaceConfiguration( ) {
        InterfaceConfiguration conf = read("cwierkacz.xml").getInterfaceConfigurations();
        assertNotNull(conf);

        assertEquals(1, conf.getInterfaces().size());
        verifyInterfaceConfig(conf.getInterfaces().get(0),
                              "XmlServer",
                              (short) 3030,
                              true,
                              ImmutableMap.<String, String> builder()
                                          .put("schema", "conf/schema/XmlRequestSchema.xsl")
                                          .build());
    }

    private void verifyInterfaceConfig( SingleInterfaceConfiguration sic,
                                        String name,
                                        short portNumber,
                                        boolean enabled,
                                        Map<String, String> properties ) {
        assertNotNull(sic);
        assertEquals(name, sic.getName());
        assertEquals(portNumber, sic.getPortNumber());
        assertEquals(enabled, sic.isEnabled());
        assertEquals(properties, sic.getProperties());
    }

    private ApplicationConfiguration read( String filename ) {
        File file = new File(PATH + filename);
        return (ApplicationConfiguration) ( new XStreamConfigurationParser().parse(file) );
    }

    static final String AC = "ACCOUNT-CREATION";
    static final String AM = "ACCOUNT-MODIFICATION";
    static final String AD = "ACCOUNT-DELETION";
    static final String CV = "CREDENTIALS-VALIDATION";
    static final String EN = "EMAIL-NOTIFICATION";
    static final String SA = "SAVE-ARTIFACTS";
    static final String SOH = "SAVE-OPERATION-HISTORY";
    static final String TP = "TWEET-POSTER";
    static final String TF = "TWEET-FETCHER";

    static final Map<String, String> EMPTYMAP = ImmutableMap.of();
}
