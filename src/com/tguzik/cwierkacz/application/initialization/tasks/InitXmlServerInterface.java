package com.tguzik.cwierkacz.application.initialization.tasks;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.InterfaceConfiguration;

public class InitXmlServerInterface implements InitializationTask<Void>
{
    private final InterfaceConfiguration configuration;
    private final ApplicationContextBuilder builder;
    private final Future<ThreadPoolExecutor> threadPoolFuture;

    public InitXmlServerInterface( InterfaceConfiguration configuration, ApplicationContextBuilder builder,
                                   Future<ThreadPoolExecutor> threadPool ) {
        this.configuration = configuration;
        this.threadPoolFuture = threadPool;
        this.builder = builder;
    }

    @Override
    public Void call( ) throws Exception {
        ThreadPoolExecutor threadPool = threadPoolFuture.get();

        builder.withInterface(getName(), null);
        return null;
    }

    @Override
    public String getName( ) {
        return "XMLSRV";
    }
}
