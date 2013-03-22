package com.tguzik.cwierkacz.server.initialization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.google.common.util.concurrent.SettableFuture;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.initialization.task.InitConfiguration;
import com.tguzik.cwierkacz.server.initialization.task.InitDataAccessor;
import com.tguzik.cwierkacz.server.initialization.task.InitDatabaseService;
import com.tguzik.cwierkacz.server.initialization.task.InitEndpointThreadPool;
import com.tguzik.cwierkacz.server.initialization.task.InitInterfaces;
import com.tguzik.cwierkacz.server.initialization.task.InitJobs;
import com.tguzik.cwierkacz.server.initialization.task.InitMainThreadPool;
import com.tguzik.cwierkacz.server.initialization.task.InitProcessors;
import com.tguzik.cwierkacz.server.initialization.task.InitializationTask;
import com.tguzik.cwierkacz.server.initialization.task.InitializeComponents;

public class ApplicationInitialization
{
    private final String configurationDirectory;
    private final ParallelLoader parallelLoader;

    public ApplicationInitialization( String configurationDirectory ) {
        this.configurationDirectory = configurationDirectory;
        this.parallelLoader = new ParallelLoader();
    }

    /**
     * <h1>Here be dragons.</h1>
     * 
     * Basically what we are doing is abusing the Future<T> system in a way that
     * we create a future that will hold a class that holds other futures, and
     * then we create those futures using the first one. Don't do it at home ;-) <br>
     * Oh, and if we get a cycle, then we're screwed.
     * 
     */
    public ApplicationContext initialize( ) throws InterruptedException, ExecutionException {
        SettableFuture<InitializationState> futureState = SettableFuture.<InitializationState> create();
        InitializationState state = submitTasks(futureState);
        futureState.set(state);

        // Once all tasks to create subcomponents are submitted, let's add a task to initialize them
        // Note: This could be added in the submitTasks(..), but it's here for readability
        parallel(new InitializeComponents(futureState));

        // Wait for all components to initialize, check for exceptions and then shut down the loader
        parallelLoader.checkForExceptions();
        parallelLoader.shutdown();

        return state.buildContext();
    }

    private < T > Future<T> parallel( InitializationTask<T> task ) {
        return parallelLoader.schedule(task);
    }

    private InitializationState submitTasks( SettableFuture<InitializationState> futureState ) {
        return new InitializationState(configurationDirectory, // 
                                       parallel(new InitInterfaces(futureState)),
                                       parallel(new InitProcessors(futureState)),
                                       parallel(new InitJobs(futureState)),
                                       parallel(new InitEndpointThreadPool(futureState)),
                                       parallel(new InitConfiguration(futureState)),
                                       parallel(new InitMainThreadPool(futureState)),
                                       parallel(new InitDatabaseService(futureState)),
                                       parallel(new InitDataAccessor(futureState)));
    }
}
