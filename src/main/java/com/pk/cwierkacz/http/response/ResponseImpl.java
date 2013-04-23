package com.pk.cwierkacz.http.response;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.model.dao.TweetDao;

@JsonSerialize( include = JsonSerialize.Inclusion.NON_NULL )
public class ResponseImpl implements Response, LoginResponse, FetchTweetsResponse
{

    private Status status;

    private String message; //TODO moze lepsza by była lista stringow?

    private long tokenId;

    private Set<String> accounts;

    private List<TweetDao> tweets;

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
    public < T extends Response > T buildLoginResponse( Set<String> accounts ) {
        this.accounts = accounts;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Response > T buildFetchResponse( List<TweetDao> tweets, Map<Long, String> users ) {
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
    public Set<String> getAccounts( ) {
        return accounts;
    }

    @Override
    public List<TweetDao> getTweets( ) {
        return tweets;
    }

    @Override
    public Map<Long, String> getUsersTweeter( ) {
        return usersTweeter;
    }
}
