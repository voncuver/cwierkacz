package com.tguzik.cwierkacz.configuration;

import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableList;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class DatabaseConfiguration extends StandardElement
{
    private List<TableCacheConfiguration> cacheConfig;

    private String url;
    private String username;
    private String serviceName;
    private char[] password; // TODO: Move this data to more secure location

    private DatabaseConfiguration() {
    }

    public ImmutableList<TableCacheConfiguration> getCacheConfig( ) {
        return copyToImmutableList(cacheConfig);
    }

    public String getUrl( ) {
        return url;
    }

    public String getUsername( ) {
        return username;
    }

    public String getServiceName( ) {
        return serviceName;
    }

    @Deprecated
    public char[] getPassword( ) {
        return Arrays.copyOf(password, password.length);
    }
}
