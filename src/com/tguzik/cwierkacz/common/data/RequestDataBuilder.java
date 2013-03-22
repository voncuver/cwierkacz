package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.tguzik.cwierkacz.cache.dataobject.User;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.data.diagnostics.Diagnostic;

public final class RequestDataBuilder
{
    private Owner owner;
    private final Job requestedOperation;
    private final ImmutableMultimap.Builder<User, UserMessage> userMessagesBuilder;
    private final ImmutableSet.Builder<Diagnostic> requestedDiagnosticsBuilder;

    public RequestDataBuilder() {
        this.owner = Owner.EMPTY;
        this.requestedOperation = Job.NO_OPERATION;
        this.userMessagesBuilder = ImmutableMultimap.builder();
        this.requestedDiagnosticsBuilder = ImmutableSet.builder();
    }

    public RequestDataBuilder withOwner( Owner owner ) {
        this.owner = owner;
        return this;
    }

    public RequestDataBuilder withUserMessage( User user, UserMessage message ) {
        this.userMessagesBuilder.put(user, message);
        return this;
    }

    public RequestDataBuilder withDiagnostic( Diagnostic diagnostic ) {
        this.requestedDiagnosticsBuilder.add(diagnostic);
        return this;
    }

    public RequestData build( ) {
        return new RequestData(owner,
                               requestedOperation,
                               userMessagesBuilder.build(),
                               requestedDiagnosticsBuilder.build());
    }
}
