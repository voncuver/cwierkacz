package com.tguzik.cwierkacz.interfaces;

import static java.lang.String.format;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.utils.annotation.Initializable;

public abstract class AbstractSocketInterface implements Initializable, Callable<Void>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSocketInterface.class);
    private final ThreadPoolExecutor threadPool;
    private final ServerSocket serverSocket;
    private final String nameWithPort;
    private final short portNumber;

    protected AbstractSocketInterface( String interfaceName, ThreadPoolExecutor threadPool, short portNumber )
                                                                                                              throws IOException {
        this.nameWithPort = format("%s:%d", interfaceName, portNumber);
        this.serverSocket = new ServerSocket();
        this.threadPool = threadPool;
        this.portNumber = portNumber;
    }

    @Override
    public final Void call( ) {
        try {
            initialize();

            while ( serverSocket.isBound() ) {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(createWorker(clientSocket));
            }
        }
        catch ( Exception e ) {
            LOGGER.error(format("[%s] Recieved exception %s:%s", nameWithPort, e.getClass().getName(), e.getMessage()));
        }
        finally {
            shutdown();
        }
        return null;
    }

    @Override
    public void initialize( ) throws IOException {
        LOGGER.info(format("[%s] Binding socket...", nameWithPort));

        serverSocket.setSoTimeout(0);
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(portNumber));

        LOGGER.info(format("[%s] Socket bound, accepting connections", nameWithPort));
    }

    @Override
    public void shutdown( ) {
        if ( serverSocket.isClosed() ) {
            return;
        }

        try {
            LOGGER.info(format("[%s] Closing socket...", nameWithPort));
            serverSocket.close();
        }
        catch ( IOException e ) {
            LOGGER.error(format("[%s] Error during clean up: %s:%s",
                                nameWithPort,
                                e.getClass().getName(),
                                e.getMessage()));
        }
    }

    public String getNameWithPort( ) {
        return nameWithPort;
    }

    protected abstract Runnable createWorker( Socket clientSocket );
}
