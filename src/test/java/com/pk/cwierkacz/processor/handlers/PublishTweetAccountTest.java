package com.pk.cwierkacz.processor.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.pk.cwierkacz.twitter.TweetsResult;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class PublishTweetAccountTest extends PopulateData
{
    PublishMessagesHandler publishTweetAccount;
    protected TweetService tweetService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishTweetAccountTest.class);

    @Before
    public void setUp( ) throws TwitterAuthenticationException {
        publishTweetAccount = new PublishMessagesHandler();
        tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        populateUserAndAccount();
    }

    @Test
    public void addTweet( ) throws TwitterActionException {
        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        ApplicationData appData = new ApplicationData();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("first", "first", AccountType.TWITTER));
        accounts.add(new Account("second", "second", AccountType.TWITTER));
        String text = "TEST OF PUBLISH TWEET HANDLER " + new Date().getTime();

        Request request = RequestImpl.create(Action.PUBLISHMESSAGE, token).buildPublishRequest(text, accounts);
        appData.setRequest(request);

        publishTweetAccount.handle(appData);

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
        ApplicationData appData = new ApplicationData();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("first", "first", AccountType.TWITTER));
        String text = "TEST OF PUBLISH TWEET HANDLER WITH IMG" + new Date().getTime();

        byte[] body = IOUtils.toByteArray(new FileInputStream(new File("src/test/java/com/pk/cwierkacz/processor/handlers/lena.PNG")));

        Request request = RequestImpl.create(Action.PUBLISHMESSAGE, token)
                                     .buildPublishRequest(text, accounts)
                                     .withImg(body, "lena.PNG");
        appData.setRequest(request);

        publishTweetAccount.handle(appData);

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
    public void addReplyTweet( ) throws TwitterActionException {
        TweetDao tweet = twitterAccount.composeNewTweet("NEW TWEET TEST " + ( new Date() ).getTime());
        tweetService.save(tweet);

        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        ApplicationData appData = new ApplicationData();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("first", "first", AccountType.TWITTER));
        accounts.add(new Account("second", "second", AccountType.TWITTER));
        String text = "TEST OF PUBLISH TWEET HANDLER (REPLY) " + new Date().getTime();
        String textWithReplyName = "@" + username + " " + text;

        Request request = RequestImpl.create(Action.PUBLISHMESSAGE, token).buildPublishRequest(text,
                                                                                             accounts,
                                                                                             tweet.getId(),
                                                                                             0);
        appData.setRequest(request);

        publishTweetAccount.handle(appData);

        assertNotNull(appData.getResponse());
        System.out.println("==msg: " + appData.getResponse().getText());
        assertEquals(Status.OK, appData.getResponse().getStatus());

        List<TweetDao> tweets1 = tweetService.getActualReplies(tweet);

        assertEquals(2, tweets1.size());

        assertEquals(true, StringUtils.equals(tweets1.get(0).getText(), textWithReplyName));
        assertEquals(true, StringUtils.equals(tweets1.get(1).getText(), textWithReplyName));

        TweetsResult tweets1a = twitterAccount.getTweetsFromUserTimeline(startDate);
        TweetsResult tweets2a = twitterAccount2.getTweetsFromUserTimeline(startDate);

        TweetDao t1 = null;
        TweetDao t2 = null;

        for ( TweetDao t : tweets1a.getTweets() ) {
            if ( StringUtils.equals(t.getText(), textWithReplyName) )
                t1 = t;
        }
        for ( TweetDao t : tweets2a.getTweets() ) {
            if ( StringUtils.equals(t.getText(), textWithReplyName) )
                t2 = t;
        }

        assertNotNull(t1);
        assertNotNull(t2);

        assertEquals(tweet.getId(), t1.getInReplyTo().getId());
        assertEquals(tweet.getId(), t2.getInReplyTo().getId());

        TweetDao refreshedMainTweet = tweetService.getTweetById(tweet.getId());
        assertEquals(2, refreshedMainTweet.getActualReplies().size());

    }

    @Test
    public void addReTweet( ) throws TwitterActionException {

        DateTime orig = new DateTime();
        DateTime origStartDate = orig.minusMillis(orig.getMillisOfSecond());

        String text = "NEW TWEET TEST FOR RETWEETED " + new Date().getTime();
        TweetDao tweet = twitterAccount.composeNewTweet(text);
        tweetService.save(tweet);

        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());

        ApplicationData appData = new ApplicationData();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("first", "first", AccountType.TWITTER));
        accounts.add(new Account("second", "second", AccountType.TWITTER));

        Request request = RequestImpl.create(Action.PUBLISHMESSAGE, token).buildPublishRequest(null,
                                                                                             accounts,
                                                                                             0,
                                                                                             tweet.getId());
        appData.setRequest(request);

        publishTweetAccount.handle(appData);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getText());
        assertEquals(Status.ERROR, appData.getResponse().getStatus());
        assertTrue(appData.getResponse()
                          .getText()
                          .contains("Bład komunikacji dla użytkownika " +
                                    twitterAccount.getAccount().getAccountName())); //cannot retweet himself

        assertTrue(!appData.getResponse().getText().contains(twitterAccount2.getAccount().getAccountName()));

        List<TweetDao> tweets1 = tweetService.getActualRetweets(tweet);

        assertEquals(1, tweets1.size());

        String textWithPrefix = "RT @" + twitterAccount.getAccount().getAccountName() + ": " + text;
        assertEquals(true, StringUtils.equals(tweets1.get(0).getText(), textWithPrefix));

        TweetsResult tweets2a = twitterAccount2.getTweetsFromMentionsAndUserTimeline(startDate);
        TweetsResult tweets1b = twitterAccount.getRetweeted(origStartDate);
        assertEquals(1, tweets1b.size());
        TweetsResult tweets1a = twitterAccount.getRetweets(tweets1b.getTweets().get(0), startDate);

        TweetDao t1 = null;
        TweetDao t2 = null;

        for ( TweetDao t : tweets2a.getTweets() ) {
            if ( StringUtils.equals(t.getText(), textWithPrefix) )
                t2 = t;
        }

        for ( TweetDao t : tweets1a.getTweets() ) {
            if ( StringUtils.equals(t.getText(), textWithPrefix) )
                t1 = t;
        }

        assertNotNull(t1);
        assertNotNull(t2);

        assertEquals(tweet.getId(), t1.getRetweeted().getId());
        assertEquals(tweet.getId(), t2.getRetweeted().getId());

        TweetDao refreshedMainTweet = tweetService.getTweetById(tweet.getId());
        assertEquals(1, refreshedMainTweet.getRetweets().size());

    }

    @Test
    public void addTweetWithNoRights( ) throws TwitterActionException {
        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        ApplicationData appData = new ApplicationData();
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("first", "first", AccountType.TWITTER));
        accounts.add(new Account("second", "second", AccountType.TWITTER));

        String text = "TEST OF PUBLISH TWEET HANDLER " + new Date().getTime();

        Request request = RequestImpl.create(Action.PUBLISHMESSAGE, token).buildPublishRequest(text, accounts);
        appData.setRequest(request);

        publishTweetAccount.handle(appData);

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
