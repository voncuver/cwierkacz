package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.common.data.diagnostics.Diagnostic;
import com.tguzik.cwierkacz.common.data.value.CustomerName;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class RequestData extends StandardElement
{
    private final CustomerName owner;
    private final ImmutableList<RequestedJob> requestedJobs;
    private final ImmutableSet<Diagnostic> requestedDiagnostics;

    RequestData( CustomerName owner,
                 ImmutableList<RequestedJob> requestedJobs,
                 ImmutableSet<Diagnostic> requestedDiagnostics ) {
        super();
        this.requestedDiagnostics = requestedDiagnostics;
        this.requestedJobs = requestedJobs;
        this.owner = owner;
    }

    public CustomerName getCustomerName( ) {
        return owner;
    }

    public ImmutableList<RequestedJob> getRequestedJobs( ) {
        return requestedJobs;
    }

    public ImmutableSet<Diagnostic> getRequestedDiagnostics( ) {
        return requestedDiagnostics;
    }

    public boolean hasDiagnostic( Diagnostic diagnostic ) {
        return requestedDiagnostics.contains(diagnostic);
    }

    public static RequestDataBuilder builder( ) {
        return new RequestDataBuilder();
    }
}
