package com.tguzik.cwierkacz.common.data;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;

public class RequestedJobBuilder
{
    private String name;
    private boolean cacheOnly;
    private final ImmutableList.Builder<RequestedAccount> twitterAccounts;

    public RequestedJobBuilder() {
        this.name = StringUtils.EMPTY;
        this.twitterAccounts = ImmutableList.builder();
    }

    public RequestedJobBuilder withName( String name ) {
        this.name = name;
        return this;
    }

    public RequestedJobBuilder withCacheOnly( boolean value ) {
        this.cacheOnly = value;
        return this;
    }

    public RequestedJobBuilder withTwitterAccount( RequestedAccount account ) {
        this.twitterAccounts.add(account);
        return this;
    }

    public RequestedJob build( ) {
        return new RequestedJob(name, cacheOnly, twitterAccounts.build());
    }
}
