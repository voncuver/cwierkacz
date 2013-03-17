package com.tguzik.cwierkacz.application.configuration;

import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class CacheRegionConfiguration extends StandardElement
{
    public static final CacheRegionConfiguration DEFAULT = create("DEFAULT", 5000, true, true, false);

    private String name = null;
    private Integer maxObjects = null;
    private Boolean cacheable = null;
    private Boolean preloadable = null;
    private Boolean disabled = null;

    private CacheRegionConfiguration() {
    }

    private CacheRegionConfiguration( String name, Integer maxObjects, Boolean cacheable, Boolean preloadable,
                                      Boolean disabled ) {
        this.name = name;
        this.maxObjects = maxObjects;
        this.cacheable = cacheable;
        this.preloadable = preloadable;
        this.disabled = disabled;
    }

    public String getName( ) {
        return name;
    }

    public Integer getMaxObjects( ) {
        return maxObjects;
    }

    public Boolean isCacheable( ) {
        return cacheable;
    }

    public Boolean isPreloadable( ) {
        return preloadable;
    }

    public Boolean isDisabled( ) {
        return disabled;
    }

    public static CacheRegionConfiguration create( String name, Integer maxObjects, Boolean cacheable,
                                                   Boolean preloadable, Boolean disabled ) {
        return new CacheRegionConfiguration(name, maxObjects, cacheable, preloadable, disabled);
    }
}
