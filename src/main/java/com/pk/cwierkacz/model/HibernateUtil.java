package com.pk.cwierkacz.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.pk.cwierkacz.Startable;
import com.pk.cwierkacz.exception.StartException;

public class HibernateUtil implements Startable
{
    private SessionFactory factory;

    @Override
    public void start( ) throws StartException {
        Configuration configuration = new Configuration();
        configuration.configure();
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
