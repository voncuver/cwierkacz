package com.tguzik.cwierkacz.common.initialization.tasks;

import static com.tguzik.cwierkacz.common.configuration.CacheRegionConfiguration.DEFAULT;
import static com.tguzik.cwierkacz.common.configuration.CacheRegionConfiguration.create;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.tguzik.cwierkacz.cache.CacheManager;
import com.tguzik.cwierkacz.cache.CacheManagerBuilder;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.cache.loader.DataObjectLoader;
import com.tguzik.cwierkacz.cache.loader.NoOperationDataObjectLoader;
import com.tguzik.cwierkacz.common.configuration.CacheConfiguration;
import com.tguzik.cwierkacz.common.configuration.CacheRegionConfiguration;
import com.tguzik.cwierkacz.server.ApplicationContextBuilder;

// TODO: Refactor
public class InitDataAccessor implements InitializationTask<DataAccessor>
{
    private final ApplicationContextBuilder builder;
    private final Future<DataObjectLoader> dao;
    private final CacheConfiguration cache;

    public InitDataAccessor( CacheConfiguration cache, Future<DataObjectLoader> dao, ApplicationContextBuilder builder ) {
        this.builder = builder;
        this.cache = cache;
        this.dao = dao;
    }

    @Override
    public DataAccessor call( ) throws InterruptedException, ExecutionException {
        CacheManagerBuilder cacheManagerBuilder = CacheManager.builder();
        DataAccessor dataAccessor;

        initializeCacheRegions(cacheManagerBuilder, cache, dao.get());
        dataAccessor = DataAccessor.create(cacheManagerBuilder.build());

        builder.withDataAccessor(dataAccessor);
        return dataAccessor;
    }

    private void initializeCacheRegions( CacheManagerBuilder cacheManagerBuilder, CacheConfiguration cache,
                                         DataObjectLoader dao ) {
        for ( Class<?> region : DataAccessor.getAvailableCacheRegions() ) {
            CacheRegionConfiguration config = constructRegionConfig(getRegionName(region), cache.getRegionConfigs());
            cacheManagerBuilder.withRegion(region, constructDataLoaderForClass(dao, config), config);
        }
    }

    private CacheRegionConfiguration constructRegionConfig( String regionName, List<CacheRegionConfiguration> regions ) {
        CacheRegionConfiguration defined = Iterables.find(regions, RegionNamePredicate.create(regionName), DEFAULT);

        Integer maxObjects = defined.getMaxObjects() != null ? defined.getMaxObjects() : DEFAULT.getMaxObjects();
        Boolean cacheable = defined.isCacheable() != null ? defined.isCacheable() : DEFAULT.isCacheable();
        Boolean preloadable = defined.isPreloadable() != null ? defined.isPreloadable() : DEFAULT.isPreloadable();
        Boolean disabled = defined.isDisabled() != null ? defined.isDisabled() : DEFAULT.isDisabled();

        return create(regionName, maxObjects, cacheable, preloadable, disabled);
    }

    private DataObjectLoader constructDataLoaderForClass( DataObjectLoader dao, CacheRegionConfiguration config ) {
        return config.isDisabled() ? NoOperationDataObjectLoader.getInstance() : dao;
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
