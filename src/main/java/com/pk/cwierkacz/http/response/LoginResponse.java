package com.pk.cwierkacz.http.response;

import java.util.Set;

import com.pk.cwierkacz.model.Account;

public interface LoginResponse extends Response
{
    Set<Account> getAccounts( );

}
