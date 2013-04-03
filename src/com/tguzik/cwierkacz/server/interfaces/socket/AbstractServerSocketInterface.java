package com.tguzik.cwierkacz.server.interfaces.socket;

import static java.lang.String.format;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.common.Initializable;

public abstract class AbstractServerSocketInterface implements Initializable, Callable<Void>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractServerSocketInterface.class);
    private final ThreadPoolExecutor threadPool;
    private final ServerSocket serverSocket;
    private final String nameWithPort;
    private final short portNumber;

    protected AbstractServerSocketInterface( String interfaceName, ThreadPoolExecutor threadPool, short portNumber ) throws IOException {
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
                threadPool.execute(createWorker(clientSocket, nameWithPort));
            }
        }
        catch ( Exception e ) {
            LOGGER.error("[{}] Recieved exception {}:{}",
                         nameWithPort,
                         e.getClass().getName(),
                         e.getMessage());
        }
        finally {
            shutdown();
        }
        return null;
    }

    @Override
    public void initialize( ) throws Exception {
        LOGGER.info("[{}] Binding socket...", nameWithPort);

        serverSocket.setSoTimeout(0);
        serverSocket.setReuseAddress(true);
        serverSocket.setPerformancePreferences(2, 1, 0);
        serverSocket.bind(new InetSocketAddress(portNumber));

        LOGGER.info("[{}] Socket bound, accepting connections", nameWithPort);
    }

    @Override
    public void shutdown( ) {
        if ( serverSocket.isClosed() ) {
            return;
        }

        try {
            LOGGER.info("[{}] Closing socket...", nameWithPort);
            serverSocket.close();
        }
        catch ( IOException e ) {
            LOGGER.error("[{}] Error during clean up: {}:{}",
                         nameWithPort,
                         e.getClass().getName(),
                         e.getMessage());
        }
    }

    public String getNameWithPort( ) {
        return nameWithPort;
    }

    protected abstract Runnable createWorker( Socket clientSocket, String originInterface );
}
