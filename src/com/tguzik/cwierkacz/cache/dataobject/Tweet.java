package com.tguzik.cwierkacz.cache.dataobject;

import org.joda.time.DateTime;

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
    private final Long externalId;
    private final Long inReplyTo;
    private final Long creatorId;
    private final DateTime cratedDate;
    private final String text;

    private Tweet( Long externalId, Long inReplyTo, Long creatorId, DateTime cratedDate, String text ) {
        this.creatorId = creatorId;
        this.cratedDate = cratedDate;
        this.externalId = externalId;
        this.inReplyTo = inReplyTo;
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
    public Long getCreatorId( ) {
        return creatorId;
    }

    /**
     * returns a date when this tweet was created
     */
    public DateTime getCratedDate( ) {
        return cratedDate;
    }

    /**
     * returns a id stored in twitter
     */
    public Long getExternalId( ) {
        return externalId;
    }

    public Long getInReplyTo( ) {
        return inReplyTo;
    }

    /**
     * returns text representation of tweet
     */
    public String getText( ) {
        return text;
    }

    public static Tweet create( Long externalId,
                                Long inReplyTo,
                                Long creatorId,
                                DateTime cratedDate,
                                String text ) {
        return new Tweet(externalId, inReplyTo, creatorId, cratedDate, text);
    }
}
