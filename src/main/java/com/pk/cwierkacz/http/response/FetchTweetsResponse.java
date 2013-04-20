package com.pk.cwierkacz.http.response;

import java.util.List;
import java.util.Map;

import com.pk.cwierkacz.model.dao.TweetDao;

public interface FetchTweetsResponse extends Response
{
    List<TweetDao> getTweets( );

    Map<Long, String> getUsersTweeter( );
}
