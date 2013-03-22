package com.tguzik.cwierkacz.cache.dataobject;

import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class Tweets extends DataObject
{

    @Override
    public UniqueKey getUniqueKey( ) {
        // TODO Auto-generated method stub
        return null;
    }

}
