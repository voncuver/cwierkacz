package com.pk.cwierkacz.twitter.converters;

import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.pk.cwierkacz.model.dao.TweetDao;

public class TweetConverter
{
    private static final Function<TweetDao, StatusUpdate> TO_STATUS_UPDATE = new ToStatusUpdateConverter();
    private static final Function<Status, TweetDao> TO_TWEET = new ToTweetConverter();

    public TweetDao toTweet( Status status ) {
        return TO_TWEET.apply(status);
    }

    public ImmutableList<TweetDao> toTweets( Iterable<Status> result ) {
        Iterable<Status> statuses = result;
        return ImmutableList.copyOf(Iterables.transform(statuses, TO_TWEET));
    }

    public StatusUpdate fromTweet( TweetDao tweet ) {
        return TO_STATUS_UPDATE.apply(tweet);
    }

    public ImmutableList<TweetDao> fromResults( QueryResult result ) {
        Iterable<Status> statuses = result.getTweets();
        return ImmutableList.copyOf(Iterables.transform(statuses, TO_TWEET));
    }

}
