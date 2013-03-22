package com.tguzik.cwierkacz.common.initialization.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.common.configuration.ProcessorsConfiguration;
import com.tguzik.cwierkacz.common.configuration.SingleProcessorConfiguration;
import com.tguzik.cwierkacz.common.initialization.InitializationState;
import com.tguzik.cwierkacz.common.initialization.ProcessorFactory;

public class InitProcessors implements InitializationTask<ImmutableMap<String, Processor>>
{
    private final Future<InitializationState> futureState;

    public InitProcessors( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public ImmutableMap<String, Processor> call( ) throws Exception {
        ProcessorsConfiguration configuration = getConfiguration().getProcessorConfigurations();
        ProcessorFactory factory = new ProcessorFactory(getDataAccessor());
        ThreadPoolExecutor endpointThreadPool = getEndpointThreadPool();
        Builder<String, Processor> builder = ImmutableMap.builder();

        for ( SingleProcessorConfiguration spc : configuration.getProcessors() ) {
            Processor processor = createProcessor(factory, spc, endpointThreadPool);
            builder.put(spc.getName(), processor);
        }

        return builder.build();
    }

    private Processor createProcessor( ProcessorFactory factory,
                                       SingleProcessorConfiguration spc,
                                       ThreadPoolExecutor endpointThreadPool ) {
        return factory.create(spc.getClazz(), spc.getProperties(), endpointThreadPool);
    }

    private ApplicationConfiguration getConfiguration( ) throws InterruptedException, ExecutionException {
        return futureState.get().getConfiguration().get();
    }

    private ThreadPoolExecutor getEndpointThreadPool( ) throws InterruptedException, ExecutionException {
        return futureState.get().getEndpointThreadPool().get();
    }

    private DataAccessor getDataAccessor( ) throws InterruptedException, ExecutionException {
        return futureState.get().getDataAccessor().get();
    }

    @Override
    public String getName( ) {
        return "Processor repository";
    }
}
