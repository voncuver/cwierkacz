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
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(t);
        session.getTransaction().commit();
    }

    public void merge( T t ) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.merge(t);
        session.getTransaction().commit();
    }

    public void saveOrUpdate( T t ) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(t);
        session.getTransaction().commit();
    }

    //rather marked that entity was deleted
    public void delete( T t ) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.delete(t);
        session.getTransaction().commit();
    }

    public List<T> getListByQuery( String query ) {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings( "unchecked" )
        List<T> result = session.createQuery(query).list();
        return result;
    }

    public T getByQuery( String query ) {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings( "unchecked" )
        T result = (T) session.createQuery(query).list().get(0);
        return result;
    }

    @SuppressWarnings( "rawtypes" )
    public Criteria getCriteria( Class className ) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.createCriteria(className);
    }

    public void commit( ) {
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

}
