package com.pk.cwierkacz.processor.handlers;

import java.sql.Timestamp;

import org.joda.time.DateTime;

import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.Session;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.http.Action;
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
        UserDao user = userService.getByUserId(name);

        Session session = new Session();
        DateTime dateTime = new DateTime();
        session.setLastActive(new Timestamp(dateTime.getMillis()));
        session.setUserId(user.getId());
        session.setCurrentToken(appData.getRequest().getTokenId());
        sessionService.save(session);
        //check pass

    }
}
