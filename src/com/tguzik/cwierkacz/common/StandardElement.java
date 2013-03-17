package com.tguzik.cwierkacz.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class StandardElement
{
    @Override
    public int hashCode( ) {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    @Override
    public boolean equals( Object obj ) {
        return EqualsBuilder.reflectionEquals(this, obj, false);
    }

    @Override
    public String toString( ) {
        return new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).toString();
    }
}
