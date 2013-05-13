package com.pk.cwierkacz.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import com.pk.cwierkacz.http.request.AccountManageRequest;
import com.pk.cwierkacz.http.request.AddTweeterAccountRequest;
import com.pk.cwierkacz.http.request.FetchTweetsRequest;
import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.request.PublishRequest;
import com.pk.cwierkacz.http.request.Request;

public class RequestBuilderTest
{

    @Test
    public void accountManageRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.MODACCOUNT.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("passwordOld", new String[] {"TEST"});
        params.put("passwordNew", new String[] {"TEST"});

        Cookie[] cookies = new Cookie[0];

        AccountManageRequest request = RequestBuilder.buildRequest(params, cookies, null);

        assertEquals(Action.MODACCOUNT, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());
        assertEquals("TEST", request.getNewPassword());
        assertEquals("TEST", request.getPassword());
    }

    @Test
    public void addTweeterAccountRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.LINKSOCIALACCOUNT.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("accountLogin", new String[] {"TEST"});
        params.put("accountPassword", new String[] {"TEST"});

        Cookie[] cookies = new Cookie[0];

        AddTweeterAccountRequest request = RequestBuilder.buildRequest(params, cookies, null);

        assertEquals(Action.LINKSOCIALACCOUNT, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());
        assertEquals("TEST", request.getLoginTweet());
        assertEquals("TEST", request.getPasswordTweet());
    }

    @Test
    public void fetchTweetsRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.FETCHMESSAGES.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("password", new String[] {"1111"});
        params.put("accounts", new String[] {"1234", "test"});
        params.put("replayForId", new String[] {"1234567"});
        params.put("retweetForId", new String[] {"123456789"});
        params.put("size", new String[] {"15"});
        params.put("dateFrom", new String[] {"2012-12-01"});
        params.put("dateTo", new String[] {"2012-12-04"});
        params.put("accountType", new String[] {"twitter"});

        Cookie[] cookies = new Cookie[0];

        FetchTweetsRequest request = RequestBuilder.buildRequest(params, cookies, null);

        assertEquals(Action.FETCHMESSAGES, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals("1234", request.getAccounts().get(0));
        assertEquals(1234567, request.getReplayFor());
        assertEquals(123456789, request.getRetweetFor());
        assertEquals(15, request.getSize());
        assertEquals(DateTime.parse("2012-12-01"), request.getDateFrom());
        assertEquals(DateTime.parse("2012-12-04"), request.getDateTo());
    }

    @Test
    public void loginRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.SIGNIN.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("password", new String[] {"1111"});

        Cookie[] cookies = new Cookie[0];

        LoginRequest request = RequestBuilder.buildRequest(params, cookies, null);

        assertEquals(Action.SIGNIN, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());
        assertEquals("1111", request.getPassword());
    }

    @Test
    public void publishRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.PUBLISHTWEET.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("accounts", new String[] {"1234", "test"});
        params.put("replayForId", new String[] {"1234567"});
        params.put("retweetForId", new String[] {"123456789"});
        params.put("tweet", new String[] {"Testtowy test"});

        Cookie[] cookies = new Cookie[0];

        PublishRequest request = RequestBuilder.buildRequest(params, cookies);

        assertEquals(Action.PUBLISHTWEET, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals("1234", request.getAccounts().get(0));
        assertEquals("test", request.getAccounts().get(1));

        assertEquals(1234567, request.getReplayFor());
        assertEquals(123456789, request.getRetweetFor());
        assertEquals("Testtowy test", request.getTweetText());
        assertNull(request.getBody());
    }

    @Test
    public void publishRequestWithBodyTest( ) throws IOException {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.PUBLISHTWEET.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("accounts", new String[] {"1234", "test"});
        params.put("tweet", new String[] {"Testtowy test"});
        params.put("imgName", new String[] {"TEST"});

        File lenaFile = new File("src/test/java/com/pk/cwierkacz/http/lena.PNG");
        InputStream is = new FileInputStream(lenaFile);
        byte[] body = IOUtils.toByteArray(is);

        Cookie[] cookies = new Cookie[0];

        PublishRequest request = RequestBuilder.buildRequest(params, cookies, body);

        assertEquals(Action.PUBLISHTWEET, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals("1234", request.getAccounts().get(0));
        assertEquals("test", request.getAccounts().get(1));

        assertEquals("Testtowy test", request.getTweetText());

        byte[] readedBody = request.getBody();
        assertNotNull(readedBody);
        assertTrue(ArrayUtils.isEquals(body, readedBody));

    }

    @Test
    public void fetchTweeterAccountsTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.FETCHSOCIALACCOUNTS.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});

        Cookie[] cookies = new Cookie[0];

        Request request = RequestBuilder.buildRequest(params, cookies, null);

        assertEquals(Action.FETCHSOCIALACCOUNTS, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());
    }
}
