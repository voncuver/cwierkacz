package com.tguzik.cwierkacz.cache.dataobject.key;

import com.google.common.base.Objects;
import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.common.data.traits.HasCustomerId;

public class CustomerKey extends UniqueKey
{
    private final Integer customerId;

    private CustomerKey( Integer customerId ) {
        this.customerId = customerId;
    }

    @Override
    public boolean apply( DataObject obj ) {
        if ( obj instanceof HasCustomerId ) {
            HasCustomerId vbo = (HasCustomerId) obj;
            return Objects.equal(customerId, vbo.getCustomerId());
        }

        return false;
    }

    public Integer getCustomerId( ) {
        return customerId;
    }

    public static CustomerKey create( Integer customerId ) {
        return new CustomerKey(customerId);
    }
}
