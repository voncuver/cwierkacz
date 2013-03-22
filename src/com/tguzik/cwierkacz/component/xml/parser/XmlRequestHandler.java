package com.tguzik.cwierkacz.component.xml.parser;

import static java.lang.String.format;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;

public class XmlRequestHandler extends DefaultHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlRequestHandler.class);
    private final XmlRequestHandlerHelper helper;
    private StringBuilder buffer;

    public XmlRequestHandler( XmlRequest request ) {
        this.helper = new XmlRequestHandlerHelper(request);
        resetCharacterBuffer();
    }

    @Override
    public void startElement( String uri, String localName, String qName, Attributes attributes ) throws SAXException {
        XmlTags tag = XmlTags.fromString(localName, qName);

        if ( tag == null ) {
            throw new SAXException("Invalid/unrecognized element " + localName);
        }

        helper.startElement(tag, attributes);
        resetCharacterBuffer();
    }

    @Override
    public void endElement( String uri, String localName, String qName ) throws SAXException {
        XmlTags tag = XmlTags.fromString(localName, qName);

        if ( tag == null ) {
            throw new SAXException("Invalid/unrecognized element " + localName);
        }

        helper.endElement(tag, buffer.toString());
        resetCharacterBuffer();
    }

    @Override
    /** 
     * Reminder - characters(..) method can be called multiple times for the same text with different 
     * chunks every time. For example, if the parser is parsing text "Lorem ipsum dolor &amp; sit amet", 
     * then the characters(..) method will be invoked three times:
     * 1. characters("Lorem ipsum dolor ");
     * 2. characters("&");
     * 3. characters(" sit amet");
     * 
     * Keep that in mind.
     */
    public void characters( char chars[], int start, int length ) throws SAXException {
        buffer.append(chars, start, length);
    }

    @Override
    public void warning( SAXParseException e ) throws SAXException {
        LOGGER.warn(format("Warning from SAXParser: %s:%s on line %d",
                           e.getClass().getSimpleName(),
                           e.getMessage(),
                           e.getLineNumber()),
                    e);
    }

    @Override
    public void error( SAXParseException e ) throws SAXException {
        LOGGER.warn(format("Error from SAXParser: %s:%s on line %d",
                           e.getClass().getSimpleName(),
                           e.getMessage(),
                           e.getLineNumber()),
                    e);
    }

    private void resetCharacterBuffer( ) {
        this.buffer = new StringBuilder();
    }
}
