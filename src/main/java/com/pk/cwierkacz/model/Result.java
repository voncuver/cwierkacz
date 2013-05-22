package com.pk.cwierkacz.model;

import com.pk.cwierkacz.http.Status;

public class Result
{
    private final String message;
    private final Status status;

    public Result( String message, Status status ) {
        this.message = message;
        this.status = status;
    }

    public String getMessage( ) {
        return message;
    }

    public boolean isValid( ) {
        return status.equals(Status.OK);
    }

    public Status getStatus( ) {
        return status;
    }

}
