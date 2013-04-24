package com.pk.cwierkacz.processor.handlers;

import org.junit.Before;
import org.junit.Test;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.request.AddTweeAccRequest;
import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.request.RequestImpl;
import com.pk.cwierkacz.model.ApplicationData;

public class WireTweetAccountTest
{
    CreateAccountHandler accountHandler;
    LoginHandler loginHandler;
    WireTweetAccount tweetAccount;

    @Before
    public void setUp( ) {
        accountHandler = new CreateAccountHandler();
        loginHandler = new LoginHandler();
        tweetAccount = new WireTweetAccount();
    }

    @Test
    public void complexTest( ) {
        ApplicationData appData = new ApplicationData();
        Request request = RequestImpl.create().buildBaseRequest(Action.CREATEACCOUNT, "test");

        LoginRequest loginRequest = RequestImpl.create(request).buildLoginRequest("Test");
        appData.setRequest(loginRequest);
        accountHandler.handle(appData);

        Request request2 = RequestImpl.create().buildBaseRequest(Action.LOGIN, "test");
        LoginRequest loginRequest2 = RequestImpl.create(request2).buildLoginRequest("Test");
        appData.setRequest(loginRequest2);
        loginHandler.handle(appData);

        RequestImpl request3 = RequestImpl.create().withTokenId(appData.getResponse().getTokenId());
        Request request4 = request3.buildBaseRequest(Action.ADDTWEETACCOUNT, "test");
        AddTweeAccRequest accRequest = RequestImpl.create(request4).buildAddAccountTweetRequest("msierpien",
                                                                                                "Kinia12");
        //accRequest = RequestImpl.create(accRequest).withPin(6903256l);

        appData.setRequest(accRequest);
        tweetAccount.handle(appData);
    }
}
