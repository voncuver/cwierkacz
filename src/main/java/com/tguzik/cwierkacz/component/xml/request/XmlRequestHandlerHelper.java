package com.tguzik.cwierkacz.component.xml.request;

import static com.tguzik.cwierkacz.component.xml.request.XmlTags.REQUEST;
import static com.tguzik.cwierkacz.component.xml.request.XmlTags.TWEET;
import static org.apache.commons.lang3.StringUtils.isBlank;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.tguzik.cwierkacz.component.xml.beans.XmlAccount;
import com.tguzik.cwierkacz.component.xml.beans.XmlJob;
import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;
import com.tguzik.cwierkacz.component.xml.beans.XmlTweet;

public class XmlRequestHandlerHelper
{
    private static final String STRING_NAME = "name";
    private final XmlRequest xmlRequest;
    private XmlAccount account;
    private XmlTweet tweet;
    private XmlJob job;

    public XmlRequestHandlerHelper( XmlRequest xmlRequest ) {
        this.xmlRequest = xmlRequest;
    }

    public void startElement( XmlTags tag, Attributes attributes ) throws SAXException {
        switch ( tag ) {
        case REQUEST:
            startRequestTag(attributes);
            break;

        case JOB:
            startJobTag(attributes);
            break;

        case ACCOUNT:
            startAccountTag(attributes);
            break;

        case TWEET:
            startTweetTag(attributes);
            break;

        case DIAGNOSTIC:
            startDiagnosticTag(attributes);
            break;

        default:
            break;
        }
    }

    public void endElement( XmlTags tag, String characters ) {
        switch ( tag ) {
        case JOB:
            endJobTag(characters);
            break;

        case ACCOUNT:
            endAccountTag(characters);
            break;

        case TWEET:
            endTweetTag(characters);
            break;

        case DIAGNOSTIC:
            endDiagnosticTag(characters);
            break;

        default:
            break;
        }
    }

    private void startRequestTag( Attributes attributes ) throws SAXException {
        String customerId = attributes.getValue("customerId");
        throwAttributeMissingIfEmpty(customerId, "customerId", REQUEST.getName());

        xmlRequest.setCustomerId(NumberUtils.toLong(customerId));

    }

    private void startJobTag( Attributes attributes ) throws SAXException {
        String name = attributes.getValue(STRING_NAME);
        throwAttributeMissingIfEmpty(name, STRING_NAME, "Job");

        String cacheOnly = attributes.getValue("cacheOnly");

        this.job = new XmlJob();
        this.job.setName(name);
        this.job.setCacheOnly(BooleanUtils.toBoolean(cacheOnly));
    }

    private void startAccountTag( Attributes attributes ) throws SAXException {
        String name = attributes.getValue(STRING_NAME);
        throwMissingParentTagIf(job == null, "Account", "Job");
        throwAttributeMissingIfEmpty(name, STRING_NAME, "Account");

        account = new XmlAccount();
        account.setName(name);
    }

    private void startTweetTag( Attributes attributes ) throws SAXException {
        throwMissingParentTagIf(account == null, "Tweet", "Account");

        String content = attributes.getValue("content");
        throwAttributeMissingIfEmpty(content, "content", TWEET.getName());

        tweet = new XmlTweet();
        tweet.setContent(content);
    }

    private void startDiagnosticTag( Attributes attributes ) {
        String number = attributes.getValue("number");
        Integer value = Integer.parseInt(number, 10);
        xmlRequest.addRequestedDiagnostics(value);
    }

    private void endJobTag( String characters ) {
        xmlRequest.addJob(job);
        job = null;
    }

    private void endAccountTag( String characters ) {
        job.addAccount(account);
    }

    private void endTweetTag( String characters ) {
        account.addTweet(tweet);
    }

    private void endDiagnosticTag( String characters ) {
        // do nothing.
    }

    private void throwAttributeMissingIfEmpty( String value, String attribute, String parentTag ) throws SAXException {
        if ( isBlank(value) ) {
            throw new SAXException(String.format("Attribute %s in <%s> is blank or missing",
                                                 attribute,
                                                 parentTag));
        }
    }

    private void throwMissingParentTagIf( boolean condition, String tagName, String parentTag ) throws SAXException {
        if ( condition ) {
            throw new SAXException(String.format("Element <%s> must be within <%s>", tagName, parentTag));
        }
    }

}
