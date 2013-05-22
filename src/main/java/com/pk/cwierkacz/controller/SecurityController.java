package com.pk.cwierkacz.controller;

import java.util.Map;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.RequestBuilder;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.Result;
import com.pk.cwierkacz.processor.MainProcessor;

// General security problems like existing session, existing user
public class SecurityController
{
    private final MainProcessor mainProcessor;

    public SecurityController() {
        mainProcessor = MainProcessor.getInstance();
    }

    public ApplicationData handle( Map<String, String[]> parameters, byte body[] ) {
        Result result = checkParams(parameters);
        if ( !result.isValid() ) {
            ApplicationData applicationData = new ApplicationData();
            applicationData.setResponse(ResponseImpl.create(Status.DENY, result.getMessage(), 0));
            return applicationData;
        }
        else {
            return passCorrect(parameters, body);
        }
    }

    private Result checkParams( Map<String, String[]> parameters ) {
        if ( isActionRequireToken(parameters.get(RequestBuilder.ACTIONPARAM)[ 0 ]) &&
             !isTokenValid(parameters.get(RequestBuilder.TOKEN)) ) {
            return new Result("Użytkownik nie jest zalogowany.", Status.DENY);
        }
        return new Result("OK", Status.OK);
    }

    private boolean isActionRequireToken( String actionName ) {
        Action action = Action.getActionByName(actionName);

        boolean result = false;
        result |= action.equals(Action.SIGNIN);
        result |= action.equals(Action.ADDACCOUNT);
        return !result;
    }

    private boolean isTokenValid( String[] tokenTab ) {
        if ( tokenTab == null )
            return false;
        if ( tokenTab[ 0 ] == null )
            return false;
        return Long.parseLong(tokenTab[ 0 ]) > 0;
    }

    public ApplicationData passCorrect( Map<String, String[]> parameters, byte body[] ) {
        Request requestAction = RequestBuilder.buildRequest(parameters, body);
        return mainProcessor.process(requestAction);
    }
}
