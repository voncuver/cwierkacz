package com.pk.cwierkacz.http.request;

import java.util.List;

import com.pk.cwierkacz.model.AccountType;

public interface GetMessagesRequest extends Request
{
    AccountType getAccountType( );

    List<Long> getIds( );

    List<String> getAccountLogins( );
}
