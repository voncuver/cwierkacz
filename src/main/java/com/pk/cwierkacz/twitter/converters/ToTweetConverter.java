package com.pk.cwierkacz.twitter.converters;

import twitter4j.Status;

import com.google.common.base.Function;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.utils.DateUtil;

class ToTweetConverter implements Function<Status, TweetDao>
{
    @Override
    public TweetDao apply( Status status ) {

        //TODO ciagnac z bazy jak jest a jak nie ma to sworzyc nowego tweeta
        TwitterAccountService twitterAccountService = null;
        // TwitterAccountDao accountDao = twitterAccountService.getAccountById(status.getUser().getId());

        //TweetService tweetService = null;
        //TweetDao tweetDao = tweetService.getTweetById(status.getInReplyToStatusId());

        Long retweetId = null;
        TweetDao reTweetDao = null;
        /*if ( status.getRetweetedStatus() != null ) {
            retweetId = status.getRetweetedStatus().getId();

            reTweetDao = tweetService.getTweetById(retweetId);
        }*/
        return TweetDao.create(status.getId(), null, // TODO
                               null,
                               null,
                               DateUtil.convertDateUTC(status.getCreatedAt()),
                               status.getText());
    }
}
