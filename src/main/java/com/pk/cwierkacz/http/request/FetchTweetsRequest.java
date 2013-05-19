package com.pk.cwierkacz.http.request;

import java.util.List;

import org.joda.time.DateTime;

import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;

// FetchTweetsRequest, FetchTweetRequest
public interface FetchTweetsRequest extends Request
{
    List<Account> getAccounts( );

    AccountType getAccountType( );

    int getSize( );

    long getReplayFor( );

    long getRetweetFor( );

    DateTime getDateFrom( );

    DateTime getDateTo( );

    List<Long> getIds( );
}
