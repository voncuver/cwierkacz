package com.pk.cwierkacz.twitter.converters;

import twitter4j.Status;

import com.google.common.base.Function;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.utils.DateUtil;

public class ToTweetConverter implements Function<Status, TweetDao>
{

    private final TwitterAccountService accountService = ServiceRepo.getInstance()
                                                                    .getService(TwitterAccountService.class);

    private final TweetService tweetService = ServiceRepo.getInstance().getService(TweetService.class);

    @Override
    public TweetDao apply( Status status ) {

        TweetDao tweetDb = tweetService.getByExternalId(status.getId());
        if ( tweetDb != null )
            return tweetDb;
        else {
            TweetDao tweet = new TweetDao();

            tweet.setText(status.getText());
            tweet.setCratedDate(DateUtil.convertDateUTC(status.getCreatedAt()));
            tweet.setCreator(accountService.getAccountByExternalId(status.getUser().getId()));
            tweet.setExternalId(status.getId());
            if ( status.getInReplyToStatusId() > 0 )
                tweet.setInReplyToExtId(status.getInReplyToStatusId());
            if ( status.getRetweetedStatus() != null )
                tweet.setRetweetedExtId(status.getRetweetedStatus().getId());

            if ( status.getRetweetedStatus() != null )
                tweetService.getByExternalId(status.getRetweetedStatus().getId());

            return fulfill(tweet);
        }
    }

    public TweetDao fulfill( TweetDao tweet ) {
        if ( tweet.getRetweeted() == null && tweet.getRetweetedExtId() != null ) {
            tweet.setRetweeted(tweetService.getByExternalId(tweet.getRetweetedExtId()));
        }

        if ( tweet.getInReplyTo() == null && tweet.getInReplyToExtId() != null ) {
            tweet.setInReplyTo(tweetService.getByExternalId(tweet.getInReplyToExtId()));
        }

        return tweet;
    }

}
