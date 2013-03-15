package com.tguzik.cwierkacz.application.configuration;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.utils.CollectionUtil;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class SingleInterfaceConfiguration extends StandardElement
{
    private Map<String, String> properties;
    private short portNumber;
    private boolean enabled;
    private String name;

    public short getPortNumber( ) {
        return portNumber;
    }

    public String getName( ) {
        return name;
    }

    public boolean isEnabled( ) {
        return enabled;
    }

    public ImmutableMap<String, String> getProperties( ) {
        return CollectionUtil.copyToImmutableMap(properties);
    }
}
