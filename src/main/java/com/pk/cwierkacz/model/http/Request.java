package com.pk.cwierkacz.model.http;

import java.sql.Timestamp;

public class Request
{

    private final String action;

    private final Timestamp timestamp;

    private final String functionalUserName;

    public Request( String action, Timestamp timestamp, String functionalUserName ) {
        this.action = action;
        this.timestamp = timestamp;
        this.functionalUserName = functionalUserName;
    }

    public String getAction( ) {
        return action;
    }

    public Timestamp getTimestamp( ) {
        return timestamp;
    }

    public String getFunctionalUserName( ) {
        return functionalUserName;
    }
}
