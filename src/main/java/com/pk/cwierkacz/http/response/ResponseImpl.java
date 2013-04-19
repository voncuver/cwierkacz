package com.pk.cwierkacz.http.response;

import java.util.List;
import java.util.Map;

import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.model.dao.Tweet;

public class ResponseImpl implements Response, LoginResponse, FetchTweetsResponse
{

    private Status status;

    private String message;

    private long tokenId;

    private List<String> accounts;

    private List<Tweet> tweets;

    private Map<Long, String> usersTweeter;

    public static ResponseImpl create( ) {
        ResponseImpl responseImpl = new ResponseImpl();
        return responseImpl;
    }

    public static ResponseImpl create( Status status, String message, long tokenId ) {
        ResponseImpl responseImpl = new ResponseImpl();
        responseImpl.status = status;
        responseImpl.message = message;
        responseImpl.tokenId = tokenId;
        return responseImpl;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildLoginResponse( List<String> accounts ) {
        this.accounts = accounts;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildFetchResponse( List<Tweet> tweets, Map<Long, String> users ) {
        this.tweets = tweets;
        this.usersTweeter = users;
        return (T) this;
    }

    @Override
    public Status getStatus( ) {
        return status;
    }

    @Override
    public String getMessage( ) {
        return message;
    }

    @Override
    public long getTokenId( ) {
        return tokenId;
    }

    @Override
    public List<String> getAccounts( ) {
        return accounts;
    }

    @Override
    public List<Tweet> getTweets( ) {
        return tweets;
    }

    @Override
    public Map<Long, String> getUsersTweeter( ) {
        return usersTweeter;
    }
}
