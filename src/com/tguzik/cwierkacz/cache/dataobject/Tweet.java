package com.tguzik.cwierkacz.cache.dataobject;

import org.joda.time.LocalDate;

import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

/**
 * Class representing a single tweet (single, but may containing re-tweets)
 * 
 * @author radek
 */
@Immutable
@ReflectionInstanitation
public final class Tweet extends DataObject
{
    //TODO consider adding a internal id

    private final Long externalId;

    private final User tweetCreator;

    private final LocalDate cratedDate;

    private final String text;

    private Tweets reTweet;

    /**
     * Initialize a single tweet
     * 
     * @param externalId
     *            Identifier of tweet - same as stored in twitter db
     * @param tweetCreator
     *            user which create this tweet
     * @param cratedDate
     *            date of this tweet creation
     */
    public Tweet( Long externalId, User tweetCreator, LocalDate cratedDate, String text ) {
        this.tweetCreator = tweetCreator;
        this.cratedDate = cratedDate;
        this.externalId = externalId;
        this.text = text;
    }

    @Override
    public UniqueKey getUniqueKey( ) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * returns a user which created this tweet
     */
    public User getTweetCreator( ) {
        return tweetCreator;
    }

    /**
     * returns a date when this tweet was created
     */
    public LocalDate getCratedDate( ) {
        return cratedDate;
    }

    /**
     * returns a list of reply tweet
     */
    public Tweets getReTweet( ) {
        return reTweet;
    }

    /**
     * returns a id stored in twitter
     */
    public Long getExternalId( ) {
        return externalId;
    }

    /**
     * add list of reply tweet to current tweet
     * 
     * @param reTweet
     */
    public void setReTweet( Tweets reTweet ) {
        this.reTweet = reTweet;
    }

    /**
     * returns text representation of tweet
     */
    public String getText( ) {
        return text;
    }
}
