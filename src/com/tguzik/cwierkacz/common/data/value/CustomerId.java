package com.tguzik.cwierkacz.common.data.value;

import static org.apache.commons.lang3.math.NumberUtils.toLong;

public class CustomerId extends Value<Long>
{
    public static final CustomerId EMPTY = new CustomerId(-1L);

    CustomerId( Long updateId ) {
        super(updateId);
    }

    public boolean isEmpty( ) {
        return this.equals(EMPTY) || toValue() == null;
    }

    public static CustomerId create( Long id ) {
        return new CustomerId(id);
    }

    public static CustomerId create( String str ) {
        return new CustomerId(toLong(str, -1L));
    }
}
