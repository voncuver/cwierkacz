package com.tguzik.cwierkacz.twitter.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;

import twitter4j.Status;

import com.tguzik.cwierkacz.cache.dataobject.Tweet;

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

        Tweet tweet = converter.toTweet(status);
        assertEquals(new Long(tweet.getExternalId()), new Long(status.getId()));
        assertEquals(new Long(tweet.getExternalId()), new Long(77));

        assertEquals(tweet.getCratedDate(), date);

        assertEquals((long) tweet.getCreatorId(), (long) 1234);

        assertEquals(tweet.getText(), "test msg");
    }
}
