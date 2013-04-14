package com.pk.cwierkacz.model.http;

import java.sql.Timestamp;

public class Request
{

    private final Action action;

    private final Timestamp timestamp;

    private final String functionalUserName;

    public Request( Action action, Timestamp timestamp, String functionalUserName ) {
        this.action = action;
        this.timestamp = timestamp;
        this.functionalUserName = functionalUserName;
    }

    public Action getAction( ) {
        return action;
    }

    public Timestamp getTimestamp( ) {
        return timestamp;
    }

    public String getFunctionalUserName( ) {
        return functionalUserName;
    }
}
