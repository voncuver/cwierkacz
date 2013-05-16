package com.pk.cwierkacz.processor.handlers;

import java.util.HashSet;
import java.util.Set;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.AddTweeterAccountRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.Account;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.UserService;

public class ListTweetAccounts extends AbstractHandler
{
    private final UserService userService;
    private final SessionService sessionService;

    public ListTweetAccounts() {
        userService = ServiceRepo.getInstance().getService(UserService.class);
        sessionService = ServiceRepo.getInstance().getService(SessionService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.FETCHSOCIALACCOUNTS);
    }

    @Override
    public void handle( ApplicationData appData ) {
        AddTweeterAccountRequest accRequest = (AddTweeterAccountRequest) appData.getRequest();

        SessionDao sessionDao = sessionService.getByToken(accRequest.getTokenId());
        UserDao user = userService.getBySessionId(sessionDao);
        if ( user != null && user.getSession().getCurrentToken() != accRequest.getTokenId() ) {
            Response response = ResponseImpl.create(Status.DENY, "Invalid Token", accRequest.getTokenId());
            appData.setResponse(response);
            return;
        }

        Set<TwitterAccountDao> accounts = user.getAccounts();

        Set<Account> accountsNames = new HashSet<>();
        for ( TwitterAccountDao accountDao : accounts ) {
            accountsNames.add(new Account(accountDao.getAccountName(), AccountType.TWITTER));
        }

        Response response = ResponseImpl.create(Status.OK, "Account List", accRequest.getTokenId())
                                        .buildLoginResponse(accountsNames);
        appData.setResponse(response);
        return;
    }

}
