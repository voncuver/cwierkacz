package com.pk.cwierkacz.processor.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.request.RequestImpl;
import com.pk.cwierkacz.http.response.FetchMessagesResponse;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.http.response.dto.Message;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;
import com.pk.cwierkacz.twitter.attachment.ImageAttachment;
import com.pk.cwierkacz.twitter.attachment.TweetAttachments;

public class FetchTweetsHandlerTest extends PopulateData
{

    FetchTweetsHandler fetchTweetsHandler;
    protected TweetService tweetService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishTweetAccountTest.class);

    @Before
    public void setUp( ) throws TwitterAuthenticationException {
        fetchTweetsHandler = new FetchTweetsHandler();
        tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        populateUserAndAccount();
    }

    @Test
    public void fetchTweetForAccounts( ) throws TwitterActionException, InterruptedException {
        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        List<TweetDao> tweets = new ArrayList<TweetDao>();
        for ( int i = 0; i < 2; i++ ) {
            System.out.println("adding tweet ......");
            TweetDao t1 = twitterAccount.composeNewTweet("FetchTweetsHandlerTest Tweet " +
                                                         new Date().getTime());
            Thread.sleep(1000);
            System.out.println("adding tweet ......");
            TweetDao t2 = twitterAccount2.composeNewTweet("FetchTweetsHandlerTest Tweet " +
                                                          new Date().getTime());
            Thread.sleep(1000);
            System.out.println("adding tweet ......");
            TweetDao t3 = twitterAccount2.composeNewReplyTweet("FetchTweetsHandlerTest Tweet " +
                                                                       new Date().getTime(),
                                                               t1);

            Thread.sleep(1000);

            tweetService.save(t1);
            tweetService.save(t2);
            tweetService.save(t3);
            tweets.add(t1);
            tweets.add(t2);
            tweets.add(t3);
        }

        for ( int i = 0; i < 2; i++ ) {
            System.out.println("adding tweet ......");
            TweetDao t1 = twitterAccount.composeNewTweet("FetchTweetsHandlerTest Tweet " +
                                                         new Date().getTime());
            Thread.sleep(1000);
            System.out.println("adding tweet ......");
            TweetDao t2 = twitterAccount2.composeNewTweet("FetchTweetsHandlerTest Tweet " +
                                                          new Date().getTime());
            Thread.sleep(1000);
            System.out.println("adding tweet ......");
            TweetDao t3 = twitterAccount.composeNewReplyTweet("FetchTweetsHandlerTest Tweet " +
                                                                      new Date().getTime(),
                                                              t2);

            Thread.sleep(1000);
            tweets.add(t1);
            tweets.add(t2);
            tweets.add(t3);
        }

        ApplicationData appData = new ApplicationData();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("first", "first", AccountType.TWITTER));
        accounts.add(new Account("second", "second", AccountType.TWITTER));

        Request request = RequestImpl.create(Action.FETCHMESSAGES).buildFetchRequest(accounts,
                                                                                     10,
                                                                                     startDate,
                                                                                     -1,
                                                                                     -1,
                                                                                     AccountType.TWITTER);
        appData.setRequest(request);

        fetchTweetsHandler.handle(appData);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getErrors());
        assertEquals(Status.OK, appData.getResponse().getStatus());
        FetchMessagesResponse response = (FetchMessagesResponse) appData.getResponse();

        assertEquals(10, response.getMessages().size());

        for ( int i = 0; i < 10; i++ ) {
            assertEquals(tweets.get(11 - i).getText(), response.getMessages().get(i).getText());
        }

    }

    @Test
    public void fetchTweetWithImgForAccounts( ) throws TwitterActionException, InterruptedException {
        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());

        Thread.sleep(1000);
        System.out.println("adding tweet ......");
        TweetDao t1a = twitterAccount.composeNewTweet("FetchTweetsHandlerTest Tweet WITH SAVE" +
                                                      new Date().getTime());
        tweetService.save(t1a);

        System.out.println("adding tweet ......");
        ImageAttachment image = new ImageAttachment(new File("src/test/java/com/pk/cwierkacz/processor/handlers/lena.PNG"));
        TweetDao t1 = twitterAccount.composeNewTweet("FetchTweetsHandlerTest Tweet WITHOUT SAVE" +
                                                             new Date().getTime(),
                                                     TweetAttachments.createImage(image));

        ApplicationData appData = new ApplicationData();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("first", "first", AccountType.TWITTER));
        accounts.add(new Account("second", "second", AccountType.TWITTER));
        Request request = RequestImpl.create(Action.FETCHMESSAGES).buildFetchRequest(accounts,
                                                                                     5,
                                                                                     startDate,
                                                                                     -1,
                                                                                     -1,
                                                                                     AccountType.TWITTER);
        appData.setRequest(request);

        fetchTweetsHandler.handle(appData);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getErrors());
        assertEquals(Status.OK, appData.getResponse().getStatus());
        FetchMessagesResponse response = (FetchMessagesResponse) appData.getResponse();

        Message tweetNew = response.getMessages().get(0);
        assertEquals(t1.getText(), tweetNew.getText());

        assertNotNull(tweetNew.getImagePath());
        assertTrue(tweetNew.getImagePath().endsWith(".png"));

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

        ApplicationData appData = new ApplicationData();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("first", "first", AccountType.TWITTER));
        accounts.add(new Account("second", "second", AccountType.TWITTER));

        Request request = RequestImpl.create(Action.FETCHMESSAGES, token)
                                     .buildFetchRequest(accounts,
                                                        -1,
                                                        startDate,
                                                        mainTweet.getId(),
                                                        -1,
                                                        AccountType.TWITTER);
        appData.setRequest(request);

        fetchTweetsHandler.handle(appData);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getErrors());
        assertEquals(Status.OK, appData.getResponse().getStatus());
        FetchMessagesResponse response = (FetchMessagesResponse) appData.getResponse();

        assertEquals(9, response.getMessages().size());

        assertEquals(mainTweet.getText(), response.getMessages().get(8).getText());

        for ( int i = 0; i < 8; i++ ) {
            assertEquals(tweets.get(7 - i).getText(), response.getMessages().get(i).getText());
        }
    }

    @Test
    public void fetchRewteetsForAccounts( ) throws TwitterActionException, InterruptedException {

        TweetDao mainTweet = twitterAccount.composeNewTweet("FetchTweetsHandlerTest Main Tweet " +
                                                            new Date().getTime());
        tweetService.save(mainTweet);
        System.out.println("adding tweet ......");
        Thread.sleep(1000);

        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        List<TweetDao> tweets = new ArrayList<TweetDao>();

        System.out.println("adding tweet ......");
        TweetDao t2a = twitterAccount2.composeNewReTweet(mainTweet);
        Thread.sleep(1000);
        tweets.add(t2a);

        ApplicationData appData = new ApplicationData();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("first", "first", AccountType.TWITTER));
        accounts.add(new Account("second", "second", AccountType.TWITTER));
        Request request = RequestImpl.create(Action.FETCHMESSAGES, token)
                                     .buildFetchRequest(accounts,
                                                        -1,
                                                        startDate,
                                                        -1,
                                                        mainTweet.getId(),
                                                        AccountType.TWITTER);

        appData.setRequest(request);

        fetchTweetsHandler.handle(appData);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getErrors());
        assertEquals(Status.OK, appData.getResponse().getStatus());
        FetchMessagesResponse response = (FetchMessagesResponse) appData.getResponse();

        assertEquals(2, response.getMessages().size());

        assertEquals(tweets.get(0).getText(), response.getMessages().get(0).getText());
        assertEquals(mainTweet.getText(), response.getMessages().get(1).getText());

    }

}
