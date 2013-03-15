package com.tguzik.cwierkacz.interfaces;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.utils.annotation.Initializable;

public abstract class AbstractSocketInterface implements Initializable, Runnable
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSocketInterface.class);
    private final ThreadPoolExecutor threadPool;
    private final ServerSocket serverSocket;
    private final String interfaceName;
    private final short portNumber;

    protected AbstractSocketInterface( String interfaceName, ThreadPoolExecutor threadPool, short portNumber )
                                                                                                        throws IOException {
        this.interfaceName = String.format("%s:%d", interfaceName, portNumber);
        this.serverSocket = new ServerSocket();
        this.threadPool = threadPool;
        this.portNumber = portNumber;
    }

    @Override
    public void run( ) {
        try {
            initialize();

            while ( serverSocket.isBound() ) {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(createWorker(clientSocket));
            }
        }
        catch ( Exception e ) {
            LOGGER.error("[%s] Recieved exception %s:%s", interfaceName, e.getClass().getName(), e.getMessage());
        }
        finally {
            shutdown();
        }
    }

    @Override
    public void initialize( ) throws IOException {
        LOGGER.info("[%s] Binding socket...", interfaceName);

        serverSocket.setSoTimeout(0);
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(portNumber));

        LOGGER.info("[%s] Socket bound", interfaceName);
    }

    @Override
    public void shutdown( ) {
        if ( serverSocket.isClosed() ) {
            return;
        }

        try {
            LOGGER.info("[%s] Closing socket...");
            serverSocket.close();
        }
        catch ( IOException e ) {
            LOGGER.error("[%s] Error during clean up: %s:%s", interfaceName, e.getClass().getName(), e.getMessage());
        }
    }

    public String getInterfaceName( ) {
        return interfaceName;
    }

    protected abstract Runnable createWorker( Socket clientSocket );
}
