package com.tguzik.cwierkacz.application.initialization;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.application.configuration.ThreadPoolConfiguration;

public class InitMainThreadPool implements InitializationTask<ThreadPoolExecutor>
{
    private final CwierkaczConfiguration configuration;
    private final ApplicationContextBuilder builder;

    InitMainThreadPool( CwierkaczConfiguration configuration, ApplicationContextBuilder builder ) {
        this.configuration = configuration;
        this.builder = builder;
    }

    @Override
    public ThreadPoolExecutor call( ) throws Exception {
        ThreadPoolConfiguration tpc = configuration.getThreadPoolConfiguration();

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(tpc.getMinPoolSize(),
                                                               tpc.getMaxPoolSize(),
                                                               tpc.getKeepAliveSeconds(),
                                                               TimeUnit.SECONDS,
                                                               new LinkedBlockingQueue<Runnable>(),
                                                               new ThreadPoolExecutor.DiscardPolicy());

        builder.withMainThreadPool(threadPool);
        return threadPool;
    }

    @Override
    public String getName( ) {
        return "Main Thread Pool";
    }
}
