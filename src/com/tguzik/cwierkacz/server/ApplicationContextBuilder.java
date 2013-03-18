package com.tguzik.cwierkacz.server;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterface;

public class ApplicationContextBuilder
{
    private final ImmutableMap.Builder<String, AbstractSocketInterface> interfacesByName;
    private final ImmutableMap.Builder<String, Processor> processorsByName;
    private final ImmutableMap.Builder<String, Job> jobsByName;

    private final AtomicReference<CwierkaczConfiguration> configuration;
    private final AtomicReference<ThreadPoolExecutor> mainThreadPool;
    private final AtomicReference<DataAccessor> dataAccessor;

    ApplicationContextBuilder() {
        this.interfacesByName = ImmutableMap.builder();
        this.processorsByName = ImmutableMap.builder();
        this.mainThreadPool = new AtomicReference<>();
        this.configuration = new AtomicReference<>();
        this.dataAccessor = new AtomicReference<>();
        this.jobsByName = ImmutableMap.builder();
    }

    public ApplicationContextBuilder withConfiguration( CwierkaczConfiguration config ) {
        configuration.set(config);
        return this;
    }

    public ApplicationContextBuilder withDataAccessor( DataAccessor dataAccessor ) {
        this.dataAccessor.set(dataAccessor);
        return this;
    }

    public synchronized ApplicationContextBuilder withJob( String name, Job job ) {
        jobsByName.put(name, job);
        return this;
    }

    public synchronized ApplicationContextBuilder withProcessor( String name, Processor processor ) {
        processorsByName.put(name, processor);
        return this;
    }

    public synchronized ApplicationContextBuilder withInterface( String name, AbstractSocketInterface server ) {
        interfacesByName.put(name, server);
        return this;
    }

    public ApplicationContextBuilder withMainThreadPool( ThreadPoolExecutor threadPool ) {
        mainThreadPool.set(threadPool);
        return this;
    }

    public ApplicationContext build( ) {
        return new ApplicationContext(configuration.get(),
                                      dataAccessor.get(),
                                      mainThreadPool.get(),
                                      interfacesByName.build(),
                                      processorsByName.build(),
                                      jobsByName.build());
    }

}
