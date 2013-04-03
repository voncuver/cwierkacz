package com.tguzik.cwierkacz.cache.dataobject.key;

import com.google.common.base.Objects;
import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.common.data.traits.HasTweetId;
import com.tguzik.cwierkacz.common.data.value.TweetId;

public class TweetKey extends UniqueKey implements HasTweetId
{
    private final TweetId tweetId;

    private TweetKey( TweetId tweetId ) {
        this.tweetId = tweetId;
    }

    @Override
    public boolean apply( DataObject obj ) {
        if ( obj instanceof HasTweetId ) {
            HasTweetId vbo = (HasTweetId) obj;
            return Objects.equal(getTweetId(), vbo.getTweetId());
        }

        return false;
    }

    @Override
    public TweetId getTweetId( ) {
        return tweetId;
    }

    public static TweetKey create( TweetId tweetId ) {
        return new TweetKey(tweetId);
    }
}
