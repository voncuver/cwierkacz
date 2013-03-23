package com.tguzik.cwierkacz.cache.dataobject.key;

import com.google.common.base.Objects;
import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.common.data.traits.HasCustomerName;

public class CustomerKey extends UniqueKey
{
    private final String customerName;

    private CustomerKey( String customerName ) {
        this.customerName = customerName;
    }

    @Override
    public boolean apply( DataObject obj ) {
        if ( obj instanceof HasCustomerName ) {
            HasCustomerName vbo = (HasCustomerName) obj;
            return Objects.equal(customerName, vbo.getCustomerName());
        }

        return false;
    }

    public String getCustomerName( ) {
        return customerName;
    }

    public static CustomerKey create( String customerName ) {
        return new CustomerKey(customerName);
    }
}
