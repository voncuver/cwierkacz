package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.common.data.value.UserMessage;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class RequestedAccount extends StandardElement
{
    private final String name;
    private final ImmutableList<UserMessage> messages;

    RequestedAccount( String name, ImmutableList<UserMessage> messages ) {
        this.name = name;
        this.messages = messages;
    }

    public String getName( ) {
        return name;
    }

    public ImmutableList<UserMessage> getMessages( ) {
        return messages;
    }

    public static RequestedAccountBuilder builder( ) {
        return new RequestedAccountBuilder();
    }
}
