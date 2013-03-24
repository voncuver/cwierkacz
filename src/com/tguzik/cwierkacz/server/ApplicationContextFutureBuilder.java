package com.tguzik.cwierkacz.server;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.database.DatabaseService;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterface;

public class ApplicationContextFutureBuilder
{
    private Future<ImmutableMap<String, AbstractSocketInterface>> interfacesByName;
    private Future<ImmutableMap<String, Processor>> processorsByName;
    private Future<ThreadPoolExecutor> endpointThreadPool;
    private Future<ImmutableMap<String, Job>> jobsByName;
    private Future<ApplicationConfiguration> configuration;
    private Future<ThreadPoolExecutor> mainThreadPool;
    private Future<DatabaseService> databaseService;
    private Future<DataAccessor> dataAccessor;

    ApplicationContextFutureBuilder() {
    }

    public ApplicationContextFutureBuilder withInterfacesByName( Future<ImmutableMap<String, AbstractSocketInterface>> interfaces ) {
        this.interfacesByName = interfaces;
        return this;
    }

    public ApplicationContextFutureBuilder withProcessorsByName( Future<ImmutableMap<String, Processor>> processors ) {
        this.processorsByName = processors;
        return this;
    }

    public ApplicationContextFutureBuilder withJobsByName( Future<ImmutableMap<String, Job>> jobsByName ) {
        this.jobsByName = jobsByName;
        return this;
    }

    public ApplicationContextFutureBuilder withApplicationConfiguration( Future<ApplicationConfiguration> configuration ) {
        this.configuration = configuration;
        return this;
    }

    public ApplicationContextFutureBuilder withMainThreadPool( Future<ThreadPoolExecutor> mainThreadPool ) {
        this.mainThreadPool = mainThreadPool;
        return this;
    }

    public ApplicationContextFutureBuilder withDatabaseService( Future<DatabaseService> databaseService ) {
        this.databaseService = databaseService;
        return this;
    }

    public ApplicationContextFutureBuilder withEndpointThreadPool( Future<ThreadPoolExecutor> endpointThreadPool ) {
        this.endpointThreadPool = endpointThreadPool;
        return this;
    }

    public ApplicationContext build( ) throws InterruptedException, ExecutionException {
        return new ApplicationContext(configuration.get(),
                                      dataAccessor.get(),
                                      databaseService.get(),
                                      mainThreadPool.get(),
                                      endpointThreadPool.get(),
                                      interfacesByName.get(),
                                      processorsByName.get(),
                                      jobsByName.get());
    }

}
