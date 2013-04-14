package com.pk.cwierkacz.model.http;

public class LoginRequest
{
    private String password;

    private Request request;

    public static LoginRequest buildLoginRequest( Request request, String password ) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.password = password;
        loginRequest.request = request;
        return loginRequest;
    }

    public String getPassword( ) {
        return password;
    }

    public Request getRequest( ) {
        return request;
    }
}
