package com.pk.cwierkacz.model.http;

import java.sql.Timestamp;
import java.util.List;

public class PublishRequest
{
    private String retweetId;

    private String tweet;

    private List<String> accounts;

    private Request request;

    public PublishRequest buildPublishRequest( Request request, String tweet, List<String> accounts ) {
        PublishRequest publishRequest = new PublishRequest();
        publishRequest.request = request;
        publishRequest.tweet = tweet;
        publishRequest.accounts = accounts;
        return publishRequest;
    }

    public PublishRequest buildPublishRequest( Request request,
                                               String tweet,
                                               List<String> accounts,
                                               String retweetId ) {
        PublishRequest publishRequest = new PublishRequest();
        publishRequest.request = request;
        publishRequest.tweet = tweet;
        publishRequest.accounts = accounts;
        publishRequest.retweetId = retweetId;
        return publishRequest;
    }

    public String getRetweetId( ) {
        return retweetId;
    }

    public String getTweet( ) {
        return tweet;
    }

    public List<String> getAccounts( ) {
        return accounts;
    }

    public Action getAction( ) {
        return request.getAction();
    }

    public Timestamp getTimestamp( ) {
        return request.getTimestamp();
    }

    public String getFunctionalUserName( ) {
        return request.getFunctionalUserName();
    }
}
