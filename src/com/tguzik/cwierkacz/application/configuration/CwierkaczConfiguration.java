package com.tguzik.cwierkacz.application.configuration;

import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class CwierkaczConfiguration extends StandardElement
{
    private CacheConfiguration cacheConfiguration;
    private DatabaseConfiguration databaseConfiguration;
    private JobsConfiguration jobsConfiguration;
    private ProcessorsConfiguration processorsConfiguration;
    private ThreadPoolConfiguration threadPoolConfiguration;
    private XmlServerConfiguration xmlServerConfiguration;

    public CacheConfiguration getCacheConfiguration( ) {
        return cacheConfiguration;
    }

    public DatabaseConfiguration getDatabaseConfiguration( ) {
        return databaseConfiguration;
    }

    public JobsConfiguration getJobsConfiguration( ) {
        return jobsConfiguration;
    }

    public ProcessorsConfiguration getProcessorsConfiguration( ) {
        return processorsConfiguration;
    }

    public ThreadPoolConfiguration getThreadPoolConfiguration( ) {
        return threadPoolConfiguration;
    }

    public XmlServerConfiguration getXmlServerConfiguration( ) {
        return xmlServerConfiguration;
    }
}
