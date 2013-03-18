package com.tguzik.cwierkacz.cache.loader;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.cache.dataobject.key.GeneralKey;
import com.tguzik.cwierkacz.cache.dataobject.key.UniqueKey;

// Placeholder, so FIXME: Implement.
public class SqlDataObjectLoader extends DataObjectLoader
{

    @Override
    public void initialize( ) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void shutdown( ) {
        // TODO Auto-generated method stub

    }

    @Override
    public DataObject load( UniqueKey key ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ImmutableList<DataObject> load( GeneralKey key ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update( DataObject obj ) {
        // TODO Auto-generated method stub

    }

    @Override
    public void insert( DataObject obj ) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove( UniqueKey key ) {
        // TODO Auto-generated method stub

    }
}
