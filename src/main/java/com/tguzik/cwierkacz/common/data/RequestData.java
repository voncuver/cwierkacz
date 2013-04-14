package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.common.data.diagnostics.Diagnostic;
import com.tguzik.cwierkacz.common.data.traits.HasCustomerId;
import com.tguzik.cwierkacz.common.data.value.CustomerId;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class RequestData extends StandardElement implements HasCustomerId
{
    private final Long customerId;
    private final ImmutableList<RequestedJob> requestedJobs;
    private final ImmutableSet<Diagnostic> requestedDiagnostics;

    RequestData( Long customerId,
                 ImmutableList<RequestedJob> requestedJobs,
                 ImmutableSet<Diagnostic> requestedDiagnostics ) {
        super();
        this.requestedDiagnostics = requestedDiagnostics;
        this.requestedJobs = requestedJobs;
        this.customerId = customerId;
    }

    @Override
    public CustomerId getCustomerId( ) {
        return CustomerId.create(customerId);
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
