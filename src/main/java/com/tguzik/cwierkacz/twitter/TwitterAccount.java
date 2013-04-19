package com.tguzik.cwierkacz.twitter;

import main.java.com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;
import main.java.com.tguzik.cwierkacz.twitter.converters.TweetConverter;
import main.java.com.tguzik.cwierkacz.utils.DateUtil;

import org.joda.time.LocalDate;
import java.util.List;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.google.common.collect.ImmutableList;

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
    private static final DateTimeFormatter DATE_FORMATTER = DateUtil.formatterYyyyMMddUTC();

    protected final FunctionalAccount user;
    protected Twitter twitter;
    protected TweetConverter tweetConverter = new TweetConverter();

    /**
     * Initialize a twitter account
     * 
     * @param user
     *            owner of this account
     * @throws TwitterAuthenticationException
     */
    public TwitterAccount( FunctionalAccount user ) throws TwitterAuthenticationException {
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
            validateTweetMsg(msg);
            Status stat = twitter.updateStatus(msg);
            return tweetConverter.toTweet(stat);
        }
        catch ( TwitterException e ) {
            LOGGER.error(e.getMessage());
            throw new TwitterActionException(e.getMessage());
        }
    }

    /**
     * Method which compose new reply tweet in Tweeter account
     * 
     * @param msg
     *            textual representation of tweet
     * @param mainTweetId
     *            identifier of tweet for which we reply
     * @throws TwitterActionException
     */
    public Tweet composeNewReplyTweet( String msg, Tweet mainTweet ) throws TwitterActionException {
        try {
            String msgWithTarget = "@" + mainTweet.getCreatorName() + " " + msg;
            validateTweetMsg(msgWithTarget);
            StatusUpdate update = new StatusUpdate(msgWithTarget);
            update.setInReplyToStatusId(mainTweet.getTweetId().toValue());
            Status stat = twitter.updateStatus(update);
            return tweetConverter.toTweet(stat);
        }
        catch ( TwitterException e ) {
            LOGGER.error(e.getMessage());
            throw new TwitterActionException(e.getMessage());
        }
    }

    /**
     * Method which compose new re tweet in Tweeter account
     * 
     * @param msg
     *            textual representation of tweet
     * @param mainTweetId
     *            identifier of tweet for which we create reTweet
     * @throws TwitterActionException
     */
    public Tweet composeNewReTweet( Tweet mainTweet ) throws TwitterActionException {
        try {
            if ( mainTweet.getAccountId().equals(user.getAccountId()) )
                throw new TwitterActionException("You cannot retweet himself");

            Status stat = twitter.retweetStatus(mainTweet.getTweetId().toValue());
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
            twitter.destroyStatus(tweet.getTweetId().toValue());
        }
        catch ( TwitterException e ) {
            LOGGER.error(e.getMessage(), e);
            throw new TwitterActionException(e.getMessage());
        }
    }

    public ImmutableList<Tweet> getTweetsFromHomeTimeline( int count ) throws TwitterActionException {
        try {
            List<Status> statuses = twitter.getHomeTimeline(new Paging().count(count));
            ImmutableList.Builder<Tweet> builder = ImmutableList.builder();
            for ( int i = 0; i < statuses.size(); i++ ) {
                builder.add(tweetConverter.toTweet(statuses.get(i)));
            }
            return builder.build();
        }
        catch ( TwitterException e ) {
            LOGGER.error(e.getMessage(), e);
            throw new TwitterActionException(e.getMessage());
        }
    }

    /**
     * Method which get all tweet matching to criteria
     * 
     * @param criteria
     * @throws TwitterActionException
     */
    @Deprecated
    //not tested - probably unnecessary method
    public ImmutableList<Tweet> searchTweets( QueryCriteria criteria ) throws TwitterActionException {

        return searchTweets(prepereQuery(criteria));
    }

    protected Query prepereQuery( QueryCriteria criteria ) {

        String fromString = "";
        if ( criteria.getFrom() != null )
            fromString = String.format("from:%s", criteria.getFrom().getAccountName().toValue());

        String toString = "";
        if ( criteria.getTo() != null )
            toString = String.format("to:%s", criteria.getTo().getAccountName().toValue());

        String sinceString = "";
        if ( criteria.getSinceDate() != null )
            sinceString = String.format("since:%s", DATE_FORMATTER.print(criteria.getSinceDate()));

        String untilString = "";
        if ( criteria.getUntilDate() != null )
            untilString = String.format("until:%s", DATE_FORMATTER.print(criteria.getUntilDate()));

        String queryString = fromString + " " + toString + " " + sinceString + " " + untilString;

        return new Query(queryString);
    }

    protected ImmutableList<Tweet> searchTweets( Query query ) throws TwitterActionException {
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

    protected void authenticate( FunctionalAccount user ) throws TwitterAuthenticationException {
        TwitterFactory factory = new TwitterFactory();

        if ( user.isOAuthAvailable() ) {
            AccessToken token = new AccessToken(user.getAccessToken(), user.getAccessTokenSecret());
            twitter = factory.getInstance(token);
        }
        else {
            throw new TwitterAuthenticationException("oAuth authentication impossible");
        }
    }

    protected void validateTweetMsg( String msg ) throws TwitterActionException {
        if ( msg.length() > 140 )
            throw new TwitterActionException("Size of tweeter message can't be grather than 140");
    }
}
