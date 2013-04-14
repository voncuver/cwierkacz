package com.tguzik.cwierkacz.common.data.value;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class FunctionalAccountName extends Value<String>
{
    public static final FunctionalAccountName EMPTY = new FunctionalAccountName("");

    FunctionalAccountName( String value ) {
        super(value);
    }

    public boolean isEmpty( ) {
        return this.equals(EMPTY);
    }

    public static FunctionalAccountName create( String name ) {
        return isBlank(name) ? EMPTY : new FunctionalAccountName(name);
    }
}
