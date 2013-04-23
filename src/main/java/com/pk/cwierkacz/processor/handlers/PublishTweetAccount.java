package com.pk.cwierkacz.processor.handlers;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.PublishRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.twitter.TwitterAccount;
import com.pk.cwierkacz.twitter.TwitterAccountMap;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class PublishTweetAccount implements Handler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PublishTweetAccount.class);

    private final TweetService tweetService;

    private final TwitterAccountService accountService;

    public PublishTweetAccount() {
        this.tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        this.accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.PUBLISHTWEET);
    }

    @Override
    public void handle( ApplicationData appData ) {
        PublishRequest publishRequest = (PublishRequest) appData.getRequest();

        StringBuilder errorBuilder = new StringBuilder();
        for ( String accountName : publishRequest.getAccounts() ) { //tranzakcyjność per jedno konto - a może inaczej?
            TwitterAccountDao accountDao = accountService.getAccountByName(accountName);
            if ( accountDao == null ) {
                errorBuilder.append(accountName + " not exist in system ; ");
            }
            else {
                try {
                    TweetDao newTweet;
                    TwitterAccount account = TwitterAccountMap.getTwitterAccount(accountDao);
                    if ( publishRequest.getReplayForId() > 0 ) {
                        TweetDao inReply = tweetService.getTweetById(publishRequest.getReplayForId());
                        if ( inReply == null )
                            errorBuilder.append("in reply tweet not exist ; ");
                        newTweet = account.composeNewReplyTweet(publishRequest.getTweetText(), inReply);
                    }
                    else {
                        newTweet = account.composeNewTweet(publishRequest.getTweetText());
                    }
                    //TODO add retweet handling

                    tweetService.save(newTweet);
                }
                catch ( TwitterAuthenticationException e ) {
                    LOGGER.error(e.getMessage());
                    errorBuilder.append("fail while authenticate for " + accountName + " ; ");
                }
                catch ( TwitterActionException e ) {
                    LOGGER.error(e.getMessage());
                    errorBuilder.append("fail while add tweet for " + accountName + " ; ");
                }
                catch ( Throwable e ) {
                    LOGGER.error(e.getMessage());
                    errorBuilder.append("internal error for " + accountName + " ; ");
                }
            }

        }

        Response response;
        String errors = errorBuilder.toString();
        if ( StringUtils.isEmpty(errors) ) {
            response = ResponseImpl.create(Status.OK,
                                           "Tweet for all account was add correctly",
                                           appData.getRequest().getTokenId());
        }
        else {
            response = ResponseImpl.create(Status.ERROR, "Tweet for not all account was add correctly - " +
                                                         errors, appData.getRequest().getTokenId());
        }

        appData.setResponse(response);
    }

}
