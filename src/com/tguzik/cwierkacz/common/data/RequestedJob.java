package com.tguzik.cwierkacz.common.data;

import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public class RequestedJob extends StandardElement
{
    private final String name;

    public RequestedJob( String name ) {
        super();
        this.name = name;
    }

    public String getName( ) {
        return name;
    }

    public static RequestedJobBuilder builder( ) {
        return new RequestedJobBuilder();
    }
}
