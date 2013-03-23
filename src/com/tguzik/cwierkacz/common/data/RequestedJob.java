package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class RequestedJob extends StandardElement
{
    private final String name;
    private final boolean cacheOnly;
    private final ImmutableList<RequestedAccount> twitterAccounts;

    RequestedJob( String name, boolean cacheOnly, ImmutableList<RequestedAccount> twitterAccounts ) {
        super();
        this.twitterAccounts = twitterAccounts;
        this.cacheOnly = cacheOnly;
        this.name = name;
    }

    public String getName( ) {
        return name;
    }

    public boolean isCacheOnly( ) {
        return cacheOnly;
    }

    public ImmutableList<RequestedAccount> getTwitterAccounts( ) {
        return twitterAccounts;
    }

    public static RequestedJobBuilder builder( ) {
        return new RequestedJobBuilder();
    }
}
