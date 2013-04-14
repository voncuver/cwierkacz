package com.pk.cwierkacz.processor;

import com.pk.cwierkacz.model.http.Request;
import com.pk.cwierkacz.model.http.Response;

public class MainProcessor
{

    private static MainProcessor instance;

    private MainProcessor() {

    }

    public static MainProcessor getInstance( ) {
        if ( instance == null ) {
            synchronized ( MainProcessor.class ) {
                instance = new MainProcessor();
            }
        }
        return instance;
    }

    public Response process( Request request ) {
        return null;
    }
}
