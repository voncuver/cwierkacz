package com.tguzik.cwierkacz.component.xml.response;

import java.util.Properties;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.jamesmurty.utils.XMLBuilder;
import com.tguzik.cwierkacz.component.xml.beans.XmlAccount;
import com.tguzik.cwierkacz.component.xml.beans.XmlJob;
import com.tguzik.cwierkacz.component.xml.beans.XmlResponse;
import com.tguzik.cwierkacz.component.xml.beans.XmlTweet;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;

// TODO: Change the underlying engine to StringBuilder-based
@Threadsafe
public class XmlResponseBuilder
{
    public String build( XmlResponse response ) throws ParserConfigurationException,
                                               FactoryConfigurationError,
                                               TransformerException {
        XMLBuilder builder = XMLBuilder.create("CwierkaczResponse")
                                       .attribute("returnCode", String.valueOf(response.getReturnCode()));

        for ( XmlJob job : response.getJobs() ) {
            builder = builder.element("Job").attribute("name", job.getName());

            if ( job.isCacheOnly() ) {
                builder = builder.element("CacheOnly").up();
            }

            for ( XmlAccount account : job.getAccounts() ) {
                builder = builder.element("Account").attribute("name", account.getName());

                for ( XmlTweet tweet : account.getTweets() ) {
                    serializeTweet(builder, tweet);
                }

                builder = builder.up();
            }

            builder = builder.up();
        }

        builder.comment(response.getDiagnostics());

        return builder.asString(OUTPUT_PROPERTIES);
    }

    private void serializeTweet( XMLBuilder builder, XmlTweet tweet ) {
        builder = builder.element("Tweet")
                         .attribute("id", String.valueOf(tweet.getId()))
                         .attribute("date", serializeDateTime(tweet.getDate()))
                         .attribute("account", tweet.getAccount())
                         .element("Content")
                         .text(tweet.getContent())
                         .up();

        for ( XmlTweet reply : tweet.getReplies() ) {
            serializeTweet(builder, reply);
        }
    }

    private String serializeDateTime( DateTime date ) {
        return DATE_FORMATTER.print(date);
    }

    private static Properties constructOutputProperties( ) {
        Properties outputProperties = new Properties();

        // Explicitly identify the output as an XML document
        outputProperties.put(javax.xml.transform.OutputKeys.METHOD, "xml");

        // Pretty-print the XML output (doesn't work in all cases)
        outputProperties.put(javax.xml.transform.OutputKeys.INDENT, "yes");

        // Omit the XML declaration header
        outputProperties.put(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes");

        // Get 2-space indenting when using the Apache transformer
        outputProperties.put("{http://xml.apache.org/xslt}indent-amount", "4");

        return outputProperties;
    }

    private static final Properties OUTPUT_PROPERTIES = constructOutputProperties();
    private static final DateTimeFormatter DATE_FORMATTER = ISODateTimeFormat.basicDateTime();
}
