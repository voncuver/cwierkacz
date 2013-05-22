package com.pk.cwierkacz.http.request;

import java.util.List;

import org.joda.time.DateTime;

import com.pk.cwierkacz.http.response.dto.Account;

public interface FetchMessagesRequest extends Request
{
    List<Account> getAccounts( );

    int getSize( );

    DateTime getDateFrom( );

    DateTime getDateTo( );

}
