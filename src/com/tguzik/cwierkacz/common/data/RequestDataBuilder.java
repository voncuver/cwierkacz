package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.tguzik.cwierkacz.common.data.diagnostics.Diagnostic;
import com.tguzik.cwierkacz.common.data.value.CustomerName;

public final class RequestDataBuilder
{
    private CustomerName customerName;
    private final ImmutableList.Builder<RequestedJob> requestedJobsBuilder;
    private final ImmutableSet.Builder<Diagnostic> requestedDiagnosticsBuilder;

    public RequestDataBuilder() {
        this.customerName = CustomerName.EMPTY;
        this.requestedJobsBuilder = ImmutableList.builder();
        this.requestedDiagnosticsBuilder = ImmutableSet.builder();
    }

    public RequestDataBuilder withCustomerName( CustomerName customerName ) {
        this.customerName = customerName;
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
        return new RequestData(customerName,
                               requestedJobsBuilder.build(),
                               requestedDiagnosticsBuilder.build());
    }
}
