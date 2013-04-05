package com.tguzik.cwierkacz.server.initialization.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import com.tguzik.cwierkacz.common.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.common.configuration.ThreadPoolConfiguration;
import com.tguzik.cwierkacz.server.initialization.InitializationState;
import com.tguzik.cwierkacz.utils.thread.ThreadUtils;

public class InitializeMainThreadPool implements InitializationTask<ThreadPoolExecutor>
{
    private final Future<InitializationState> futureState;

    public InitializeMainThreadPool( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public ThreadPoolExecutor call( ) throws Exception {
        ThreadPoolConfiguration configuration = getConfiguration().getMainThreadPoolConfiguration();
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.DiscardOldestPolicy();
        BasicThreadFactory factory = ThreadUtils.createThreadFactory("main");

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(configuration.getMinPoolSize(),
                                                               configuration.getMaxPoolSize(),
                                                               configuration.getKeepAliveSeconds(),
                                                               TimeUnit.SECONDS,
                                                               new LinkedBlockingQueue<Runnable>(),
                                                               factory,
                                                               rejectedExecutionHandler);

        threadPool.prestartAllCoreThreads();
        return threadPool;
    }

    private ApplicationConfiguration getConfiguration( ) throws InterruptedException, ExecutionException {
        return futureState.get().getConfiguration().get();
    }

    @Override
    public String getName( ) {
        return "Initialize Main Thread Pool";
    }
}
