package com.tguzik.cwierkacz.configuration.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

import com.tguzik.cwierkacz.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.configuration.DatabaseConfiguration;
import com.tguzik.cwierkacz.configuration.JobsConfiguration;
import com.tguzik.cwierkacz.configuration.ProcessorsConfiguration;
import com.tguzik.cwierkacz.configuration.TableCacheConfiguration;
import com.tguzik.cwierkacz.configuration.XmlServerConfiguration;

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
        // verifySingleJob...
    }

    @Test
    public void testProcessorsConfiguration( ) {
        ProcessorsConfiguration conf = read("processors.xml").getProcessorsConfiguration();
        assertNotNull(conf);

        assertEquals(9, conf.getProcessors().size());
        // verifySingleProcessor...
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

}
