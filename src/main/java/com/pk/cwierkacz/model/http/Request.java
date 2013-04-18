package com.pk.cwierkacz.model.http;

import java.sql.Timestamp;

import org.joda.time.DateTime;

public class Request
{

    private final Action action;

    private final Timestamp timestamp;

    private final String functionalUserName;

    private final long tokenId;

    private final DateTime dateTime;

    public Request( Action action, Timestamp timestamp, String functionalUserName, long tokenId ) {
        this.action = action;
        this.timestamp = timestamp;
        this.functionalUserName = functionalUserName;
        this.tokenId = tokenId;
        this.dateTime = new DateTime();
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

    public long getTokenId( ) {
        return tokenId;
    }

    public DateTime getDateTime( ) {
        return dateTime;
    }

}
