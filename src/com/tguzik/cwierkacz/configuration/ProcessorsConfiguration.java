package com.tguzik.cwierkacz.configuration;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class ProcessorsConfiguration extends StandardElement
{
    private final List<SingleProcessorConfiguration> processors;

    private ProcessorsConfiguration() {
        this.processors = Lists.newArrayList();
    }

    public ImmutableList<SingleProcessorConfiguration> getProcessors( ) {
        return ImmutableList.copyOf(processors);
    }

    public SingleProcessorConfiguration getProcessor( String name ) {
        for ( SingleProcessorConfiguration processor : processors ) {
            if ( StringUtils.equalsIgnoreCase(name, processor.getName()) ) {
                return processor;
            }
        }
        return null;
    }
}
