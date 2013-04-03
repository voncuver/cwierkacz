package com.tguzik.cwierkacz.cache.dataobject;

import com.tguzik.cwierkacz.cache.dataobject.key.CustomerKey;
import com.tguzik.cwierkacz.common.data.traits.HasCustomerId;
import com.tguzik.cwierkacz.common.data.value.CustomerId;
import com.tguzik.cwierkacz.common.data.value.CustomerName;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class Customer extends DataObject implements HasCustomerId
{
    private Long customerId;
    private String customerName;

    @Override
    public CustomerKey getUniqueKey( ) {
        return CustomerKey.create(getCustomerId());
    }

    @Override
    public CustomerId getCustomerId( ) {
        return CustomerId.create(customerId);
    }

    public CustomerName getCustomerName( ) {
        return CustomerName.create(customerName);
    }
}
