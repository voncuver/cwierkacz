package com.tguzik.cwierkacz.interfaces;

import static java.lang.String.format;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.utils.annotation.SingleThreaded;

@SingleThreaded
public abstract class InterfaceWorker implements Runnable
{
    private static final Logger LOGGER = LoggerFactory.getLogger(InterfaceWorker.class);
    private final Socket clientSocket;

    protected InterfaceWorker( Socket clientSocket ) {
        this.clientSocket = clientSocket;
    }

    @Override
    public final void run( ) {
        try {
            createRequest(clientSocket.getInputStream());
            process();
            createResponse(clientSocket.getOutputStream());
            postprocessing();
        }
        catch ( Exception e ) {
            LOGGER.error("Exception caught while processing", e);
        }
        finally {
            try {
                clientSocket.close();
            }
            catch ( IOException e ) {
                LOGGER.error("Exception caught while closing client socket", e);
            }
        }
    }

    protected void preprocessing( ) {
        LOGGER.info(format("Interacting with client %s", clientSocket.getRemoteSocketAddress()));
    }

    protected void postprocessing( ) {
        LOGGER.info(format("Finished interacting with client %s", clientSocket.getRemoteSocketAddress()));
    }

    abstract protected void createRequest( InputStream inputStream );

    abstract protected void process( );

    abstract protected void createResponse( OutputStream outputStream );
}
