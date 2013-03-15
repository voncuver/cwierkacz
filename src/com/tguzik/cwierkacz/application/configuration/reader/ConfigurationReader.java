package com.tguzik.cwierkacz.application.configuration.reader;

import java.io.File;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;

@Threadsafe
public class ConfigurationReader
{
    private static final ImmutableList<String> CONFIGURATION_FILES = ImmutableList.of("cache.xml",
                                                                                      "cwierkacz.xml",
                                                                                      "database.xml",
                                                                                      "jobs.xml",
                                                                                      "processors.xml",
                                                                                      "xmlserver.xml");
    private final String configurationDirectory;
    private final XStreamConfigurationParser parser;

    public ConfigurationReader( String configurationDirectory ) {
        this.configurationDirectory = addSlash(configurationDirectory);
        this.parser = new XStreamConfigurationParser();
    }

    public CwierkaczConfiguration read( ) {
        CwierkaczConfiguration configuration = new CwierkaczConfiguration();

        for ( String file : CONFIGURATION_FILES ) {
            parser.parse(constructPath(file), configuration);
        }

        return configuration;
    }

    String addSlash( String str ) {
        if ( !str.endsWith("\\") && !str.endsWith("/") ) {
            return str + "/";
        }
        return str;
    }

    File constructPath( String filename ) {
        return new File(configurationDirectory + filename);
    }
}
