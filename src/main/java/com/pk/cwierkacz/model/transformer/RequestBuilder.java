package com.pk.cwierkacz.model.transformer;

import java.sql.Timestamp;
import java.util.Map;

import com.pk.cwierkacz.model.http.Action;
import com.pk.cwierkacz.model.http.Request;

public class RequestBuilder
{
    public static final String ACTIONPARAM = "Action";

    public static Request buildRequest( Map<String, String[]> params ) {

        String actionName = params.get(ACTIONPARAM)[ 0 ];

        Action action = Action.getActionByName(actionName);

        return new Request(Action.CREATEACCOUNT, new Timestamp(0), "null", 0l);
    }
}
