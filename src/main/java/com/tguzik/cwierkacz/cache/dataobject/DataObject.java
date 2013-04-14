package com.tguzik.cwierkacz.cache.dataobject;

import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.common.StandardElement;

public abstract class DataObject extends StandardElement
{
    public abstract UniqueKey getUniqueKey( );

    public static String getRegionName( Class<? extends DataObject> region ) {
        return region.getSimpleName().toUpperCase();
    }
}
