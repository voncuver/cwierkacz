package com.tguzik.cwierkacz.interfaces.xmlserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.tguzik.cwierkacz.interfaces.InterfaceWorker;

public class XmlServerWorker extends InterfaceWorker
{
    protected XmlServerWorker( Socket clientSocket ) {
        super(clientSocket);
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
