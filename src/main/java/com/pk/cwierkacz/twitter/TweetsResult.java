package com.pk.cwierkacz.twitter;

import com.google.common.collect.ImmutableList;
import com.pk.cwierkacz.model.dao.TweetDao;

/**
 * Tweeter results of tweeter home timeline
 * 
 * @author radek
 * 
 */
public class TweetsResult
{
    /**
     * if false that mens that result is not full. Probably we get all tweets
     * from home timeline or twitter result is too big, so twitter don't return
     * all values
     */
    private final boolean fullResult;

    private final ImmutableList<TweetDao> tweets;

    public int size( ) {
        return getTweets().size();
    }

    public TweetsResult( boolean fullResult, ImmutableList<TweetDao> tweets ) {
        this.fullResult = fullResult;
        this.tweets = tweets;
    }

    public static TweetsResult full( ImmutableList<TweetDao> tweets ) {
        return new TweetsResult(true, tweets);
    }

    public static TweetsResult partially( ImmutableList<TweetDao> tweets ) {
        return new TweetsResult(false, tweets);
    }

    public boolean isFullResult( ) {
        return fullResult;
    }

    public ImmutableList<TweetDao> getTweets( ) {
        return tweets;
    }
}
