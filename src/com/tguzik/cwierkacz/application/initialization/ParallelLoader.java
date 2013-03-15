package com.tguzik.cwierkacz.application.initialization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParallelLoader
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ParallelLoader.class);
    private final ExecutorService executor;

    public ParallelLoader() {
        this.executor = Executors.newCachedThreadPool();
    }

    public < T > Future<T> schedule( InitializationTask<T> task ) {
        LOGGER.info(String.format("Scheduling %s for initialization...", task.getName()));
        return executor.submit(task);
    }

    public void shutdown( ) throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
