package com.tguzik.cwierkacz.common.data;

import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class ResponseData extends StandardElement
{
    private final Integer returnCode;

    public ResponseData( Integer returnCode ) {
        super();
        this.returnCode = returnCode;
    }

    public Integer getReturnCode( ) {
        return returnCode;
    }

    public static ResponseDataBuilder builder( ) {
        return new ResponseDataBuilder();
    }
}
