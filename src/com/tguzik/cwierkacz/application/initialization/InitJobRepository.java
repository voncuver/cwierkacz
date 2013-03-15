package com.tguzik.cwierkacz.application.initialization;

import java.util.concurrent.Future;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.tguzik.cwierkacz.application.ApplicationContextBuilder;
import com.tguzik.cwierkacz.application.configuration.CwierkaczConfiguration;
import com.tguzik.cwierkacz.application.configuration.JobsConfiguration;
import com.tguzik.cwierkacz.application.configuration.SingleJobConfiguration;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.ProcessorChainElement;

public class InitJobRepository implements InitializationTask<ImmutableMap<String, Job>>
{
    private final Future<ImmutableMap<String, Processor>> processorsFuture;
    private final JobsConfiguration jobsConfiguration;
    private final ApplicationContextBuilder builder;

    InitJobRepository( CwierkaczConfiguration configuration, ApplicationContextBuilder builder,
                       Future<ImmutableMap<String, Processor>> processors ) {
        this.jobsConfiguration = configuration.getJobsConfiguration();
        this.processorsFuture = processors;
        this.builder = builder;
    }

    @Override
    public ImmutableMap<String, Job> call( ) throws Exception {
        ImmutableMap<String, Processor> processors = processorsFuture.get();
        Builder<String, Job> jobs = ImmutableMap.builder();

        for ( SingleJobConfiguration sjc : jobsConfiguration.getJobs() ) {
            jobs.put(sjc.getName(), createJob(processors, sjc));
        }

        builder.withJobRepository(jobs.build());
        return jobs.build();
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
