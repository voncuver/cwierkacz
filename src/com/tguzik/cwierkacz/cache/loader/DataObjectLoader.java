package com.tguzik.cwierkacz.cache.loader;

import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.cache.dataobject.key.UniqueKey;

public interface DataObjectLoader< T extends DataObject >
{
    T loadDataObject( UniqueKey<T> key );

    //   Iterable<T> loadDataObjects( GeneralKey<T> key );
}
