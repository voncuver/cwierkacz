package com.tguzik.cwierkacz.common.data;

import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class Owner extends Value<String>
{
    public static final Owner ALL = new Owner("*");
    public static final Owner EMPTY = new Owner("");

    Owner( String value ) {
        super(value);
    }
}
