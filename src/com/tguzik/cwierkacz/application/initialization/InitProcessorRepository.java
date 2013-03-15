package com.tguzik.cwierkacz.application.initialization;

import java.util.concurrent.Future;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleProcessorConfiguration;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Processor;

public class InitProcessorRepository implements InitializationTask<ImmutableMap<String, Processor>>
{
    private final CwierkaczConfiguration configuration;
    private final ApplicationContextBuilder builder;
    private final Future<DataAccessor> daFuture;

    InitProcessorRepository( CwierkaczConfiguration configuration, ApplicationContextBuilder builder,
                             Future<DataAccessor> daFuture ) {
        this.configuration = configuration;
        this.daFuture = daFuture;
        this.builder = builder;
    }

    @Override
    public ImmutableMap<String, Processor> call( ) throws Exception {
        ProcessorFactory factory = new ProcessorFactory(daFuture.get());
        Builder<String, Processor> processors = ImmutableMap.builder();

        for ( SingleProcessorConfiguration spc : configuration.getProcessorsConfiguration().getProcessors() ) {
            processors.put(spc.getName(), createProcessor(factory, spc));
        }

        builder.withProcessorsRepository(processors.build());
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
