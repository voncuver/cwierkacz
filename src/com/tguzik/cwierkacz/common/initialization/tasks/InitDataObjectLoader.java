package com.tguzik.cwierkacz.common.initialization.tasks;

import java.lang.reflect.Method;

import com.tguzik.cwierkacz.cache.loader.DataObjectLoader;
import com.tguzik.cwierkacz.common.configuration.DatabaseConfiguration;

public class InitDataObjectLoader implements InitializationTask<DataObjectLoader>
{
    private final DatabaseConfiguration config;

    public InitDataObjectLoader( DatabaseConfiguration config ) {
        this.config = config;
    }

    @Override
    public DataObjectLoader call( ) throws Exception {
        Method method = config.getDefaultDataLoader().getDeclaredMethod("create", DatabaseConfiguration.class);

        return (DataObjectLoader) method.invoke(null, config);
    }

    @Override
    public String getName( ) {
        return "Default Data Object Loader";
    }
}
