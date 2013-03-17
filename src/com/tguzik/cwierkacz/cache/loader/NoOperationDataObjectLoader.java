package com.tguzik.cwierkacz.cache.loader;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.application.configuration.DatabaseConfiguration;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.cache.dataobject.key.GeneralKey;
import com.tguzik.cwierkacz.cache.dataobject.key.UniqueKey;

public class NoOperationDataObjectLoader extends DataObjectLoader
{
    public static final NoOperationDataObjectLoader INSTANCE = new NoOperationDataObjectLoader();

    public static DataObjectLoader create( DatabaseConfiguration config ) {
        return INSTANCE;
    }

    public static DataObjectLoader getInstance( ) {
        return INSTANCE;
    }

    private NoOperationDataObjectLoader() {
        // Do nothing.
    }

    @Override
    public void initialize( ) throws Exception {
        // Do nothing.
    }

    @Override
    public void shutdown( ) {
        // Do nothing.
    }

    @Override
    public DataObject load( UniqueKey key ) {
        return null;
    }

    @Override
    public ImmutableList<DataObject> load( GeneralKey key ) {
        return ImmutableList.of();
    }

    @Override
    public void update( DataObject obj ) {
        // Do nothing.
    }

    @Override
    public void insert( DataObject obj ) {
        // Do nothing.
    }

    @Override
    public void remove( UniqueKey key ) {
        // Do nothing.
    }
}
