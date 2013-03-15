package com.tguzik.cwierkacz.application;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;

public class ApplicationContextBuilder
{
    private final AtomicReference<CwierkaczConfiguration> configuration;
    private final AtomicReference<ImmutableMap<String, Processor>> processorsByName;
    private final AtomicReference<ImmutableMap<String, Job>> jobsByName;
    private final AtomicReference<DataAccessor> dataAccessor;
    private final AtomicReference<ThreadPoolExecutor> mainThreadPool;
    private final AtomicReference<Object> xmlServerInterface;
    private final AtomicReference<Object> protobufServerInterface;

    ApplicationContextBuilder() {
        this.protobufServerInterface = new AtomicReference<>();
        this.xmlServerInterface = new AtomicReference<>();
        this.processorsByName = new AtomicReference<>();
        this.mainThreadPool = new AtomicReference<>();
        this.configuration = new AtomicReference<>();
        this.dataAccessor = new AtomicReference<>();
        this.jobsByName = new AtomicReference<>();
    }

    public ApplicationContextBuilder withConfiguration( CwierkaczConfiguration config ) {
        configuration.set(config);
        return this;
    }

    public ApplicationContextBuilder withDataAccessor( DataAccessor dataAccessor ) {
        this.dataAccessor.set(dataAccessor);
        return this;
    }

    public ApplicationContextBuilder withJobRepository( ImmutableMap<String, Job> jobRepository ) {
        jobsByName.set(jobRepository);
        return this;
    }

    public ApplicationContextBuilder withProcessorsRepository( ImmutableMap<String, Processor> build ) {
        processorsByName.set(build);
        return this;
    }

    public ApplicationContextBuilder withMainThreadPool( ThreadPoolExecutor threadPool ) {
        mainThreadPool.set(threadPool);
        return this;
    }

    public ApplicationContextBuilder withProtobufServerInterface( Object protobufServer ) {
        this.protobufServerInterface.set(protobufServer);
        return this;
    }

    public ApplicationContextBuilder withXmlServerInterface( Object xmlServer ) {
        this.xmlServerInterface.set(xmlServer);
        return this;
    }

    public ApplicationContext build( ) {
        return new ApplicationContext(configuration.get(),
                                      dataAccessor.get(),
                                      processorsByName.get(),
                                      jobsByName.get(),
                                      mainThreadPool.get(),
                                      xmlServerInterface.get(),
                                      protobufServerInterface.get());
    }

}
