package com.pk.cwierkacz.processor.handlers;

import org.apache.commons.lang3.exception.ExceptionUtils;

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
            Response response = ResponseImpl.create(result.getStatus(),
                                                    result.getMessage(),
                                                    appData.getRequest().getTokenId());
            appData.setResponse(response);
        }

    }

    public Result checkSecurity( ApplicationData appData ) {
        return new Result("OK", Status.OK);
    }

    public StringBuilder appendError( StringBuilder initBuilder, String domainMsg, Throwable t ) {
        StringBuilder errorsBuilder = initBuilder.append(domainMsg);
        errorsBuilder.append(System.getProperty("line.separator"));
        errorsBuilder.append(getErrorBuilder(t));
        return errorsBuilder;
    }

    public StringBuilder getErrorBuilder( Throwable t ) {
        StringBuilder errorsBuilder = new StringBuilder();
        errorsBuilder.append(t.getClass());
        errorsBuilder.append(System.getProperty("line.separator"));
        errorsBuilder.append(t.getMessage());
        errorsBuilder.append(System.getProperty("line.separator"));
        errorsBuilder.append(ExceptionUtils.getStackTrace(t));
        return errorsBuilder;
    }

    public String getError( Throwable t ) {
        return getErrorBuilder(t).toString();
    }

    public StringBuilder appendError( String domainMsg, Throwable t ) {
        return appendError(new StringBuilder(), domainMsg, t);
    }

    public abstract void handle( ApplicationData appData );
}
