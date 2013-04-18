package com.pk.cwierkacz.model.http;

import java.util.List;
import java.util.Map;

import com.pk.cwierkacz.model.dao.Tweet;

public class FetchTweetsResponse extends Response
{

    private final List<Tweet> tweets;

    private final Map<Long, String> usersTweeter;

    public FetchTweetsResponse( Status status,
                                String message,
                                long tokenId,
                                List<Tweet> tweets,
                                Map<Long, String> usersTweeter ) {
        super(status, message, tokenId);
        this.tweets = tweets;
        this.usersTweeter = usersTweeter;
    }

    public List<Tweet> getTweets( ) {
        return tweets;
    }

    public Map<Long, String> getUsersTweeter( ) {
        return usersTweeter;
    }
}
