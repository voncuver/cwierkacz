package com.tguzik.cwierkacz.server.initialization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.database.DatabaseService;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterface;

public class InitializationState
{
    private final Future<ImmutableMap<String, AbstractSocketInterface>> interfacesByName;
    private final Future<ImmutableMap<String, Processor>> processorsByName;
    private final Future<ThreadPoolExecutor> endpointThreadPool;
    private final Future<ImmutableMap<String, Job>> jobsByName;
    private final Future<ApplicationConfiguration> configuration;
    private final Future<ThreadPoolExecutor> mainThreadPool;
    private final Future<DatabaseService> databaseService;
    private final Future<DataAccessor> dataAccessor;
    private final String configurationDirectory;

    public InitializationState( String configurationDirectory,
                                Future<ImmutableMap<String, AbstractSocketInterface>> interfacesByName,
                                Future<ImmutableMap<String, Processor>> processorsByName,
                                Future<ImmutableMap<String, Job>> jobsByName,
                                Future<ThreadPoolExecutor> endpointThreadPool,
                                Future<ApplicationConfiguration> configuration,
                                Future<ThreadPoolExecutor> mainThreadPool,
                                Future<DatabaseService> databaseService,
                                Future<DataAccessor> dataAccessor ) {
        this.configurationDirectory = configurationDirectory;
        this.interfacesByName = interfacesByName;
        this.processorsByName = processorsByName;
        this.endpointThreadPool = endpointThreadPool;
        this.jobsByName = jobsByName;
        this.configuration = configuration;
        this.mainThreadPool = mainThreadPool;
        this.databaseService = databaseService;
        this.dataAccessor = dataAccessor;
    }

    public String getConfigurationDirectory( ) {
        return configurationDirectory;
    }

    public Future<ImmutableMap<String, AbstractSocketInterface>> getInterfacesByName( ) {
        return interfacesByName;
    }

    public Future<ImmutableMap<String, Processor>> getProcessorsByName( ) {
        return processorsByName;
    }

    public Future<ThreadPoolExecutor> getEndpointThreadPool( ) {
        return endpointThreadPool;
    }

    public Future<ImmutableMap<String, Job>> getJobsByName( ) {
        return jobsByName;
    }

    public Future<ApplicationConfiguration> getConfiguration( ) {
        return configuration;
    }

    public Future<ThreadPoolExecutor> getMainThreadPool( ) {
        return mainThreadPool;
    }

    public Future<DatabaseService> getDatabaseService( ) {
        return databaseService;
    }

    public Future<DataAccessor> getDataAccessor( ) {
        return dataAccessor;
    }

    public ApplicationContext buildContext( ) throws InterruptedException, ExecutionException {
        return ApplicationContext.builder() //
                                 .withDataAccessor(dataAccessor.get())
                                 .withApplicationConfiguration(configuration.get())
                                 .withDatabaseService(databaseService.get())
                                 .withEndpointThreadPool(endpointThreadPool.get())
                                 .withInterfacesByName(interfacesByName.get())
                                 .withJobsByName(jobsByName.get())
                                 .withMainThreadPool(mainThreadPool.get())
                                 .withProcessorsByName(processorsByName.get())
                                 .build();
    }

}
