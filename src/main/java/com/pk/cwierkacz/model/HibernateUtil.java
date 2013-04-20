package com.pk.cwierkacz.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.pk.cwierkacz.Startable;

public class HibernateUtil implements Startable
{
    private SessionFactory factory;

    private static class InstanceHolder
    {
        public static HibernateUtil hibernateUtil = new HibernateUtil();
    }

    public static HibernateUtil getInstance( ) {
        return InstanceHolder.hibernateUtil;
    }

    @Override
    public void start( ) {

        Configuration configuration = new Configuration();
        configuration.configure("main/resources/hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                                                                      .buildServiceRegistry();

        factory = configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    public void stop( ) {
        factory.close();
        factory = null;
    }

    public SessionFactory getSessionFactory( ) {
        return factory;
    }
}
