package com.tguzik.cwierkacz.cache.dataobject.key;

import com.google.common.base.Objects;
import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.common.data.traits.HasFunctionalAccountId;
import com.tguzik.cwierkacz.common.data.value.FunctionalAccountId;

public class FunctionalAccountKey extends UniqueKey implements HasFunctionalAccountId
{
    private final FunctionalAccountId accountId;

    private FunctionalAccountKey( FunctionalAccountId accountId ) {
        this.accountId = accountId;
    }

    @Override
    public boolean apply( DataObject obj ) {
        if ( obj instanceof HasFunctionalAccountId ) {
            HasFunctionalAccountId vbo = (HasFunctionalAccountId) obj;
            return Objects.equal(getAccountId(), vbo.getAccountId());
        }

        return false;
    }

    @Override
    public FunctionalAccountId getAccountId( ) {
        return accountId;
    }

    public static FunctionalAccountKey create( FunctionalAccountId accountId ) {
        return new FunctionalAccountKey(accountId);
    }
}
