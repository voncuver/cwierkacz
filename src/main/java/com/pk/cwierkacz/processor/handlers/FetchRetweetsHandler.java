package com.pk.cwierkacz.processor.handlers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.FetchRetweetsRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.http.response.dto.Message;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.Result;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.processor.handlers.helpers.ImageUtil;
import com.pk.cwierkacz.twitter.TweetsResult;
import com.pk.cwierkacz.twitter.TwitterAccount;
import com.pk.cwierkacz.twitter.TwitterAccountMap;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class FetchRetweetsHandler extends AbstractHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchMessagesHandler.class);

    private final TweetService tweetService;

    private final ImageUtil imageUtil;

    public FetchRetweetsHandler() {
        super();
        this.tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        this.imageUtil = new ImageUtil();
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.FETCHRETWEETS);
    }

    @Override
    public Result checkSecurity( ApplicationData appData ) {
        FetchRetweetsRequest fetchRequest = (FetchRetweetsRequest) appData.getRequest();

        if ( fetchRequest.getRetweetFor() <= 0 ) {
            return new Result("Aby pobrać retweety musisz podać identyfikator tweeta dla którego chcesz pobrać wiadomości",
                              Status.ERROR);
        }

        return new Result("OK", Status.OK);
    }

    @Override
    public void handle( ApplicationData appData ) {
        FetchRetweetsRequest fetchRequest = (FetchRetweetsRequest) appData.getRequest();

        StringBuilder errorBuilder = new StringBuilder();
        List<TweetDao> mergedTweets = new ArrayList<TweetDao>();
        TwitterAccountDao accountDao = null;
        try {
            TweetDao retweeted = tweetService.getTweetById(fetchRequest.getRetweetFor());
            if ( retweeted == null ) {
                errorBuilder.append("Brak tweetu, dla którego chcesz pobrać retweety");
            }
            else {
                accountDao = retweeted.getCreator();
                if ( accountDao != null ) {
                    TwitterAccount account = TwitterAccountMap.getTwitterAccount(accountDao);
                    TweetsResult result = account.getRetweets(retweeted);
                    for ( TweetDao tweet : result.getReadyTweets() ) {
                        tweet.setImagePath(retweeted.getImagePath());
                        tweetService.save(tweet);
                    }
                    do {
                        result = result.fulfilledNoReady(account);
                        for ( TweetDao tweet : result.getReadyTweets() ) {
                            TweetDao tweetWithData = tweet;
                            if ( tweet.getRetweetedExtId() == retweeted.getExternalId() ) {
                                tweetWithData.setImagePath(retweeted.getImagePath());
                            }
                            else {
                                tweetWithData = imageUtil.tweetWithImg(tweetWithData);
                            }
                            tweetService.save(tweetWithData);
                        }
                    }
                    while ( !result.allReady() );

                    mergedTweets = tweetService.getActualRetweets(retweeted);
                }
                //else nothing to do, because we may don't know what is owner of the main tweet
            }
        }
        catch ( TwitterAuthenticationException e ) {
            LOGGER.error(getError(e));
            errorBuilder = appendError(errorBuilder, "Błąd autoryzacji dla: " +
                                                     accountDao.getAccountName() +
                                                     ".", e);
        }
        catch ( TwitterActionException e ) {
            LOGGER.error(getError(e));
            errorBuilder = appendError(errorBuilder,
                                       "Bład pobierania tweetów dla " + accountDao.getAccountName() + ".",
                                       e);
        }
        catch ( Throwable e ) {
            LOGGER.error(getError(e));
            errorBuilder = appendError(errorBuilder, "Wewnętrzny bład aplikacji.", e);
        }

        Response response;

        String errors = errorBuilder.toString();
        if ( StringUtils.isEmpty(errors) ) {
            response = ResponseImpl.create(Status.OK,
                                           "Pobrano pomyślnie wszystkie tweety.",
                                           appData.getRequest().getTokenId())
                                   .buildFetchResponse(Message.apply(mergedTweets));
            ;
        }
        else {
            response = ResponseImpl.create(Status.ERROR,
                                           "Bład pobierania tweetów. " + errors,
                                           appData.getRequest().getTokenId())
                                   .buildFetchResponse(Message.apply(mergedTweets));
        }

        appData.setResponse(response);

    }
}
