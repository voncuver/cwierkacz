package com.tguzik.cwierkacz.server.interfaces.xmlserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.tguzik.cwierkacz.server.interfaces.InterfaceWorker;

public class XmlServerWorker extends InterfaceWorker
{
    protected XmlServerWorker( Socket clientSocket, String originInterface ) {
        super(clientSocket, originInterface);
    }

    @Override
    protected void createRequest( InputStream inputStream ) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void process( ) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void createResponse( OutputStream outputStream ) {
        // TODO Auto-generated method stub

    }
}
