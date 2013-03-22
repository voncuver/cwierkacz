package com.tguzik.cwierkacz.server.interfaces.xmlserver;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.server.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterface;

public class XmlServerInterface extends AbstractSocketInterface
{
    public XmlServerInterface( ThreadPoolExecutor threadPool, SingleInterfaceConfiguration configuration )
                                                                                                          throws IOException {
        super(getCanonicalName(), threadPool, configuration.getPortNumber());
    }

    @Override
    protected Runnable createWorker( Socket clientSocket, String originInterface ) {
        return new XmlServerWorker(clientSocket, originInterface);
    }

    public static String getCanonicalName( ) {
        return "XmlServer";
    }
}