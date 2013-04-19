package com.pk.cwierkacz.http.response;

import java.util.List;
import java.util.Map;

import com.pk.cwierkacz.model.dao.Tweet;

public interface FetchTweetsResponse extends Response
{
    List<Tweet> getTweets( );

    Map<Long, String> getUsersTweeter( );
}
