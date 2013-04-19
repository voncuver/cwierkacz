package com.pk.cwierkacz.processor;

import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.model.ApplicationData;

public class MainProcessor
{
    private final ChainProcessor chainProcessor;

    private MainProcessor() {
        chainProcessor = null;
    }

    private static class InstanceHolder
    {
        public static MainProcessor mainProcessor = new MainProcessor();
    }

    public static MainProcessor getInstance( ) {
        return InstanceHolder.mainProcessor;
    }

    public Response process( Request request ) {
        ApplicationData applicationData = new ApplicationData();
        applicationData.setRequest(request);

        chainProcessor.handle(applicationData);

        return applicationData.getResponse();
    }
}
