package com.tguzik.cwierkacz.common.initialization.tasks;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.common.configuration.InterfaceConfiguration;
import com.tguzik.cwierkacz.common.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.server.ApplicationContextBuilder;
import com.tguzik.cwierkacz.server.interfaces.protobuf.ProtobufServerInterface;

public class InitProtobufServerInterface implements InitializationTask<ProtobufServerInterface>
{
    private final Future<ThreadPoolExecutor> threadPoolFuture;
    private final SingleInterfaceConfiguration configuration;
    private final ApplicationContextBuilder builder;

    public InitProtobufServerInterface( InterfaceConfiguration configuration, ApplicationContextBuilder builder,
                                        Future<ThreadPoolExecutor> threadPool ) {
        this.configuration = findWithName(configuration.getInterfaces(), getName());
        this.threadPoolFuture = threadPool;
        this.builder = builder;
    }

    @Override
    public ProtobufServerInterface call( ) throws Exception {
        ThreadPoolExecutor threadPool = threadPoolFuture.get();
        ProtobufServerInterface psi;

        psi = new ProtobufServerInterface(threadPool, configuration);

        builder.withInterface(getName(), psi);
        return psi;
    }

    @Override
    public String getName( ) {
        return ProtobufServerInterface.getCanonicalName();
    }

    private static SingleInterfaceConfiguration findWithName( ImmutableList<SingleInterfaceConfiguration> interfaces,
                                                              String name ) {
        for ( SingleInterfaceConfiguration sic : interfaces ) {
            if ( StringUtils.equalsIgnoreCase(name, sic.getName()) ) {
                return sic;
            }
        }

        return null;
    }
}
