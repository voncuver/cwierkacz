package com.tguzik.cwierkacz.common.initialization.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.tguzik.cwierkacz.common.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.common.configuration.ThreadPoolConfiguration;
import com.tguzik.cwierkacz.common.initialization.InitializationState;

public class InitMainThreadPool implements InitializationTask<ThreadPoolExecutor>
{
    private final Future<InitializationState> futureState;

    public InitMainThreadPool( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public ThreadPoolExecutor call( ) throws Exception {
        ThreadPoolConfiguration configuration = getConfiguration().getMainThreadPoolConfiguration();

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(configuration.getMinPoolSize(),
                                                               configuration.getMaxPoolSize(),
                                                               configuration.getKeepAliveSeconds(),
                                                               TimeUnit.SECONDS,
                                                               new LinkedBlockingQueue<Runnable>(),
                                                               new ThreadPoolExecutor.DiscardPolicy());

        threadPool.prestartAllCoreThreads();
        return threadPool;
    }

    private ApplicationConfiguration getConfiguration( ) throws InterruptedException, ExecutionException {
        return futureState.get().getConfiguration().get();
    }

    @Override
    public String getName( ) {
        return "Main Thread Pool";
    }
}