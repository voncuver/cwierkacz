package com.tguzik.cwierkacz.component.xml.request;

import static org.apache.commons.lang3.StringUtils.isBlank;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.tguzik.cwierkacz.component.xml.beans.XmlAccount;
import com.tguzik.cwierkacz.component.xml.beans.XmlCustomer;
import com.tguzik.cwierkacz.component.xml.beans.XmlJob;
import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;
import com.tguzik.cwierkacz.component.xml.beans.XmlTweet;

public class XmlRequestHandlerHelper
{
    private static final String STRING_NAME = "name";
    private final XmlRequest xmlRequest;
    private XmlCustomer customer;
    private XmlAccount account;
    private XmlTweet tweet;
    private XmlJob job;

    public XmlRequestHandlerHelper( XmlRequest xmlRequest ) {
        this.xmlRequest = xmlRequest;
    }

    public void startElement( XmlTags tag, Attributes attributes ) throws SAXException {
        switch ( tag ) {
        case CUSTOMER:
            startCustomerTag(attributes);
            break;

        case JOB:
            startJobTag(attributes);
            break;

        case CACHEONLY:
            startCacheOnlyTag(attributes);
            break;

        case ACCOUNT:
            startAccountTag(attributes);
            break;

        case TWEET:
            startTweetTag(attributes);
            break;

        case CONTENT:
            startContentTag(attributes);
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
        case CUSTOMER:
            endCustomerTag(characters);
            break;

        case JOB:
            endJobTag(characters);
            break;

        case CACHEONLY:
            endCacheOnlyTag(characters);
            break;

        case ACCOUNT:
            endAccountTag(characters);
            break;

        case TWEET:
            endTweetTag(characters);
            break;

        case CONTENT:
            endContentTag(characters);
            break;

        case DIAGNOSTIC:
            endDiagnosticTag(characters);
            break;

        default:
            break;
        }
    }

    private void startCustomerTag( Attributes attributes ) throws SAXException {
        String name = attributes.getValue(STRING_NAME);
        throwAttributeMissingIfEmpty(name, STRING_NAME, "Customer");

        customer = new XmlCustomer();
        customer.setName(name);
    }

    private void startJobTag( Attributes attributes ) throws SAXException {
        String name = attributes.getValue(STRING_NAME);
        throwAttributeMissingIfEmpty(name, STRING_NAME, "Job");

        this.job = new XmlJob();
        this.job.setName(name);
    }

    private void startCacheOnlyTag( Attributes attributes ) throws SAXException {
        throwMissingParentTagIf(this.job == null, "CacheOnly", "Job");
        this.job.setCacheOnly(true);
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

        tweet = new XmlTweet();
    }

    private void startContentTag( Attributes attributes ) throws SAXException {
        throwMissingParentTagIf(tweet == null, "Content", "Tweet");
    }

    private void startDiagnosticTag( Attributes attributes ) {
        String number = attributes.getValue("number");
        Integer value = Integer.parseInt(number, 10);
        xmlRequest.addRequestedDiagnostics(value);
    }

    private void endCustomerTag( String characters ) {
        xmlRequest.setCustomer(customer);
        customer = null;
    }

    private void endJobTag( String characters ) {
        xmlRequest.addJob(job);
        job = null;
    }

    private void endCacheOnlyTag( String characters ) {
        // do nothing.
    }

    private void endAccountTag( String characters ) {
        job.addAccount(account);
    }

    private void endTweetTag( String characters ) {
        account.addTweet(tweet);
    }

    private void endContentTag( String characters ) {
        tweet.setContent(characters);
    }

    private void endDiagnosticTag( String characters ) {
        // do nothing.
    }

    private void throwAttributeMissingIfEmpty( String value, String attributeName, String parentTag ) throws SAXException {
        if ( isBlank(value) ) {
            throw new SAXException(String.format("Attribute %s in <%s> is blank or missing",
                                                 attributeName,
                                                 parentTag));
        }
    }

    private void throwMissingParentTagIf( boolean condition, String tagName, String parentTag ) throws SAXException {
        if ( condition ) {
            throw new SAXException(String.format("Element <%s> must be within <%s>", tagName, parentTag));
        }
    }

}
