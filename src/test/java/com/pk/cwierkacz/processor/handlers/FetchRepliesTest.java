package com.pk.cwierkacz.processor.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.request.RequestImpl;
import com.pk.cwierkacz.http.response.FetchMessagesResponse;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.processor.MainProcessor;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class FetchRepliesTest extends PopulateData
{

    protected TweetService tweetService;

    @Before
    public void setUp( ) throws TwitterAuthenticationException {
        tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        populateUserAndAccount();
    }

    @Test
    public void fetchReplyTweetForAccounts( ) throws TwitterActionException, InterruptedException {
        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        List<TweetDao> tweets = new ArrayList<TweetDao>();

        TweetDao mainTweet = twitterAccount.composeNewTweet("FetchTweetsHandlerTest Main Tweet " +
                                                            new Date().getTime());
        tweetService.save(mainTweet);
        System.out.println("adding tweet ......");
        Thread.sleep(1000);

        for ( int i = 0; i < 2; i++ ) {
            System.out.println("adding tweet ......");
            TweetDao t1 = twitterAccount.composeNewReplyTweet("FetchTweetsHandlerTest Tweet " +
                                                                      new Date().getTime(),
                                                              mainTweet);
            Thread.sleep(1000);
            System.out.println("adding tweet ......");
            TweetDao t2 = twitterAccount2.composeNewReplyTweet("FetchTweetsHandlerTest Tweet " +
                                                                       new Date().getTime(),
                                                               mainTweet);
            Thread.sleep(1000);

            tweetService.save(t1);
            tweetService.save(t2);
            tweets.add(t1);
            tweets.add(t2);
        }

        for ( int i = 0; i < 2; i++ ) {
            System.out.println("adding tweet ......");
            TweetDao t1 = twitterAccount.composeNewReplyTweet("FetchTweetsHandlerTest Tweet " +
                                                                      new Date().getTime(),
                                                              mainTweet);
            Thread.sleep(1000);
            System.out.println("adding tweet ......");
            TweetDao t2 = twitterAccount2.composeNewReplyTweet("FetchTweetsHandlerTest Tweet " +
                                                                       new Date().getTime(),
                                                               mainTweet);
            Thread.sleep(1000);
            tweets.add(t1);
            tweets.add(t2);
        }

        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("cwierkacz1", "Cwierkacz", AccountType.TWITTER));
        accounts.add(new Account("cwierkacz13", "Cwierkacz", AccountType.TWITTER));

        Request request = RequestImpl.create(Action.FETCHMESSAGES, token)
                                     .buildFetchRequest(accounts,
                                                        -1,
                                                        startDate,
                                                        mainTweet.getId(),
                                                        -1,
                                                        AccountType.TWITTER);
        ApplicationData appData = MainProcessor.getInstance().process(request);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getText());
        assertEquals(Status.OK, appData.getResponse().getStatus());
        FetchMessagesResponse response = (FetchMessagesResponse) appData.getResponse();

        assertEquals(9, response.getMessages().size());

        assertEquals(mainTweet.getText(), response.getMessages().get(8).getText());

        for ( int i = 0; i < 8; i++ ) {
            assertEquals(tweets.get(7 - i).getText(), response.getMessages().get(i).getText());
        }
    }

}
