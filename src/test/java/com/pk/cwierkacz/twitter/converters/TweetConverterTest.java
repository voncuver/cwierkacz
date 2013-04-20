package com.pk.cwierkacz.twitter.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;

import twitter4j.Status;

import com.pk.cwierkacz.model.dao.TweetDao;

public class TweetConverterTest
{

    @Before
    public void setUp( ) throws Exception {
    }

    @Test
    public void toTweetTest( ) {
        DateTime date = new DateTime(2013, 03, 24, 12, 22, 33, 500, DateTimeZone.UTC);
        Date utilDate = date.toDate();

        TweetConverter converter = new TweetConverter();

        Status status = mock(Status.class);
        twitter4j.User tweetUser = mock(twitter4j.User.class);

        stub(status.getId()).toReturn(77L);
        stub(status.getCreatedAt()).toReturn(utilDate);
        stub(status.getUser()).toReturn(tweetUser);
        stub(status.getText()).toReturn("test msg");
        stub(tweetUser.getId()).toReturn(1234L);

        TweetDao tweet = converter.toTweet(status);
        assertEquals(tweet.getId().longValue(), status.getId());
        assertEquals(tweet.getId().longValue(), 77L);

        assertEquals(tweet.getCratedDate(), date);

        assertEquals(tweet.getCreatorId().longValue(), 1234L);

        assertEquals(tweet.getText(), "test msg");
    }
}
