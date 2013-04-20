package com.pk.cwierkacz.http;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.request.RequestImpl;

public class RequestBuilder
{
    private static Logger logger = LoggerFactory.getLogger(RequestBuilder.class);

    public static final String ACTIONPARAM = "Action";
    public static final String FUNUSERNAME = "FunctionalUserName";
    public static final String TOKENID = "TokenID";

    public static final String PASSWORD = "Password";

    public static final String TWEETACCOUNT = "TweetAccount";
    public static final String TWEETPASSWORD = "TweetPassword";

    public static final String ACCOUNTS = "Accounts";

    public static final String TWEETTEXT = "TweetText";
    public static final String REPLAYFORID = "ReplayForId";

    public static final String SIZE = "Size";
    public static final String DATEFROM = "DateFrom";

    @SuppressWarnings( "unchecked" )
    public static < T > T buildRequest( Map<String, String[]> params ) {
        logger.debug(params.toString());
        String actionName = params.get(ACTIONPARAM)[ 0 ];
        Action action = Action.getActionByName(actionName);
        Request request = buildBasicRequest(params, action);

        if ( action.equals(Action.LOGIN) ||
             action.equals(Action.LOGOUT) ||
             action.equals(Action.CREATEACCOUNT) ) {

            if ( params.get(PASSWORD) != null && params.get(PASSWORD).length > 0 ) {
                String password = params.get(PASSWORD)[ 0 ];
                request = RequestImpl.create(request).buildLoginRequest(password);
            }
        }
        else if ( action.equals(Action.ADDTWEETACCOUNT) ) {
            String tweetAccount = params.get(TWEETACCOUNT)[ 0 ];
            String tweetPassword = params.get(TWEETPASSWORD)[ 0 ];
            request = RequestImpl.create(request).buildAddAccountTweetRequest(tweetAccount, tweetPassword);
        }
        else if ( action.equals(Action.FETCHTWEETS) ) {
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

        }
        else if ( action.equals(Action.PUBLISHTWEET) ) {
            String tweetText = params.get(TWEETTEXT)[ 0 ];
            List<String> accounts = Arrays.asList(params.get(ACCOUNTS));

            request = RequestImpl.create(request).buildPublishRequest(tweetText, accounts);

            if ( params.get(REPLAYFORID) != null && params.get(REPLAYFORID).length > 0 ) {
                Long replayForId = Long.parseLong(params.get(REPLAYFORID)[ 0 ]);
                request = RequestImpl.create(request).withReplayForID(replayForId);
            }
        }

        return (T) request;
    }

    private static Request buildBasicRequest( Map<String, String[]> params, Action action ) {
        Request request = RequestImpl.create().buildBaseRequest(action, params.get(FUNUSERNAME)[ 0 ]);

        if ( params.get(TOKENID) != null && params.get(TOKENID).length > 0 ) {
            Long tokenId = Long.parseLong(params.get(TOKENID)[ 0 ]);
            request = RequestImpl.create(request).withTokenId(tokenId);
        }
        return request;
    }
}
