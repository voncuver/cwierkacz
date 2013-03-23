package com.tguzik.cwierkacz.cache;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
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
    private static final MapJoiner MAP_JOINER = Joiner.on("\n")
                                                      .withKeyValueSeparator(" - ")
                                                      .useForNull("null");
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

    /** For parallel preloading */
    public CacheManager getCacheManager( ) {
        return cacheManager;
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
        MAP_JOINER.appendTo(builder, getCacheStats().entrySet());

        return builder.toString();
    }
}
