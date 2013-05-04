package com.pk.cwierkacz.http.request;

import java.util.List;

// PublishRequest
public interface PublishRequest extends Request
{
    long getReplayFor( );

    long getRetweetFor( );

    String getTweetText( );

    List<String> getAccounts( );
}
