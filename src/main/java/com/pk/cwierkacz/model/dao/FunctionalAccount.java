package com.pk.cwierkacz.model.dao;

import org.apache.commons.lang3.StringUtils;

public final class FunctionalAccount
{
    private long id;
    private final Long accountId;
    private final Long customerId;
    private final String accountName;
    private final String accessToken;
    private final String accessTokenSecret;

    private FunctionalAccount( Long accountId,
                               Long customerId,
                               String name,
                               String accessToken,
                               String accessTokenSecret ) {
        this.accessTokenSecret = accessTokenSecret;
        this.accessToken = accessToken;
        this.customerId = customerId;
        this.accountId = accountId;
        this.accountName = name;
    }

    public long getUniqueKey( ) {
        return id;

    }

    public String getAccountName( ) {
        return accountName;
    }

    public Long getCustomerId( ) {
        return customerId;
    }

    public Long getAccountId( ) {
        return accountId;
    }

    public String getAccessToken( ) {
        return accessToken;
    }

    public String getAccessTokenSecret( ) {
        return accessTokenSecret;
    }

    public boolean isOAuthAvailable( ) {
        return !StringUtils.isEmpty(accessToken) && !StringUtils.isEmpty(accessTokenSecret);
    }

    public static FunctionalAccount create( long externalId,
                                            long customerId,
                                            String accountName,
                                            String accessToken,
                                            String accessTokenSecret ) {
        return new FunctionalAccount(externalId, customerId, accountName, accessToken, accessTokenSecret);
    }
}
