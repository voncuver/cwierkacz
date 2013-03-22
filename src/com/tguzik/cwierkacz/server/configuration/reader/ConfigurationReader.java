package com.tguzik.cwierkacz.server.configuration.reader;

import static com.google.common.collect.ImmutableList.of;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.server.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;

@Threadsafe
public class ConfigurationReader
{
    private static final ImmutableList<String> CONFIGURATION_FILES = of("cwierkacz.xml",
                                                                        "jobs.xml",
                                                                        "processors.xml");
    private static final String MYBATIS_CONFIGURATION_FILE = "mybatis.xml";
    private final String configurationDirectory;

    public ConfigurationReader( String configurationDirectory ) {
        this.configurationDirectory = configurationDirectory;
    }

    public ApplicationConfiguration read( ) {
        ApplicationConfiguration configuration = new ApplicationConfiguration();
        XStreamConfigurationParser parser = new XStreamConfigurationParser();

        for ( String file : CONFIGURATION_FILES ) {
            parser.parse(constructPath(file), configuration);
        }

        return configuration;
    }

    public SqlSessionFactory getMyBatisSessionFactory( ) throws IOException {
        InputStream is = new FileInputStream(constructPath(MYBATIS_CONFIGURATION_FILE));
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        is.close();
        return factory;
    }

    File constructPath( String filename ) {
        return Paths.get(configurationDirectory, filename).toFile();
    }
}
