package com.tguzik.cwierkacz.twitter;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.tguzik.cwierkacz.cache.dataobject.Tweet;
import com.tguzik.cwierkacz.cache.dataobject.Tweets;
import com.tguzik.cwierkacz.cache.dataobject.User;
import com.tguzik.cwierkacz.twitter.converters.DateConverter;
import com.tguzik.cwierkacz.twitter.converters.TweetConverter;
import com.tguzik.cwierkacz.twitter.converters.TweetsConverter;

/**
 * Class which represents twitter account - using this account we can for
 * example compose new tweet or search tweet
 * 
 * @author radek
 * 
 */
public class TwitterAccount
{
    protected Twitter twitter;

    protected User user;

    protected DateConverter dateConverter = new DateConverter();

    protected TweetsConverter tweetsConverter = new TweetsConverter();

    protected TweetConverter tweetConverter = new TweetConverter();

    private final Logger log = LoggerFactory.getLogger(TwitterAccount.class);

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
            log.error(e.getMessage());
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
            log.error(e.getMessage());
            throw new TwitterActionException(e.getMessage());
        }
    }

    /**
     * Method which get all tweet since reference for Tweeter account
     * 
     * @param sinceDate
     * @throws TwitterActionException
     */
    public Tweets getTweetsSince( LocalDate sinceDate ) throws TwitterActionException {

        Query query = new Query("from:" + user.getName()).since(dateConverter.toTruncateStringDate(sinceDate));
        return queryToTweets(query);
    }

    protected Tweets queryToTweets( Query query ) throws TwitterActionException {
        Query mutableQuery = query;
        QueryResult result;
        Tweets tweets = new Tweets();
        try {
            do {
                result = twitter.search(mutableQuery);
                tweets.addTweets(tweetsConverter.toTweets(result.getTweets()));
            }
            while ( ( query = result.nextQuery() ) != null );

            return tweets;
        }
        catch ( TwitterException e ) {
            log.error(e.getMessage());
            throw new TwitterActionException(e.getMessage());
        }
    }

    protected void authenticate( User user ) throws TwitterAuthenticationException {
        TwitterFactory factory = new TwitterFactory();

        if ( user.oAuthAuthenticationAvailable() ) {
            AccessToken token = new AccessToken(user.getAccessToken(), user.getAccessTokenSecret());
            twitter = factory.getInstance(token);
        }
        else
            throw new TwitterAuthenticationException("Simple authentication and oAuth authentication impossible");
    }
}
