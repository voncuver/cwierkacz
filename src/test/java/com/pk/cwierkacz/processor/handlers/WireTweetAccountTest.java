package com.pk.cwierkacz.processor.handlers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.AddTweeterAccountRequest;
import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.request.RequestImpl;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.UserService;

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
        Request request = RequestImpl.create(Action.ADDACCOUNT).buildBaseRequest("test");

        LoginRequest loginRequest = RequestImpl.create(request).buildLoginRequest("Test");
        appData.setRequest(loginRequest);
        accountHandler.handle(appData);

        Request request2 = RequestImpl.create(Action.SIGNIN).buildBaseRequest("test");
        LoginRequest loginRequest2 = RequestImpl.create(request2).buildLoginRequest("Test");
        appData.setRequest(loginRequest2);
        loginHandler.handle(appData);

        RequestImpl request3 = RequestImpl.create(Action.LINKSOCIALACCOUNT).withTokenId(appData.getResponse()
                                                                                               .getTokenId());
        Request request4 = request3.buildBaseRequest("test");
        AddTweeterAccountRequest accRequest = RequestImpl.create(request4)
                                                         .buildAddAccountTweetRequest("msierpien")
                                                         .withPasswordTweet("Kinia12")
                                                         .withAccountType(AccountType.TWITTER);
        appData.setRequest(accRequest);

        UserService service = ServiceRepo.getInstance().getService(UserService.class);

        UserDao userDao = service.getByUserName("test");

        appData.setCurrentUser(userDao);
        tweetAccount.handle(appData);

        System.out.println(appData.getResponse().getText());
        assertEquals(Status.OK, appData.getResponse().getStatus());

    }
}
