package com.tguzik.cwierkacz.interfaces.protobuf;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.interfaces.AbstractSocketInterface;

public class ProtobufServerInterface extends AbstractSocketInterface
{

    protected ProtobufServerInterface( ThreadPoolExecutor threadPool, short portNumber ) throws IOException {
        super("Protobuf", threadPool, portNumber);
    }

    @Override
    protected Runnable createWorker( Socket clientSocket ) {
        // TODO Auto-generated method stub
        return null;
    }

}
