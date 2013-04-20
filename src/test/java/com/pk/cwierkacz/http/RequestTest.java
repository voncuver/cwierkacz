package com.pk.cwierkacz.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.request.PublishRequest;

public class RequestTest
{

    @Test
    public void LoginRequestTest( ) {

        Map<String, String[]> params = new HashMap<>();
        params.put("Action", new String[] {"Login"});
        params.put("FunctionalUserName", new String[] {"TestUser"});
        params.put("TokenID", new String[] {"1234"});
        params.put("Password", new String[] {"Secret"});

        LoginRequest request = RequestBuilder.buildRequest(params);
        assertEquals(Action.LOGIN, request.getAction());
        assertEquals("TestUser", request.getFunctionalUserName());
        assertEquals(1234, request.getTokenId());
        assertEquals("Secret", request.getPassword());

    }

    @Test
    public void PublishRequestTest( ) {

        Map<String, String[]> params = new HashMap<>();
        params.put("Action", new String[] {"PublishTweet"});
        params.put("FunctionalUserName", new String[] {"TestUser"});
        params.put("TweetText", new String[] {"TestMsg"});
        params.put("Accounts", new String[] {"First", "Second"});

        PublishRequest request = RequestBuilder.buildRequest(params);
        assertEquals(Action.PUBLISHTWEET, request.getAction());
        assertEquals("TestUser", request.getFunctionalUserName());
        assertEquals(0, request.getTokenId());
        assertEquals("TestMsg", request.getTweetText());

        assertTrue(request.getAccounts().contains("First"));
        assertTrue(request.getAccounts().contains("Second"));

    }

}
