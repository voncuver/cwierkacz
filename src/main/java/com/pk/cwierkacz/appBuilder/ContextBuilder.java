package com.pk.cwierkacz.appBuilder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.model.HibernateUtil;
import com.pk.cwierkacz.processor.MainProcessor;

public class ContextBuilder implements ServletContextListener
{
    Logger logger = LoggerFactory.getLogger(ContextBuilder.class);

    @Override
    public void contextInitialized( ServletContextEvent arg0 ) {
        HibernateUtil.getInstance().start();
        MainProcessor.getInstance();
        logger.info("Application Startup");
        //build Processor

        //start Startable beans
    }

    @Override
    public void contextDestroyed( ServletContextEvent arg0 ) {
        logger.info("Application Shutdown");
        HibernateUtil.getInstance().stop();
    }
}
