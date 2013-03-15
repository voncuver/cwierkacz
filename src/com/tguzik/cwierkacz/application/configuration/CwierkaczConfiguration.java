package com.tguzik.cwierkacz.application.configuration;

import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class CwierkaczConfiguration extends StandardElement
{
    private ProcessorsConfiguration processors;
    private ThreadPoolConfiguration threadPool;
    private InterfaceConfiguration interfaces;
    private DatabaseConfiguration database;
    private CacheConfiguration cache;
    private JobsConfiguration jobs;

    public ProcessorsConfiguration getProcessors( ) {
        return processors;
    }

    public ThreadPoolConfiguration getThreadPool( ) {
        return threadPool;
    }

    public InterfaceConfiguration getInterfaces( ) {
        return interfaces;
    }

    public DatabaseConfiguration getDatabase( ) {
        return database;
    }

    public CacheConfiguration getCache( ) {
        return cache;
    }

    public JobsConfiguration getJobs( ) {
        return jobs;
    }
}
