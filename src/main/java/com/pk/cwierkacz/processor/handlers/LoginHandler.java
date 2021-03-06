package com.pk.cwierkacz.processor.handlers;

import java.sql.Timestamp;
import java.util.Date;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.UserService;
import com.pk.cwierkacz.utils.HashUtil;
import com.pk.cwierkacz.utils.TokenUtil;

public class LoginHandler extends AbstractHandler
{
    private final UserService userService;

    public LoginHandler() {
        super();
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
            appData.setResponse(ResponseImpl.create(Status.ERROR, "Nie ma takiego użytkownika.", 0));
            return;
        }

        String password = user.getPassword();
        String cadidatePass = HashUtil.hashString(loginRequest.getPassword());

        if ( !password.equals(cadidatePass) ) {
            appData.setResponse(ResponseImpl.create(Status.ERROR, "Złe hasło.", 0));
            return;
        }

        if ( user.getSession() != null ) {
            appData.setResponse(ResponseImpl.create(Status.OK,
                                                    "Pomyślnie zalogowano użytkownika.",
                                                    user.getSession().getCurrentToken()));
            return;
        }

        SessionDao sessionDao = new SessionDao();
        sessionDao.setLastActive(new Timestamp(new Date().getTime()));
        sessionDao.setCurrentToken(TokenUtil.getToken());
        user.setSession(sessionDao);

        userService.saveOrUpdate(user);

        appData.setResponse(ResponseImpl.create(Status.OK,
                                                "Pomyślnie zalogowano użytkownika.",
                                                user.getSession().getCurrentToken()));
        return;

    }
}
