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
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.processor.MainProcessor;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class GetTweetsTest extends PopulateData
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

        List<Long> ids = new ArrayList<Long>();
        ids.add(t1.getId());
        ids.add(t2.getId());

        Request request = RequestImpl.create(Action.GETMESSAGES, token).buildGetRequest(AccountType.TWITTER,
                                                                                        ids);

        ApplicationData appData = MainProcessor.getInstance().process(request);

        assertNotNull(appData.getResponse());
        System.out.println("msg: " + appData.getResponse().getText());
        assertEquals(Status.OK, appData.getResponse().getStatus());
        FetchMessagesResponse response = (FetchMessagesResponse) appData.getResponse();

        assertEquals(2, response.getMessages().size());

    }

}
