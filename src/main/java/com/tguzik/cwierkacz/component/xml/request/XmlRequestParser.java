package com.tguzik.cwierkacz.component.xml.request;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;

@Threadsafe
public class XmlRequestParser
{
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlRequestParser.class);
    private static final SAXParserFactory factory = createFactory();

    public XmlRequest parse( String input ) throws Exception {
        XmlRequest request = new XmlRequest();
        XmlRequestHandler handler = new XmlRequestHandler(request);

        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(IOUtils.toInputStream(input), handler);

            return request;
        }
        catch ( Exception e ) {
            LOGGER.warn("Caught exception while parsing request: {}:{}",
                        e.getClass().getName(),
                        e.getMessage(),
                        e);
            throw e;
        }
    }

    private static SAXParserFactory createFactory( ) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory;
    }
}
