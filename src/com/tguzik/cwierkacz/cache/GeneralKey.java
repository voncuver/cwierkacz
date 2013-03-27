package com.tguzik.cwierkacz.cache;

import com.tguzik.cwierkacz.cache.dataobject.DataObject;

public abstract class GeneralKey implements Key<DataObject>
{
    public static final GeneralKey ALWAYS_TRUE = new GeneralKey() {
        @Override
        public boolean apply( DataObject input ) {
            return true;
        }
    };
}
