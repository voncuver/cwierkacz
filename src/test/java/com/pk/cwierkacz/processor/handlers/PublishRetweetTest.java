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

public class PublishRetweetTest extends PopulateData
{
    protected TweetService tweetService;

    @Before
    public void setUp( ) throws TwitterAuthenticationException {
        tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        populateUserAndAccount();
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

        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("cwierkacz1", "Cwierkacz", AccountType.TWITTER));
        accounts.add(new Account("cwierkacz13", "Cwierkacz", AccountType.TWITTER));

        Request request = RequestImpl.create(Action.PUBLISHRETWEET, token).buildRetweetRequest(accounts,
                                                                                               tweet.getId());
        ApplicationData appData = MainProcessor.getInstance().process(request);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getText());
        assertEquals(Status.ERROR, appData.getResponse().getStatus());
        assertTrue(appData.getResponse()
                          .getText()
                          .contains("Bład komunikacji dla konta " +
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

}
