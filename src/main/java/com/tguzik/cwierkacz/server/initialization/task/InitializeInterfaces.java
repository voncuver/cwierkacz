package com.tguzik.cwierkacz.server.initialization.task;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.common.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.common.configuration.InterfaceConfiguration;
import com.tguzik.cwierkacz.common.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.initialization.InitializationState;
import com.tguzik.cwierkacz.server.interfaces.socket.AbstractServerSocketInterface;
import com.tguzik.cwierkacz.server.interfaces.xmlserver.XmlServerInterface;

public final class InitializeInterfaces implements
                                       InitializationTask<ImmutableMap<String, AbstractServerSocketInterface>>
{
    private final Future<InitializationState> futureState;

    public InitializeInterfaces( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public ImmutableMap<String, AbstractServerSocketInterface> call( ) throws Exception {
        ImmutableMap.Builder<String, AbstractServerSocketInterface> builder = ImmutableMap.builder();
        InterfaceConfiguration interfaces = getConfiguration().getInterfaceConfigurations();

        for ( SingleInterfaceConfiguration sic : interfaces.getInterfaces() ) {
            if ( sic.isEnabled() ) {
                builder.put(sic.getName(), createMatchingInterface(sic));
            }
        }

        return builder.build();
    }

    private AbstractServerSocketInterface createMatchingInterface( SingleInterfaceConfiguration sic ) throws IOException,
                                                                                               InterruptedException,
                                                                                               ExecutionException {
        Future<ApplicationContext> futureContext = futureState.get().getApplicationContext();
        String name = String.valueOf(sic.getName()).toLowerCase();

        switch ( name ) {
        case "xmlserver":
            return new XmlServerInterface(getMainThreadPool(), sic, futureContext);

        default:
            throw new IllegalArgumentException("Unknown interface " + name);
        }
    }

    private ApplicationConfiguration getConfiguration( ) throws InterruptedException, ExecutionException {
        return futureState.get().getConfiguration().get();
    }

    private ThreadPoolExecutor getMainThreadPool( ) throws InterruptedException, ExecutionException {
        return futureState.get().getMainThreadPool().get();
    }

    @Override
    public String getName( ) {
        return "Initialize Interfaces";
    }
}
