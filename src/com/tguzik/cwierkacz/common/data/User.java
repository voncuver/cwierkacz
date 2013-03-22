package com.tguzik.cwierkacz.common.data;

import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class User extends Value<String>
{
    public static User ALL = new User("*");

    User( String value ) {
        super(value);
    }
}
