package com.pk.cwierkacz.processor.handlers;

import java.sql.Timestamp;

import org.joda.time.DateTime;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.UserService;

public class LoginHandler implements Handler
{
    private final UserService userService = null;
    private final SessionService sessionService = null;

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.LOGIN);
    }

    @Override
    public void handle( ApplicationData appData ) {
        String name = appData.getRequest().getFunctionalUserName();
        UserDao user = userService.getByUserName(name);

        SessionDao session = new SessionDao();
        DateTime dateTime = new DateTime();
        session.setLastActive(new Timestamp(dateTime.getMillis()));
        session.setCurrentToken(appData.getRequest().getTokenId());
        sessionService.save(session);
        //check pass

    }
}
