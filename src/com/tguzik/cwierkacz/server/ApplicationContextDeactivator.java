package com.tguzik.cwierkacz.server;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Initializable;
import com.tguzik.cwierkacz.database.DatabaseService;

public class ApplicationContextDeactivator
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextDeactivator.class);

    public static void deactivate( ApplicationContext context ) {
        if ( context == null ) {
            return;
        }

        deactivateMap(context.getInterfacesByName(), "interfaces");
        deactivateThreadPool(context.getMainThreadPool());
        deactivateThreadPool(context.getEndpointThreadPool());
        deactivateMap(context.getProcessorsByName(), "processors");
        deactivateDataAccessor(context.getDataAccessor());
        deactivateDatabaseService(context.getDatabaseService());

        LOGGER.info("Deactivation complete");
    }

    private static void deactivateMap( Map<String, ?> map, String name ) {
        if ( map == null ) {
            return;
        }

        log(name);
        for ( Map.Entry<String, ?> entry : map.entrySet() ) {
            if ( entry.getValue() instanceof Initializable ) {
                log(entry.getKey());
                ( (Initializable) entry.getValue() ).shutdown();
            }
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

    private static void deactivateDataAccessor( DataAccessor dataAccessor ) {
        if ( dataAccessor == null ) {
            return;
        }

        log("Data Accessor");
        dataAccessor.shutdown();
    }

    private static void deactivateDatabaseService( DatabaseService databaseService ) {
        if ( databaseService == null ) {
            return;
        }

        log("Data Accessor");
        databaseService.shutdown();
    }

    private static void log( String name ) {
        LOGGER.info("Deactivating {}", name);
    }
}
