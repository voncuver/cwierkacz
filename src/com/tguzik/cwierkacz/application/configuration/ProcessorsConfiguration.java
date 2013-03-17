package com.tguzik.cwierkacz.application.configuration;

import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableList;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class ProcessorsConfiguration extends StandardElement
{
    private List<SingleProcessorConfiguration> processors;

    private ProcessorsConfiguration() {
    }

    public ImmutableList<SingleProcessorConfiguration> getProcessors( ) {
        return copyToImmutableList(processors);
    }
}
