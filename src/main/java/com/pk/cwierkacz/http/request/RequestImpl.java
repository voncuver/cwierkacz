package com.pk.cwierkacz.http.request;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.pk.cwierkacz.http.Action;

// login,logout,createAccount - by Action
public class RequestImpl implements
                        Request,
                        LoginRequest,
                        AddTweeAccRequest,
                        PublishRequest,
                        FetchTweetsRequest
{
    //Basic
    private Action action;
    private Timestamp timestamp;
    private String functionalUserName;
    private long tokenId;

    //Wire TweetAccount
    private String accountTweet;
    private String passTweet;

    //FetchTweetsRequest, LoginResponse, PublishRequest
    private List<String> accounts;

    //FetchTweets
    private int size;
    private DateTime dateFrom;

    //Login
    private String password;

    //PublishTweet
    private long replayForId;
    private String tweetText;

    public static RequestImpl create( ) {
        RequestImpl requestImpl = new RequestImpl();
        requestImpl.timestamp = new Timestamp(new Date().getTime());

        return new RequestImpl();
    }

    public static RequestImpl create( Request request ) {
        RequestImpl requestImpl = new RequestImpl();
        requestImpl.action = request.getAction();
        requestImpl.functionalUserName = request.getFunctionalUserName();
        requestImpl.timestamp = request.getTimestamp();
        requestImpl.tokenId = request.getTokenId();
        return null;
    }

    public static RequestImpl create( PublishRequest request ) {
        RequestImpl requestImpl = create((Request) request);
        requestImpl.accounts = request.getAccounts();
        requestImpl.tweetText = request.getTweetText();
        return null;
    }

    public static RequestImpl create( FetchTweetsRequest request ) {
        RequestImpl requestImpl = create((Request) request);
        requestImpl.accounts = request.getAccounts();
        requestImpl.size = request.getSize();
        requestImpl.dateFrom = request.getDateFrom();
        requestImpl.replayForId = request.getReplayForId();
        return null;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildEmptyRequest( ) {
        this.action = Action.NOTRECOGNIZED;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildBaseRequest( Action action, String functionalUserName ) {
        this.action = action;
        this.functionalUserName = functionalUserName;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T withTokenId( Long tokenId ) {
        this.tokenId = tokenId;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildLoginRequest( String password ) {
        this.password = password;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildAddAccountTweetRequest( String login, String password ) {
        this.accountTweet = login;
        this.passTweet = password;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildPublishRequest( String tweetText, List<String> accounts ) {
        this.tweetText = tweetText;
        this.accounts = accounts;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T withReplayForID( Long replayForID ) {
        this.replayForId = replayForID;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildFetchRequest( List<String> accounts ) {
        this.accounts = accounts;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T withSize( int size ) {
        this.size = size;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T withDateFrom( DateTime dateTime ) {
        this.dateFrom = dateTime;
        return (T) this;
    }

    @Override
    public Action getAction( ) {
        return action;
    }

    @Override
    public Timestamp getTimestamp( ) {
        return timestamp;
    }

    @Override
    public String getFunctionalUserName( ) {
        return functionalUserName;
    }

    @Override
    public long getTokenId( ) {
        return tokenId;
    }

    @Override
    public String getAccountTweet( ) {
        return accountTweet;
    }

    @Override
    public String getPassTweet( ) {
        return passTweet;
    }

    @Override
    public List<String> getAccounts( ) {
        return accounts;
    }

    @Override
    public int getSize( ) {
        return size;
    }

    @Override
    public String getPassword( ) {
        return password;
    }

    @Override
    public long getReplayForId( ) {
        return replayForId;
    }

    @Override
    public DateTime getDateFrom( ) {
        return dateFrom;
    }

    @Override
    public String getTweetText( ) {
        return tweetText;
    }
}
