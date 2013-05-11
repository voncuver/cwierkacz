package com.pk.cwierkacz.http;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.joda.time.DateTime;

import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.request.RequestImpl;

public class RequestBuilder
{
    public static final String ACTIONPARAM = "action";
    public static final String USERNAME = "username";
    public static final String TOKEN = "token";

    public static final String PASSWORD = "password";
    public static final String PASSWORDOLD = "passwordOld";
    public static final String PASSWORDNEW = "passwordNew";

    public static final String ACCOUNTS = "accounts";

    public static final String LOGINTWEET = "loginTweet";
    public static final String PASSWORDTWEET = "passwordTweet";

    public static final String TWEET = "tweet";
    public static final String REPLAYFORID = "replayForId";
    public static final String RETWEETFORID = "retweetForId";

    public static final String SIZE = "size";
    public static final String DATEFROM = "dateFrom";
    public static final String DATETO = "dateTo";

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
        else if ( action.equals(Action.FETCHTWEETS) ) {
            request = createFetchTweetsRequest(params, request);

        }
        else if ( action.equals(Action.PUBLISHTWEET) ) {

            request = createPublishTweetRequest(params, request, body);
        }
        else if ( action.equals(Action.ADDTWEETACCOUNT) || action.equals(Action.DELTWEETACCOUNT) ) {
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
        request = RequestImpl.create(request).buildFetchRequest(accounts);

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

    private static Request createPublishTweetRequest( Map<String, String[]> params,
                                                      Request request,
                                                      byte[] body ) {
        String tweetText = params.get(TWEET)[ 0 ];
        List<String> accounts = Arrays.asList(params.get(ACCOUNTS));

        request = RequestImpl.create(request).buildPublishRequest(tweetText, accounts).withBody(body);

        if ( params.get(REPLAYFORID) != null && params.get(REPLAYFORID).length > 0 ) {
            Long replayForId = Long.parseLong(params.get(REPLAYFORID)[ 0 ]);
            request = RequestImpl.create(request).withReplayForID(replayForId).withBody(body);
        }

        if ( params.get(RETWEETFORID) != null && params.get(RETWEETFORID).length > 0 ) {
            Long retweetForId = Long.parseLong(params.get(RETWEETFORID)[ 0 ]);
            request = RequestImpl.create(request).withRetweetForId(retweetForId);
        }

        return request;
    }

    private static Request createAddTweeterAccountRequest( Map<String, String[]> params, Request request ) {
        String loginTweet = params.get(LOGINTWEET)[ 0 ];

        request = RequestImpl.create(request).buildAddAccountTweetRequest(loginTweet);

        if ( params.get(PASSWORDTWEET) != null && params.get(PASSWORDTWEET).length > 0 ) {
            String password = params.get(PASSWORDTWEET)[ 0 ];
            request = RequestImpl.create(request).withPasswordTweet(password);
        }

        return request;
    }
}
