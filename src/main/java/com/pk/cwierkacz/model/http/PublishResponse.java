package com.pk.cwierkacz.model.http;

import java.util.List;

import com.pk.cwierkacz.model.dao.Tweet;

public class PublishResponse
{
    private Response response;

    List<Tweet> responses;

    public PublishResponse buildPublishResponse( Response response, List<Tweet> tweets ) {
        PublishResponse publishResponse = new PublishResponse();
        publishResponse.response = response;
        publishResponse.responses = tweets;
        return publishResponse;
    }

    public List<Tweet> getResponses( ) {
        return responses;
    }

    public String getStatus( ) {
        return response.getStatus();
    }

    public String getMessage( ) {
        return response.getMessage();
    }
}
