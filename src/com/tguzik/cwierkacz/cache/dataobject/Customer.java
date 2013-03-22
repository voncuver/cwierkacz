package com.tguzik.cwierkacz.cache.dataobject;

import com.tguzik.cwierkacz.cache.dataobject.key.CustomerKey;
import com.tguzik.cwierkacz.common.data.traits.HasCustomerId;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class Customer extends DataObject implements HasCustomerId
{
    private Integer customerId;

    @Override
    public CustomerKey getUniqueKey( ) {
        return CustomerKey.create(customerId);
    }

    @Override
    public Integer getCustomerId( ) {
        return customerId;
    }
}
