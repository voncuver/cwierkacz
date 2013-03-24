package com.tguzik.cwierkacz.twitter.converters;

import twitter4j.Status;

import com.tguzik.cwierkacz.cache.dataobject.Tweet;

public class TweetConverter
{
    protected UserConverter userConverter = new UserConverter();
    protected DateConverter dateConverter = new DateConverter();

    public Tweet toTweet( Status status ) {
        Tweet tweet = new Tweet(status.getId(),
                                userConverter.toModelUser(status.getUser()),
                                dateConverter.toDate(status.getCreatedAt()),
                                status.getText());
        return tweet;
    }
}
