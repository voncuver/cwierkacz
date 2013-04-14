package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AbstractService< T >
{
    private final SessionFactory sessionFactory;

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

    public void saveOrUpdate( T t ) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
    }

    public void delete( T t ) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    public List<T> getByQuery( String query ) {
        Session session = sessionFactory.openSession();
        @SuppressWarnings( "unchecked" )
        List<T> result = session.createQuery(query).list();
        session.close();
        return result;
    }

}
