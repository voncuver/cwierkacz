package com.tguzik.cwierkacz.twitter.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.LocalDate;
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
        TweetConverter converter = new TweetConverter();
        Calendar cal = Calendar.getInstance();
        cal.set(2013, 2, 24); //means 24.03.2013
        Date date = cal.getTime();

        Status status = mock(Status.class);
        twitter4j.User tweetUser = mock(twitter4j.User.class);

        stub(status.getId()).toReturn(77L);
        stub(status.getCreatedAt()).toReturn(date);
        stub(status.getUser()).toReturn(tweetUser);
        stub(status.getText()).toReturn("test msg");
        stub(tweetUser.getName()).toReturn("Test username");

        Tweet tweet = converter.toTweet(status);
        assertEquals(new Long(tweet.getExternalId()), new Long(status.getId()));
        assertEquals(new Long(tweet.getExternalId()), new Long(77));

        assertEquals(tweet.getCratedDate(), new LocalDate(2013, 3, 24));

        assertEquals(tweet.getTweetCreator().getName(), "Test username");

        assertEquals(tweet.getText(), "test msg");
    }
}
