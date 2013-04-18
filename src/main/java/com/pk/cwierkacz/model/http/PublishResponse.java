package com.pk.cwierkacz.model.http;

import java.util.List;

import com.pk.cwierkacz.model.dao.Tweet;

public class PublishResponse extends Response
{
    private final List<Tweet> responses;

    public PublishResponse( Status status, String message, long tokenId, List<Tweet> tweets ) {
        super(status, message, tokenId);
        this.responses = tweets;
    }

    public List<Tweet> getResponses( ) {
        return responses;
    }
}
