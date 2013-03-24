package com.tguzik.cwierkacz.common.data;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.common.data.value.UserMessage;

public class RequestedAccountBuilder
{
    private final ImmutableList.Builder<UserMessage> messages;
    private String name;

    RequestedAccountBuilder() {
        this.messages = ImmutableList.builder();
        this.name = StringUtils.EMPTY;
    }

    public RequestedAccountBuilder withName( String name ) {
        this.name = name;
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
