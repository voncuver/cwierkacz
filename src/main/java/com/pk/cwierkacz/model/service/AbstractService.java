package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

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
    @Deprecated
    public Criteria getCriteria( Class className ) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.createCriteria(className);
    }

    @Deprecated
    public void commit( ) {
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    public T getUniqueByCriteria( List<Criterion> restrictions, Class className ) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(className);
        for ( Criterion criterion : restrictions ) {
            criteria.add(criterion);
        }

        @SuppressWarnings( "unchecked" )
        T t = (T) criteria.uniqueResult();

        session.getTransaction().commit();
        session.close();

        return t;
    }

    public List<T> getListByCriteria( List<Criterion> restrictions, Class className, Order order ) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(className);
        for ( Criterion criterion : restrictions ) {
            criteria.add(criterion);
        }

        if ( order != null ) {
            criteria.addOrder(order);
        }

        @SuppressWarnings( "unchecked" )
        List<T> t = criteria.list();

        session.getTransaction().commit();
        session.close();

        return t;

    }

    public List<T> getListByCriteria( List<Criterion> restrictions, Class className ) {
        return getListByCriteria(restrictions, className, null);
    }
}
