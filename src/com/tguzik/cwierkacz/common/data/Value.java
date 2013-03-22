package com.tguzik.cwierkacz.common.data;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.google.common.base.Objects;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
abstract class Value< T >
{
    private final T value;

    protected Value( T v ) {
        this.value = v;
    }

    public T toValue( ) {
        return value;
    }

    @Override
    public int hashCode( ) {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj instanceof Value ) {
            Value<?> other = (Value<?>) obj;
            return Objects.equal(value, other.value);
        }

        return false;
    }

    @Override
    public String toString( ) {
        return ReflectionToStringBuilder.toString(value);
    }
}
