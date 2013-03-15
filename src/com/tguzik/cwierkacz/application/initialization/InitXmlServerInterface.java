package com.tguzik.cwierkacz.application.initialization;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;

class InitXmlServerInterface implements InitializationTask<Void>
{
    private final CwierkaczConfiguration configuration;
    private final ApplicationContextBuilder builder;
    private final Future<ThreadPoolExecutor> threadPoolFuture;

    InitXmlServerInterface( CwierkaczConfiguration configuration, ApplicationContextBuilder builder,
                            Future<ThreadPoolExecutor> threadPool ) {
        this.configuration = configuration;
        this.threadPoolFuture = threadPool;
        this.builder = builder;
    }

    @Override
    public String getName( ) {
        return "XML Server interface initialization";
    }

    @Override
    public Void call( ) throws Exception {
        ThreadPoolExecutor threadPool = threadPoolFuture.get();

        return null;
    }

}
