package com.tguzik.cwierkacz.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Iterables;
import com.tguzik.cwierkacz.application.configuration.CacheRegionConfiguration;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.cache.dataobject.key.GeneralKey;
import com.tguzik.cwierkacz.cache.dataobject.key.UniqueKey;
import com.tguzik.cwierkacz.cache.loader.DataObjectLoader;
import com.tguzik.cwierkacz.common.Initializable;
import com.tguzik.cwierkacz.utils.CollectionUtil;

// FIXME: Add unit tests like, right now.
public final class CacheRegion implements Initializable
{
    private final static Logger LOGGER = LoggerFactory.getLogger(CacheRegion.class);
    private final CacheRegionConfiguration configuration;
    private final DataObjectLoader dao;
    private final Cache<UniqueKey, DataObject> cache;

    CacheRegion( CacheRegionConfiguration configuration, DataObjectLoader dao, Cache<UniqueKey, DataObject> cache ) {
        this.configuration = configuration;
        this.dao = dao;
        this.cache = cache;
    }

    public void update( DataObject obj ) {
        cache.put(obj.getUniqueKey(), obj);
        dao.update(obj);
    }

    public void insert( DataObject obj ) {
        cache.put(obj.getUniqueKey(), obj);
        dao.insert(obj);
    }

    public void remove( UniqueKey key ) {
        cache.invalidate(key);
        dao.remove(key);
    }

    /**
     * Loads single data object from either cache or the source, depending on
     * configuration.
     * 
     * @param key
     *            UniqueKey for this data object
     * @return value if found, null if not found
     */
    public DataObject retrieve( UniqueKey key ) {
        if ( configuration.isCacheable() ) {
            if ( configuration.isPreloadable() ) {
                return retrieveFromCache(key);
            }

            return retrieveFromCacheAndSource(key);
        }

        return retrieveFromSource(key);
    }

    private DataObject retrieveFromCache( UniqueKey key ) {
        return cache.getIfPresent(key);
    }

    private DataObject retrieveFromSource( UniqueKey key ) {
        return dao.load(key);
    }

    private DataObject retrieveFromCacheAndSource( UniqueKey key ) {
        try {
            return cache.get(key, dao.createCallableRetriever(key));
        }
        catch ( Exception e ) {
            // Keep in mind that DAO should do its job and print exceptions by itself.
            LOGGER.error(String.format("Error while retrieving %s:%s: %s",
                                       configuration.getName(),
                                       String.valueOf(key),
                                       e.getMessage()), e);
        }
        return null;
    }

    /**
     * Loads collection of object from cache or from the source, depending on
     * configuration.
     * 
     * @param key
     *            GeneralKey for that set of objects
     * @return Collection of matching elements *or* empty collection if nothing
     *         was found
     */
    public ImmutableCollection<DataObject> retrieve( GeneralKey key ) {
        if ( configuration.isCacheable() ) {
            if ( configuration.isPreloadable() ) {
                return retrieveFromCache(key);
            }

            return retrieveFromCacheAndSource(key);
        }

        return retrieveFromSource(key);
    }

    private ImmutableCollection<DataObject> retrieveFromCache( GeneralKey key ) {
        Iterable<DataObject> matchingEntries = Iterables.filter(cache.asMap().values(), key);
        return CollectionUtil.copyToImmutableList(matchingEntries);
    }

    private ImmutableCollection<DataObject> retrieveFromSource( GeneralKey key ) {
        return CollectionUtil.copyToImmutableList(dao.load(key));
    }

    private ImmutableCollection<DataObject> retrieveFromCacheAndSource( GeneralKey key ) {
        ImmutableCollection<DataObject> sourceItems = retrieveFromSource(key);

        // Put retrieved items to cache
        for ( DataObject obj : sourceItems ) {
            cache.put(obj.getUniqueKey(), obj);
        }

        return retrieveFromCache(key);
    }

    public CacheStats getStats( ) {
        return cache.stats();
    }

    @Override
    public void initialize( ) throws Exception {
        dao.initialize();
    }

    @Override
    public void shutdown( ) {
        cache.invalidateAll();
        dao.shutdown();
    }
}
