package com.tguzik.cwierkacz.server.configuration;

import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class ApplicationConfiguration extends StandardElement
{
    private ThreadPoolConfiguration mainThreadPoolConfiguration;
    private ThreadPoolConfiguration endpointThreadPoolConfiguration;

    private ProcessorsConfiguration processorConfigurations;
    private InterfaceConfiguration interfaceConfigurations;
    private CacheConfiguration cacheConfiguration;
    private JobsConfiguration jobConfigurations;

    public ProcessorsConfiguration getProcessorConfigurations( ) {
        return processorConfigurations;
    }

    public ThreadPoolConfiguration getMainThreadPoolConfiguration( ) {
        return mainThreadPoolConfiguration;
    }

    public ThreadPoolConfiguration getEndpointThreadPoolConfiguration( ) {
        return endpointThreadPoolConfiguration;
    }

    public InterfaceConfiguration getInterfaceConfigurations( ) {
        return interfaceConfigurations;
    }

    public CacheConfiguration getCacheConfiguration( ) {
        return cacheConfiguration;
    }

    public JobsConfiguration getJobConfigurations( ) {
        return jobConfigurations;
    }
}
