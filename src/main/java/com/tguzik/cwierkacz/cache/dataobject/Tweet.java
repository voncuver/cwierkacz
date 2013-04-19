package com.tguzik.cwierkacz.cache.dataobject;

import org.joda.time.DateTime;

import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.cache.dataobject.key.TweetKey;
import com.tguzik.cwierkacz.common.data.traits.HasFunctionalAccountId;
import com.tguzik.cwierkacz.common.data.traits.HasTweetId;
import com.tguzik.cwierkacz.common.data.value.FunctionalAccountId;
import com.tguzik.cwierkacz.common.data.value.TweetId;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

/**
 * Class representing a single tweet (single, but may containing re-tweets)
 * 
 * @author radek
 */
@Immutable
@ReflectionInstanitation
public final class Tweet extends DataObject implements HasFunctionalAccountId, HasTweetId
{
    private final Long externalId;
    private final Long inReplyTo;
    private final Long creatorId;
    private final String creatorName; // Redundant information, but useful
    private final DateTime cratedDate;
    private final String text;

    private Tweet( Long externalId,
                   Long inReplyTo,
                   Long creatorId,
                   String creatorName,
                   DateTime cratedDate,
                   String text ) {
        this.creatorId = creatorId;
        this.cratedDate = cratedDate;
        this.externalId = externalId;
        this.inReplyTo = inReplyTo;
        this.text = text;
        this.creatorName = creatorName;
    }

    @Override
    public UniqueKey getUniqueKey( ) {
        return TweetKey.create(getTweetId());
    }

    @Override
    public FunctionalAccountId getAccountId( ) {
        return FunctionalAccountId.create(creatorId);
    }

    @Override
    public TweetId getTweetId( ) {
        return TweetId.create(externalId);
    }

    public DateTime getCratedDate( ) {
        return cratedDate;
    }

    public TweetId getInReplyTo( ) {
        return TweetId.create(inReplyTo);
    }

    public String getText( ) {
        return text;
    }

    public static Tweet create( Long externalId,
                                Long creatorId,
                                String creatorName,
                                Long inReplyTo,
                                DateTime cratedDate,
                                String text ) {
        return new Tweet(externalId, inReplyTo, creatorId, creatorName, cratedDate, text);
    }

    public String getCreatorName( ) {
        return creatorName;
    }
}
