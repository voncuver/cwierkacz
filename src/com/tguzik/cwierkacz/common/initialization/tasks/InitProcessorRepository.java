package com.tguzik.cwierkacz.common.initialization.tasks;

import java.util.concurrent.Future;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.configuration.ProcessorsConfiguration;
import com.tguzik.cwierkacz.common.configuration.SingleProcessorConfiguration;
import com.tguzik.cwierkacz.common.initialization.ProcessorFactory;
import com.tguzik.cwierkacz.server.ApplicationContextBuilder;

public class InitProcessorRepository implements InitializationTask<ImmutableMap<String, Processor>>
{
    private final ProcessorsConfiguration configuration;
    private final ApplicationContextBuilder builder;
    private final Future<DataAccessor> daFuture;

    public InitProcessorRepository( ProcessorsConfiguration configuration, ApplicationContextBuilder builder,
                                    Future<DataAccessor> daFuture ) {
        this.configuration = configuration;
        this.daFuture = daFuture;
        this.builder = builder;
    }

    @Override
    public ImmutableMap<String, Processor> call( ) throws Exception {
        ProcessorFactory factory = new ProcessorFactory(daFuture.get());
        Builder<String, Processor> processors = ImmutableMap.builder();

        for ( SingleProcessorConfiguration spc : configuration.getProcessors() ) {
            Processor processor = createProcessor(factory, spc);
            processor.initialize();

            builder.withProcessor(spc.getName(), processor);
            processors.put(spc.getName(), processor);
        }

        return processors.build();
    }

    private Processor createProcessor( ProcessorFactory factory, SingleProcessorConfiguration spc ) {
        return factory.getInstance(spc.getClazz(), spc.getProperties());
    }

    @Override
    public String getName( ) {
        return "Processor repository";
    }
}
