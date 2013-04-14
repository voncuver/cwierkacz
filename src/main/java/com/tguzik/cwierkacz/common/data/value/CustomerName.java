package com.tguzik.cwierkacz.common.data.value;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class CustomerName extends Value<String>
{
    public static final CustomerName EMPTY = new CustomerName("");

    CustomerName( String value ) {
        super(value);
    }

    public boolean isEmpty( ) {
        return this.equals(EMPTY);
    }

    public static CustomerName create( String name ) {
        return isBlank(name) ? EMPTY : new CustomerName(name);
    }
}
