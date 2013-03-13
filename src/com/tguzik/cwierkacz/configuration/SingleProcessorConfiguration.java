package com.tguzik.cwierkacz.configuration;

import java.util.Map;

import javax.annotation.processing.Processor;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class SingleProcessorConfiguration extends StandardElement
{
    private String name;
    private Class<? extends Processor> clazz;
    private final Map<String, String> properties;

    private SingleProcessorConfiguration() {
        this.properties = Maps.newHashMap();
    }

    public String getName( ) {
        return name;
    }

    public Class<? extends Processor> getClazz( ) {
        return clazz;
    }

    public Map<String, String> getProperties( ) {
        return ImmutableMap.copyOf(properties);
    }
}
