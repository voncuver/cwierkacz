package com.tguzik.cwierkacz.configuration;

import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableMap;

import java.util.Map;

import javax.annotation.processing.Processor;

import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class SingleProcessorConfiguration extends StandardElement
{
    private String name;
    private Class<? extends Processor> clazz;
    private Map<String, String> properties;

    private SingleProcessorConfiguration() {
    }

    public String getName( ) {
        return name;
    }

    public Class<? extends Processor> getClazz( ) {
        return clazz;
    }

    public Map<String, String> getProperties( ) {
        return copyToImmutableMap(properties);
    }
}
