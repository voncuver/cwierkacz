package com.pk.cwierkacz.twitter.converters;

import twitter4j.MediaEntity;
import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;

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

    private final TwitterAcountConverter twitterAcountConverter = new TwitterAcountConverter();

    @Override
    public TweetDao apply( Status status ) {

        TweetDao tweetDb = tweetService.getByExternalId(status.getId());
        if ( tweetDb != null )
            return tweetDb;
        else {
            TweetDao tweet = new TweetDao();

            tweet.setText(plainText(status));
            tweet.setCratedDate(DateUtil.convertDateUTC(status.getCreatedAt()));
            tweet.setCreator(twitterAcountConverter.toAccount(status.getUser()));
            tweet.setExternalId(status.getId());
            if ( status.getInReplyToStatusId() > 0 )
                tweet.setInReplyToExtId(status.getInReplyToStatusId());
            if ( status.getRetweetedStatus() != null )
                tweet.setRetweetedExtId(status.getRetweetedStatus().getId());

            if ( status.getRetweetedStatus() != null )
                tweetService.getByExternalId(status.getRetweetedStatus().getId());

            if ( status.getMediaEntities() != null ) {
                for ( MediaEntity me : status.getMediaEntities() ) {
                    if ( me.getMediaURL() != null )
                        tweet.setTwitterImageUrl(me.getMediaURL());
                }
            }

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

    public String plainText( Status status ) {
        String fullText = status.getText();
        String withoutRT = fullText;

        if ( status.getRetweetedStatus() != null && fullText.startsWith("RT") ) {
            withoutRT = fullText.substring(3, fullText.length());
        }

        String witoutReply = withoutRT;

        for ( UserMentionEntity mention : status.getUserMentionEntities() ) {
            witoutReply = witoutReply.replace("@" + mention.getScreenName() + ": ", "");
            witoutReply = witoutReply.replace("@" + mention.getScreenName() + " ", "");
        }

        String withoutImg = witoutReply;

        for ( URLEntity url : status.getMediaEntities() ) {
            withoutImg = withoutImg.replace(" " + url.getURL(), "");
        }

        return withoutImg;
    }

}
