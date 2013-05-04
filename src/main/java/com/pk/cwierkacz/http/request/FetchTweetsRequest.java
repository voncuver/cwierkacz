package com.pk.cwierkacz.http.request;

import java.util.List;

import org.joda.time.DateTime;

// FetchTweetsRequest, FetchTweetRequest
public interface FetchTweetsRequest extends Request
{
    List<String> getAccounts( );

    int getSize( );

    long getReplayFor( );

    long getRetweetFor( );

    DateTime getDateFrom( );

    DateTime getDateTo( );
}
