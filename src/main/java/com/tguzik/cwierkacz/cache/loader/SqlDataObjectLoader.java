package com.tguzik.cwierkacz.cache.loader;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.GeneralKey;
import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.database.DatabaseService;

public class SqlDataObjectLoader extends DataObjectLoader
{
    private final Class<? extends DataObject> table;
    private final DatabaseService service;

    public SqlDataObjectLoader( Class<? extends DataObject> table, DatabaseService service ) {
        this.service = service;
        this.table = table;
    }

    @Override
    public void initialize( ) throws Exception {
    }

    @Override
    public void shutdown( ) {
    }

    @Override
    public DataObject load( UniqueKey key ) {
        return service.load(table, key);
    }

    @Override
    public ImmutableList<DataObject> load( GeneralKey key ) {
        return service.load(table, key);
    }

    @Override
    public void update( DataObject obj ) {
        service.update(table, obj);
    }

    @Override
    public void insert( DataObject obj ) {
        service.create(table, obj);
    }

    @Override
    public void remove( UniqueKey key ) {
        service.remove(table, key);
    }
}
