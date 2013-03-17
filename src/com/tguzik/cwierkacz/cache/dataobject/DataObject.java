package com.tguzik.cwierkacz.cache.dataobject;

import com.tguzik.cwierkacz.cache.dataobject.key.UniqueKey;
import com.tguzik.cwierkacz.common.StandardElement;

public abstract class DataObject extends StandardElement
{
    public abstract UniqueKey getUniqueKey( );

    public String getRegionName( ) {
        return getRegionName(getClass());
    }

    public static String getRegionName( Class<? extends DataObject> class1 ) {
        return class1.getSimpleName().toUpperCase();
    }
}
