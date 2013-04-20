package com.pk.cwierkacz.processor.handlers;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.HibernateUtil;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.UserService;

public class CreateAccountHandler implements Handler
{

    private final UserService userService;

    public CreateAccountHandler() {
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        userService = new UserService(hibernateUtil.getSessionFactory());
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.CREATEACCOUNT);
    }

    @Override
    public void handle( ApplicationData appData ) {
        LoginRequest loginRequest = (LoginRequest) appData.getRequest();

        UserDao userDao = new UserDao();
        userDao.setName(loginRequest.getFunctionalUserName());
        userDao.setPassword(loginRequest.getPassword());

        userService.save(userDao);

        Response response = ResponseImpl.create(Status.OK, "Ok", loginRequest.getTokenId());

        appData.setResponse(response);
    }

}
