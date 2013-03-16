package com.tguzik.cwierkacz.interfaces.protobuf;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.application.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.interfaces.AbstractSocketInterface;

public class ProtobufServerInterface extends AbstractSocketInterface
{

    public ProtobufServerInterface( ThreadPoolExecutor threadPool, SingleInterfaceConfiguration configuration )
                                                                                                               throws IOException {
        super(getCanonicalName(), threadPool, configuration.getPortNumber());
    }

    @Override
    protected Runnable createWorker( Socket clientSocket, String originInterface ) {
        return new ProtobufWorker(clientSocket, originInterface);
    }

    public static String getCanonicalName( ) {
        return "ProtobufServer";
    }
}
