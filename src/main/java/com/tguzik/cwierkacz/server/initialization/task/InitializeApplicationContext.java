package com.tguzik.cwierkacz.server.initialization.task;

import java.util.concurrent.Future;

import com.google.common.util.concurrent.SettableFuture;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.initialization.InitializationState;

public class InitializeApplicationContext implements InitializationTask<Void>
{
    private final Future<InitializationState> futureState;

    public InitializeApplicationContext( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public Void call( ) throws Exception {
        InitializationState state = futureState.get();
        SettableFuture<ApplicationContext> applicationContext = state.getApplicationContext();

        applicationContext.set(ApplicationContext.builder()
                                                 .withDataAccessor(state.getDataAccessor().get())
                                                 .withApplicationConfiguration(state.getConfiguration().get())
                                                 .withDatabaseService(state.getDatabaseService().get())
                                                 .withEndpointThreadPool(state.getEndpointThreadPool().get())
                                                 .withInterfacesByName(state.getInterfacesByName().get())
                                                 .withJobsByName(state.getJobsByName().get())
                                                 .withMainThreadPool(state.getMainThreadPool().get())
                                                 .withProcessorsByName(state.getProcessorsByName().get())
                                                 .build());

        return null;
    }

    @Override
    public String getName( ) {
        return "Initialize Application Context";
    }
}
