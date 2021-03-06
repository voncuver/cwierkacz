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

public class LogoutHandler extends AbstractHandler
{
    private final UserService userService;
    private final SessionService sessionService;

    public LogoutHandler() {
        super();
        userService = ServiceRepo.getInstance().getService(UserService.class);
        sessionService = ServiceRepo.getInstance().getService(SessionService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.SIGNOUT);
    }

    @Override
    public void handle( ApplicationData appData ) {
        LoginRequest loginRequest = (LoginRequest) appData.getRequest();
        SessionDao sessionDao = sessionService.getByToken(loginRequest.getTokenId());
        UserDao userDao = userService.getBySessionId(sessionDao);

        if ( userDao == null ) {
            appData.setResponse(ResponseImpl.create(Status.DENY, "Zły token.", loginRequest.getTokenId()));
            return;
        }

        userDao.setSession(null);
        userService.saveOrUpdate(userDao);
        sessionService.delete(sessionDao);

        appData.setResponse(ResponseImpl.create(Status.OK, "Pomyślnie wylogowano użytkownika.", -1));
    }

}
