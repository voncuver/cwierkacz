package com.tguzik.cwierkacz.component.xml.parser;

import static com.tguzik.util.TestFileUtil.getFileContents;
import static com.tguzik.util.TestFileUtil.getFileContentsAsInputStream;
import static com.tguzik.util.TestFileUtil.normalizeLineEndings;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.tguzik.cwierkacz.component.xml.beans.XmlRequest;

public class XmlRequestParserTest
{

    @Before
    public void setUp( ) throws Exception {
    }

    @Test
    public void testBasicRequest_FetchTweets( ) throws FileNotFoundException, IOException, Exception {
        String expected = getFileAsString("parsed/request_basic_fetch_tweets.txt");
        XmlRequest request = new XmlRequestParser().parse(getFile("request_basic_fetch_tweets.xml"));

        assertEquals(expected, normalizeLineEndings(request.toString()));
    }

    private InputStream getFile( String name ) throws FileNotFoundException, IOException {
        return getFileContentsAsInputStream("../cwierkacz/component/xml/parser/cases", name);
    }

    private String getFileAsString( String name ) throws FileNotFoundException, IOException {
        return normalizeLineEndings(getFileContents("../cwierkacz/component/xml/parser/cases", name));
    }

}
