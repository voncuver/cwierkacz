package com.pk.cwierkacz.controller;

import java.util.Map;

import javax.servlet.http.Cookie;

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

    public ApplicationData handle( Map<String, String[]> parameters, Cookie[] cookies, byte body[] ) {
        Result result = checkParams();
        if ( !result.isValid() ) {
            Long tokenId = 0l;
            if ( parameters.get(RequestBuilder.TOKEN) != null &&
                 parameters.get(RequestBuilder.TOKEN).length > 0 ) {
                tokenId = Long.parseLong(parameters.get(RequestBuilder.TOKEN)[ 0 ]);
            }
            ApplicationData applicationData = new ApplicationData();
            applicationData.setResponse(ResponseImpl.create(Status.DENY, result.getMessage(), tokenId));
            return applicationData;
        }
        else {
            return passCorrect(parameters, cookies, body);
        }
    }

    private Result checkParams( ) {
        // TODO Security check
        return new Result("OK", true);
    }

    public ApplicationData passCorrect( Map<String, String[]> parameters, Cookie[] cookies, byte body[] ) {
        Request requestAction = RequestBuilder.buildRequest(parameters, cookies, body);
        return mainProcessor.process(requestAction);
    }
}
