package com.tguzik.cwierkacz.cache;

import com.google.common.base.Predicate;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;

public interface Key< T extends DataObject > extends Predicate<T>
{

}
