package com.pk.cwierkacz.model;

import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.response.Response;

public class ApplicationData
{
    private Request request;

    private Response response;

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
}
