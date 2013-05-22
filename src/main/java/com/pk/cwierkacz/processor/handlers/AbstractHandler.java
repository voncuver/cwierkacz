package com.pk.cwierkacz.processor.handlers;

import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.Result;

public abstract class AbstractHandler implements Handler
{
    @Override
    public void handleWithSecurity( ApplicationData appData ) {
        Result result = checkSecurity(appData);
        if ( result.isValid() ) {
            handle(appData);
        }
        else {
            Response response = ResponseImpl.create(Status.DENY, result.getMessage(), appData.getRequest()
                                                                                             .getTokenId());
            appData.setResponse(response);
        }

    }

    public Result checkSecurity( ApplicationData appData ) {
        return new Result("OK", Status.OK);
    }

    public abstract void handle( ApplicationData appData );
}
