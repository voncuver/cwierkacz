package com.tguzik.cwierkacz.server;

import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.database.DatabaseService;
import com.tguzik.cwierkacz.server.interfaces.socket.AbstractServerSocketInterface;

public class ApplicationContextBuilder
{
    private ImmutableMap<String, AbstractServerSocketInterface> interfacesByName;
    private ImmutableMap<String, Processor> processorsByName;
    private ImmutableMap<String, Job> jobsByName;
    private ApplicationConfiguration configuration;
    private ThreadPoolExecutor mainThreadPool;
    private ThreadPoolExecutor endpointThreadPool;
    private DatabaseService databaseService;
    private DataAccessor dataAccessor;

    ApplicationContextBuilder() {
    }

    public ApplicationContextBuilder withInterfacesByName( ImmutableMap<String, AbstractServerSocketInterface> interfaces ) {
        this.interfacesByName = interfaces;
        return this;
    }

    public ApplicationContextBuilder withProcessorsByName( ImmutableMap<String, Processor> processorsByName ) {
        this.processorsByName = processorsByName;
        return this;
    }

    public ApplicationContextBuilder withJobsByName( ImmutableMap<String, Job> jobsByName ) {
        this.jobsByName = jobsByName;
        return this;
    }

    public ApplicationContextBuilder withApplicationConfiguration( ApplicationConfiguration configuration ) {
        this.configuration = configuration;
        return this;
    }

    public ApplicationContextBuilder withMainThreadPool( ThreadPoolExecutor mainThreadPool ) {
        this.mainThreadPool = mainThreadPool;
        return this;
    }

    public ApplicationContextBuilder withDatabaseService( DatabaseService databaseService ) {
        this.databaseService = databaseService;
        return this;
    }

    public ApplicationContextBuilder withDataAccessor( DataAccessor dataAccessor ) {
        this.dataAccessor = dataAccessor;
        return this;
    }

    public ApplicationContextBuilder withEndpointThreadPool( ThreadPoolExecutor endpointThreadPool ) {
        this.endpointThreadPool = endpointThreadPool;
        return this;
    }

    public ApplicationContext build( ) {
        return new ApplicationContext(configuration,
                                      dataAccessor,
                                      databaseService,
                                      mainThreadPool,
                                      endpointThreadPool,
                                      interfacesByName,
                                      processorsByName,
                                      jobsByName);
    }

}
