package com.tguzik.cwierkacz.cache.loader;

import java.util.concurrent.Callable;

import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.cache.dataobject.key.GeneralKey;
import com.tguzik.cwierkacz.cache.dataobject.key.UniqueKey;
import com.tguzik.cwierkacz.common.Initializable;
import com.tguzik.cwierkacz.utils.CollectionUtil;

public abstract class DataObjectLoader extends CacheLoader<UniqueKey, DataObject> implements Initializable
{
    @Override
    public abstract DataObject load( UniqueKey key );

    public abstract ImmutableList<DataObject> load( GeneralKey key );

    public abstract void update( DataObject obj );

    public abstract void insert( DataObject obj );

    public abstract void remove( UniqueKey key );

    public CallableSingleObjectRetriever createCallableRetriever( UniqueKey key ) {
        return new CallableSingleObjectRetriever(this, key);
    }

    public CallableMultiObjectRetriever createCallableRetriever( GeneralKey key ) {
        return new CallableMultiObjectRetriever(this, key);
    }
}

final class CallableSingleObjectRetriever implements Callable<DataObject>
{
    private final DataObjectLoader dao;
    private final UniqueKey key;

    public CallableSingleObjectRetriever( DataObjectLoader dao, UniqueKey key ) {
        this.dao = dao;
        this.key = key;
    }

    @Override
    public DataObject call( ) throws Exception {
        return dao.load(key);
    }
}

final class CallableMultiObjectRetriever implements Callable<ImmutableCollection<DataObject>>
{
    private final DataObjectLoader dao;
    private final GeneralKey key;

    public CallableMultiObjectRetriever( DataObjectLoader dao, GeneralKey key ) {
        this.dao = dao;
        this.key = key;
    }

    @Override
    public ImmutableCollection<DataObject> call( ) throws Exception {
        return CollectionUtil.copyToImmutableList(dao.load(key));
    }
}
