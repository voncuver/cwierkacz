package com.tguzik.cwierkacz.twitter.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import twitter4j.Status;

import com.tguzik.cwierkacz.cache.dataobject.Tweets;

public class TweetsConverterTest
{

    @Before
    public void setUp( ) throws Exception {
    }

    @Test
    public void toTweetsTest( ) {
        TweetsConverter converter = new TweetsConverter();

        Status status1 = mock(Status.class);
        Status status2 = mock(Status.class);

        twitter4j.User tweetUser = mock(twitter4j.User.class);
        Date date = new Date();

        stub(status1.getId()).toReturn(1L);
        stub(status2.getId()).toReturn(2L);
        stub(status1.getUser()).toReturn(tweetUser);
        stub(status2.getUser()).toReturn(tweetUser);
        stub(status1.getCreatedAt()).toReturn(date);
        stub(status2.getCreatedAt()).toReturn(date);

        List<Status> stats = new ArrayList<Status>();
        stats.add(status1);
        stats.add(status2);

        Tweets tweets = converter.toTweets(stats);

        assertEquals(tweets.getTweets().size(), 2);
        assertEquals(tweets.getTweets().get(0).getExternalId(), new Long(1));
        assertEquals(tweets.getTweets().get(1).getExternalId(), new Long(2));
    }
}
