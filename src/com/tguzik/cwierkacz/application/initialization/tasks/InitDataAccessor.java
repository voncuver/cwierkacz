package com.tguzik.cwierkacz.application.initialization.tasks;

import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.CacheConfiguration;
import com.tguzik.cwierkacz.application.configuration.DatabaseConfiguration;
import com.tguzik.cwierkacz.cache.DataAccessor;

public class InitDataAccessor implements InitializationTask<DataAccessor>
{
    private final ApplicationContextBuilder builder;
    private final DatabaseConfiguration database;
    private final CacheConfiguration cache;

    public InitDataAccessor( CacheConfiguration cache, DatabaseConfiguration database, ApplicationContextBuilder builder ) {
        this.builder = builder;
        this.database = database;
        this.cache = cache;
    }

    @Override
    public DataAccessor call( ) {
        DataAccessor dataAccessor = null;

        builder.withDataAccessor(dataAccessor);
        return dataAccessor;
    }

    @Override
    public String getName( ) {
        return "Data Accessor";
    }
}
