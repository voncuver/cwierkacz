package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.common.data.value.FunctionalAccountName;
import com.tguzik.cwierkacz.common.data.value.UserMessage;

public class RequestedAccountBuilder
{
    private final ImmutableList.Builder<UserMessage> messages;
    private FunctionalAccountName name;

    RequestedAccountBuilder() {
        this.messages = ImmutableList.builder();
        this.name = FunctionalAccountName.EMPTY;
    }

    public RequestedAccountBuilder withName( String name ) {
        this.name = FunctionalAccountName.create(name);
        return this;
    }

    public RequestedAccountBuilder withUserMessage( UserMessage userMessage ) {
        this.messages.add(userMessage);
        return this;
    }

    public RequestedAccount build( ) {
        return new RequestedAccount(name, messages.build());
    }
}
