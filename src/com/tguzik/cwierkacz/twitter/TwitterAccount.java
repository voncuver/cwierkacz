package com.tguzik.cwierkacz.twitter;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.dataobject.Tweet;
import com.tguzik.cwierkacz.cache.dataobject.User;
import com.tguzik.cwierkacz.twitter.converters.TweetConverter;
import com.tguzik.cwierkacz.utils.DateUtil;

/**
 * Class which represents twitter account - using this account we can for
 * example compose new tweet or search tweet
 * 
 * @author radek
 * 
 */
//TODO(Tomek): Rewrite to a separate service that selected processors would be using.
public class TwitterAccount
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterAccount.class);
    private static final DateTimeFormatter DATE_FORMATTER = DateUtil.formatterUTC();

    protected final User user;
    protected Twitter twitter;
    protected TweetConverter tweetConverter = new TweetConverter();

    /**
     * Initialize a twitter account
     * 
     * @param user
     *            owner of this account
     * @throws TwitterAuthenticationException
     */
    public TwitterAccount( User user ) throws TwitterAuthenticationException {
        authenticate(user);
        this.user = user;
    }

    /**
     * Method which compose new tweet in Tweeter account
     * 
     * @param msg
     *            textual representation of tweet
     * @throws TwitterActionException
     */
    public Tweet composeNewTweet( String msg ) throws TwitterActionException {
        try {
            Status stat = twitter.updateStatus(msg);
            return tweetConverter.toTweet(stat);
        }
        catch ( TwitterException e ) {
            LOGGER.error(e.getMessage());
            throw new TwitterActionException(e.getMessage());
        }
    }

    /**
     * Method which delete existing tweet
     * 
     * @param tweet
     *            which will be deleted
     * @throws TwitterActionException
     */
    public void deleteTweet( Tweet tweet ) throws TwitterActionException {
        try {
            twitter.destroyStatus(tweet.getExternalId());
        }
        catch ( TwitterException e ) {
            LOGGER.error(e.getMessage(), e);
            throw new TwitterActionException(e.getMessage());
        }
    }

    /**
     * Method which get all tweet since reference for Tweeter account
     * 
     * @param sinceDate
     * @throws TwitterActionException
     */
    public ImmutableList<Tweet> getTweetsSince( LocalDate sinceDate ) throws TwitterActionException {
        String queryString = String.format("from:%s", user.getName());
        Query query = new Query(queryString).since(DATE_FORMATTER.print(sinceDate));
        return queryToTweets(query);
    }

    protected ImmutableList<Tweet> queryToTweets( Query query ) throws TwitterActionException {
        ImmutableList.Builder<Tweet> builder = ImmutableList.builder();
        QueryResult result;

        try {
            do {
                result = twitter.search(query);
                for ( Status status : result.getTweets() ) {
                    builder.add(tweetConverter.toTweet(status));
                }
            }
            while ( ( query = result.nextQuery() ) != null );

            return builder.build();
        }
        catch ( TwitterException e ) {
            LOGGER.error(e.getMessage(), e);
            throw new TwitterActionException(e.getMessage());
        }
    }

    protected void authenticate( User user ) throws TwitterAuthenticationException {
        TwitterFactory factory = new TwitterFactory();

        if ( user.oAuthAuthenticationAvailable() ) {
            AccessToken token = new AccessToken(user.getAccessToken(), user.getAccessTokenSecret());
            twitter = factory.getInstance(token);
        }
        else {
            throw new TwitterAuthenticationException("Simple authentication and oAuth authentication impossible");
        }
    }
}
