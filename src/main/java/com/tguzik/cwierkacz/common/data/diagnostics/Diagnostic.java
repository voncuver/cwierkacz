package com.tguzik.cwierkacz.common.data.diagnostics;

import com.google.common.collect.ImmutableMap;

public enum Diagnostic {
    AVAILABLE_DIAGNOSTICS( 0, "Available diagnostics" ),

    REQUEST_DATA_DIAGNOSTIC( 1, "Request data diagnostic" ),

    PRINT_CUSTOMER_CACHE_DATA( 200, "Print customer cache data" ),
    PRINT_USER_CACHE_DATA( 201, "Print user cache data" );

    private static final ImmutableMap<Integer, Diagnostic> diagnosticsByNumber = createDiagnosticsMap();
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

    public static Diagnostic from( String diagnosticNumber ) {
        Integer number = Integer.valueOf(diagnosticNumber);
        return diagnosticsByNumber.get(number);
    }

    public static Diagnostic from( Integer diagnosticNumber ) {
        return diagnosticsByNumber.get(diagnosticNumber);
    }

    private static ImmutableMap<Integer, Diagnostic> createDiagnosticsMap( ) {
        ImmutableMap.Builder<Integer, Diagnostic> builder = ImmutableMap.builder();

        for ( Diagnostic diag : Diagnostic.values() ) {
            builder.put(diag.getNumber(), diag);
        }

        return builder.build();
    }
}
