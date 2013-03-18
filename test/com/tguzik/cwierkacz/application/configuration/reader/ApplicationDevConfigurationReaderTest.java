package com.tguzik.cwierkacz.application.configuration.reader;

import static com.google.common.collect.ImmutableList.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.application.configuration.CacheConfiguration;
import com.tguzik.cwierkacz.application.configuration.CacheRegionConfiguration;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.application.configuration.DatabaseConfiguration;
import com.tguzik.cwierkacz.application.configuration.InterfaceConfiguration;
import com.tguzik.cwierkacz.application.configuration.JobsConfiguration;
import com.tguzik.cwierkacz.application.configuration.ProcessorsConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleJobConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleProcessorConfiguration;
import com.tguzik.cwierkacz.application.configuration.ThreadPoolConfiguration;
import com.tguzik.cwierkacz.cache.loader.NoOperationDataObjectLoader;
import com.tguzik.cwierkacz.processing.postprocessor.artifacts.ArtifactsProcessor;
import com.tguzik.cwierkacz.processing.postprocessor.email.EmailNotificationProcessor;
import com.tguzik.cwierkacz.processing.postprocessor.history.HistoryProcessor;
import com.tguzik.cwierkacz.processing.preprocessor.credentials.CredentialsValidationProcessor;
import com.tguzik.cwierkacz.processing.processor.account.AccountCreatorProcessor;
import com.tguzik.cwierkacz.processing.processor.account.AccountDeletionProcessor;
import com.tguzik.cwierkacz.processing.processor.account.AccountModificationProcessor;
import com.tguzik.cwierkacz.processing.processor.twitter.FetcherProcessor;
import com.tguzik.cwierkacz.processing.processor.twitter.PosterProcessor;

public class ApplicationDevConfigurationReaderTest
{
    private static final String PATH = "conf/dev/";

    @Test
    public void testReading( ) {
        CwierkaczConfiguration configuration = new ConfigurationReader(PATH).read();
        assertNotNull(configuration);
    }

    @Test
    public void testCacheConfiguration( ) {
        CacheConfiguration conf = read("cwierkacz.xml").getCache();
        assertNotNull(conf);

        assertEquals(2, conf.getRegionConfigs().size());
        verifyCacheConfiguration(conf.getRegionConfigs().get(0), "DEFAULT", 5000, true, true, false);
        verifyCacheConfiguration(conf.getRegionConfigs().get(1), "TWEETS", 20000, null, null, null);
    }

    private void verifyCacheConfiguration( CacheRegionConfiguration conf, String name, Integer maxObjects,
                                           Boolean cacheable, Boolean preloadable, Boolean disabled ) {
        assertNotNull(conf);
        assertEquals(name, conf.getName());
        assertEquals(maxObjects, conf.getMaxObjects());
        assertEquals(cacheable, conf.isCacheable());
        assertEquals(preloadable, conf.isPreloadable());
        assertEquals(disabled, conf.isDisabled());
    }

    @Test
    public void testDatabaseConfiguration( ) {
        DatabaseConfiguration conf = read("database.xml").getDatabase();

        assertNotNull(conf);

        assertEquals("localhost", conf.getUrl());
        assertEquals("db", conf.getUsername());
        assertEquals("password", String.valueOf(conf.getPassword()));
        assertEquals("CWIERKACZ", conf.getServiceName());
        assertEquals(NoOperationDataObjectLoader.class, conf.getDefaultDataLoader());
    }

    @Test
    public void testJobsConfiguration( ) {

        JobsConfiguration conf = read("jobs.xml").getJobs();
        assertNotNull(conf);

        assertEquals(5, conf.getJobs().size());
        verifySingleJob(conf.getJobs().get(0), "CREATE-SYSTEM-ACCOUNT", of(AC, SOH, SA, EN), EMPTYMAP);
        verifySingleJob(conf.getJobs().get(1), "MODIFY-SYSTEM-ACCOUNT", of(CV, AM, SOH, SA), EMPTYMAP);
        verifySingleJob(conf.getJobs().get(2), "DELETE-SYSTEM-ACCOUNT", of(CV, AD, SOH, SA), EMPTYMAP);
        verifySingleJob(conf.getJobs().get(3), "POST-TWEET", of(CV, TP, SOH, SA), EMPTYMAP);
        verifySingleJob(conf.getJobs().get(4), "FETCH-TWEETS", of(CV, TF, SOH, SA), EMPTYMAP);
    }

    private void verifySingleJob( SingleJobConfiguration job, String name, List<String> lifecycle,
                                  Map<String, String> properties ) {
        assertEquals(name, job.getName());
        assertEquals(lifecycle, job.getLifecycleStageNames());
        assertEquals(properties, job.getProperties());
    }

    @Test
    public void testProcessorsConfiguration( ) {
        ProcessorsConfiguration conf = read("processors.xml").getProcessors();
        assertNotNull(conf);

        assertEquals(9, conf.getProcessors().size());
        verifySingleProcessor(conf.getProcessors().get(0), CV, CredentialsValidationProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(1),
                              EN,
                              EmailNotificationProcessor.class,
                              ImmutableMap.<String, String> builder().put("smtpserver", "localhost")
                                          .put("smtpport", "12345").put("smtplogin", "automation")
                                          .put("smtppassword", "password").build());
        verifySingleProcessor(conf.getProcessors().get(2), SA, ArtifactsProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(3), SOH, HistoryProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(4), AC, AccountCreatorProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(5), AM, AccountModificationProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(6), AD, AccountDeletionProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(7), TP, PosterProcessor.class, EMPTYMAP);
        verifySingleProcessor(conf.getProcessors().get(8), TF, FetcherProcessor.class, EMPTYMAP);

    }

    private void verifySingleProcessor( SingleProcessorConfiguration conf, String name, Class<?> clazz,
                                        Map<String, String> properties ) {
        assertEquals(name, conf.getName());
        assertEquals(clazz, conf.getClazz());
        assertEquals(properties, conf.getProperties());
    }

    @Test
    public void testThreadPoolConfiguration( ) {
        ThreadPoolConfiguration conf = read("cwierkacz.xml").getThreadPool();
        assertNotNull(conf);

        assertEquals(10, conf.getMinPoolSize());
        assertEquals(100, conf.getMaxPoolSize());
        assertEquals(30, conf.getKeepAliveSeconds());
    }

    @Test
    public void testInterfaceConfiguration( ) {
        InterfaceConfiguration conf = read("cwierkacz.xml").getInterfaces();
        assertNotNull(conf);

        assertEquals(2, conf.getInterfaces().size());
        verifyInterfaceConfig(conf.getInterfaces().get(0),
                              "XmlServer",
                              (short) 3030,
                              true,
                              ImmutableMap.<String, String> builder().put("schema", "conf/schema/XmlRequestSchema.xsl")
                                          .build());
        verifyInterfaceConfig(conf.getInterfaces().get(1), "ProtobufServer", (short) 6060, true, EMPTYMAP);
    }

    private void verifyInterfaceConfig( SingleInterfaceConfiguration sic, String name, short portNumber,
                                        boolean enabled, Map<String, String> properties ) {
        assertNotNull(sic);
        assertEquals(name, sic.getName());
        assertEquals(portNumber, sic.getPortNumber());
        assertEquals(enabled, sic.isEnabled());
        assertEquals(properties, sic.getProperties());
    }

    private CwierkaczConfiguration read( String filename ) {
        File file = new File(PATH + filename);
        return (CwierkaczConfiguration) ( new XStreamConfigurationParser().parse(file) );
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
