package com.pk.cwierkacz.http;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.request.RequestImpl;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;

public class RequestBuilder
{
    public static final String ACTIONPARAM = "action";
    public static final String USERNAME = "username";
    public static final String TOKEN = "token";

    public static final String PASSWORD = "password";
    public static final String PASSWORDOLD = "passwordold";
    public static final String PASSWORDNEW = "passwordnew";

    public static final String ACCOUNTS = "accounts";
    public static final String ACCOUNTTYPEArr = "accounttype[]";
    public static final String ACCOUNTTYPE = "accounttype";

    public static final String ACCOUNTLOGINS = "accountlogins[]";
    public static final String ACCOUNTTYPES = "accounttypes[]";

    public static final String ACCOUNTLOGIN = "accountlogin";
    public static final String ACCOUNTPASSWORD = "accountpassword";

    public static final String TWEET = "tweet";
    public static final String REPLAYFORID = "replyforid";
    public static final String RETWEETFORID = "retweetforid";
    public static final String IMGNAME = "imgname";
    public static final String IMGURL = "imgurl";

    public static final String SIZE = "size";
    public static final String DATEFROM = "datefrom";
    public static final String DATETO = "dateto";

    public static final String IDS = "ids[]";

    public static < T > T buildRequest( Map<String, String[]> params ) {
        return buildRequest(params, null);
    }

    @SuppressWarnings( "unchecked" )
    public static < T > T buildRequest( Map<String, String[]> params, byte[] body ) {

        Request request = buildBasicRequest(params);

        Action action = request.getAction();

        byte[] bodyOrNull = null;
        if ( body != null && body.length > 0 )
            bodyOrNull = body;

        if ( action.equals(Action.SIGNIN) || action.equals(Action.SIGNOUT) ) {
            request = createLoginRequest(params, request);
        }
        else if ( action.equals(Action.ADDACCOUNT) ||
                  action.equals(Action.MODACCOUNT) ||
                  action.equals(Action.DELACCOUNT) ) {
            request = createManageRequest(params, request);
        }
        else if ( action.equals(Action.FETCHMESSAGES) ) {
            request = createFetchMsgsRequest(params, request);

        }
        else if ( action.equals(Action.GETMESSAGES) ) {
            request = createGetMsgsRequest(params, request);

        }
        else if ( action.equals(Action.FETCHREPLIES) ) {
            request = createFetchRepliesRequest(params, request);

        }
        else if ( action.equals(Action.FETCHRETWEETS) ) {
            request = createFetchRetweetsRequest(params, request);

        }
        else if ( action.equals(Action.PUBLISHMESSAGE) ||
                  action.equals(Action.PUBLISHREPLY) ||
                  action.equals(Action.PUBLISHRETWEET) ) {
            request = createPublishMsgRequest(action, params, request, bodyOrNull);
        }
        else if ( action.equals(Action.LINKSOCIALACCOUNT) || action.equals(Action.UNLINKSOCIALACCOUNT) ) {
            request = createAddTweeterAccountRequest(params, request);
        }

        return (T) request;
    }

    private static Request buildBasicRequest( Map<String, String[]> params ) {
        String actionName = params.get(ACTIONPARAM)[ 0 ];
        Action action = Action.getActionByName(actionName);

        Request request = RequestImpl.create(action);

        if ( params.get(USERNAME) != null && params.get(USERNAME).length > 0 ) {
            String userName = params.get(USERNAME)[ 0 ];
            request = RequestImpl.create(action)
                                 .buildBaseRequest(userName)
                                 .withTimestamp(new Timestamp(new Date().getTime()));
        }

        if ( params.get(TOKEN) != null && params.get(TOKEN).length > 0 ) {
            Long tokenId = Long.parseLong(params.get(TOKEN)[ 0 ]);
            request = RequestImpl.create(request).withTokenId(tokenId);
        }

        return request;
    }

    private static Request createLoginRequest( Map<String, String[]> params, Request request ) {
        if ( params.get(PASSWORD) != null && params.get(PASSWORD).length > 0 ) {
            String password = params.get(PASSWORD)[ 0 ];
            request = RequestImpl.create(request).buildLoginRequest(password);
        }
        return request;
    }

    private static Request createManageRequest( Map<String, String[]> params, Request request ) {
        String password = null;
        if ( params.get(PASSWORD) != null && params.get(PASSWORD).length > 0 ) {
            password = params.get(PASSWORD)[ 0 ];
        }

        if ( params.get(PASSWORDOLD) != null && params.get(PASSWORDOLD).length > 0 ) {
            password = params.get(PASSWORDOLD)[ 0 ];
        }

        request = RequestImpl.create(request).buildLoginRequest(password);

        if ( params.get(PASSWORDNEW) != null && params.get(PASSWORDNEW).length > 0 ) {
            String passwordNew = params.get(PASSWORDNEW)[ 0 ];
            request = RequestImpl.create(request).withNewPassword(passwordNew);
        }

        return request;
    }

    private static Request createFetchMsgsRequest( Map<String, String[]> params, Request request ) {

        List<String> accounts = new ArrayList<>();
        if ( params.get(ACCOUNTS) != null && params.get(ACCOUNTS).length > 0 ) {
            accounts = Arrays.asList(params.get(ACCOUNTS));
        }

        List<String> accontTypesString = new ArrayList<>();
        if ( params.get(ACCOUNTTYPES) != null && params.get(ACCOUNTTYPES).length > 0 ) {
            accontTypesString = Arrays.asList(params.get(ACCOUNTTYPES));
        }

        List<Account> accountsWithType = new ArrayList<>();
        for ( int i = 0; i < accounts.size(); i++ ) {
            accountsWithType.add(new Account(accounts.get(i),
                                             accounts.get(i),
                                             AccountType.getAccountType(accontTypesString.get(i))));
        }

        request = RequestImpl.create(request).buildFetchRequest(accountsWithType);

        if ( params.get(SIZE) != null && params.get(SIZE).length > 0 ) {
            int size = Integer.parseInt(params.get(SIZE)[ 0 ]);
            request = RequestImpl.create(request).withSize(size);
        }

        if ( params.get(DATEFROM) != null && params.get(DATEFROM).length > 0 ) {
            DateTime dateFrom = new DateTime(Long.parseLong(params.get(DATEFROM)[ 0 ]));
            request = RequestImpl.create(request).withDateFrom(dateFrom);
        }

        if ( params.get(DATETO) != null && params.get(DATETO).length > 0 ) {
            DateTime dateTo = new DateTime(Long.parseLong(params.get(DATETO)[ 0 ]));
            request = RequestImpl.create(request).withDateTo(dateTo);
        }

        return request;
    }

    private static Request createGetMsgsRequest( Map<String, String[]> params, Request request ) {

        List<String> ids = Arrays.asList(params.get(IDS));
        List<Long> idsLong = new ArrayList<>();

        for ( String id : ids ) {
            idsLong.add(new Long(id));
        }

        String accontTypeString = null;
        if ( params.get(ACCOUNTTYPEArr) != null && params.get(ACCOUNTTYPEArr).length > 0 ) {
            accontTypeString = params.get(ACCOUNTTYPEArr)[ 0 ];
        }

        AccountType accountType = AccountType.getAccountType(accontTypeString);

        return request = RequestImpl.create(request)
                                    .buildFetchByIdRequest(idsLong)
                                    .withAccountType(accountType);
    }

    private static Request createFetchRepliesRequest( Map<String, String[]> params, Request request ) {
        Long replayForId = null;
        if ( params.get(REPLAYFORID) != null && params.get(REPLAYFORID).length > 0 ) {
            replayForId = Long.parseLong(params.get(REPLAYFORID)[ 0 ]);
        }
        return RequestImpl.create(request).withReplayForID(replayForId);
    }

    private static Request createFetchRetweetsRequest( Map<String, String[]> params, Request request ) {
        Long retweetForId = null;
        if ( params.get(RETWEETFORID) != null && params.get(RETWEETFORID).length > 0 ) {
            retweetForId = Long.parseLong(params.get(RETWEETFORID)[ 0 ]);
        }
        return RequestImpl.create(request).withRetweetForId(retweetForId);
    }

    private static Request createPublishMsgRequest( Action action,
                                                    Map<String, String[]> params,
                                                    Request request,
                                                    byte[] body ) {
        String tweetText = null;
        List<Account> accountsWithType = null;
        String accountLogin = null;
        Long retweetForId = null;
        Long replayForId = null;
        String imgName = null;
        String imgURL = null;

        if ( action.equals(Action.PUBLISHMESSAGE) || action.equals(Action.PUBLISHRETWEET) ) {

            List<String> accounts = new ArrayList<String>();
            if ( params.get(ACCOUNTLOGINS) != null ) {
                accounts = Arrays.asList(params.get(ACCOUNTLOGINS));
            }

            List<String> accountsTypes = new ArrayList<String>();
            if ( params.get(ACCOUNTTYPES) != null ) {
                accountsTypes = Arrays.asList(params.get(ACCOUNTTYPES));
            }

            accountsWithType = new ArrayList<>();

            for ( int i = 0; i < accounts.size(); i++ ) {
                accountsWithType.add(new Account(accounts.get(i),
                                                 accounts.get(i),
                                                 AccountType.getAccountType(accountsTypes.get(i))));
            }
        }

        if ( action.equals(Action.PUBLISHMESSAGE) || action.equals(Action.PUBLISHREPLY) ) {
            String[] tweetTexts = params.get(TWEET);
            if ( tweetTexts != null )
                tweetText = tweetTexts[ 0 ];

            if ( params.get(IMGNAME) != null && params.get(IMGNAME).length > 0 ) {
                imgName = params.get(IMGNAME)[ 0 ];
                request = RequestImpl.create(request).withImg(body, imgName);
            }

            if ( params.get(IMGURL) != null && params.get(IMGURL).length > 0 ) {
                imgURL = params.get(IMGURL)[ 0 ];
                request = RequestImpl.create(request).withImg(imgURL);
            }
        }

        request = RequestImpl.create(request).buildPublishRequest(tweetText, accountsWithType);

        if ( action.equals(Action.PUBLISHREPLY) ) {
            if ( params.get(REPLAYFORID) != null && params.get(REPLAYFORID).length > 0 ) {
                replayForId = Long.parseLong(params.get(REPLAYFORID)[ 0 ]);
                request = RequestImpl.create(request).withReplayForID(replayForId);
            }
            if ( params.get(ACCOUNTLOGIN) != null && params.get(ACCOUNTLOGIN).length > 0 ) {
                accountLogin = params.get(ACCOUNTLOGIN)[ 0 ];
                request = RequestImpl.create(request).withLogin(accountLogin);
            }
        }
        else if ( action.equals(Action.PUBLISHRETWEET) ) {
            retweetForId = Long.parseLong(params.get(RETWEETFORID)[ 0 ]);
            request = RequestImpl.create(request).withRetweetForId(retweetForId);
        }

        return request;
    }

    private static Request createAddTweeterAccountRequest( Map<String, String[]> params, Request request ) {
        String loginTweet = params.get(ACCOUNTLOGIN)[ 0 ];

        request = RequestImpl.create(request).buildAddAccountTweetRequest(loginTweet);

        if ( params.get(ACCOUNTPASSWORD) != null && params.get(ACCOUNTPASSWORD).length > 0 ) {
            String password = params.get(ACCOUNTPASSWORD)[ 0 ];
            request = RequestImpl.create(request).withPasswordTweet(password);
        }

        if ( params.get(ACCOUNTTYPE) != null && params.get(ACCOUNTTYPE).length > 0 ) {
            String accountType = params.get(ACCOUNTTYPE)[ 0 ];
            AccountType type = AccountType.getAccountType(accountType);
            request = RequestImpl.create(request).withAccountType(type);
        }

        return request;
    }
}
