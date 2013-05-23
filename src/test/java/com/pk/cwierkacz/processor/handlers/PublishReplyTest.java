package com.pk.cwierkacz.processor.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.processor.MainProcessor;
import com.pk.cwierkacz.twitter.TweetsResult;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class PublishReplyTest extends PopulateData
{
    protected TweetService tweetService;

    @Before
    public void setUp( ) throws TwitterAuthenticationException {
        tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        populateUserAndAccount();
    }

    @Test
    public void addReplyTweet( ) throws TwitterActionException {
        TweetDao tweet = twitterAccount.composeNewTweet("NEW TWEET TEST " + ( new Date() ).getTime());
        tweetService.save(tweet);

        DateTime now = new DateTime();
        DateTime startDate = now.minusMillis(now.getMillisOfSecond());
        String text = "TEST OF PUBLISH TWEET HANDLER (REPLY) " + new Date().getTime();

        Request request = RequestImpl.create(Action.PUBLISHREPLY, token).buildReplyRequest(text,
                                                                                           "cwierkacz1",
                                                                                           tweet.getId());
        ApplicationData appData = MainProcessor.getInstance().process(request);

        assertNotNull(appData.getResponse());
        System.out.println("==msg: " + appData.getResponse().getText());
        assertEquals(Status.OK, appData.getResponse().getStatus());

        List<TweetDao> tweets1 = tweetService.getActualReplies(tweet);

        assertEquals(1, tweets1.size());

        assertEquals(true, StringUtils.equals(tweets1.get(0).getText(), text));

        TweetsResult tweets1a = twitterAccount2.getTweetsFromUserTimeline(( new DateTime() ).minusHours(2));

        for ( TweetDao dao : tweets1a.getTweets() ) {
            System.out.println(dao.getText() +
                               " R" +
                               dao.getInReplyToExtId() +
                               " RT" +
                               dao.getRetweetedExtId());
        }

        TweetDao t1 = null;

        for ( TweetDao t : tweets1a.getTweets() ) {
            if ( StringUtils.equals(t.getText(), text) )
                t1 = t;
        }

        assertNotNull(t1);

        assertEquals(tweet.getId(), t1.getInReplyTo().getId());

        TweetDao refreshedMainTweet = tweetService.getTweetById(tweet.getId());
        assertEquals(1, refreshedMainTweet.getActualReplies().size());

    }

}
