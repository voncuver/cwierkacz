package com.tguzik.cwierkacz.configuration;

import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class XmlServerConfiguration extends StandardElement
{
    private short portNumber;
    private boolean xmlValidation;
    private String schemaLocation;

    public short getPortNumber( ) {
        return portNumber;
    }

    public boolean isXmlValidation( ) {
        return xmlValidation;
    }

    public String getSchemaLocation( ) {
        return schemaLocation;
    }
}
