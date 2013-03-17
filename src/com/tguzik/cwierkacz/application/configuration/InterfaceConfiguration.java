package com.tguzik.cwierkacz.application.configuration;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.CollectionUtil;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class InterfaceConfiguration extends StandardElement
{
    private List<SingleInterfaceConfiguration> interfaces;

    private InterfaceConfiguration() {
    }

    public ImmutableList<SingleInterfaceConfiguration> getInterfaces( ) {
        return CollectionUtil.copyToImmutableList(interfaces);
    }
}
