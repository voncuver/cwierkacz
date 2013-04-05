package com.tguzik.cwierkacz.server;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.tguzik.cwierkacz.utils.thread.ThreadUtils;

// TODO: Refactor this class away.
public class Application implements Callable<Void>
{
    private final ApplicationContext context;
    private final ExecutorService serverThreadPool;

    public Application( ApplicationContext context ) {
        this.serverThreadPool = createInterfacesThreadPool();
        this.context = context;
    }

    private ExecutorService createInterfacesThreadPool( ) {
        ThreadFactory factory = ThreadUtils.createThreadFactory("interfaces");
        ExecutorService pool = Executors.newCachedThreadPool(factory);

        return Executors.unconfigurableExecutorService(pool);
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
