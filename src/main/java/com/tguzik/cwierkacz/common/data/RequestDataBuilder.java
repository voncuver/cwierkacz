package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.tguzik.cwierkacz.common.data.diagnostics.Diagnostic;

public final class RequestDataBuilder
{
    private Long customerId;
    private final ImmutableList.Builder<RequestedJob> requestedJobsBuilder;
    private final ImmutableSet.Builder<Diagnostic> requestedDiagnosticsBuilder;

    public RequestDataBuilder() {
        this.customerId = null;
        this.requestedJobsBuilder = ImmutableList.builder();
        this.requestedDiagnosticsBuilder = ImmutableSet.builder();
    }

    public RequestDataBuilder withCustomerId( Long customerId ) {
        this.customerId = customerId;
        return this;
    }

    public RequestDataBuilder withRequestedJob( RequestedJob requestedJob ) {
        this.requestedJobsBuilder.add(requestedJob);
        return this;
    }

    public RequestDataBuilder withDiagnostic( Diagnostic diagnostic ) {
        this.requestedDiagnosticsBuilder.add(diagnostic);
        return this;
    }

    public RequestData build( ) {
        return new RequestData(customerId, requestedJobsBuilder.build(), requestedDiagnosticsBuilder.build());
    }
}
