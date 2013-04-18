package com.pk.cwierkacz.processor;

import java.util.List;

import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.http.Response;
import com.pk.cwierkacz.processor.handlers.Handler;

public class ChainProcessor
{

    private final List<Handler> handlers;

    public ChainProcessor( List<Handler> hanlders ) {
        this.handlers = hanlders;
    }

    public void handle( ApplicationData applicationData ) {
        for ( Handler handler : handlers ) {
            if ( handler.isHandleable(applicationData) ) {
                handle(applicationData);
                return;
            }
        }

        applicationData.setResponse(Response.createFailResponse("No Handler for action found.",
                                                                applicationData.getRequest().getTokenId()));
    }
}
