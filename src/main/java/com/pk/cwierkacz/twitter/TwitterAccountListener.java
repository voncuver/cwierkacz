package com.pk.cwierkacz.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;

import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.twitter.converters.TweetConverter;

public class TwitterAccountListener extends TwitterStreamResolver
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterAccountListener.class);

    protected final TwitterAccountDao account;
    protected TweetConverter tweetConverter = new TweetConverter();
    protected TwitterStream twitterStream;

    /**
     * Initialize a twitter account
     * 
     * @param user
     *            owner of this account
     * @throws TwitterAuthenticationException
     */
    public TwitterAccountListener( TwitterAccountDao account ) throws TwitterAuthenticationException {
        authenticate(account);
        this.account = account;
    }

    /**
     * initialize o twitter account listener - created status listener and add
     * to stream
     * 
     * @param storage
     *            api to create/remove tweet in db
     */
    public void initialize( final TwitterStorage storage ) {
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus( Status status ) {
                LOGGER.info("@" + status.getUser().getScreenName() + " - " + status.getText());
                TweetDao newTweet = tweetConverter.toTweet(status);
                storage.addUnclassifiedTweet(newTweet);
            }

            @Override
            public void onDeletionNotice( StatusDeletionNotice statusDeletionNotice ) {
                LOGGER.info("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
                long deletedTweetId = statusDeletionNotice.getStatusId();
                storage.removeTweet(deletedTweetId);
            }

            @Override
            public void onTrackLimitationNotice( int numberOfLimitedStatuses ) {
                LOGGER.warn("Track Limitaion Notice : " + numberOfLimitedStatuses + "\n");
                //TODO think how handle it
            }

            @Override
            public void onScrubGeo( long userId, long upToStatusId ) {
                //not supported
            }

            @Override
            public void onStallWarning( StallWarning warning ) {
                LOGGER.warn("Stall warning : " + warning.toString() + "\n");
                //TODO think how handle it
            }

            @Override
            public void onException( Exception ex ) {
                LOGGER.error(ex.getMessage());
                //TODO think how handle it
            }
        };
        twitterStream.addListener(listener);
    }

    /**
     * listen o twitter status on current user account
     */
    public void listen( ) {
        long[] followers = {account.getExternalId()};
        FilterQuery query = new FilterQuery(0, followers);
        twitterStream.filter(query);
    }

    /**
     * stop listen status
     */
    public void stopListen( ) {
        twitterStream.cleanUp();
    }

    protected void authenticate( TwitterAccountDao account ) throws TwitterAuthenticationException {
        twitterStream = createTwitterStream(account, false);
    }

    @Override
    public String toString( ) {
        return "Twitter Acount Listener on " + account.getAccountName() + " (" + account.getId() + ")";
    }

}
