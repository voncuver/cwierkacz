package com.pk.cwierkacz.http.request;

import java.util.List;

import com.pk.cwierkacz.http.response.dto.Account;

public interface PublishRetweetRequest extends Request
{
    long getRetweetFor( );

    List<Account> getAccounts( );
}
