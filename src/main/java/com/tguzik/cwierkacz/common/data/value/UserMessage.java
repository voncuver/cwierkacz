package com.tguzik.cwierkacz.common.data.value;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class UserMessage extends Value<String>
{
    public static final UserMessage EMPTY = new UserMessage("");

    UserMessage( String value ) {
        super(value);
    }

    public boolean isEmpty( ) {
        return this.equals(EMPTY);
    }

    public static UserMessage create( String name ) {
        return isBlank(name) ? EMPTY : new UserMessage(name);
    }
}
