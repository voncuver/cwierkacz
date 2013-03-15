package com.tguzik.cwierkacz.application.initialization;

import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.cache.DataAccessor;

public class InitDataAccessor implements InitializationTask<DataAccessor>
{
    private final CwierkaczConfiguration configuration;
    private final ApplicationContextBuilder builder;

    InitDataAccessor( CwierkaczConfiguration configuration, ApplicationContextBuilder builder ) {
        this.configuration = configuration;
        this.builder = builder;
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
