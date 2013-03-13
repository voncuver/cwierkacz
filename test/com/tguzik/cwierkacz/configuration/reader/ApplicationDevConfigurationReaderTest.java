package com.tguzik.cwierkacz.configuration.reader;

import static com.google.common.collect.ImmutableList.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.configuration.DatabaseConfiguration;
import com.tguzik.cwierkacz.configuration.JobsConfiguration;
import com.tguzik.cwierkacz.configuration.ProcessorsConfiguration;
import com.tguzik.cwierkacz.configuration.SingleJobConfiguration;
import com.tguzik.cwierkacz.configuration.SingleProcessorConfiguration;
import com.tguzik.cwierkacz.configuration.TableCacheConfiguration;
import com.tguzik.cwierkacz.configuration.XmlServerConfiguration;
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
    public void testDatabaseConfiguration( ) {
        DatabaseConfiguration conf = read("database.xml").getDatabaseConfiguration();
        assertNotNull(conf);

        assertEquals("localhost", conf.getUrl());
        assertEquals("db", conf.getUsername());
        assertEquals("password", String.valueOf(conf.getPassword()));
        assertEquals("CWIERKACZ", conf.getServiceName());

        assertEquals(2, conf.getCacheConfig().size());
        verifyCacheConfiguration(conf.getCacheConfig().get(0), "DEFAULT", 5000, true);
        verifyCacheConfiguration(conf.getCacheConfig().get(1), "TWEETS", 20000, false);
    }

    private void verifyCacheConfiguration( TableCacheConfiguration conf, String name, int maxObjects, boolean cacheable ) {
        assertNotNull(conf);
        assertEquals(name, conf.getName());
        assertEquals(maxObjects, conf.getMaxObjects());
        assertEquals(cacheable, conf.isCacheable());
    }

    @Test
    public void testJobsConfiguration( ) {

        JobsConfiguration conf = read("jobs.xml").getJobsConfiguration();
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
        ProcessorsConfiguration conf = read("processors.xml").getProcessorsConfiguration();
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
    public void testXmlServerConfiguration( ) {
        XmlServerConfiguration conf = read("xmlserver.xml").getXmlServerConfiguration();
        assertNotNull(conf);

        assertEquals(3030, conf.getPortNumber());
        assertEquals(true, conf.isXmlValidation());
        assertEquals("conf/schema/XmlRequestSchema.xsl", conf.getSchemaLocation());
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
