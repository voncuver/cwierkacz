package com.tguzik.cwierkacz.configuration.reader;

import java.io.File;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;

@Threadsafe
public class ConfigurationReader
{
    private static final ImmutableList<String> CONFIGURATION_FILES = ImmutableList.of("database.xml", "jobs.xml",
                                                                                      "processors.xml", "xmlserver.xml");
    private final String configurationDirectory;
    private final XStreamConfigurationParser parser;

    public ConfigurationReader( String configurationDirectory ) {
        this.configurationDirectory = configurationDirectory;
        this.parser = new XStreamConfigurationParser();
    }

    public CwierkaczConfiguration read( ) {
        CwierkaczConfiguration configuration = new CwierkaczConfiguration();

        for ( String file : CONFIGURATION_FILES ) {
            parser.parse(constructPath(file), configuration);
        }

        return configuration;
    }

    File constructPath( String filename ) {
        return new File(configurationDirectory + filename);
    }
}
