package com.tguzik.cwierkacz.database;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.GeneralKey;
import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.common.processing.traits.Initializable;
import com.tguzik.cwierkacz.utils.CollectionUtil;

public class DatabaseService implements Initializable
{
    private final SqlSessionFactory factory;

    public DatabaseService( SqlSessionFactory factory ) {
        this.factory = factory;
    }

    public DataObject load( Class<? extends DataObject> table, UniqueKey key ) {
        SqlSession session = openSession();
        DataObject obj = (DataObject) session.selectOne(createQueryName(table, "single"), key);
        closeSession(session);
        return obj;
    }

    public ImmutableList<DataObject> load( Class<? extends DataObject> table, GeneralKey key ) {
        SqlSession session = openSession();
        List<DataObject> fetched = session.selectList(createQueryName(table, "list"), key);
        closeSession(session);
        return CollectionUtil.copyToImmutableList(fetched);
    }

    public void update( Class<? extends DataObject> table, DataObject obj ) {
        SqlSession session = openSession();
        session.update(createQueryName(table, "update"), obj);
        closeSession(session);
    }

    public void create( Class<? extends DataObject> table, DataObject obj ) {
        SqlSession session = openSession();
        session.insert(createQueryName(table, "insert"), obj);
        closeSession(session);
    }

    public void remove( Class<? extends DataObject> table, UniqueKey key ) {
        SqlSession session = openSession();
        session.delete(createQueryName(table, "remove"), key);
        closeSession(session);
    }

    SqlSession openSession( ) {
        SqlSession session = factory.openSession(false);
        return session;
    }

    void closeSession( SqlSession session ) {
        session.commit();
        session.close();
    }

    String createQueryName( Class<? extends DataObject> table, String kind ) {
        return table.getSimpleName().toLowerCase() + "." + kind;
    }

    @Override
    public void initialize( ) throws Exception {
    }

    @Override
    public void shutdown( ) {
    }
}
