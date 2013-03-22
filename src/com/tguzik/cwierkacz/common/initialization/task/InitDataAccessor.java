package com.tguzik.cwierkacz.common.initialization.task;

import static com.tguzik.cwierkacz.common.configuration.CacheRegionConfiguration.DEFAULT;
import static com.tguzik.cwierkacz.common.configuration.CacheRegionConfiguration.create;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.tguzik.cwierkacz.cache.CacheManager;
import com.tguzik.cwierkacz.cache.CacheManagerBuilder;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.cache.loader.DataObjectLoader;
import com.tguzik.cwierkacz.cache.loader.NoOperationDataObjectLoader;
import com.tguzik.cwierkacz.cache.loader.SqlDataObjectLoader;
import com.tguzik.cwierkacz.common.configuration.CacheConfiguration;
import com.tguzik.cwierkacz.common.configuration.CacheRegionConfiguration;
import com.tguzik.cwierkacz.common.initialization.InitializationState;
import com.tguzik.cwierkacz.database.DatabaseService;

public final class InitDataAccessor implements InitializationTask<DataAccessor>
{
    private final Future<InitializationState> futureState;

    public InitDataAccessor( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public DataAccessor call( ) throws InterruptedException, ExecutionException {
        CacheConfiguration cache = futureState.get().getConfiguration().get().getCacheConfiguration();
        DatabaseService service = futureState.get().getDatabaseService().get();
        return DataAccessor.create(initializeCacheRegions(cache, service));
    }

    private CacheManager initializeCacheRegions( CacheConfiguration config, DatabaseService service ) {
        ImmutableList<CacheRegionConfiguration> regionalConfigs = config.getRegionConfigs();
        CacheManagerBuilder cacheManagerBuilder = CacheManager.builder();

        for ( Class<? extends DataObject> region : DataAccessor.getAvailableCacheRegions() ) {
            CacheRegionConfiguration regionConfig = constructRegionConfig(getRegionName(region),
                                                                          regionalConfigs);

            cacheManagerBuilder.withRegion(region,
                                           regionConfig,
                                           constructDataLoaderForClass(region, regionConfig, service));
        }

        return cacheManagerBuilder.build();
    }

    private DataObjectLoader constructDataLoaderForClass( Class<? extends DataObject> region,
                                                          CacheRegionConfiguration config,
                                                          DatabaseService service ) {
        if ( config.isDisabled() ) {
            return NoOperationDataObjectLoader.getInstance();
        }

        return new SqlDataObjectLoader(region, service);
    }

    private CacheRegionConfiguration constructRegionConfig( String regionName,
                                                            List<CacheRegionConfiguration> regions ) {
        CacheRegionConfiguration defined = Iterables.find(regions,
                                                          RegionNamePredicate.create(regionName),
                                                          DEFAULT);

        return create(regionName,
                      select(defined.getMaxObjects(), DEFAULT.getMaxObjects()),
                      select(defined.isCacheable(), DEFAULT.isCacheable()),
                      select(defined.isPreloadable(), DEFAULT.isPreloadable()),
                      select(defined.isDisabled(), DEFAULT.isDisabled()),
                      select(defined.getDataLoader(), DEFAULT.getDataLoader()));
    }

    private static < T > T select( T first, T second ) {
        return ( first != null ? first : second );
    }

    @SuppressWarnings( "unchecked" )
    private static String getRegionName( Class<?> region ) {
        return DataObject.getRegionName((Class<? extends DataObject>) region);
    }

    @Override
    public String getName( ) {
        return "Data Accessor";
    }
}

final class RegionNamePredicate implements Predicate<CacheRegionConfiguration>
{
    private final String name;

    private RegionNamePredicate( String name ) {
        this.name = name;
    }

    @Override
    public boolean apply( CacheRegionConfiguration value ) {
        return Objects.equal(name, value.getName());
    }

    public static RegionNamePredicate create( String name ) {
        return new RegionNamePredicate(name);
    }
}
