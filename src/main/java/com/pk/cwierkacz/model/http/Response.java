package com.pk.cwierkacz.model.http;

public class Response
{
    private final String status;

    private final String message;

    public Response( String status, String message ) {
        this.status = status;
        this.message = message;
    }

    public String getStatus( ) {
        return status;
    }

    public String getMessage( ) {
        return message;
    }
}
