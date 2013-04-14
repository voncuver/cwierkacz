package com.tguzik.cwierkacz.common.data.value;

import static org.apache.commons.lang3.math.NumberUtils.toLong;

public class TweetId extends Value<Long>
{
    public static final TweetId EMPTY = new TweetId(-1L);

    TweetId( Long updateId ) {
        super(updateId);
    }

    public boolean isEmpty( ) {
        return this.equals(EMPTY) || toValue() == null;
    }

    public static TweetId create( Long id ) {
        return new TweetId(id);
    }

    public static TweetId create( String str ) {
        return new TweetId(toLong(str, -1L));
    }
}
