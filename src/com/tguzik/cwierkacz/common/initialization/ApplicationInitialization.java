package com.tguzik.cwierkacz.common.initialization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.google.common.util.concurrent.SettableFuture;
import com.tguzik.cwierkacz.common.initialization.task.InitializationTask;
import com.tguzik.cwierkacz.common.initialization.task.InitializeApplicationContext;
import com.tguzik.cwierkacz.common.initialization.task.InitializeComponents;
import com.tguzik.cwierkacz.common.initialization.task.InitializeConfiguration;
import com.tguzik.cwierkacz.common.initialization.task.InitializeDataAccessor;
import com.tguzik.cwierkacz.common.initialization.task.InitializeDatabaseService;
import com.tguzik.cwierkacz.common.initialization.task.InitializeEndpointThreadPool;
import com.tguzik.cwierkacz.common.initialization.task.InitializeInterfaces;
import com.tguzik.cwierkacz.common.initialization.task.InitializeJobRepository;
import com.tguzik.cwierkacz.common.initialization.task.InitializeMainThreadPool;
import com.tguzik.cwierkacz.common.initialization.task.InitializeProcessors;
import com.tguzik.cwierkacz.server.ApplicationContext;

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
     * then we create those futures using the first one. Yeah. Don't do it at
     * home ;-) <br>
     * Oh, and if we get a cycle, then we're screwed.
     */
    public ApplicationContext initialize( ) throws InterruptedException, ExecutionException {
        SettableFuture<InitializationState> futureState = SettableFuture.<InitializationState> create();
        futureState.set(submitTasksForInitializationState(futureState));
        submitMiscleanousTasks(futureState);

        // This one if kind of important :)
        parallel(new InitializeApplicationContext(futureState));

        // Wait for all components to initialize, check for exceptions and then shut down the loader
        parallelLoader.checkForExceptions();
        parallelLoader.shutdown();

        return futureState.get().getApplicationContext().get();
    }

    private void submitMiscleanousTasks( SettableFuture<InitializationState> futureState ) {
        parallel(new InitializeComponents(futureState));
        // FIXME: Implement database connection
        // parallel(new PreloadCacheRegions(futureState));
    }

    private < T > Future<T> parallel( InitializationTask<T> task ) {
        return parallelLoader.schedule(task);
    }

    private InitializationState submitTasksForInitializationState( SettableFuture<InitializationState> futureState ) {
        return new InitializationState(configurationDirectory, // 
                                       parallel(new InitializeInterfaces(futureState)),
                                       parallel(new InitializeProcessors(futureState)),
                                       parallel(new InitializeJobRepository(futureState)),
                                       parallel(new InitializeEndpointThreadPool(futureState)),
                                       parallel(new InitializeConfiguration(futureState)),
                                       parallel(new InitializeMainThreadPool(futureState)),
                                       parallel(new InitializeDatabaseService(futureState)),
                                       parallel(new InitializeDataAccessor(futureState)));
    }
}
