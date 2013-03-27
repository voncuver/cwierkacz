package com.tguzik.cwierkacz.twitter.converters;

import twitter4j.Status;

import com.tguzik.cwierkacz.cache.dataobject.Tweet;
import com.tguzik.cwierkacz.utils.DateUtil;

public class TweetConverter
{

    protected UserConverter userConverter = new UserConverter();

    public Tweet toTweet( Status status ) {
        Tweet tweet = Tweet.create(status.getId(),
                                   status.getInReplyToStatusId(),
                                   status.getUser().getId(),
                                   DateUtil.convertDateUTC(status.getCreatedAt()),
                                   status.getText());
        return tweet;
    }
}
