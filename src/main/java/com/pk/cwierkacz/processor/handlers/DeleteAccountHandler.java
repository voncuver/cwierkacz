package com.pk.cwierkacz.processor.handlers;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.AccountManageRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.UserService;
import com.pk.cwierkacz.utils.HashUtil;

public class DeleteAccountHandler implements Handler
{

    private final UserService userService;
    private final SessionService sessionService;

    public DeleteAccountHandler() {
        userService = ServiceRepo.getInstance().getService(UserService.class);
        sessionService = ServiceRepo.getInstance().getService(SessionService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.DELACCOUNT);
    }

    @Override
    public void handle( ApplicationData appData ) {
        AccountManageRequest loginRequest = (AccountManageRequest) appData.getRequest();

        SessionDao sessionDao = sessionService.getByToken(loginRequest.getTokenId());
        UserDao userDao = userService.getBySessionId(sessionDao);

        if ( userDao == null ) {
            appData.setResponse(ResponseImpl.create(Status.ERROR, "User dosen't exist", 0));
            return;
        }

        String hash = HashUtil.hashString(loginRequest.getPassword());

        if ( !hash.equals(userDao.getPassword()) ) {
            appData.setResponse(ResponseImpl.create(Status.ERROR,
                                                    "Password dosen't match",
                                                    loginRequest.getTokenId()));
            return;
        }

        userService.delete(userDao);

        Response response = ResponseImpl.create(Status.OK,
                                                "Succesfully deleted Account",
                                                loginRequest.getTokenId());
        appData.setResponse(response);

    }

}