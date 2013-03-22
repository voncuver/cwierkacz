package com.tguzik.cwierkacz.common.data.diagnostics;

public class DiagnosticFormatter
{
    private static final String DASHED_LINE = "-------------";
    private static final String NEWLINE = "\n";

    public static String getDiagnosticHeader( Diagnostic diagnostic ) {
        return String.format("%s Diagnostic %d - %20s %s",
                             DASHED_LINE,
                             diagnostic.getNumber(),
                             diagnostic.getDescription(),
                             DASHED_LINE);
    }

    public static String getDiagnosticFooter( ) {
        return DASHED_LINE + " END DIAGNOSTIC " + DASHED_LINE;
    }

    public static String getDiagnosticsLegend( ) {
        StringBuilder builder = new StringBuilder();
        builder.append(DASHED_LINE).append(" All available diagnostics ").append(DASHED_LINE).append(NEWLINE);

        for ( Diagnostic diagnostic : Diagnostic.values() ) {
            builder.append(diagnostic.getNumber())
                   .append(" - ")
                   .append(diagnostic.getDescription())
                   .append(NEWLINE);
        }

        builder.append(DASHED_LINE).append(DASHED_LINE).append(DASHED_LINE).append(NEWLINE);
        return builder.toString();
    }
}
