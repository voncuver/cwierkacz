package com.pk.cwierkacz.model.http;

public enum Status {
    NOTRECOGNIZED( "NotRecognized" ),

    OK( "ok" ),
    ERROR( "Error" ),
    DENY( "Deny" );

    private String status;

    Status( String status ) {
        this.status = status;
    }

    public String getStatusName( ) {
        return status;
    }
}
