package com.pk.cwierkacz.model.transformer;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.pk.cwierkacz.exception.ProcessingException;

public class JsonTransformer
{
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static < T > String responseToJson( T response ) throws ProcessingException {

        try {
            objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion.NON_NULL);
            return objectMapper.writeValueAsString(response);
        }
        catch ( IOException e ) {
            throw new ProcessingException("Exception while processing response: " + e.getMessage(), e);
        }
    }

}
