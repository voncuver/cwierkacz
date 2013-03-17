package com.tguzik.cwierkacz.cache.dataobject.key;

import java.util.Map;

import com.google.common.base.Predicate;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;

public interface Key extends Predicate<DataObject>
{
    Map<String, String> getValuesByField( );

    Map<String, String> getOperatorsByField( );
}
