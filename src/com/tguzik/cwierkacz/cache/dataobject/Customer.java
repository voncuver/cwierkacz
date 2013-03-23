package com.tguzik.cwierkacz.cache.dataobject;

import com.tguzik.cwierkacz.cache.dataobject.key.CustomerKey;
import com.tguzik.cwierkacz.common.data.traits.HasCustomerName;
import com.tguzik.cwierkacz.common.data.value.CustomerName;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class Customer extends DataObject implements HasCustomerName
{
    private Integer customerId;
    private String customerName;

    @Override
    public CustomerKey getUniqueKey( ) {
        return CustomerKey.create(customerName);
    }

    public Integer getCustomerId( ) {
        return customerId;
    }

    @Override
    public CustomerName getCustomerName( ) {
        return CustomerName.create(customerName);
    }
}
