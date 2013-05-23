package com.pk.cwierkacz.processor.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.request.RequestImpl;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.processor.MainProcessor;
import com.pk.cwierkacz.twitter.TweetsResult;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class PublishTweetTest extends PopulateData
{
    protected TweetService tweetService;

    @Before
    public void setUp( ) throws TwitterAuthenticationException {
        tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        populateUserAndAccount();
    }

    @Test
    public void addTweet( ) throws TwitterActionException {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("cwierkacz1", "Cwierkacz", AccountType.TWITTER));
        accounts.add(new Account("cwierkacz13", "Cwierkacz", AccountType.TWITTER));
        simpleAddingTweet(accounts);
    }

    @Test
    public void addTweetForAllAccounts( ) throws TwitterActionException {
        simpleAddingTweet(null);
    }

    private void simpleAddingTweet( List<Account> accounts ) throws TwitterActionException {
        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        String text = "TEST OF PUBLISH TWEET HANDLER " + new Date().getTime();

        Request request = RequestImpl.create(Action.PUBLISHMESSAGE, token)
                                     .buildPublishRequest(text, accounts);
        ApplicationData appData = MainProcessor.getInstance().process(request);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getText());
        assertEquals(Status.OK, appData.getResponse().getStatus());

        List<TweetDao> tweets1 = tweetService.getActualTweetForAccount(twitterAccountDao,
                                                                       startDate,
                                                                       null,
                                                                       null);
        List<TweetDao> tweets2 = tweetService.getActualTweetForAccount(twitterAccountDao2,
                                                                       startDate,
                                                                       null,
                                                                       null);

        assertEquals(1, tweets1.size());

        System.out.println("==============");
        for ( TweetDao t : tweets2 ) {
            System.out.println(t.getCratedDate() + " : " + t.getText());
        }
        System.out.println("==============");
        assertEquals(1, tweets2.size());

        assertEquals(true, StringUtils.equals(tweets1.get(0).getText(), text));
        assertEquals(true, StringUtils.equals(tweets2.get(0).getText(), text));

        TweetsResult tweets1a = twitterAccount.getTweetsFromUserTimeline(startDate);
        TweetsResult tweets2a = twitterAccount2.getTweetsFromUserTimeline(startDate);

        boolean exist1a = false;
        boolean exist2a = false;

        for ( TweetDao t : tweets1a.getTweets() ) {
            if ( StringUtils.equals(t.getText(), text) )
                exist1a = true;
        }
        for ( TweetDao t : tweets2a.getTweets() ) {
            if ( StringUtils.equals(t.getText(), text) )
                exist2a = true;
        }

        assertEquals(true, exist1a);
        assertEquals(true, exist2a);
    }

    @Test
    public void addTweetWithImg( ) throws TwitterActionException, FileNotFoundException, IOException {
        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("cwierkacz1", "Cwierkacz", AccountType.TWITTER));
        String text = "TEST OF PUBLISH TWEET HANDLER WITH IMG" + new Date().getTime();

        byte[] body = IOUtils.toByteArray(new FileInputStream(new File("src/test/java/com/pk/cwierkacz/processor/handlers/lena.PNG")));

        Request request = RequestImpl.create(Action.PUBLISHMESSAGE, token)
                                     .buildPublishRequest(text, accounts)
                                     .withImg(body, "lena.PNG");
        ApplicationData appData = MainProcessor.getInstance().process(request);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getText());
        assertEquals(Status.OK, appData.getResponse().getStatus());

        List<TweetDao> tweets1 = tweetService.getActualTweetForAccount(twitterAccountDao,
                                                                       startDate,
                                                                       null,
                                                                       null);

        assertEquals(1, tweets1.size());

        assertEquals(true, tweets1.get(0).getText().startsWith(text));
        assertNotNull(tweets1.get(0).getImagePath());
        System.out.println("path : " + tweets1.get(0).getImagePath());

        TweetsResult tweets1a = twitterAccount.getTweetsFromUserTimeline(startDate);

        TweetDao t1a = null;

        for ( TweetDao t : tweets1a.getTweets() ) {
            if ( t.getText().startsWith(text) )
                t1a = t;
        }

        assertNotNull(t1a);
        assertNotNull(t1a.getImagePath());
    }

    @Test
    public void addTweetWithNoRights( ) throws TwitterActionException {
        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("cwierkacz1", "Cwierkacz", AccountType.TWITTER));
        accounts.add(new Account("cwierkacz13", "Cwierkacz", AccountType.TWITTER));
        accounts.add(new Account("fake", "fake", AccountType.TWITTER));

        String text = "TEST OF PUBLISH TWEET HANDLER " + new Date().getTime();

        Request request = RequestImpl.create(Action.PUBLISHMESSAGE, token)
                                     .buildPublishRequest(text, accounts);

        ApplicationData appData = MainProcessor.getInstance().process(request);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getText());
        assertEquals(Status.DENY, appData.getResponse().getStatus());

        List<TweetDao> tweets1 = tweetService.getActualTweetForAccount(twitterAccountDao3,
                                                                       startDate,
                                                                       null,
                                                                       null);

        assertEquals(0, tweets1.size());

    }
}
