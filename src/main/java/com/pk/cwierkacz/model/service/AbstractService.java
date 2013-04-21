package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AbstractService< T >
{
    protected final SessionFactory sessionFactory;

    public AbstractService( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }

    public void save( T t ) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    public void merge( T t ) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.merge(t);
        session.getTransaction().commit();
        session.close();
    }

    public void saveOrUpdate( T t ) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
    }

    @Deprecated
    //rather marked that entity was deleted
    public void delete( T t ) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    public List<T> getListByQuery( String query ) {
        Session session = sessionFactory.openSession();
        @SuppressWarnings( "unchecked" )
        List<T> result = session.createQuery(query).list();
        session.close();
        return result;
    }

    public T getByQuery( String query ) {
        Session session = sessionFactory.openSession();
        @SuppressWarnings( "unchecked" )
        T result = (T) session.createQuery(query).list().get(0);
        session.close();
        return result;
    }

    @SuppressWarnings( "rawtypes" )
    public Criteria getCriteria( Class className ) {
        return sessionFactory.openSession().createCriteria(className);
    }

}
