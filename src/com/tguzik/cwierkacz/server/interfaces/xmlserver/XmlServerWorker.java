package com.tguzik.cwierkacz.server.interfaces.xmlserver;

import java.io.InputStream;
import java.net.Socket;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.RequestData;
import com.tguzik.cwierkacz.common.data.RequestedJob;
import com.tguzik.cwierkacz.component.xml.XmlConverter;
import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;
import com.tguzik.cwierkacz.component.xml.beans.XmlResponse;
import com.tguzik.cwierkacz.component.xml.request.XmlRequestParser;
import com.tguzik.cwierkacz.component.xml.response.XmlResponseBuilder;
import com.tguzik.cwierkacz.server.ApplicationContext;
import com.tguzik.cwierkacz.server.interfaces.AbstractSocketInterfaceWorker;

public class XmlServerWorker extends AbstractSocketInterfaceWorker
{
    private final XmlResponseBuilder xmlResponseBuilder;
    private final XmlRequestParser xmlRequestParser;
    private final ApplicationContext context;
    private final XmlConverter xmlConverter;

    public XmlServerWorker( String originInterface,
                            ApplicationContext context,
                            XmlRequestParser xmlRequestParser,
                            XmlConverter xmlConverter,
                            XmlResponseBuilder xmlResponseBuilder,
                            Socket clientSocket ) {
        super(clientSocket, originInterface);
        this.xmlResponseBuilder = xmlResponseBuilder;
        this.xmlRequestParser = xmlRequestParser;
        this.xmlConverter = xmlConverter;
        this.context = context;
    }

    @Override
    protected ApplicationProcessingData createRequest( InputStream inputStream ) throws Exception {
        XmlRequest xmlRequest = xmlRequestParser.parse(inputStream);
        return xmlConverter.fromXml(xmlRequest);
    }

    @Override
    protected void process( ApplicationProcessingData data ) throws Exception {
        // TODO: Refactor

        RequestData requestData = data.getRequestData();

        for ( RequestedJob requestedJob : requestData.getRequestedJobs() ) {
            Job job = context.getJobsByName().get(requestedJob.getName());

            job.getChain().process(data, requestedJob);
        }
    }

    @Override
    protected String createResponse( ApplicationProcessingData data ) throws ParserConfigurationException,
                                                                     FactoryConfigurationError,
                                                                     TransformerException {
        XmlResponse xmlResponse = xmlConverter.toXml(data);
        return xmlResponseBuilder.build(xmlResponse);
    }

    @Override
    protected void preprocessing( ApplicationProcessingData data ) {
        // do nothing.
    }

    @Override
    protected void postprocessing( ApplicationProcessingData data ) {
        // do nothing.
    }

    @Override
    protected String produceErrorResponse( Exception e ) {
        return String.format("<Error> %s: %s </Error>\n", e.getClass().getName(), e.getMessage());
    }
}
