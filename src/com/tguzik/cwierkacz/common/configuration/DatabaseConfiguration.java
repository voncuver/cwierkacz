package com.tguzik.cwierkacz.common.configuration;

import java.util.Arrays;

import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class DatabaseConfiguration extends StandardElement
{
    private final String url = null;
    private final String username = null;
    private final String serviceName = null;
    private final char[] password = null; // TODO: Move this data to more secure location
    private final Class<?> defaultDataLoader = null;

    private DatabaseConfiguration() {
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

    public Class<?> getDefaultDataLoader( ) {
        return defaultDataLoader;
    }
}
