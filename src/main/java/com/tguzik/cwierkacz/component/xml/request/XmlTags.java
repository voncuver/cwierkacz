package com.tguzik.cwierkacz.component.xml.request;

import com.google.common.collect.ImmutableMap;

public enum XmlTags {
    REQUEST( "CwierkaczRequest" ),
    JOB( "Job" ),
    ACCOUNT( "Account" ),
    TWEET( "Tweet" ),
    DIAGNOSTIC( "Diagnostic" );

    private static final ImmutableMap<String, XmlTags> mappings = createMappings();
    private final String name;

    private XmlTags( String tagName ) {
        this.name = tagName;
    }

    public String getName( ) {
        return this.name;
    }

    public static XmlTags fromString( String localName, String qName ) {
        return mappings.containsKey(localName) ? mappings.get(localName) : mappings.get(qName);
    }

    private static ImmutableMap<String, XmlTags> createMappings( ) {
        ImmutableMap.Builder<String, XmlTags> builder = ImmutableMap.builder();

        for ( XmlTags tag : values() ) {
            builder.put(tag.getName(), tag);
        }

        return builder.build();
    }
}
