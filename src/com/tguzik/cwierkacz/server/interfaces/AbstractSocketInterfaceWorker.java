package com.tguzik.cwierkacz.server.interfaces;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.utils.annotation.SingleThreaded;

@SingleThreaded
public abstract class AbstractSocketInterfaceWorker implements Runnable
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSocketInterfaceWorker.class);
    private final String remoteAddress;
    private final String originInterface;
    private final Socket clientSocket;

    protected AbstractSocketInterfaceWorker( Socket clientSocket, String originInterface ) {
        this.remoteAddress = String.valueOf(clientSocket.getRemoteSocketAddress());
        this.originInterface = originInterface;
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

            ApplicationProcessingData data = createRequest(input);
            preprocessing(data);
            process(data);
            sendResponse(writer, createResponse(data));
            postprocessing(data);
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

        sendResponse(writer, produceErrorResponse(caught));
    }

    abstract protected void preprocessing( ApplicationProcessingData data ) throws Exception;

    abstract protected void postprocessing( ApplicationProcessingData data ) throws Exception;

    abstract protected String produceErrorResponse( Exception e );

    abstract protected ApplicationProcessingData createRequest( InputStream inputStream ) throws Exception;

    abstract protected void process( ApplicationProcessingData data ) throws Exception;

    abstract protected String createResponse( ApplicationProcessingData data ) throws Exception;
}
