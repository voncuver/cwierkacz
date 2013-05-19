package com.pk.cwierkacz.http;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

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
    public static final String PASSWORDOLD = "passwordOld";
    public static final String PASSWORDNEW = "passwordNew";

    public static final String ACCOUNTS = "accounts";
    public static final String ACCOUNTTYPE = "accountType";

    public static final String ACCOUNTLOGINS = "accountLogins";
    public static final String ACCOUNTTYPES = "accountTypes";

    public static final String ACCOUNTLOGIN = "accountLogin";
    public static final String ACCOUNTPASSWORD = "accountPassword";

    public static final String TWEET = "tweet";
    public static final String REPLAYFORID = "replayForId";
    public static final String RETWEETFORID = "retweetForId";
    public static final String IMGNAME = "imgName";

    public static final String SIZE = "size";
    public static final String DATEFROM = "dateFrom";
    public static final String DATETO = "dateTo";

    public static final String IDS = "ids";

    public static < T > T buildRequest( Map<String, String[]> params, Cookie[] cookies ) {
        return buildRequest(params, cookies, null);
    }

    @SuppressWarnings( "unchecked" )
    public static < T > T buildRequest( Map<String, String[]> params, Cookie[] cookies, byte[] body ) {

        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                params.put(cookie.getName(), new String[] {cookie.getValue()});
            }
        }

        Request request = buildBasicRequest(params);

        Action action = request.getAction();

        if ( action.equals(Action.SIGNIN) || action.equals(Action.SIGNOUT) ) {
            request = createLoginRequest(params, request);
        }
        else if ( action.equals(Action.ADDACCOUNT) ||
                  action.equals(Action.MODACCOUNT) ||
                  action.equals(Action.DELACCOUNT) ) {
            request = createManageRequest(params, request);
        }
        else if ( action.equals(Action.FETCHMESSAGE) || action.equals(Action.FETCHMESSAGES) ) {
            request = createFetchTweetsRequest(params, request);

        }
        else if ( action.equals(Action.FETCHMESSAGEBYID) ) {
            request = createFetchByIdTweetsRequest(params, request);
        }
        else if ( action.equals(Action.PUBLISHTWEET) ) {
            byte[] bodyOrNull = null;
            if ( body != null && body.length > 0 )
                bodyOrNull = body;
            request = createPublishTweetRequest(params, request, bodyOrNull);
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

    private static Request createFetchTweetsRequest( Map<String, String[]> params, Request request ) {
        List<String> accounts = Arrays.asList(params.get(ACCOUNTS));
        String accontTypeString = params.get(ACCOUNTTYPE)[ 0 ];
        AccountType accountType = AccountType.getAccountType(accontTypeString);

        List<Account> accountsWithType = new ArrayList<>();
        for ( String account : accounts ) {
            accountsWithType.add(new Account(account, account, accountType));
        }

        request = RequestImpl.create(request).buildFetchRequest(accountsWithType);

        if ( params.get(SIZE) != null && params.get(SIZE).length > 0 ) {
            int size = Integer.parseInt(params.get(SIZE)[ 0 ]);
            request = RequestImpl.create(request).withSize(size);
        }

        if ( params.get(DATEFROM) != null && params.get(DATEFROM).length > 0 ) {
            DateTime dateFrom = DateTime.parse(params.get(DATEFROM)[ 0 ]);
            request = RequestImpl.create(request).withDateFrom(dateFrom);
        }

        if ( params.get(DATETO) != null && params.get(DATETO).length > 0 ) {
            DateTime dateTo = DateTime.parse(params.get(DATETO)[ 0 ]);
            request = RequestImpl.create(request).withDateTo(dateTo);
        }

        if ( params.get(REPLAYFORID) != null && params.get(REPLAYFORID).length > 0 ) {
            Long replayForId = Long.parseLong(params.get(REPLAYFORID)[ 0 ]);
            request = RequestImpl.create(request).withReplayForID(replayForId);
        }

        if ( params.get(RETWEETFORID) != null && params.get(RETWEETFORID).length > 0 ) {
            Long retweetForId = Long.parseLong(params.get(RETWEETFORID)[ 0 ]);
            request = RequestImpl.create(request).withRetweetForId(retweetForId);
        }
        return request;
    }

    private static Request createFetchByIdTweetsRequest( Map<String, String[]> params, Request request ) {
        List<String> ids = Arrays.asList(params.get(IDS));
        List<Long> idsLong = new ArrayList<>();

        for ( String id : ids ) {
            idsLong.add(new Long(id));
        }

        return request = RequestImpl.create(request).buildFetchByIdRequest(idsLong);
    }

    private static Request createPublishTweetRequest( Map<String, String[]> params,
                                                      Request request,
                                                      byte[] body ) {
        String[] tweetTexts = params.get(TWEET);
        String tweetText = null;
        if ( tweetTexts != null )
            tweetText = tweetTexts[ 0 ];

        List<String> accounts = new ArrayList<String>();
        if ( params.get(ACCOUNTLOGINS) != null ) {
            accounts = Arrays.asList(params.get(ACCOUNTLOGINS));
        }

        List<String> accountsTypes = new ArrayList<String>();
        if ( params.get(ACCOUNTTYPES) != null ) {
            accountsTypes = Arrays.asList(params.get(ACCOUNTTYPES));
        }

        List<Account> accountsWithType = new ArrayList<>();

        for ( int i = 0; i < accounts.size(); i++ ) {
            accountsWithType.add(new Account(accounts.get(i),
                                             accounts.get(i),
                                             AccountType.getAccountType(accountsTypes.get(i))));
        }

        request = RequestImpl.create(request).buildPublishRequest(tweetText, accountsWithType);

        if ( params.get(IMGNAME) != null && params.get(IMGNAME).length > 0 ) {
            String imgName = params.get(IMGNAME)[ 0 ];
            request = RequestImpl.create(request).withImg(body, imgName);
        }

        if ( params.get(REPLAYFORID) != null && params.get(REPLAYFORID).length > 0 ) {
            Long replayForId = Long.parseLong(params.get(REPLAYFORID)[ 0 ]);
            request = RequestImpl.create(request).withReplayForID(replayForId);
        }

        if ( params.get(RETWEETFORID) != null && params.get(RETWEETFORID).length > 0 ) {
            Long retweetForId = Long.parseLong(params.get(RETWEETFORID)[ 0 ]);
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

        return request;
    }
}
