package com.tguzik.cwierkacz.cache;

import java.util.Map;

import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.common.Initializable;

public final class CacheManager implements Initializable
{
    private final ImmutableMap<Class<? extends DataObject>, CacheRegion> regionsByClass;

    public CacheManager( ImmutableMap<Class<? extends DataObject>, CacheRegion> regionsByClass ) {
        this.regionsByClass = regionsByClass;
    }

    public DataObject retrieve( Class<? extends DataObject> region, UniqueKey key ) {
        CacheRegion regionInstance = regionsByClass.get(region);

        if ( regionInstance != null ) {
            return regionInstance.retrieve(key);
        }

        return null;
    }

    public ImmutableCollection<DataObject> retrieve( Class<? extends DataObject> region, GeneralKey key ) {
        CacheRegion regionInstance = regionsByClass.get(region);

        if ( regionInstance != null ) {
            return regionInstance.retrieve(key);
        }

        return ImmutableList.of();
    }

    public void update( Class<? extends DataObject> region, DataObject value ) {
        CacheRegion regionInstance = regionsByClass.get(region);

        if ( regionInstance != null ) {
            regionInstance.update(value);
        }
    }

    public void insert( Class<? extends DataObject> region, DataObject value ) {
        CacheRegion regionInstance = regionsByClass.get(region);

        if ( regionInstance != null ) {
            regionInstance.insert(value);
        }
    }

    public void remove( Class<? extends DataObject> region, UniqueKey key ) {
        CacheRegion regionInstance = regionsByClass.get(region);

        if ( regionInstance != null ) {
            regionInstance.remove(key);
        }
    }

    @Override
    public void initialize( ) throws Exception {
        for ( CacheRegion region : regionsByClass.values() ) {
            region.initialize();
        }
    }

    @Override
    public void shutdown( ) {
        for ( CacheRegion region : regionsByClass.values() ) {
            region.shutdown();
        }
    }

    public ImmutableMap<Class<? extends DataObject>, CacheStats> getCacheStats( ) {
        Builder<Class<? extends DataObject>, CacheStats> builder = ImmutableMap.builder();

        for ( Map.Entry<Class<? extends DataObject>, CacheRegion> entry : regionsByClass.entrySet() ) {
            builder.put(entry.getKey(), entry.getValue().getStats());
        }

        return builder.build();
    }

    public static CacheManagerBuilder builder( ) {
        return new CacheManagerBuilder();
    }
}
