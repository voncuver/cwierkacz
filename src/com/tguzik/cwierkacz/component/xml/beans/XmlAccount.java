package com.tguzik.cwierkacz.component.xml.beans;

import org.apache.commons.lang3.StringUtils;

import com.tguzik.cwierkacz.common.StandardElement;

public class XmlAccount extends StandardElement
{
    private String name = StringUtils.EMPTY;
    private String message = StringUtils.EMPTY;

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getMessage( ) {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }
}
