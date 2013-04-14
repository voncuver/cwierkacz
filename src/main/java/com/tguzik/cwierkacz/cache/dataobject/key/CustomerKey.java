package com.tguzik.cwierkacz.cache.dataobject.key;

import com.google.common.base.Objects;
import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.common.data.traits.HasCustomerId;
import com.tguzik.cwierkacz.common.data.value.CustomerId;

public class CustomerKey extends UniqueKey implements HasCustomerId
{
    private final CustomerId id;

    private CustomerKey( CustomerId id ) {
        this.id = id;
    }

    @Override
    public boolean apply( DataObject obj ) {
        if ( obj instanceof HasCustomerId ) {
            HasCustomerId vbo = (HasCustomerId) obj;
            return Objects.equal(getCustomerId(), vbo.getCustomerId());
        }

        return false;
    }

    @Override
    public CustomerId getCustomerId( ) {
        return id;
    }

    public static CustomerKey create( CustomerId customerId ) {
        return new CustomerKey(customerId);
    }
}
