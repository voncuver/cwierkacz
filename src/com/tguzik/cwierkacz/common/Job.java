package com.tguzik.cwierkacz.common;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class Job
{
    public static final Job NO_OPERATION = create("NO-OPERATION",
                                                  ProcessorChainElement.EMPTY,
                                                  ImmutableMap.<String, String> of());

    private final ImmutableMap<String, String> properties;
    private final ProcessorChainElement chain;
    private final String name;

    private Job( String name, ProcessorChainElement chain, ImmutableMap<String, String> properties ) {
        this.properties = properties;
        this.chain = chain;
        this.name = name;
    }

    public ImmutableMap<String, String> getProperties( ) {
        return properties;
    }

    public ProcessorChainElement getChain( ) {
        return chain;
    }

    public String getName( ) {
        return name;
    }

    public static Job create( String name,
                              ProcessorChainElement chain,
                              ImmutableMap<String, String> properties ) {
        return new Job(name, chain, properties);
    }
}
