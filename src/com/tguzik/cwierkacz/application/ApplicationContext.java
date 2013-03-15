package com.tguzik.cwierkacz.application;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.utils.CollectionUtil;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class ApplicationContext
{
    private final ImmutableMap<String, Processor> processorsByName;
    private final ImmutableMap<String, Job> jobsByName;
    private final CwierkaczConfiguration configuration;
    private final ThreadPoolExecutor mainThreadPool;
    private final DataAccessor dataAccessor;

    ApplicationContext( CwierkaczConfiguration configuration, DataAccessor dataAccessor,
                        Map<String, Processor> processorsByName, Map<String, Job> jobsByName,
                        ThreadPoolExecutor mainThreadPool, Object object, Object object2 ) {
        this.configuration = configuration;
        this.dataAccessor = dataAccessor;
        this.processorsByName = CollectionUtil.copyToImmutableMap(processorsByName);
        this.jobsByName = CollectionUtil.copyToImmutableMap(jobsByName);
        this.mainThreadPool = mainThreadPool;
    }

    public CwierkaczConfiguration getConfiguration( ) {
        return configuration;
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
