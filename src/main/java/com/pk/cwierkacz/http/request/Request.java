package com.pk.cwierkacz.http.request;

import java.sql.Timestamp;

import com.pk.cwierkacz.http.Action;

public interface Request
{
    Action getAction( );

    Timestamp getTimestamp( );

    String getFunctionalUserName( );

    long getTokenId( );
}
