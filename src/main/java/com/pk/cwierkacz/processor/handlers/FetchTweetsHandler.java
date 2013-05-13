package com.pk.cwierkacz.processor.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.FetchTweetsRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.model.service.UserService;
import com.pk.cwierkacz.processor.handlers.helpers.FileSaver;
import com.pk.cwierkacz.twitter.TweetsResult;
import com.pk.cwierkacz.twitter.TwitterAccount;
import com.pk.cwierkacz.twitter.TwitterAccountMap;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class FetchTweetsHandler extends AbstractHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchTweetsHandler.class);

    private final TweetService tweetService;

    private final TwitterAccountService accountService;

    private final UserService userService;

    private final SessionService sessionService;

    private final FileSaver fileSaver;

    private TweetDao tweetWithImg( TweetDao t ) throws IOException {
        t.setImagePath(fileSaver.saveFileFromUrl(t.getTwitterImageUrl()));
        return t;
    }

    public FetchTweetsHandler() {
        this.tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        this.accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
        this.userService = ServiceRepo.getInstance().getService(UserService.class);
        this.sessionService = ServiceRepo.getInstance().getService(SessionService.class);
        this.fileSaver = new FileSaver();
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.FETCHMESSAGE) ||
               applicationData.getRequest().getAction().equals(Action.FETCHMESSAGES);
    }

    @Override
    public void handle( ApplicationData appData ) {
        //TODO może lepiej przechowywać odpowiedz jak mape list?
        FetchTweetsRequest fetchRequest = (FetchTweetsRequest) appData.getRequest();
        List<TwitterAccountDao> acs = new ArrayList<TwitterAccountDao>();

        StringBuilder errorBuilder = new StringBuilder();
        //Map<TwitterAccountDao, List<TweetDao>> groupedTweets = new HashMap<TwitterAccountDao, List<TweetDao>>();
        List<TweetDao> mergedTweets = new ArrayList<TweetDao>();
        try {
            //moze walidacja tego ze nie moze byc account i replay na przykład
            if ( fetchRequest.getReplayFor() > 0 ) {
                TweetDao replyTweet = tweetService.getTweetById(fetchRequest.getReplayFor());
                if ( replyTweet == null ) {
                    errorBuilder.append("not found tweet which was supposed to be replied; ");
                }
                else {
                    SessionDao sessionDao = sessionService.getByToken(fetchRequest.getTokenId());
                    UserDao user = userService.getBySessionId(sessionDao);
                    List<TwitterAccountDao> accountsDao = accountService.getAccountsForUser(user);
                    TweetsResult notReadyTweets = new TweetsResult();
                    for ( TwitterAccountDao accountDao : accountsDao ) {
                        TweetDao last = tweetService.getLastActualReplies(replyTweet);
                        if ( last == null )
                            last = replyTweet;
                        try {
                            TwitterAccount account;
                            account = TwitterAccountMap.getTwitterAccount(accountDao);
                            TweetsResult result = account.getTweetsFromMentionsAndUserTimeline(last);
                            for ( TweetDao tweet : result.getReadyTweets() ) {
                                tweetService.save(tweetWithImg(tweet));
                            }
                            notReadyTweets = notReadyTweets.add(result);

                        }
                        catch ( TwitterAuthenticationException e ) {
                            LOGGER.error(e.getMessage());
                            errorBuilder.append("fail while authenticate for " +
                                                accountDao.getAccountName() +
                                                " ; ");
                        }
                        catch ( TwitterActionException e ) {
                            LOGGER.error(e.getMessage());
                            errorBuilder.append("propably not all tweets are fetched for " +
                                                accountDao.getAccountName() +
                                                " ; ");
                        }
                    }
                    try {
                        for ( TweetDao tweet : notReadyTweets.fulfilledNoReady() ) {
                            tweetService.save(tweetWithImg(tweet));
                        }
                    }
                    catch ( Exception e ) {
                        LOGGER.error(e.getMessage());
                        errorBuilder.append("propably not all tweets are fetched, becouse some dependency ar not resolved ; ");
                    }

                    mergedTweets = tweetService.getActualReplies(replyTweet);
                    mergedTweets.add(replyTweet);
                }
            }
            else if ( fetchRequest.getRetweetFor() > 0 ) {
                TweetDao retweeted = tweetService.getTweetById(fetchRequest.getRetweetFor());
                if ( retweeted == null ) {
                    errorBuilder.append("not found was supposed to be retweeted; ");
                }
                else {
                    SessionDao sessionDao = sessionService.getByToken(fetchRequest.getTokenId());
                    UserDao user = userService.getBySessionId(sessionDao);
                    TwitterAccountDao accountDao = accountService.getSampleAccountForUser(user);
                    if ( accountDao == null ) {
                        errorBuilder.append("user haven't accounts : ");
                    }
                    else {
                        TwitterAccount account;
                        account = TwitterAccountMap.getTwitterAccount(accountDao);
                        TweetsResult result = account.getRetweets(retweeted);
                        for ( TweetDao tweet : result.getReadyTweets() ) {
                            tweetService.save(tweetWithImg(tweet));
                        }
                        for ( TweetDao tweet : result.fulfilledNoReady() ) {
                            tweetService.save(tweetWithImg(tweet));
                        }

                        mergedTweets = tweetService.getActualRetweets(retweeted);
                        mergedTweets.add(retweeted);
                    }
                }
            }
            else if ( fetchRequest.getAccounts().size() > 0 ) {
                TweetsResult notReadyTweets = new TweetsResult();
                for ( String accountName : fetchRequest.getAccounts() ) { //tranzakcyjność per jedno konto - a może inaczej?
                    try {
                        TwitterAccountDao accountDao = accountService.getAccountByName(accountName);
                        List<TweetDao> currentTweets = null;
                        if ( accountDao == null )
                            errorBuilder.append("cannot find account name " + accountName + " : ");
                        else {
                            TweetDao last = tweetService.getLastActualTweetForAccount(accountDao);
                            if ( last != null ) {
                                try {
                                    TwitterAccount account;
                                    account = TwitterAccountMap.getTwitterAccount(accountDao);
                                    TweetsResult result = account.getTweetsFromMentionsAndUserTimeline(last);
                                    for ( TweetDao tweet : result.getReadyTweets() ) {
                                        tweetService.save(tweetWithImg(tweet));
                                    }
                                    notReadyTweets = notReadyTweets.add(result);

                                }
                                catch ( TwitterAuthenticationException e ) {
                                    LOGGER.error(e.getMessage());
                                    errorBuilder.append("fail while authenticate for " + accountName + " ; ");
                                }
                                catch ( TwitterActionException e ) {
                                    LOGGER.error(e.getMessage());
                                    errorBuilder.append("propably not all tweets are fetched for " +
                                                        accountName +
                                                        " ; ");
                                }
                            }

                            //groupedTweets if used
                            acs.add(accountDao);

                        }
                    }
                    catch ( Throwable e ) {
                        LOGGER.error(e.getMessage());
                        errorBuilder.append("internal error for " + accountName + " ; ");
                    }
                }
                try {
                    for ( TweetDao tweet : notReadyTweets.fulfilledNoReady() ) {
                        tweetService.save(tweetWithImg(tweet));
                    }
                }
                catch ( Exception e ) {
                    LOGGER.error(e.getMessage());
                    errorBuilder.append("propably not all tweets are fetched, becouse some dependency ar not resolved ; ");
                }

                mergedTweets = tweetService.getActualTweetForAccounts(acs,
                                                                      fetchRequest.getDateFrom(),
                                                                      fetchRequest.getDateTo(),
                                                                      fetchRequest.getSize());

            }
        }
        catch ( Throwable e ) {
            LOGGER.error(e.getMessage());
            errorBuilder.append("internal error");
        }

        Map<Long, String> users = new HashMap<Long, String>();
        for ( TweetDao tweet : mergedTweets ) {
            users.put(tweet.getCreator().getId(), tweet.getCreatorName());
        }

        Response response;

        String errors = errorBuilder.toString();
        if ( StringUtils.isEmpty(errors) ) {
            response = ResponseImpl.create(Status.OK,
                                           "Tweet for all account was fetched correctly",
                                           appData.getRequest().getTokenId())
                                   .buildFetchResponse(mergedTweets, users);
            ;
        }
        else {
            response = ResponseImpl.create(Status.ERROR,
                                           "Tweet for not all account was fetched correctly - " + errors,
                                           appData.getRequest().getTokenId())
                                   .buildFetchResponse(mergedTweets, users);
        }

        appData.setResponse(response);

    }
}
