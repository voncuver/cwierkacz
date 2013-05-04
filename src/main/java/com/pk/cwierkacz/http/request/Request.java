package com.pk.cwierkacz.http.request;

import java.sql.Timestamp;

import com.pk.cwierkacz.http.Action;

// FetchTweeterAccountsRequest, LogoutRequest
public interface Request
{
    Action getAction( );

    Timestamp getTimestamp( );

    String getUserName( );

    long getTokenId( );
}
