package com.tguzik.cwierkacz.server;

import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.database.DatabaseService;
import com.tguzik.cwierkacz.server.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterface;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class ApplicationContext
{
    private final ImmutableMap<String, AbstractSocketInterface> interfacesByName;
    private final ImmutableMap<String, Processor> processorsByName;
    private final ImmutableMap<String, Job> jobsByName;
    private final ApplicationConfiguration configuration;
    private final ThreadPoolExecutor endpointThreadPool;
    private final ThreadPoolExecutor mainThreadPool;
    private final DatabaseService databaseService;
    private final DataAccessor dataAccessor;

    ApplicationContext( ApplicationConfiguration configuration,
                        DataAccessor dataAccessor,
                        DatabaseService databaseService,
                        ThreadPoolExecutor mainThreadPool,
                        ThreadPoolExecutor endpointThreadPool,
                        ImmutableMap<String, AbstractSocketInterface> interfacesByName,
                        ImmutableMap<String, Processor> processorsByName,
                        ImmutableMap<String, Job> jobsByName ) {
        this.endpointThreadPool = endpointThreadPool;
        this.interfacesByName = interfacesByName;
        this.processorsByName = processorsByName;
        this.databaseService = databaseService;
        this.mainThreadPool = mainThreadPool;
        this.configuration = configuration;
        this.dataAccessor = dataAccessor;
        this.jobsByName = jobsByName;
    }

    public ImmutableMap<String, AbstractSocketInterface> getInterfacesByName( ) {
        return interfacesByName;
    }

    public ImmutableMap<String, Processor> getProcessorsByName( ) {
        return processorsByName;
    }

    public ImmutableMap<String, Job> getJobsByName( ) {
        return jobsByName;
    }

    public ApplicationConfiguration getConfiguration( ) {
        return configuration;
    }

    public ThreadPoolExecutor getEndpointThreadPool( ) {
        return endpointThreadPool;
    }

    public ThreadPoolExecutor getMainThreadPool( ) {
        return mainThreadPool;
    }

    public DatabaseService getDatabaseService( ) {
        return databaseService;
    }

    public DataAccessor getDataAccessor( ) {
        return dataAccessor;
    }

    public static ApplicationContextBuilder builder( ) {
        return new ApplicationContextBuilder();
    }

    public static ApplicationContextFutureBuilder futureBuilder( ) {
        return new ApplicationContextFutureBuilder();
    }
}
