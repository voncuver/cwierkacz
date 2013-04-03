package com.tguzik.cwierkacz.component.xml.response;

import static com.tguzik.util.TestFileUtil.getFileContents;
import static com.tguzik.util.TestFileUtil.normalizeLineEndings;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import com.tguzik.cwierkacz.component.xml.beans.XmlAccount;
import com.tguzik.cwierkacz.component.xml.beans.XmlJob;
import com.tguzik.cwierkacz.component.xml.beans.XmlResponse;
import com.tguzik.cwierkacz.component.xml.beans.XmlTweet;

public class XmlResponseBuilderTest
{
    @Test
    public void testXmlResponse( ) throws FileNotFoundException,
                                  IOException,
                                  ParserConfigurationException,
                                  FactoryConfigurationError,
                                  TransformerException {
        String expected = getFileAsString("response_basic.xml");
        String actual = normalizeLineEndings(new XmlResponseBuilder().build(createXmlResponse()));

        assertEquals(expected, actual);
    }

    private XmlResponse createXmlResponse( ) {
        XmlResponse response = new XmlResponse();
        XmlAccount account = new XmlAccount();
        XmlJob job = new XmlJob();

        response.setReturnCode(42);
        response.setCustomerId(12345L);

        job.setName("FETCH-TWEETS");
        job.setCacheOnly(true);

        account.setName("konto-na-twitterze-1");
        account.addTweet(createTweet(1234L,
                                     new DateTime(2013, 03, 22, 00, 01, DateTimeZone.UTC),
                                     null,
                                     "Nasz tweet #1",
                                     createTweet(1235L,
                                                 new DateTime(2013, 03, 23, 00, 18, DateTimeZone.UTC),
                                                 "odpowiadajacy-1",
                                                 "Odpowiedz #1 na tweeta #1"),
                                     createTweet(1236L,
                                                 new DateTime(2013, 03, 24, 12, 12, DateTimeZone.UTC),
                                                 "odpowiadajacy-2",
                                                 "Odpowiedz #2 na tweeta #1")));
        job.addAccount(account);

        account = new XmlAccount();
        account.setName("konto-na-twitterze-2");
        account.addTweet(createTweet(321L,
                                     new DateTime(2013, 03, 20, 01, 01, DateTimeZone.UTC),
                                     null,
                                     "Nasz tweet #2"));
        account.addTweet(createTweet(4321L,
                                     new DateTime(2013, 03, 22, 00, 01, DateTimeZone.UTC),
                                     null,
                                     "Nasz tweet #3"));
        job.addAccount(account);

        response.addJob(job);
        response.addDiagnostic("\n============ Diagnostics =============\n"
                               + "Lorem Ipsum Dolor Sit Amet\n"
                               + "======================================");
        return response;
    }

    private XmlTweet createTweet( Long id, DateTime date, String account, String content, XmlTweet... replies ) {
        XmlTweet tweet = new XmlTweet();
        tweet.setId(id);
        tweet.setDate(date);
        tweet.setAccount(account);
        tweet.setContent(content);

        for ( XmlTweet reply : replies ) {
            tweet.addReply(reply);
        }

        return tweet;
    }

    private String getFileAsString( String name ) throws FileNotFoundException, IOException {
        return normalizeLineEndings(getFileContents("../cwierkacz/component/xml/cases", name));
    }
}
