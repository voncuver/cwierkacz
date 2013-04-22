package com.pk.cwierkacz.model;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.Startable;
import com.pk.cwierkacz.exception.StartException;

public class HibernateUtil implements Startable
{
    Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    private SessionFactory factory;

    private static class InstanceHolder
    {
        public static HibernateUtil hibernateUtil = new HibernateUtil();
    }

    public static HibernateUtil getInstance( ) {
        return InstanceHolder.hibernateUtil;
    }

    @Override
    public void start( ) throws StartException {
        try {
            File file = new File("/");
            File[] files = file.listFiles();
            for ( File f : files ) {
                logger.debug(f.getAbsolutePath());
            }
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                                                                          .buildServiceRegistry();

            factory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch ( HibernateException ex ) {
            throw new StartException("Exception while starting hibernate", ex);
        }
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
