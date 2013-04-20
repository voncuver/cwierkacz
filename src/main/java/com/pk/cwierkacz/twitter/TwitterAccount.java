package com.pk.cwierkacz.twitter;

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
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.twitter.attachment.TweetAttachments;
import com.pk.cwierkacz.twitter.converters.TweetConverter;
import com.pk.cwierkacz.utils.DateUtil;

/**
 * Class which represents twitter account - using this account we can for
 * example compose new tweet or search tweet
 * 
 * @author radek
 * 
 */
public class TwitterAccount
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterAccount.class);
    private static final DateTimeFormatter DATE_FORMATTER = DateUtil.formatterYyyyMMddUTC();

    protected final TwitterAccountDao account;
    protected Twitter twitter;
    protected TweetConverter tweetConverter = new TweetConverter();

    /**
     * Initialize a twitter account
     * 
     * @param user
     *            owner of this account
     * @throws TwitterAuthenticationException
     */
    public TwitterAccount( TwitterAccountDao account ) throws TwitterAuthenticationException {
        authenticate(account);
        this.account = account;
    }

    /**
     * Method which compose new tweet in Tweeter account
     * 
     * @param msg
     *            textual representation of tweet
     * @throws TwitterActionException
     */
    public TweetDao composeNewTweet( String msg ) throws TwitterActionException {
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
     * Method which compose new tweet in Tweeter account
     * 
     * @param msg
     *            textual representation of tweet
     * @param attachments
     *            tweet attachments f.ex. image
     * @throws TwitterActionException
     */
    public TweetDao composeNewTweet( String msg, TweetAttachments attachments ) throws TwitterActionException {
        return customComposeNewTweet(msg, null, attachments);
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
    public TweetDao composeNewReplyTweet( String msg, TweetDao mainTweet ) throws TwitterActionException {
        return customComposeNewTweet(msg, mainTweet, TweetAttachments.empty());
    }

    /**
     * Method which compose new reply tweet in Tweeter account
     * 
     * @param msg
     *            textual representation of tweet
     * @param mainTweetId
     *            identifier of tweet for which we reply
     * @param attachments
     *            tweet attachments f.ex. image
     * @throws TwitterActionException
     */
    public TweetDao composeNewReplyTweet( String msg, TweetDao mainTweet, TweetAttachments attachments ) throws TwitterActionException {
        return customComposeNewTweet(msg, mainTweet, attachments);
    }

    protected TweetDao customComposeNewTweet( String msg, TweetDao toReplyTweet, TweetAttachments attachments ) throws TwitterActionException {
        try {
            StatusUpdate update;
            if ( toReplyTweet == null ) {
                update = new StatusUpdate(msg);
            }
            else {
                String msgWithTarget = "@" + toReplyTweet.getCreatorName() + " " + msg;
                update = new StatusUpdate(msgWithTarget);
                update.setInReplyToStatusId(toReplyTweet.getId());
            }
            if ( attachments.haveImage() )
                update.setMedia(attachments.getImage().getAttachment());

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
    public TweetDao composeNewReTweet( TweetDao mainTweet ) throws TwitterActionException {
        try {
            if ( mainTweet.getCreatorId() == account.getId() )
                throw new TwitterActionException("You cannot retweet himself");

            Status stat = twitter.retweetStatus(mainTweet.getId());
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
    public void deleteTweet( TweetDao tweet ) throws TwitterActionException {
        try {
            twitter.destroyStatus(tweet.getId());
        }
        catch ( TwitterException e ) {
            LOGGER.error(e.getMessage(), e);
            throw new TwitterActionException(e.getMessage());
        }
    }

    public ImmutableList<TweetDao> getTweetsFromHomeTimeline( int count ) throws TwitterActionException {
        try {
            List<Status> statuses = twitter.getHomeTimeline(new Paging().count(count));
            ImmutableList.Builder<TweetDao> builder = ImmutableList.builder();
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
    public ImmutableList<TweetDao> searchTweets( QueryCriteria criteria ) throws TwitterActionException {

        return searchTweets(prepereQuery(criteria));
    }

    protected Query prepereQuery( QueryCriteria criteria ) {

        String fromString = "";
        if ( criteria.getFrom() != null )
            fromString = String.format("from:%s", criteria.getFrom().getAccountName());

        String toString = "";
        if ( criteria.getTo() != null )
            toString = String.format("to:%s", criteria.getTo().getAccountName());

        String sinceString = "";
        if ( criteria.getSinceDate() != null )
            sinceString = String.format("since:%s", DATE_FORMATTER.print(criteria.getSinceDate()));

        String untilString = "";
        if ( criteria.getUntilDate() != null )
            untilString = String.format("until:%s", DATE_FORMATTER.print(criteria.getUntilDate()));

        String queryString = fromString + " " + toString + " " + sinceString + " " + untilString;

        return new Query(queryString);
    }

    protected ImmutableList<TweetDao> searchTweets( Query query ) throws TwitterActionException {
        ImmutableList.Builder<TweetDao> builder = ImmutableList.builder();
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

    protected void authenticate( TwitterAccountDao account ) throws TwitterAuthenticationException {
        TwitterFactory factory = new TwitterFactory();

        if ( account.isOAuthAvailable() ) {
            AccessToken token = new AccessToken(account.getAccessToken(), account.getAccessTokenSecret());
            twitter = factory.getInstance(token);
        }
        else {
            throw new TwitterAuthenticationException("oAuth authentication impossible");
        }
    }

    @Deprecated
    //twitter validation is more sophisticated so we must rely on twitter response
    protected void validateTweetMsg( String msg ) throws TwitterActionException {
        if ( msg.length() > 140 )
            throw new TwitterActionException("Size of tweeter message can't be grather than 140");
    }
}
