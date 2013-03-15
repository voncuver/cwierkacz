package com.tguzik.cwierkacz.interfaces.xmlserver;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.interfaces.AbstractSocketInterface;

public class XmlServerInterface extends AbstractSocketInterface
{
    protected XmlServerInterface( ThreadPoolExecutor threadPool, short portNumber ) throws IOException {
        super("XML Server", threadPool, portNumber);
    }

    @Override
    protected Runnable createWorker( Socket clientSocket ) {
        // TODO Auto-generated method stub
        return null;
    }

}
