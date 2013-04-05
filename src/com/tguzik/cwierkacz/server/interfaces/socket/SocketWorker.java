package com.tguzik.cwierkacz.server.interfaces.socket;

import java.io.IOException;
import java.net.Socket;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.common.Initializable;
import com.tguzik.cwierkacz.utils.annotation.SingleThreaded;

@SingleThreaded
public class SocketWorker implements Initializable
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketWorker.class);
    private final String originInterface;
    private final Socket clientSocket;

    private SocketWorker( Socket clientSocket, String originInterface ) {
        this.originInterface = originInterface;
        this.clientSocket = clientSocket;
    }

    @Override
    public void initialize( ) throws Exception {
        // do nothing.
    }

    @Override
    public void shutdown( ) {
        IOUtils.closeQuietly(clientSocket);
    }

    public String getRequest( ) throws IOException {
        return IOUtils.toString(clientSocket.getInputStream());
    }

    public void sendResponse( String response ) {
        try {
            LOGGER.info("[{}] Sending response: {}", originInterface, response); //TODO: Change to debug stream.
            IOUtils.write(response, clientSocket.getOutputStream());
        }
        catch ( Exception e ) {
            LOGGER.error("Error while sending response", e);
        }
    }

    public String getRemoteAddress( ) {
        return String.valueOf(clientSocket.getRemoteSocketAddress());
    }

    public String getOriginInterface( ) {
        return originInterface;
    }

    public static SocketWorker create( Socket clientSocket, String originInterface ) {
        return new SocketWorker(clientSocket, originInterface);
    }
}
