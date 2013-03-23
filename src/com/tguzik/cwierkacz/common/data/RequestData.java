package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.tguzik.cwierkacz.cache.dataobject.User;
import com.tguzik.cwierkacz.common.Job;
import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.common.data.diagnostics.Diagnostic;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class RequestData extends StandardElement
{
    private final Owner owner;
    private final Job requestedOperation;
    private final ImmutableMultimap<User, UserMessage> userMessages;
    private final ImmutableSet<Diagnostic> requestedDiagnostics;

    RequestData( Owner owner,
                 Job requestedOperation,
                 ImmutableMultimap<User, UserMessage> userMessages,
                 ImmutableSet<Diagnostic> requestedDiagnostics ) {
        super();
        this.requestedDiagnostics = requestedDiagnostics;
        this.requestedOperation = requestedOperation;
        this.userMessages = ImmutableMultimap.copyOf(userMessages);
        this.owner = owner;
    }

    public Owner getOwner( ) {
        return owner;
    }

    public Job getRequestedOperation( ) {
        return requestedOperation;
    }

    public ImmutableMultimap<User, UserMessage> getUserMessages( ) {
        return userMessages;
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

    public ImmutableList<RequestedJob> getRequestedJobs( ) {
        // TODO Auto-generated method stub
        return null;
    }

}
