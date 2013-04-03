package com.tguzik.cwierkacz.twitter.converters;

import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableList;
import static com.tguzik.cwierkacz.utils.CollectionUtil.safe;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.tguzik.cwierkacz.cache.dataobject.Tweet;
import com.tguzik.cwierkacz.utils.annotation.Threadsafe;

@Threadsafe
public class TweetConverter
{
    private static final Function<Tweet, StatusUpdate> TO_STATUS_UPDATE = new ToStatusUpdateConverter();
    private static final Function<Status, Tweet> TO_TWEET = new ToTweetConverter();

    public Tweet toTweet( Status status ) {
        return TO_TWEET.apply(status);
    }

    public StatusUpdate fromTweet( Tweet tweet ) {
        return TO_STATUS_UPDATE.apply(tweet);
    }

    public ImmutableList<Tweet> fromResults( QueryResult result ) {
        Iterable<Status> statuses = safe(result != null ? result.getTweets() : null);
        return copyToImmutableList(Iterables.transform(statuses, TO_TWEET));
    }
}
