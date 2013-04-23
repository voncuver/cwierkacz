package com.pk.cwierkacz.processor.handlers;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.UserService;

public class LogoutHandler implements Handler
{
    private final UserService userService;
    private final SessionService sessionService;

    public LogoutHandler() {
        userService = ServiceRepo.getInstance().getService(UserService.class);
        sessionService = ServiceRepo.getInstance().getService(SessionService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.LOGOUT);
    }

    @Override
    public void handle( ApplicationData appData ) {
        LoginRequest loginRequest = (LoginRequest) appData.getRequest();
        UserDao userDao = userService.getByUserName(loginRequest.getFunctionalUserName());

        Long tokenRequest = loginRequest.getTokenId();
        Long sessionToken = userDao.getSession().getCurrentToken();
        if ( !sessionToken.equals(tokenRequest) ) {
            appData.setResponse(ResponseImpl.create(Status.DENY, "Wrong token value", tokenRequest));
            return;
        }

        SessionDao sessionDao = userDao.getSession();
        userDao.setSession(null);
        userService.saveOrUpdate(userDao);
        sessionService.deleteSession(sessionDao);

        appData.setResponse(ResponseImpl.create(Status.OK, "Logout success", tokenRequest));
    }

}
