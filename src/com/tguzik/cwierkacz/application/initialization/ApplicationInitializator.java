package com.tguzik.cwierkacz.application.initialization;

import java.io.File;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.application.ApplicationContext;
import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.application.configuration.reader.ConfigurationReader;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Processor;

public class ApplicationInitializator
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationInitializator.class);

    private final ParallelLoader parallelLoader;

    public ApplicationInitializator() {
        this.parallelLoader = new ParallelLoader();
    }

    public ApplicationContext initializeContext( CommandLine cmd ) throws ParseException, InterruptedException {
        ApplicationContextBuilder builder = ApplicationContext.builder();

        Future<ImmutableMap<String, Processor>> processors;
        Future<ThreadPoolExecutor> threadPool;
        Future<DataAccessor> dataAccessor;

        // Load configuration from XML
        CwierkaczConfiguration config = initializeConfiguration(builder, getConfigurationDirectory(cmd));

        // Load components in parallel
        dataAccessor = parallel(new InitDataAccessor(config, builder));
        threadPool = parallel(new InitMainThreadPool(config, builder));
        processors = parallel(new InitProcessorRepository(config, builder, dataAccessor));

        parallel(new InitJobRepository(config, builder, processors));
        parallel(new InitXmlServerInterface(config, builder, threadPool));
        parallel(new InitProtobufServerInterface(config, builder, threadPool));

        // Wait for all components to initialize
        parallelLoader.shutdown();

        // Create immutable context
        return builder.build();
    }

    private < T > Future<T> parallel( InitializationTask<T> task ) {
        return parallelLoader.schedule(task);
    }

    private static CwierkaczConfiguration initializeConfiguration( ApplicationContextBuilder builder,
                                                                   String configurationPath ) {
        LOGGER.info(String.format("Loading configuration from %s...", configurationPath));
        CwierkaczConfiguration config = new ConfigurationReader(configurationPath).read();

        builder.withConfiguration(config);
        return config;
    }

    private static String getConfigurationDirectory( CommandLine cmd ) throws ParseException {
        return new File(cmd.getOptionValue("conf", "conf")).getPath();
    }
}
