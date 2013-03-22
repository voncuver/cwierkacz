package com.tguzik.cwierkacz.common.data;

import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class UserMessage extends StandardElement
{
    private final String message;

    public UserMessage( String message ) {
        super();
        this.message = message;
    }

    public String getMessage( ) {
        return message;
    }

}
