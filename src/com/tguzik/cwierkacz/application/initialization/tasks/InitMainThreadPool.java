package com.tguzik.cwierkacz.application.initialization.tasks;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.ThreadPoolConfiguration;

public class InitMainThreadPool implements InitializationTask<ThreadPoolExecutor>
{
    private final ThreadPoolConfiguration configuration;
    private final ApplicationContextBuilder builder;

    public InitMainThreadPool( ThreadPoolConfiguration configuration, ApplicationContextBuilder builder ) {
        this.configuration = configuration;
        this.builder = builder;
    }

    @Override
    public ThreadPoolExecutor call( ) throws Exception {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(configuration.getMinPoolSize(),
                                                               configuration.getMaxPoolSize(),
                                                               configuration.getKeepAliveSeconds(),
                                                               TimeUnit.SECONDS,
                                                               new LinkedBlockingQueue<Runnable>(),
                                                               new ThreadPoolExecutor.DiscardPolicy());
        threadPool.prestartAllCoreThreads();

        builder.withMainThreadPool(threadPool);
        return threadPool;
    }

    @Override
    public String getName( ) {
        return "Main Thread Pool";
    }
}
