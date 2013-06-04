package com.pk.cwierkacz.processor.handlers.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pk.cwierkacz.http.response.dto.Message;

public class FetchResult
{
    private final List<Message> messages;
    private StringBuilder errorBuilder;

    public FetchResult() {
        this.messages = new ArrayList<Message>();
        this.errorBuilder = new StringBuilder();
    }

    public FetchResult( StringBuilder errorBuilder ) {
        this.messages = new ArrayList<Message>();
        this.errorBuilder = errorBuilder;
    }

    public FetchResult( List<Message> messages, StringBuilder errorBuilder ) {
        this.messages = messages;
        this.errorBuilder = errorBuilder;
    }

    public List<Message> getMessages( ) {
        return messages;
    }

    public List<Message> getMessages( Integer size ) {
        List<Message> limited = new ArrayList<Message>();

        int resultantSize = messages.size();
        if ( size != null && size != 0 && size < messages.size() )
            resultantSize = size;

        for ( int i = 0; i < resultantSize; i++ ) {
            limited.add(messages.get(i));
        }
        return limited;
    }

    public StringBuilder getErrorBuilder( ) {
        return errorBuilder;
    }

    public void add( FetchResult result ) {
        add(result.getMessages(), result.getErrorBuilder());
    }

    public void add( List<Message> newMessages, StringBuilder newErrorBuilder ) {
        messages.addAll(newMessages);
        errorBuilder = errorBuilder.append(newErrorBuilder);
    }

    public void appendBuilder( StringBuilder newErrorBuilder ) {
        errorBuilder = errorBuilder.append(newErrorBuilder);
    }

    public void sort( ) {
        Collections.sort(messages);
    }

}
