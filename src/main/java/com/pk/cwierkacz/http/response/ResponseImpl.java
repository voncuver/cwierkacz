package com.pk.cwierkacz.http.response;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.model.Account;
import com.pk.cwierkacz.model.dao.TweetDao;

@JsonSerialize( include = JsonSerialize.Inclusion.NON_NULL )
public class ResponseImpl implements Response, LoginResponse, FetchTweetsResponse
{

    private Status status;

    private String message; //TODO moze lepsza by była lista stringow? (może być wiecej iformacji o błędzie)

    @JsonIgnore
    private long tokenId;

    private Set<Account> accounts;

    private List<TweetDao> tweets; //TODO może lepsza by była mapa przechowująca account name na liste tweetów? - ale jeśli tak to co miało by oznaczać wtedy size w requescie? - proponował bym wtedy zeby to był size per konto

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
    public < T extends Response > T buildLoginResponse( Set<Account> accounts ) {
        this.accounts = accounts;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Response > T buildFetchResponse( List<TweetDao> tweets, Map<Long, String> users ) {
        this.tweets = tweets; //TODO może lepiej przechowywać odpowiedz jak mape list?
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
    public Set<Account> getAccounts( ) {
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
