package com.tguzik.cwierkacz.application.configuration;

import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableMap;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class SingleProcessorConfiguration extends StandardElement
{
    private String name;
    private Class<Processor> clazz;
    private Map<String, String> properties;

    private SingleProcessorConfiguration() {
    }

    public String getName( ) {
        return name;
    }

    public Class<Processor> getClazz( ) {
        return clazz;
    }

    public ImmutableMap<String, String> getProperties( ) {
        return copyToImmutableMap(properties);
    }
}
