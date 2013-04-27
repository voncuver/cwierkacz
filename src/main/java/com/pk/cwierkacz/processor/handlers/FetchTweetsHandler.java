package com.pk.cwierkacz.processor.handlers;

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
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.twitter.TweetsResult;
import com.pk.cwierkacz.twitter.TwitterAccount;
import com.pk.cwierkacz.twitter.TwitterAccountMap;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class FetchTweetsHandler implements Handler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchTweetsHandler.class);

    private final TweetService tweetService;

    private final TwitterAccountService accountService;

    public FetchTweetsHandler() {
        this.tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        this.accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.FETCHTWEETS);
    }

    @Override
    public void handle( ApplicationData appData ) {

        //TODO może lepiej przechowywać odpowiedz jak mape list?
        FetchTweetsRequest fetchRequest = (FetchTweetsRequest) appData.getRequest();
        Map<Long, String> users = new HashMap<Long, String>();

        StringBuilder errorBuilder = new StringBuilder();
        Map<TwitterAccountDao, List<TweetDao>> groupedTweets = new HashMap<TwitterAccountDao, List<TweetDao>>();
        List<TweetDao> mergedTweets = new ArrayList<TweetDao>();
        for ( String accountName : fetchRequest.getAccounts() ) { //tranzakcyjność per jedno konto - a może inaczej?
            try {
                TwitterAccountDao accountDao = accountService.getAccountByName(accountName);
                List<TweetDao> currentTweets = null;
                if ( accountDao == null )
                    errorBuilder.append("cannot find account name " + accountName + " : ");
                else {
                    TwitterAccount account;

                    if ( fetchRequest.getReplayForId() > 0 ) {
                        TweetDao replyTweet = tweetService.getTweetById(fetchRequest.getReplayForId());
                        if ( replyTweet == null )
                            errorBuilder.append("cannot find in reply to tweet ; ");
                        else
                            currentTweets = tweetService.getActualRepliesForAccount(accountDao,
                                                                                    replyTweet,
                                                                                    fetchRequest.getDateFrom());
                    }
                    else {
                        currentTweets = tweetService.getActualTweetForAccount(accountDao,
                                                                              fetchRequest.getDateFrom());
                    }
                    TweetDao last = currentTweets.get(currentTweets.size());

                    try {
                        account = TwitterAccountMap.getTwitterAccount(accountDao);
                        TweetsResult result = account.getTweetsFromMentionsAndUserTimeline(last);
                        for ( TweetDao tweet : result.getReadyTweets() ) {
                            tweetService.save(tweet);
                            currentTweets.add(tweet);
                        }
                        for ( TweetDao tweet : result.fulfilledNoReady() ) {
                            tweetService.save(tweet);
                            currentTweets.add(tweet);
                        }

                        /*List<TweetDao> newTweets = null;
                        if ( fetchRequest.getReplayForId() > 0 ) { // TODO refaktorawac!!!! wydzielic do innej funkcji albo wymusic zeby był idk
                            TweetDao replyTweet = tweetService.getTweetById(fetchRequest.getReplayForId());
                            if ( replyTweet == null )
                                errorBuilder.append("cannot find in reply to tweet ; ");
                            else
                                newTweets = tweetService.getActualRepliesForAccount(accountDao,
                                                                                    replyTweet,
                                                                                    last.getCratedDate());
                        }
                        else {
                            newTweets = tweetService.getActualTweetForAccount(accountDao,
                                                                              last.getCratedDate());
                        }
                        currentTweets.addAll(newTweets);*/

                    }
                    catch ( TwitterAuthenticationException e ) {
                        LOGGER.error(e.getMessage());
                        errorBuilder.append("fail while authenticate for " + accountName + " ; ");
                    }
                    catch ( TwitterActionException e ) {
                        LOGGER.error(e.getMessage());
                        errorBuilder.append("propably not all tweets are fetched for " + accountName + " ; ");
                    }
                    groupedTweets.put(accountDao, currentTweets);
                    mergedTweets.addAll(currentTweets);

                }
            }
            catch ( Throwable e ) {
                LOGGER.error(e.getMessage());
                errorBuilder.append("internal error for " + accountName + " ; ");
            }
        }

        for ( TwitterAccountDao dao : groupedTweets.keySet() ) {
            users.put(dao.getId(), dao.getAccountName());
        }

        Response response;

        String errors = errorBuilder.toString();
        if ( StringUtils.isEmpty(errors) ) {
            response = ResponseImpl.create(Status.OK,
                                           "Tweet for all account was fetched correctly",
                                           appData.getRequest().getTokenId());
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
