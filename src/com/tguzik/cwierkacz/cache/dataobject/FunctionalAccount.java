package com.tguzik.cwierkacz.cache.dataobject;

import org.apache.commons.lang3.StringUtils;

import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.cache.dataobject.key.FunctionalAccountKey;
import com.tguzik.cwierkacz.common.data.traits.HasCustomerId;
import com.tguzik.cwierkacz.common.data.traits.HasFunctionalAccountId;
import com.tguzik.cwierkacz.common.data.traits.HasFunctionalAccountName;
import com.tguzik.cwierkacz.common.data.value.CustomerId;
import com.tguzik.cwierkacz.common.data.value.FunctionalAccountId;
import com.tguzik.cwierkacz.common.data.value.FunctionalAccountName;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class FunctionalAccount extends DataObject implements
                                                       HasCustomerId,
                                                       HasFunctionalAccountId,
                                                       HasFunctionalAccountName
{
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

    @Override
    public UniqueKey getUniqueKey( ) {
        return FunctionalAccountKey.create(getAccountId());
    }

    @Override
    public FunctionalAccountName getAccountName( ) {
        return FunctionalAccountName.create(accountName);
    }

    @Override
    public CustomerId getCustomerId( ) {
        return CustomerId.create(customerId);
    }

    @Override
    public FunctionalAccountId getAccountId( ) {
        return FunctionalAccountId.create(accountId);
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

    public static FunctionalAccount create( FunctionalAccountId externalId,
                                            CustomerId customerId,
                                            FunctionalAccountName accountName,
                                            String accessToken,
                                            String accessTokenSecret ) {
        return create(externalId.toValue(),
                      customerId.toValue(),
                      accountName.toString(),
                      accessToken,
                      accessTokenSecret);
    }
}
