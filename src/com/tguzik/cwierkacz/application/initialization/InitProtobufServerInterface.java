package com.tguzik.cwierkacz.application.initialization;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;

public class InitProtobufServerInterface implements InitializationTask<Void>
{
    private final Future<ThreadPoolExecutor> threadPoolFuture;
    private final CwierkaczConfiguration configuration;
    private final ApplicationContextBuilder builder;

    InitProtobufServerInterface( CwierkaczConfiguration configuration, ApplicationContextBuilder builder,
                                 Future<ThreadPoolExecutor> threadPool ) {
        this.configuration = configuration;
        this.threadPoolFuture = threadPool;
        this.builder = builder;
    }

    @Override
    public Void call( ) throws Exception {
        Object protobuf = null;

        builder.withProtobufServerInterface(protobuf);
        return null;
    }

    @Override
    public String getName( ) {
        return "Protobuf Server interface initialization";
    }
}
