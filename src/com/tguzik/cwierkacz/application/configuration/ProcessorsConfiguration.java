package com.tguzik.cwierkacz.application.configuration;

import static com.tguzik.cwierkacz.utils.CollectionUtil.copyToImmutableList;
import static com.tguzik.cwierkacz.utils.CollectionUtil.safe;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
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

    public SingleProcessorConfiguration getProcessor( String name ) {
        for ( SingleProcessorConfiguration processor : safe(processors) ) {
            if ( StringUtils.equalsIgnoreCase(name, processor.getName()) ) {
                return processor;
            }
        }

        return null;
    }
}
