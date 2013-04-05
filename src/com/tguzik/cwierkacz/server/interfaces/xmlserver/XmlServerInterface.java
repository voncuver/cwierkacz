package com.tguzik.cwierkacz.server.interfaces.xmlserver;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.common.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.component.xml.converter.XmlConverter;
import com.tguzik.cwierkacz.component.xml.request.XmlRequestParser;
import com.tguzik.cwierkacz.component.xml.response.XmlResponseBuilder;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.MasterProcessor;
import com.tguzik.cwierkacz.server.interfaces.ProtocolWorker;
import com.tguzik.cwierkacz.server.interfaces.socket.AbstractServerSocketInterface;
import com.tguzik.cwierkacz.server.interfaces.socket.SocketWorker;
import com.tguzik.cwierkacz.utils.annotation.SingleThreaded;

@SingleThreaded
public class XmlServerInterface extends AbstractServerSocketInterface
{
    private final Future<ApplicationContext> futureContext;
    private final XmlResponseBuilder xmlResponseBuilder;
    private final XmlRequestParser xmlRequestParser;
    private final XmlConverter xmlConverter;
    private ApplicationContext context;

    public XmlServerInterface( ThreadPoolExecutor threadPool,
                               SingleInterfaceConfiguration configuration,
                               Future<ApplicationContext> futureContext ) throws IOException {
        super(getCanonicalName(), threadPool, configuration.getPortNumber());
        this.xmlResponseBuilder = new XmlResponseBuilder();
        this.xmlRequestParser = new XmlRequestParser();
        this.xmlConverter = new XmlConverter();
        this.futureContext = futureContext;
    }

    @Override
    public void initialize( ) throws Exception {
        super.initialize();
        this.context = futureContext.get();
    }

    @Override
    protected Runnable createWorker( Socket clientSocket, String originInterface ) {
        return MasterProcessor.create(context,
                                      createSocketWorker(clientSocket, originInterface),
                                      createProtocolWorker());
    }

    private SocketWorker createSocketWorker( Socket clientSocket, String originInterface ) {
        return SocketWorker.create(clientSocket, originInterface);
    }

    private ProtocolWorker createProtocolWorker( ) {
        return XmlServerWorker.create(xmlRequestParser, xmlConverter, xmlResponseBuilder);
    }

    public static String getCanonicalName( ) {
        return "XmlServer";
    }
}
