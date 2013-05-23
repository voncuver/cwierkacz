package com.pk.cwierkacz.http.request;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;

// login,logout,createAccount - by Action
public class RequestImpl implements
                        Request,
                        LoginRequest,
                        AddTweeterAccountRequest,
                        PublishMessageRequest,
                        FetchMessagesRequest,
                        AccountManageRequest,
                        PublishReplyRequest,
                        PublishRetweetRequest,
                        GetMessagesRequest,
                        FetchRepliesRequest,
                        FetchRetweetsRequest
{
    //Basic
    private Action action;
    private Timestamp timestamp;
    private long tokenId;

    //SIGNIN, ADDACCOUNT
    private String userName;

    //ADDTWEETACCOUNT, DELTWEETACCOUNT
    private String loginTweet;

    //ADDTWEETACCOUNT
    private String passwordTweet;

    //FETCHTWEETS, PUBLISHTWEET
    private List<Account> accounts;

    private List<Long> ids;

    //FETCHTWEETS
    private int size;
    private DateTime dateFrom;
    private DateTime dateTo;

    //SIGNIN, DELACCOUNT
    private String password;
    private String newPassword;

    //FETCHTWEETS, PUBLISHTWEET
    private long replayFor;
    private long retweetFor;
    private byte[] body;

    private String imgName; //imgName and imgURL is alternative param - imgURL indicates url of image but imgName indicates name of image when in request body is image 
    private String imgURL;

    //PUBLISHTWEET
    private String tweetText;

    private AccountType accountType;

    public static RequestImpl create( Action action ) {
        RequestImpl requestImpl = new RequestImpl();
        requestImpl.timestamp = new Timestamp(new Date().getTime());
        requestImpl.action = action;

        return requestImpl;
    }

    public static RequestImpl create( Action action, long tokenId ) {
        RequestImpl r = create(action);
        r.tokenId = tokenId;
        return r;
    }

    public static RequestImpl create( Request request ) {
        RequestImpl impl = (RequestImpl) request;

        RequestImpl requestImpl = new RequestImpl();
        requestImpl.accounts = impl.getAccounts();
        requestImpl.action = impl.getAction();
        requestImpl.dateFrom = impl.getDateFrom();
        requestImpl.dateTo = impl.getDateTo();
        requestImpl.loginTweet = impl.getLoginTweet();
        requestImpl.newPassword = impl.getNewPassword();
        requestImpl.password = impl.getPassword();
        requestImpl.passwordTweet = impl.getPasswordTweet();
        requestImpl.replayFor = impl.getReplayFor();
        requestImpl.retweetFor = impl.getRetweetFor();
        requestImpl.size = impl.getSize();
        requestImpl.timestamp = impl.getTimestamp();
        requestImpl.tokenId = impl.getTokenId();
        requestImpl.tweetText = impl.getTweetText();
        requestImpl.userName = impl.getUserName();
        requestImpl.body = impl.getBody();
        requestImpl.ids = impl.getIds();
        requestImpl.imgURL = impl.getImgURL();
        requestImpl.imgName = impl.getImgName();
        requestImpl.accountType = impl.getAccountType();
        return requestImpl;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T buildEmptyRequest( ) {
        this.action = Action.NOTRECOGNIZED;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T buildBaseRequest( String userName ) {
        this.userName = userName;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withTokenId( Long tokenId ) {
        this.tokenId = tokenId;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withTimestamp( Timestamp timestamp ) {
        this.timestamp = timestamp;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T buildLoginRequest( String password ) {
        this.password = password;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withNewPassword( String newPassword ) {
        this.newPassword = newPassword;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T buildAddAccountTweetRequest( String loginTweet ) {
        this.loginTweet = loginTweet;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withLogin( String loginTweet ) {
        this.loginTweet = loginTweet;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T buildPublishRequest( String tweetText, List<Account> accounts ) {
        this.tweetText = tweetText;
        this.accounts = accounts;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withReplayForID( Long replayForID ) {
        this.replayFor = replayForID;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildRetweetRequest( List<Account> accounts, long retweetedId ) {
        this.accounts = accounts;
        this.retweetFor = retweetedId;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildReplyRequest( String tweetText, String loginTweet, long replyId ) {
        this.loginTweet = loginTweet;
        this.replayFor = replyId;
        this.tweetText = tweetText;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withRetweetForId( Long retweetForId ) {
        this.retweetFor = retweetForId;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withImg( byte[] body, String imgName ) {
        this.body = body;
        this.imgName = imgName;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withImg( String imgURL ) {
        this.imgURL = imgURL;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T buildFetchRequest( List<Account> accounts ) {
        this.accounts = accounts;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T buildFetchByIdRequest( List<Long> ids ) {
        this.ids = ids;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T buildFetchRequest( List<Account> accounts,
                                                      int size,
                                                      DateTime dateFrom,
                                                      long replayForId,
                                                      long retweetedId,
                                                      AccountType accountType ) {
        this.accounts = accounts;
        this.size = size;
        this.dateFrom = dateFrom;
        this.replayFor = replayForId;
        this.retweetFor = retweetedId;
        this.accountType = accountType;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Request > T withSize( int size ) {
        this.size = size;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withDateFrom( DateTime dateTime ) {
        this.dateFrom = dateTime;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withDateTo( DateTime dateTime ) {
        this.dateTo = dateTime;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withPasswordTweet( String passwordTweet ) {
        this.passwordTweet = passwordTweet;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends RequestImpl > T withAccountType( AccountType accountType ) {
        this.accountType = accountType;
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
    public long getTokenId( ) {
        return tokenId;
    }

    @Override
    public String getUserName( ) {
        return userName;
    }

    @Override
    public String getLoginTweet( ) {
        return loginTweet;
    }

    @Override
    public String getPasswordTweet( ) {
        return passwordTweet;
    }

    @Override
    public List<Account> getAccounts( ) {
        return accounts;
    }

    @Override
    public int getSize( ) {
        return size;
    }

    @Override
    public DateTime getDateFrom( ) {
        return dateFrom;
    }

    @Override
    public DateTime getDateTo( ) {
        return dateTo;
    }

    @Override
    public String getPassword( ) {
        return password;
    }

    @Override
    public String getNewPassword( ) {
        return newPassword;
    }

    @Override
    public long getReplayFor( ) {
        return replayFor;
    }

    @Override
    public String getTweetText( ) {
        return tweetText;
    }

    @Override
    public long getRetweetFor( ) {
        return retweetFor;
    }

    @Override
    public byte[] getBody( ) {
        return body;
    }

    @Override
    public String getImgName( ) {
        return imgName;
    }

    @Override
    public AccountType getAccountType( ) {
        return accountType;
    }

    @Override
    public List<Long> getIds( ) {
        return ids;
    }

    @Override
    public String getImgURL( ) {
        return imgURL;
    }

    public void setImgURL( String imgURL ) {
        this.imgURL = imgURL;
    }
}
