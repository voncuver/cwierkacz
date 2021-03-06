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

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.pk.cwierkacz.http.request.AccountManageRequest;
import com.pk.cwierkacz.http.request.AddTweeterAccountRequest;
import com.pk.cwierkacz.http.request.FetchMessagesRequest;
import com.pk.cwierkacz.http.request.FetchRepliesRequest;
import com.pk.cwierkacz.http.request.FetchRetweetsRequest;
import com.pk.cwierkacz.http.request.GetMessagesRequest;
import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.request.PublishMessageRequest;
import com.pk.cwierkacz.http.request.PublishReplyRequest;
import com.pk.cwierkacz.http.request.PublishRetweetRequest;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.model.AccountType;

public class RequestBuilderTest
{

    @Test
    public void accountManageRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.MODACCOUNT.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("passwordold", new String[] {"TEST"});
        params.put("passwordnew", new String[] {"TEST"});

        AccountManageRequest request = RequestBuilder.buildRequest(params, null);

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
        params.put("accountlogin", new String[] {"TEST"});
        params.put("accountpassword", new String[] {"TEST"});

        AddTweeterAccountRequest request = RequestBuilder.buildRequest(params, null);

        assertEquals(Action.LINKSOCIALACCOUNT, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());
        assertEquals("TEST", request.getLoginTweet());
        assertEquals("TEST", request.getPasswordTweet());
    }

    @Test
    public void fetchMessagesRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.FETCHMESSAGES.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("password", new String[] {"1111"});
        params.put("accounts", new String[] {"1234", "test"});
        params.put("size", new String[] {"15"});
        params.put("datefrom", new String[] {Long.toString(System.currentTimeMillis())});
        params.put("dateto", new String[] {Long.toString(System.currentTimeMillis())});
        params.put("accounttypes[]",
                   new String[] {AccountType.TWITTER.getType(), AccountType.FACEBOOKBRIDGE.getType()});

        FetchMessagesRequest request = RequestBuilder.buildRequest(params, null);

        assertEquals(Action.FETCHMESSAGES, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals("1234", request.getAccounts().get(0).login);
        assertEquals("test", request.getAccounts().get(1).login);

        assertEquals(AccountType.TWITTER, request.getAccounts().get(0).type);
        assertEquals(AccountType.FACEBOOKBRIDGE, request.getAccounts().get(1).type);

        assertEquals(15, request.getSize());
        assertNotNull(request.getDateFrom());
        assertNotNull(request.getDateTo());
    }

    @Test
    public void getMessagesRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.GETMESSAGES.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("password", new String[] {"1111"});
        params.put("ids[]", new String[] {"1234567", "44444"});
        params.put("accounttype[]",
                   new String[] {AccountType.TWITTER.getType(), AccountType.TWITTER.getType()});

        params.put("accountlogins[]", new String[] {"one", "two"});

        GetMessagesRequest request = RequestBuilder.buildRequest(params, null);

        assertEquals(Action.GETMESSAGES, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals(AccountType.TWITTER, request.getAccountType());
        assertEquals(new Long(1234567), request.getIds().get(0));
        assertEquals(new Long(44444), request.getIds().get(1));

    }

    @Test
    public void fetchRepliesRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.FETCHREPLIES.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("password", new String[] {"1111"});
        params.put("replyforid", new String[] {"1234567"});

        FetchRepliesRequest request = RequestBuilder.buildRequest(params, null);

        assertEquals(Action.FETCHREPLIES, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals(1234567, request.getReplayFor());
    }

    @Test
    public void fetchRetweetsRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.FETCHRETWEETS.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("password", new String[] {"1111"});
        params.put("accounts", new String[] {"1234", "test"});
        params.put("replyforid", new String[] {"1234567"});
        params.put("retweetforid", new String[] {"123456789"});
        params.put("size", new String[] {"15"});
        params.put("datefrom", new String[] {"2012-12-01"});
        params.put("dateto", new String[] {"2012-12-04"});
        params.put("accounttype", new String[] {"twitter"});

        FetchRetweetsRequest request = RequestBuilder.buildRequest(params, null);

        assertEquals(Action.FETCHRETWEETS, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals(123456789, request.getRetweetFor());

    }

    @Test
    public void loginRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.SIGNIN.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("password", new String[] {"1111"});

        LoginRequest request = RequestBuilder.buildRequest(params, null);

        assertEquals(Action.SIGNIN, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());
        assertEquals("1111", request.getPassword());
    }

    @Test
    public void publishRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.PUBLISHMESSAGE.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("accountlogins[]", new String[] {"1234", "test"});
        params.put("accounttypes[]",
                   new String[] {AccountType.TWITTER.getType(), AccountType.FACEBOOKBRIDGE.getType()});
        params.put("tweet", new String[] {"Testtowy test"});

        PublishMessageRequest request = RequestBuilder.buildRequest(params);

        assertEquals(Action.PUBLISHMESSAGE, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals("1234", request.getAccounts().get(0).login);
        assertEquals("test", request.getAccounts().get(1).login);

        assertEquals("Testtowy test", request.getTweetText());
        assertEquals(AccountType.TWITTER, request.getAccounts().get(0).type);
        assertEquals(AccountType.FACEBOOKBRIDGE, request.getAccounts().get(1).type);

        assertNull(request.getBody());
    }

    @Test
    public void publishRequestWithBodyTest( ) throws IOException {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.PUBLISHMESSAGE.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("accountlogins[]", new String[] {"1234", "test"});
        params.put("accounttypes[]",
                   new String[] {AccountType.TWITTER.getType(), AccountType.FACEBOOKBRIDGE.getType()});
        params.put("tweet", new String[] {"Testtowy test"});
        params.put("imgname", new String[] {"TEST"});

        File lenaFile = new File("src/test/java/com/pk/cwierkacz/http/lena.PNG");
        InputStream is = new FileInputStream(lenaFile);
        byte[] body = IOUtils.toByteArray(is);

        PublishMessageRequest request = RequestBuilder.buildRequest(params, body);

        assertEquals(Action.PUBLISHMESSAGE, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals("1234", request.getAccounts().get(0).login);
        assertEquals("test", request.getAccounts().get(1).login);

        assertEquals(AccountType.TWITTER, request.getAccounts().get(0).type);
        assertEquals(AccountType.FACEBOOKBRIDGE, request.getAccounts().get(1).type);

        assertEquals("Testtowy test", request.getTweetText());

        byte[] readedBody = request.getBody();
        assertNotNull(readedBody);
        assertTrue(ArrayUtils.isEquals(body, readedBody));

    }

    @Test
    public void publishReplyRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.PUBLISHREPLY.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("accountlogin", new String[] {"1234"});
        params.put("tweet", new String[] {"Testtowy test"});
        params.put("replyforid", new String[] {"1234567"});

        PublishReplyRequest request = RequestBuilder.buildRequest(params);

        assertEquals(Action.PUBLISHREPLY, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals("1234", request.getLoginTweet());

        assertEquals(1234567, request.getReplayFor());
        assertEquals("Testtowy test", request.getTweetText());
        assertNull(request.getBody());
    }

    @Test
    public void publishRetweetRequestTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.PUBLISHRETWEET.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});
        params.put("accountlogins[]", new String[] {"1234", "test"});
        params.put("accounttypes[]",
                   new String[] {AccountType.TWITTER.getType(), AccountType.FACEBOOKBRIDGE.getType()});
        params.put("retweetforid", new String[] {"123456789"});

        PublishRetweetRequest request = RequestBuilder.buildRequest(params);

        assertEquals(Action.PUBLISHRETWEET, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());

        assertEquals("1234", request.getAccounts().get(0).login);
        assertEquals("test", request.getAccounts().get(1).login);

        assertEquals(AccountType.TWITTER, request.getAccounts().get(0).type);
        assertEquals(AccountType.FACEBOOKBRIDGE, request.getAccounts().get(1).type);

        assertEquals(123456789, request.getRetweetFor());
    }

    @Test
    public void fetchTweeterAccountsTest( ) {
        Map<String, String[]> params = new HashMap<String, String[]>();
        params.put("action", new String[] {Action.FETCHSOCIALACCOUNTS.toString()});
        params.put("username", new String[] {"TEST"});
        params.put("token", new String[] {"1234"});

        Request request = RequestBuilder.buildRequest(params, null);

        assertEquals(Action.FETCHSOCIALACCOUNTS, request.getAction());
        assertEquals(1234, request.getTokenId());
        assertEquals("TEST", request.getUserName());
    }
}
