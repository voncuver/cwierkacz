package com.pk.cwierkacz.http.response;

import com.pk.cwierkacz.http.Status;

public interface Response
{

    Status getStatus( );

    String getText( );

    long getTokenId( );
}
