package com.pk.cwierkacz.processor.handlers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.UserService;
import com.pk.cwierkacz.utils.HashUtil;
import com.pk.cwierkacz.utils.TokenUtil;

public class LoginHandler implements Handler
{
    private final UserService userService;

    public LoginHandler() {
        userService = ServiceRepo.getInstance().getService(UserService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.SIGNIN);
    }

    @Override
    public void handle( ApplicationData appData ) {
        LoginRequest loginRequest = (LoginRequest) appData.getRequest();

        String name = loginRequest.getUserName();
        UserDao user = userService.getByUserName(name);

        if ( user == null ) {
            appData.setResponse(ResponseImpl.create(Status.DENY, "No such user", 0));
            return;
        }

        String password = user.getPassword();
        String cadidatePass = HashUtil.hashString(loginRequest.getPassword());

        if ( !password.equals(cadidatePass) ) {
            appData.setResponse(ResponseImpl.create(Status.DENY, "Wrong password", 0));
            return;
        }

        Set<String> accounts = new HashSet<>();

        for ( TwitterAccountDao accountDao : user.getAccounts() ) {
            accounts.add(accountDao.getAccountName());
        }

        if ( user.getSession() != null ) {
            appData.setResponse(ResponseImpl.create(Status.OK,
                                                    "Authenticated correct",
                                                    user.getSession().getCurrentToken()));
            return;
        }

        SessionDao sessionDao = new SessionDao();
        sessionDao.setLastActive(new Timestamp(new Date().getTime()));
        sessionDao.setCurrentToken(TokenUtil.getToken());
        user.setSession(sessionDao);

        userService.saveOrUpdate(user);

        appData.setResponse(ResponseImpl.create(Status.OK, "Authenticated correct", user.getSession()
                                                                                        .getCurrentToken()));
        return;

    }
}
