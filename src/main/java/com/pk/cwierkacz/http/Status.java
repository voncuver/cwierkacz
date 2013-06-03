package com.pk.cwierkacz.http;

public enum Status {
    NOTRECOGNIZED( "NotRecognized" ),

    OK( "ok" ),
    ERROR( "Error" ),
    SIGNINERROR( "SigninError" ),
    DENY( "Deny" );

    private String status;

    Status( String status ) {
        this.status = status;
    }

    public String getStatusName( ) {
        return status;
    }
}
