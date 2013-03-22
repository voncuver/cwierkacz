package com.tguzik.cwierkacz.common.data.diagnostics;

public enum Diagnostic {
    AVAILABLE_DIAGNOSTICS( 0, "Available diagnostics" ),

    REQUEST_DATA_DIAGNOSTIC( 1, "Request data diagnostic" ),

    PRINT_CUSTOMER_CACHE_DATA( 200, "Print customer cache data" ),
    PRINT_USER_CACHE_DATA( 201, "Print user cache data" );

    private final Integer number;
    private final String description;

    private Diagnostic( int number, String description ) {
        this.number = number;
        this.description = description;
    }

    public Integer getNumber( ) {
        return number;
    }

    public String getDescription( ) {
        return description;
    }

    public static Diagnostic fromString( String diagnosticNumber ) {
        Integer number = Integer.valueOf(diagnosticNumber);

        for ( Diagnostic diagnostic : values() ) {
            if ( diagnostic.getNumber().equals(number) ) {
                return diagnostic;
            }
        }

        return null;
    }
}
