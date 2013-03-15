package com.tguzik.cwierkacz.application.configuration;

import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class CacheRegionConfiguration extends StandardElement
{
    private String name;
    private int maxObjects;
    private boolean cacheable;

    public String getName( ) {
        return name;
    }

    public int getMaxObjects( ) {
        return maxObjects;
    }

    public boolean isCacheable( ) {
        return cacheable;
    }
}
