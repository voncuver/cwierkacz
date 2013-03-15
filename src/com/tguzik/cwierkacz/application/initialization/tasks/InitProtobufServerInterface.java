package com.tguzik.cwierkacz.application.initialization.tasks;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.InterfaceConfiguration;

public class InitProtobufServerInterface implements InitializationTask<Void>
{
    private final Future<ThreadPoolExecutor> threadPoolFuture;
    private final InterfaceConfiguration configuration;
    private final ApplicationContextBuilder builder;

    public InitProtobufServerInterface( InterfaceConfiguration configuration, ApplicationContextBuilder builder,
                                        Future<ThreadPoolExecutor> threadPool ) {
        this.configuration = configuration;
        this.threadPoolFuture = threadPool;
        this.builder = builder;
    }

    @Override
    public Void call( ) throws Exception {
        Object protobuf = null;

        builder.withInterface(getName(), null);
        return null;
    }

    @Override
    public String getName( ) {
        return "PROTOBUFSRV";
    }
}
