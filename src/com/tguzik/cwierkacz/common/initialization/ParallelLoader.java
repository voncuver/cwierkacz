package com.tguzik.cwierkacz.common.initialization;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.tguzik.cwierkacz.common.initialization.task.InitializationTask;

public class ParallelLoader
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ParallelLoader.class);
    private final ExecutorService executor;
    private final List<Future<?>> futures;

    public ParallelLoader() {
        this.executor = Executors.newCachedThreadPool();
        this.futures = Lists.newArrayList();
    }

    public < T > Future<T> schedule( InitializationTask<T> task ) {
        LOGGER.info("Scheduling task {}...", task.getName());
        return keepReference(executor.submit(task));
    }

    public < T > Future<T> keepReference( Future<T> reference ) {
        futures.add(reference);
        return reference;
    }

    /** Throw any exceptions that occurred when loading components */
    public void checkForExceptions( ) throws InterruptedException, ExecutionException {
        for ( Future<?> future : futures ) {
            future.get();
        }
    }

    public void shutdown( ) throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        futures.clear();
    }
}
