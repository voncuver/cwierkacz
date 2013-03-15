package com.tguzik.cwierkacz.application.configuration;

import java.util.Arrays;

import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class DatabaseConfiguration extends StandardElement
{
    private String url;
    private String username;
    private String serviceName;
    private char[] password; // TODO: Move this data to more secure location

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
}
