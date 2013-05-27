package com.pk.cwierkacz.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.model.dao.UserDao;

public class ApplicationData
{
    private Request request;

    private Response response;

    private UserDao currentUser;

    private final Map<String, List<String>> additionalParams;

    public ApplicationData() {
        additionalParams = new HashMap<String, List<String>>();
    }

    public List<String> getParam( String param ) {
        if ( additionalParams.containsKey(param) ) {
            return additionalParams.get(param);
        }
        else {
            return Collections.emptyList();
        }
    }

    public void setParam( String param, String value ) {
        if ( !additionalParams.containsKey(param) ) {
            additionalParams.put(param, new ArrayList<String>());
        }

        additionalParams.get(param).add(value);
    }

    public Request getRequest( ) {
        return request;
    }

    public Response getResponse( ) {
        return response;
    }

    public void setRequest( Request request ) {
        this.request = request;
    }

    public void setResponse( Response response ) {
        this.response = response;
    }

    public UserDao getCurrentUser( ) {
        return currentUser;
    }

    public void setCurrentUser( UserDao currentUser ) {
        this.currentUser = currentUser;
    }
}
