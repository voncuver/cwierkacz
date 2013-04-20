package com.pk.cwierkacz.processor.handlers;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;

public class WireTweetAccount implements Handler
{

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.ADDTWEETACCOUNT);
    }

    @Override
    public void handle( ApplicationData appData ) {
        Response response = ResponseImpl.create(Status.ERROR, "Not implemented Action", appData.getRequest()
                                                                                               .getTokenId());
        appData.setResponse(response);

    }

}
