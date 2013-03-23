package com.tguzik.cwierkacz.cache.dataobject;

import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.common.data.traits.HasCustomerName;
import com.tguzik.cwierkacz.common.data.traits.HasTwitterAccountName;
import com.tguzik.cwierkacz.common.data.value.CustomerName;
import com.tguzik.cwierkacz.common.data.value.TwitterAccountName;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class TwitterAccount extends DataObject implements HasCustomerName, HasTwitterAccountName
{
    @Override
    public UniqueKey getUniqueKey( ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CustomerName getCustomerName( ) {
        // TODO Auto-generated method stub
        return CustomerName.create(null);
    }

    @Override
    public TwitterAccountName getTwitterAccountName( ) {
        // TODO Auto-generated method stub
        return TwitterAccountName.create(null);
    }
}
