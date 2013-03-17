package com.tguzik.cwierkacz.application;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.application.configuration.reader.ConfigurationReader;
import com.tguzik.cwierkacz.application.initialization.ParallelLoader;
import com.tguzik.cwierkacz.application.initialization.tasks.InitDataAccessor;
import com.tguzik.cwierkacz.application.initialization.tasks.InitDataObjectLoader;
import com.tguzik.cwierkacz.application.initialization.tasks.InitJobRepository;
import com.tguzik.cwierkacz.application.initialization.tasks.InitMainThreadPool;
import com.tguzik.cwierkacz.application.initialization.tasks.InitProcessorRepository;
import com.tguzik.cwierkacz.application.initialization.tasks.InitProtobufServerInterface;
import com.tguzik.cwierkacz.application.initialization.tasks.InitXmlServerInterface;
import com.tguzik.cwierkacz.application.initialization.tasks.InitializationTask;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.cache.loader.DataObjectLoader;
import com.tguzik.cwierkacz.common.Processor;

public class ApplicationContextLoader
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextLoader.class);

    private final ParallelLoader parallelLoader;

    public ApplicationContextLoader() {
        this.parallelLoader = new ParallelLoader();
    }

    public ApplicationContext initialize( CommandLine cmd ) throws ParseException, InterruptedException,
                                                           ExecutionException {
        ApplicationContextBuilder builder = ApplicationContext.builder();

        Future<ImmutableMap<String, Processor>> processors;
        Future<ThreadPoolExecutor> threadPool;
        Future<DataObjectLoader> defaultDao;
        Future<DataAccessor> dataAccessor;

        // Load configuration from XML
        CwierkaczConfiguration config = initializeConfiguration(builder, getConfigurationDirectory(cmd));

        // Load components in parallel
        defaultDao = parallel(new InitDataObjectLoader(config.getDatabase()));
        dataAccessor = parallel(new InitDataAccessor(config.getCache(), defaultDao, builder));
        threadPool = parallel(new InitMainThreadPool(config.getThreadPool(), builder));
        processors = parallel(new InitProcessorRepository(config.getProcessors(), builder, dataAccessor));

        parallel(new InitProtobufServerInterface(config.getInterfaces(), builder, threadPool));
        parallel(new InitXmlServerInterface(config.getInterfaces(), builder, threadPool));
        parallel(new InitJobRepository(config.getJobs(), builder, processors));

        // Wait for all components to initialize, check for exceptions and then shut down the loader
        parallelLoader.checkForExceptions();
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
