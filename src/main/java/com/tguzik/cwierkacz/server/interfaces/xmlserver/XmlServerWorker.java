package com.tguzik.cwierkacz.server.interfaces.xmlserver;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.RequestData;
import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;
import com.tguzik.cwierkacz.component.xml.beans.XmlResponse;
import com.tguzik.cwierkacz.component.xml.converter.XmlConverter;
import com.tguzik.cwierkacz.component.xml.request.XmlRequestParser;
import com.tguzik.cwierkacz.component.xml.response.XmlResponseBuilder;
import com.tguzik.cwierkacz.server.interfaces.ProtocolWorker;

public class XmlServerWorker implements ProtocolWorker
{
    private final XmlResponseBuilder xmlResponseBuilder;
    private final XmlRequestParser xmlRequestParser;
    private final XmlConverter xmlConverter;

    private XmlServerWorker( XmlRequestParser xmlRequestParser,
                             XmlConverter xmlConverter,
                             XmlResponseBuilder xmlResponseBuilder ) {
        this.xmlResponseBuilder = xmlResponseBuilder;
        this.xmlRequestParser = xmlRequestParser;
        this.xmlConverter = xmlConverter;
    }

    @Override
    public String produceErrorResponse( Exception e ) {
        return createErrorMessage(e.toString());
    }

    @Override
    public RequestData createRequestData( String request ) throws Exception {
        XmlRequest xmlRequest = xmlRequestParser.parse(request);
        return xmlConverter.fromXml(xmlRequest);
    }

    @Override
    public String createResponse( ApplicationProcessingData data ) throws ParserConfigurationException,
                                                                  FactoryConfigurationError,
                                                                  TransformerException {
        XmlResponse xmlResponse = xmlConverter.toXml(data);
        return xmlResponseBuilder.build(xmlResponse);
    }

    @Override
    public String produceEmptyRequestResponse( ) {
        return createErrorMessage("Empty request");
    }

    private String createErrorMessage( String message ) {
        return String.format("<Error><![CDATA[ %s ]]></Error>\n", message);
    }

    @Override
    public void initialize( ) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void shutdown( ) {
        // TODO Auto-generated method stub
    }

    public static ProtocolWorker create( XmlRequestParser xmlRequestParser,
                                         XmlConverter xmlConverter,
                                         XmlResponseBuilder xmlResponseBuilder ) {
        return new XmlServerWorker(xmlRequestParser, xmlConverter, xmlResponseBuilder);
    }
}
