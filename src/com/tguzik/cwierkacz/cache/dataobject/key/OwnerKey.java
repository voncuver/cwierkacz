package com.tguzik.cwierkacz.cache.dataobject.key;

import java.util.Map;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.dataobject.DataObject;
import com.tguzik.cwierkacz.common.data.HasOwner;

public class OwnerKey extends UniqueKey
{
    private static String FIELD_NAME = "ownerid";
    private final String value;

    private OwnerKey( String value ) {
        this.value = value;
    }

    @Override
    public Map<String, String> getValuesByField( ) {
        return ImmutableMap.of(FIELD_NAME, value);
    }

    @Override
    public Map<String, String> getOperatorsByField( ) {
        return ImmutableMap.of(FIELD_NAME, OPERATOR_EQUALS);
    }

    @Override
    public boolean apply( DataObject obj ) {
        if ( obj instanceof HasOwner ) {
            HasOwner vbo = (HasOwner) obj;
            return Objects.equal(value, vbo.getOwner());
        }

        return false;
    }

    public static OwnerKey create( String owner ) {
        return new OwnerKey(owner);
    }
}
