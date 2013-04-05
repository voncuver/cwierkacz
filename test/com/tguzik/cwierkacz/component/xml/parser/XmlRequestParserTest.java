package com.tguzik.cwierkacz.component.xml.parser;

import static com.tguzik.util.TestFileUtil.getFileContents;
import static com.tguzik.util.TestFileUtil.normalizeLineEndings;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;
import com.tguzik.cwierkacz.component.xml.request.XmlRequestParser;

public class XmlRequestParserTest
{
    private XmlRequestParser parser;

    @Before
    public void setUp( ) {
        this.parser = new XmlRequestParser();
    }

    @Test
    public void testBasicRequest_FetchTweets( ) throws FileNotFoundException, IOException, Exception {
        String expected = getFileAsString("parsed/request_basic_fetch_tweets.txt");
        String xmlRequest = getFileAsString("request_basic_fetch_tweets.xml");
        XmlRequest request = parser.parse(xmlRequest);

        assertEquals(expected, normalizeLineEndings(request.toString()));
    }

    @Test
    public void testBasicRequest_PostTweets( ) throws FileNotFoundException, IOException, Exception {
        String expected = getFileAsString("parsed/request_basic_post_tweets.txt");
        String xmlRequest = getFileAsString("request_basic_post_tweets.xml");
        XmlRequest request = parser.parse(xmlRequest);

        assertEquals(expected, normalizeLineEndings(request.toString()));
    }

    private String getFileAsString( String name ) throws FileNotFoundException, IOException {
        return normalizeLineEndings(getFileContents("../cwierkacz/component/xml/cases", name));
    }
}
