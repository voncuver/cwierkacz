package com.tguzik.cwierkacz.application.configuration.reader;

import java.io.File;
import java.nio.file.Paths;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;

@Threadsafe
public class ConfigurationReader
{
    private static final ImmutableList<String> CONFIGURATION_FILES = ImmutableList.of("cwierkacz.xml",
                                                                                      "database.xml",
                                                                                      "jobs.xml",
                                                                                      "processors.xml");
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
        return Paths.get(configurationDirectory, filename).toFile();
    }
}
