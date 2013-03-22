package com.tguzik.cwierkacz.cache;

import java.util.Map;

import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.dataobject.Customer;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.cache.dataobject.Tweets;
import com.tguzik.cwierkacz.cache.dataobject.key.CustomerKey;
import com.tguzik.cwierkacz.common.Initializable;

public final class DataAccessor implements Initializable
{
    private final CacheManager cacheManager;

    private DataAccessor( CacheManager cacheManager ) {
        this.cacheManager = cacheManager;
    }

    public Customer getCustomer( CustomerKey key ) {
        return (Customer) cacheManager.retrieve(Customer.class, key);
    }

    @Override
    public void initialize( ) throws Exception {
        cacheManager.initialize();
    }

    @Override
    public void shutdown( ) {
        cacheManager.shutdown();
    }

    public ImmutableMap<Class<? extends DataObject>, CacheStats> getCacheStats( ) {
        return cacheManager.getCacheStats();
    }

    public static ImmutableList<Class<? extends DataObject>> getAvailableCacheRegions( ) {
        return ImmutableList.of(Customer.class, Tweets.class);
    }

    public static DataAccessor create( CacheManager cacheManager ) {
        return new DataAccessor(cacheManager);
    }

    @Override
    public String toString( ) {
        StringBuilder builder = new StringBuilder("AptAccessor stats: \n");

        for ( Map.Entry<Class<? extends DataObject>, CacheStats> entry : getCacheStats().entrySet() ) {
            builder.append("Region ").append(entry.getKey().getSimpleName()).append(" - ").append(entry.getValue())
                   .append("\n");
        }

        return builder.toString();
    }
}
