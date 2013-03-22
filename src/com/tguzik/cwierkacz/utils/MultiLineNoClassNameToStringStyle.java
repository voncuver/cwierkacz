package com.tguzik.cwierkacz.utils;

import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MultiLineNoClassNameToStringStyle extends org.apache.commons.lang3.builder.ToStringStyle
{
    private static final ToStringStyle INSTANCE = new MultiLineNoClassNameToStringStyle();
    private static final long serialVersionUID = 1L;

    MultiLineNoClassNameToStringStyle() {
        super();
        this.setUseIdentityHashCode(false);
        this.setContentStart("[");
        this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
        this.setFieldSeparatorAtStart(true);
        this.setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
    }

    /**
     * <p>
     * Ensure <code>Singleton</code> after serialization.
     * </p>
     * 
     * @return the singleton
     */
    private Object readResolve( ) {
        return INSTANCE;
    }

    public static ToStringStyle getInstance( ) {
        return INSTANCE;
    }
}