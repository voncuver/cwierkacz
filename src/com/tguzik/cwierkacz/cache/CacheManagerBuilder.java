package com.tguzik.cwierkacz.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.tguzik.cwierkacz.application.configuration.CacheRegionConfiguration;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.cache.dataobject.key.UniqueKey;
import com.tguzik.cwierkacz.cache.loader.DataObjectLoader;

public class CacheManagerBuilder
{
    private final Builder<Class<? extends DataObject>, CacheRegion> regions;

    CacheManagerBuilder() {
        regions = ImmutableMap.builder();
    }

    @SuppressWarnings( "unchecked" )
    public CacheManagerBuilder withRegion( Class<?> clazz, DataObjectLoader dao, CacheRegionConfiguration configuration ) {
        Class<? extends DataObject> region = (Class<? extends DataObject>) clazz;
        Cache<UniqueKey, DataObject> cache;

        cache = CacheBuilder.newBuilder().recordStats().maximumSize(configuration.getMaxObjects()).build(dao);

        regions.put(region, new CacheRegion(configuration, dao, cache));
        return this;
    }

    public CacheManager build( ) {
        return new CacheManager(regions.build());
    }
}
