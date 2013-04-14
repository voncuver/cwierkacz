package com.pk.cwierkacz.model.http;

import java.sql.Timestamp;

public class LoginRequest
{
    private String password;

    private Request request;

    private boolean create;

    private boolean logout;

    public static LoginRequest buildLoginRequest( Request request, String password ) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.password = password;
        loginRequest.request = request;
        return loginRequest;
    }

    public static LoginRequest buildLoginRequest( Request request, String password, boolean createAccount ) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.password = password;
        loginRequest.request = request;
        loginRequest.create = createAccount;
        return loginRequest;
    }

    public static LoginRequest buildLogoutRequest( Request request, String password ) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.password = password;
        loginRequest.request = request;
        loginRequest.logout = true;
        return loginRequest;
    }

    public String getPassword( ) {
        return password;
    }

    public boolean isCreate( ) {
        return create;
    }

    public boolean isLogout( ) {
        return logout;
    }

    public Action getAction( ) {
        return request.getAction();
    }

    public Timestamp getTimestamp( ) {
        return request.getTimestamp();
    }

    public String getFunctionalUserName( ) {
        return request.getFunctionalUserName();
    }
}
