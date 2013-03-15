package com.tguzik.cwierkacz.application.configuration;

import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableList;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public class CacheConfiguration extends StandardElement
{
    private List<TableCacheConfiguration> cacheConfig;

    private CacheConfiguration() {
    }

    public ImmutableList<TableCacheConfiguration> getCacheConfig( ) {
        return copyToImmutableList(cacheConfig);
    }
}
