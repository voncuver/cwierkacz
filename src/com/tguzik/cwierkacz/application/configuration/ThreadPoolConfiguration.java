package com.tguzik.cwierkacz.application.configuration;

import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class ThreadPoolConfiguration extends StandardElement
{
    private int minPoolSize;
    private int maxPoolSize;
    private long keepAliveSeconds;

    public int getMinPoolSize( ) {
        return minPoolSize;
    }

    public int getMaxPoolSize( ) {
        return maxPoolSize;
    }

    public long getKeepAliveSeconds( ) {
        return keepAliveSeconds;
    }
}
