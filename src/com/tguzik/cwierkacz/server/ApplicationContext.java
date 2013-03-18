package com.tguzik.cwierkacz.server;

import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterface;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class ApplicationContext
{
    private final ImmutableMap<String, AbstractSocketInterface> interfacesByName;
    private final ImmutableMap<String, Processor> processorsByName;
    private final ImmutableMap<String, Job> jobsByName;
    private final CwierkaczConfiguration configuration;
    private final ThreadPoolExecutor mainThreadPool;
    private final DataAccessor dataAccessor;

    ApplicationContext( CwierkaczConfiguration configuration, DataAccessor dataAccessor,
                        ThreadPoolExecutor mainThreadPool, ImmutableMap<String, AbstractSocketInterface> interfacesByName,
                        ImmutableMap<String, Processor> processorsByName, ImmutableMap<String, Job> jobsByName ) {
        this.interfacesByName = interfacesByName;
        this.processorsByName = processorsByName;
        this.mainThreadPool = mainThreadPool;
        this.configuration = configuration;
        this.dataAccessor = dataAccessor;
        this.jobsByName = jobsByName;
    }

    public CwierkaczConfiguration getConfiguration( ) {
        return configuration;
    }

    public ImmutableMap<String, AbstractSocketInterface> getInterfacesByName( ) {
        return interfacesByName;
    }

    public DataAccessor getDataAccessor( ) {
        return dataAccessor;
    }

    public ImmutableMap<String, Job> getJobsByName( ) {
        return jobsByName;
    }

    public ThreadPoolExecutor getMainThreadPool( ) {
        return mainThreadPool;
    }

    public ImmutableMap<String, Processor> getProcessorsByName( ) {
        return processorsByName;
    }

    public static ApplicationContextBuilder builder( ) {
        return new ApplicationContextBuilder();
    }
}
