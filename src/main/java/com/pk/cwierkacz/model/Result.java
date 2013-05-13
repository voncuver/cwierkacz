package com.pk.cwierkacz.model;

public class Result
{
    private final String message;
    private final boolean isValid;

    public Result( String message, boolean isValid ) {
        this.message = message;
        this.isValid = isValid;
    }

    public String getMessage( ) {
        return message;
    }

    public boolean isValid( ) {
        return isValid;
    }
}
