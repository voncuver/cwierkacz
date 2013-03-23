package com.tguzik.cwierkacz.common.data.value;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class TwitterAccountName extends Value<String>
{
    public static final TwitterAccountName EMPTY = new TwitterAccountName("");

    TwitterAccountName( String value ) {
        super(value);
    }

    public boolean isEmpty( ) {
        return this.equals(EMPTY);
    }

    public static TwitterAccountName create( String name ) {
        return isBlank(name) ? EMPTY : new TwitterAccountName(name);
    }
}
