package com.tguzik.cwierkacz.configuration;

import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableList;
import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableMap;

import java.util.List;
import java.util.Map;

import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class SingleJobConfiguration extends StandardElement
{
    private String name;
    private List<String> lifecycleStageNames;
    private Map<String, String> properties;

    private SingleJobConfiguration() {
    }

    public String getName( ) {
        return name;
    }

    public List<String> getLifecycleStageNames( ) {
        return copyToImmutableList(lifecycleStageNames);
    }

    public Map<String, String> getProperties( ) {
        return copyToImmutableMap(properties);
    }
}
