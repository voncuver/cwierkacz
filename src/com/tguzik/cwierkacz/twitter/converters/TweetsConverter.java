package com.tguzik.cwierkacz.twitter.converters;

import java.util.List;

import twitter4j.Status;

import com.tguzik.cwierkacz.cache.dataobject.Tweets;

public class TweetsConverter
{
    protected TweetConverter tweetConverter = new TweetConverter();

    public Tweets toTweets( List<Status> stats ) {
        Tweets tweets = new Tweets();
        for ( Status stat : stats ) {
            tweets.addTweet(tweetConverter.toTweet(stat));
        }
        return tweets;
    }
}
