package com.tguzik.cwierkacz.server;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterface;

public class ApplicationContextDeactivator
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextDeactivator.class);

    public static void deactivate( ApplicationContext context ) {
        if ( context == null ) {
            return;
        }

        deactivateInterfaces(context.getInterfacesByName());
        deactivateThreadPool(context.getMainThreadPool());
        deactivateProcessors(context.getProcessorsByName());
        deactivateDataAccessor(context.getDataAccessor());

        LOGGER.info("Deactivation complete");
    }

    private static void deactivateInterfaces( ImmutableMap<String, AbstractSocketInterface> interfacesByName ) {
        if ( interfacesByName == null ) {
            return;
        }

        log("interfaces...");
        for ( Map.Entry<String, AbstractSocketInterface> entry : interfacesByName.entrySet() ) {
            log(entry.getKey());
            entry.getValue().shutdown();
        }
    }

    private static void deactivateThreadPool( ThreadPoolExecutor mainThreadPool ) {
        if ( mainThreadPool == null ) {
            return;
        }

        log("Main Thread Pool");
        try {
            mainThreadPool.shutdown();
            mainThreadPool.awaitTermination(10L, TimeUnit.SECONDS);
        }
        catch ( InterruptedException e ) {
            LOGGER.error("Error while waiting for Main Thread Pool to shut down", e);
        }
    }

    private static void deactivateProcessors( ImmutableMap<String, Processor> processorsByName ) {
        if ( processorsByName == null ) {
            return;
        }

        log("processors...");
        for ( Map.Entry<String, Processor> entry : processorsByName.entrySet() ) {
            log(entry.getKey());
            entry.getValue().shutdown();
        }
    }

    private static void deactivateDataAccessor( DataAccessor dataAccessor ) {
        if ( dataAccessor == null ) {
            return;
        }

        if ( dataAccessor != null ) {
            log("Data Accessor");
            dataAccessor.shutdown();
        }
    }

    private static void log( String name ) {
        LOGGER.info(String.format("Deactivating %s", name));
    }
}
