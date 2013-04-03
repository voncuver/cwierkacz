package com.tguzik.cwierkacz.server.interfaces.socket;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.server.interfaces.ProtocolWorker;
import com.tguzik.cwierkacz.utils.annotation.SingleThreaded;

@SingleThreaded
public class SocketWorker implements Runnable
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketWorker.class);
    private final ProtocolWorker protocolWorker;
    private final String remoteAddress;
    private final String originInterface;
    private final Socket clientSocket;

    private SocketWorker( Socket clientSocket,
                          ProtocolWorker protocolWorker,
                          String originInterface,
                          String remoteAddress ) {
        this.originInterface = originInterface;
        this.protocolWorker = protocolWorker;
        this.remoteAddress = remoteAddress;
        this.clientSocket = clientSocket;
    }

    @Override
    public final void run( ) {
        LOGGER.info("[{}] Interacting with {}", originInterface, remoteAddress);
        BufferedInputStream input = null;
        PrintWriter writer = null;

        try {
            input = new BufferedInputStream(clientSocket.getInputStream());
            writer = new PrintWriter(clientSocket.getOutputStream(), true);

            sendResponse(writer, protocolWorker.apply(input));
            protocolWorker.postprocessing();
        }
        catch ( Exception e ) {
            LOGGER.error("Exception caught while processing", e);
            sendErrorReply(writer, e);
        }
        finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(clientSocket);
            LOGGER.info("[{}] Finished interacting with {}", originInterface, remoteAddress);
        }
    }

    private void sendResponse( PrintWriter writer, String response ) {
        try {
            LOGGER.info("[{}] Sending response: {}", originInterface, response); //TODO: Change to debug stream.
            writer.write(response);
            writer.flush();
        }
        catch ( Exception e ) {
            LOGGER.error("Error while sending response", e);
        }
    }

    private void sendErrorReply( PrintWriter writer, Exception caught ) {
        if ( writer == null ) {
            return;
        }

        sendResponse(writer, protocolWorker.produceErrorResponse(caught));
    }

    public static SocketWorker create( Socket clientSocket,
                                       String originInterface,
                                       ProtocolWorker protocolWorker ) {
        return new SocketWorker(clientSocket,
                                protocolWorker,
                                originInterface,
                                String.valueOf(clientSocket.getRemoteSocketAddress()));
    }
}
