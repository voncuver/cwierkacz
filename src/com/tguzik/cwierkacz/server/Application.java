package com.tguzik.cwierkacz.server;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// TODO: Refactor this class away.
public class Application implements Callable<Void>
{
    private final ApplicationContext context;
    private final ExecutorService serverThreadPool;

    public Application( ApplicationContext context ) {
        this.serverThreadPool = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        this.context = context;
    }

    @Override
    public Void call( ) throws Exception {
        serverThreadPool.invokeAll(context.getInterfacesByName().values());
        return null;
    }

    public static void createAndRun( ApplicationContext context ) throws Exception {
        new Application(context).call();
    }
}
