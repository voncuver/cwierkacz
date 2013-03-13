package com.tguzik.cwierkacz.configuration;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class SingleJobConfiguration extends StandardElement
{
    private String name;
    private final List<String> lifecycleStageNames;
    private final Map<String, String> properties;

    private SingleJobConfiguration() {
        this.lifecycleStageNames = Lists.newArrayList();
        this.properties = Maps.newHashMap();
    }

    public String getName( ) {
        return name;
    }

    public List<String> getLifecycleStageNames( ) {
        return ImmutableList.copyOf(lifecycleStageNames);
    }

    public Map<String, String> getProperties( ) {
        return ImmutableMap.copyOf(properties);
    }
}
