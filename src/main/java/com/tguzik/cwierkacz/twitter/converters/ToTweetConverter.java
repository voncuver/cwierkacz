package com.tguzik.cwierkacz.twitter.converters;

import twitter4j.Status;

import com.google.common.base.Function;
import com.tguzik.cwierkacz.cache.dataobject.Tweet;
import com.tguzik.cwierkacz.utils.DateUtil;

class ToTweetConverter implements Function<Status, Tweet>
{
    @Override
    public Tweet apply( Status status ) {
        return Tweet.create(status.getId(),
                            status.getUser().getId(),
                            status.getUser().getScreenName(),
                            status.getInReplyToStatusId(),
                            DateUtil.convertDateUTC(status.getCreatedAt()),
                            status.getText());
    }
}
