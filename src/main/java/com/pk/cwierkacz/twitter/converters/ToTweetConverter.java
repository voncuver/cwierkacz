package com.pk.cwierkacz.twitter.converters;

import twitter4j.Status;

import com.google.common.base.Function;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.utils.DateUtil;

class ToTweetConverter implements Function<Status, TweetDao>
{
    @Override
    public TweetDao apply( Status status ) {

        Long retweetId = null;
        if ( status.getRetweetedStatus() != null )
            retweetId = status.getRetweetedStatus().getId();
        return TweetDao.create(status.getId(),
                               status.getUser().getId(),
                               status.getUser().getScreenName(),
                               status.getInReplyToStatusId(),
                               retweetId,
                               DateUtil.convertDateUTC(status.getCreatedAt()),
                               status.getText());
    }
}
