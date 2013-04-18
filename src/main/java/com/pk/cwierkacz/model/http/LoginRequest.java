package com.pk.cwierkacz.model.http;

import java.sql.Timestamp;

public class LoginRequest extends Request
{

    private final String password;

    private boolean create;

    private boolean logout;

    public LoginRequest( Action action,
                         Timestamp timestamp,
                         String functionalUserName,
                         String password,
                         long tokenId ) {
        super(action, timestamp, functionalUserName, tokenId);
        this.password = password;
    }

    public LoginRequest createAccount( Action action,
                                       Timestamp timestamp,
                                       String functionalUserName,
                                       String password,
                                       long tokenId ) {
        LoginRequest loginRequest = new LoginRequest(action, timestamp, functionalUserName, password, tokenId);
        loginRequest.create = true;
        return loginRequest;
    }

    public LoginRequest logoutAccount( Action action,
                                       Timestamp timestamp,
                                       String functionalUserName,
                                       String password,
                                       long tokenId ) {
        LoginRequest loginRequest = new LoginRequest(action, timestamp, functionalUserName, password, tokenId);
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
}
