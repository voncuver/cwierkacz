package com.tguzik.cwierkacz.cache.dataobject;

import com.tguzik.cwierkacz.cache.dataobject.key.OwnerKey;
import com.tguzik.cwierkacz.common.data.Owner;
import com.tguzik.cwierkacz.common.data.ValueByOwner;

public class Customer extends DataObject implements ValueByOwner
{

    @Override
    public OwnerKey getUniqueKey( ) {
        return null;
    }

    @Override
    public Owner getOwner( ) {
        // TODO Auto-generated method stub
        return null;
    }
}
