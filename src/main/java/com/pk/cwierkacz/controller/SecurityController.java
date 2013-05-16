package com.pk.cwierkacz.controller;

import java.util.Map;

import javax.servlet.http.Cookie;

import com.pk.cwierkacz.http.RequestBuilder;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.Result;
import com.pk.cwierkacz.processor.MainProcessor;

// General security problems like existing session, existing user
public class SecurityController
{
    private final MainProcessor mainProcessor;

    public SecurityController() {
        mainProcessor = MainProcessor.getInstance();
    }

    public Response handle( Map<String, String[]> parameters, Cookie[] cookies, byte body[] ) {
        Result result = checkParams();
        if ( !result.isValid() ) {
            Long tokenId = 0l;
            if ( parameters.get(RequestBuilder.TOKEN) != null &&
                 parameters.get(RequestBuilder.TOKEN).length > 0 ) {
                tokenId = Long.parseLong(parameters.get(RequestBuilder.TOKEN)[ 0 ]);
            }

            return ResponseImpl.create(Status.DENY, result.getMessage(), tokenId);
        }
        else {
            return passCorrect(parameters, cookies, body);
        }
    }

    private Result checkParams( ) {
        // TODO Security check
        return new Result("OK", true);
    }

    public Response passCorrect( Map<String, String[]> parameters, Cookie[] cookies, byte body[] ) {
        Request requestAction = RequestBuilder.buildRequest(parameters, cookies, body);
        return mainProcessor.process(requestAction);
    }
}
