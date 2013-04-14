package com.tguzik.cwierkacz.utils.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class OmittingXStream extends XStream
{
    @Override
    protected MapperWrapper wrapMapper( MapperWrapper next ) {
        return new MapperWrapper(next) {
            @Override
            @SuppressWarnings( "rawtypes" )
            public boolean shouldSerializeMember( Class definedIn, String fieldName ) {
                if ( definedIn == Object.class ) {
                    return false;
                }
                return super.shouldSerializeMember(definedIn, fieldName);
            }
        };
    }
}
