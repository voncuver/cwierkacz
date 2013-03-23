package com.tguzik.cwierkacz.server.interfaces.xmlserver;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.tguzik.cwierkacz.common.configuration.SingleInterfaceConfiguration;
import com.tguzik.cwierkacz.component.xml.XmlConverter;
import com.tguzik.cwierkacz.component.xml.request.XmlRequestParser;
import com.tguzik.cwierkacz.component.xml.response.XmlResponseBuilder;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterface;
import com.tguzik.cwierkacz.utils.annotation.SingleThreaded;

@SingleThreaded
public class XmlServerInterface extends AbstractSocketInterface
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
        return new XmlServerWorker(originInterface,
                                   context,
                                   xmlRequestParser,
                                   xmlConverter,
                                   xmlResponseBuilder,
                                   clientSocket);
    }

    public static String getCanonicalName( ) {
        return "XmlServer";
    }
}
