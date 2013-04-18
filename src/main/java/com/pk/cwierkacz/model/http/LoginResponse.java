package com.pk.cwierkacz.model.http;

import java.util.List;

public class LoginResponse extends Response
{
    private final List<String> accounts;

    public LoginResponse( Status status, String message, long tokenId, List<String> accounts ) {
        super(status, message, tokenId);
        this.accounts = accounts;
    }

    public List<String> getAccounts( ) {
        return accounts;
    }

}
