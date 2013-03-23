package com.tguzik.cwierkacz.common.initialization.task;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.cache.CacheRegion;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.cache.GeneralKey;
import com.tguzik.cwierkacz.common.initialization.InitializationState;

public class PreloadCacheRegions implements InitializationTask<Void>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PreloadCacheRegions.class);
    private final Future<InitializationState> futureState;

    public PreloadCacheRegions( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public Void call( ) throws Exception {
        DataAccessor accessor = futureState.get().getDataAccessor().get();

        for ( CacheRegion region : accessor.getCacheManager().getRegionsByClass().values() ) {
            if ( isRegionPreloadable(region) ) {
                preloadRegion(region);
            }
        }

        return null;
    }

    private void preloadRegion( CacheRegion region ) {
        LOGGER.info("Preloading region {}... ", region.getConfiguration().getName());

        region.retrieveFromCacheAndSource(GeneralKey.ALWAYS_TRUE);

        LOGGER.info("Finished preloading region {}", region.getConfiguration().getName());
    }

    private boolean isRegionPreloadable( CacheRegion region ) {
        return region.getConfiguration().isPreloadable();
    }

    @Override
    public String getName( ) {
        return "Preload Cache Regions";
    }
}
