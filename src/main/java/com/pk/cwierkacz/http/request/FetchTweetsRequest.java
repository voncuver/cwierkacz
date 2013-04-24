package com.pk.cwierkacz.http.request;

import java.util.List;

import org.joda.time.DateTime;

public interface FetchTweetsRequest extends Request
{
    List<String> getAccounts( );

    int getSize( );

    long getReplayForId( );

    //TODO obsługa pobieranie re-tweetów

    DateTime getDateFrom( );
}
