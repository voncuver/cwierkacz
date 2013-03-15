package com.tguzik.cwierkacz.application.initialization.tasks;

import java.util.concurrent.Future;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.JobsConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleJobConfiguration;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.ProcessorChainElement;

public class InitJobRepository implements InitializationTask<Void>
{
    private final Future<ImmutableMap<String, Processor>> processorsFuture;
    private final ApplicationContextBuilder builder;
    private final JobsConfiguration configuration;

    public InitJobRepository( JobsConfiguration configuration, ApplicationContextBuilder builder,
                              Future<ImmutableMap<String, Processor>> processors ) {
        this.configuration = configuration;
        this.processorsFuture = processors;
        this.builder = builder;
    }

    @Override
    public Void call( ) throws Exception {
        ImmutableMap<String, Processor> processors = processorsFuture.get();

        for ( SingleJobConfiguration sjc : configuration.getJobs() ) {
            builder.withJob(sjc.getName(), createJob(processors, sjc));
        }

        return null;
    }

    private Job createJob( ImmutableMap<String, Processor> processors, SingleJobConfiguration jobConfig ) {
        ProcessorChainElement chain = null;
        String name = jobConfig.getName();

        for ( String stage : jobConfig.getLifecycleStageNames() ) {
            Processor processor = processors.get(stage);

            if ( processor == null ) {
                throw new IllegalArgumentException(String.format("Stage %s is not bound to any processor!", stage));
            }

            chain = ProcessorChainElement.create(chain, name, processor);
        }

        return Job.create(name, chain, jobConfig.getProperties());
    }

    @Override
    public String getName( ) {
        return "Job Repository";
    }
}
