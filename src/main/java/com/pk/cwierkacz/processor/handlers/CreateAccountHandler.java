package com.pk.cwierkacz.processor.handlers;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.LoginRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.UserService;
import com.pk.cwierkacz.utils.HashUtil;

public class CreateAccountHandler extends AbstractHandler
{
    private final UserService userService;

    public CreateAccountHandler() {
        userService = ServiceRepo.getInstance().getService(UserService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.ADDACCOUNT);
    }

    @Override
    public void handle( ApplicationData appData ) {

        LoginRequest loginRequest = (LoginRequest) appData.getRequest();

        UserDao check = userService.getByUserName(loginRequest.getUserName());
        if ( check != null ) {
            appData.setResponse(ResponseImpl.create(Status.ERROR, "Current User exist", 0));
            return;
        }

        UserDao userDao = new UserDao();
        userDao.setName(loginRequest.getUserName());
        String hashedPassowrd = HashUtil.hashString(loginRequest.getPassword());
        if ( hashedPassowrd == "" ) {
            appData.setResponse(ResponseImpl.create(Status.ERROR, "Exception while hashing Password", 0));
        }

        userDao.setPassword(hashedPassowrd);

        userService.save(userDao);

        Response response = ResponseImpl.create(Status.OK, "Succesfully created Account", 0);
        appData.setResponse(response);
    }

}
