package com.tguzik.cwierkacz.component.xml.parser;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;

public class XmlRequestParser
{
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlRequestParser.class);

    // TODO: Is SAXParserFactory thread safe?
    private static final SAXParserFactory factory = createFactory();

    public XmlRequest parse( InputStream is ) throws Exception {
        XmlRequest request = new XmlRequest();
        XmlRequestHandler handler = new XmlRequestHandler(request);

        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(is, handler);

            return request;
        }
        catch ( Exception e ) {
            LOGGER.warn(String.format("Caught exception while parsing request: %s:%s",
                                      e.getClass().getSimpleName(),
                                      e.getMessage()), e);
            throw e;
        }
    }

    private static SAXParserFactory createFactory( ) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory;
    }
}
