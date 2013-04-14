package com.tguzik.cwierkacz.server.initialization.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.common.configuration.ApplicationConfiguration;
import com.tguzik.cwierkacz.common.configuration.JobsConfiguration;
import com.tguzik.cwierkacz.common.configuration.SingleJobConfiguration;
import com.tguzik.cwierkacz.common.processing.Job;
import com.tguzik.cwierkacz.common.processing.ProcessorChainElement;
import com.tguzik.cwierkacz.common.processing.traits.Processor;
import com.tguzik.cwierkacz.server.initialization.InitializationState;

public final class InitializeJobRepository implements InitializationTask<ImmutableMap<String, Job>>
{
    private final Future<InitializationState> futureState;

    public InitializeJobRepository( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public ImmutableMap<String, Job> call( ) throws Exception {
        JobsConfiguration jobConfigurations = getConfiguration().getJobConfigurations();
        ImmutableMap.Builder<String, Job> builder = ImmutableMap.builder();
        ImmutableMap<String, Processor> processors = getProcessors();

        for ( SingleJobConfiguration sjc : jobConfigurations.getJobs() ) {
            builder.put(sjc.getName(), createJob(processors, sjc));
        }

        return builder.build();
    }

    private Job createJob( ImmutableMap<String, Processor> processors, SingleJobConfiguration jobConfig ) {
        ProcessorChainElement chain = null;
        String name = jobConfig.getName();

        for ( String stage : jobConfig.getLifecycleStageNames() ) {
            Processor processor = processors.get(stage);

            if ( processor == null ) {
                throw new IllegalArgumentException(String.format("Stage %s in %s is not bound to any processor!",
                                                                 stage,
                                                                 name));
            }

            chain = ProcessorChainElement.create(chain, name, processor);
        }

        return Job.create(name, chain, jobConfig.getProperties());
    }

    private ApplicationConfiguration getConfiguration( ) throws InterruptedException, ExecutionException {
        return futureState.get().getConfiguration().get();
    }

    private ImmutableMap<String, Processor> getProcessors( ) throws InterruptedException, ExecutionException {
        return futureState.get().getProcessorsByName().get();
    }

    @Override
    public String getName( ) {
        return "Initialize Job Repository";
    }
}
