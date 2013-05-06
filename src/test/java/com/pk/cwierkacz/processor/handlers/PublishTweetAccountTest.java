package com.pk.cwierkacz.processor.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.request.RequestImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.twitter.TweetsResult;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class PublishTweetAccountTest extends PopulateData
{
    PublishTweetAccount publishTweetAccount;
    protected TweetService tweetService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishTweetAccountTest.class);

    @Before
    public void setUp( ) throws TwitterAuthenticationException {
        publishTweetAccount = new PublishTweetAccount();
        tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        populateUserAndAccount();
    }

    @Test
    public void addTweet( ) throws TwitterActionException {
        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        ApplicationData appData = new ApplicationData();
        List<String> accounts = new ArrayList<String>();
        accounts.add(username);
        accounts.add(username2);
        String text = "TEST OF PUBLISH TWEET HANDLER " + new Date().getTime();

        Request request = RequestImpl.create().buildPublishRequest(text, accounts);
        appData.setRequest(request);

        publishTweetAccount.handle(appData);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getMessage());
        assertEquals(Status.OK, appData.getResponse().getStatus());

        List<TweetDao> tweets1 = tweetService.getActualTweetForAccount(twitterAccountDao, startDate);
        List<TweetDao> tweets2 = tweetService.getActualTweetForAccount(twitterAccountDao2, startDate);

        assertEquals(1, tweets1.size());
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
    public void addReplyTweet( ) throws TwitterActionException {
        TweetDao tweet = twitterAccount.composeNewTweet("NEW TWEET TEST " + ( new Date() ).getTime());
        tweetService.save(tweet);

        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        ApplicationData appData = new ApplicationData();
        List<String> accounts = new ArrayList<String>();
        accounts.add(username);
        accounts.add(username2);
        String text = "TEST OF PUBLISH TWEET HANDLER (REPLY) " + new Date().getTime();
        String textWithReplyName = "@" + username + " " + text;

        Request request = RequestImpl.create().buildPublishRequest(text, accounts, tweet.getId(), 0);
        appData.setRequest(request);

        publishTweetAccount.handle(appData);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getMessage());
        assertEquals(Status.OK, appData.getResponse().getStatus());

        List<TweetDao> tweets1 = tweetService.getActualRepliesForAccount(twitterAccountDao, tweet, startDate);
        List<TweetDao> tweets2 = tweetService.getActualRepliesForAccount(twitterAccountDao2, tweet, startDate);

        assertEquals(1, tweets1.size());
        assertEquals(1, tweets2.size());

        assertEquals(true, StringUtils.equals(tweets1.get(0).getText(), textWithReplyName));
        assertEquals(true, StringUtils.equals(tweets2.get(0).getText(), textWithReplyName));

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
        List<String> accounts = new ArrayList<String>();
        accounts.add(username);
        accounts.add(username2);

        Request request = RequestImpl.create().buildPublishRequest(null, accounts, 0, tweet.getId());
        appData.setRequest(request);

        publishTweetAccount.handle(appData);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getMessage());
        assertEquals(Status.ERROR, appData.getResponse().getStatus());
        assertTrue(appData.getResponse()
                          .getMessage()
                          .contains("fail while add tweet for " +
                                    twitterAccount.getAccount().getAccountName())); //cannot retweet himself

        assertTrue(!appData.getResponse()
                           .getMessage()
                           .contains(twitterAccount2.getAccount().getAccountName()));

        List<TweetDao> tweets1 = tweetService.getActualRetweetsForAccount(twitterAccountDao, tweet, startDate);
        List<TweetDao> tweets2 = tweetService.getActualRetweetsForAccount(twitterAccountDao2,
                                                                          tweet,
                                                                          startDate);

        assertEquals(0, tweets1.size());
        assertEquals(1, tweets2.size());

        String textWithPrefix = "RT @" + twitterAccount.getAccount().getAccountName() + ": " + text;
        assertEquals(true, StringUtils.equals(tweets2.get(0).getText(), textWithPrefix));

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
}
