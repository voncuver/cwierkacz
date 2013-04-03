package com.tguzik.cwierkacz.common.data.value;

import static org.apache.commons.lang3.math.NumberUtils.toLong;

public class FunctionalAccountId extends Value<Long>
{
    public static final FunctionalAccountId EMPTY = new FunctionalAccountId(-1L);

    FunctionalAccountId( Long updateId ) {
        super(updateId);
    }

    public boolean isEmpty( ) {
        return this.equals(EMPTY) || toValue() == null;
    }

    public static FunctionalAccountId create( Long id ) {
        return new FunctionalAccountId(id);
    }

    public static FunctionalAccountId create( String str ) {
        return new FunctionalAccountId(toLong(str, -1L));
    }
}
