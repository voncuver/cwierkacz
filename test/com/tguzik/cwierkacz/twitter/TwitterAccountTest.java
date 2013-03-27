package com.tguzik.cwierkacz.twitter;

import static org.junit.Assert.fail;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.dataobject.Tweet;
import com.tguzik.cwierkacz.cache.dataobject.User;

public class TwitterAccountTest
{

    private final String username = "cwierkacz1";
    private final String accessToken = "1291752048-EINIa817O7rBs5FTcyQu6dozbgV6KQJx339Cn3I";
    private final String accessTokenSecret = "sIxeZvvJ0eSxgy3Zj27829De0KI0HytKtPcWrLK9Y";

    private TwitterAccount account;

    @Before
    public void setUp( ) throws Exception {
        User user = User.create(77L, username);
        user.grantAccess(accessToken, accessTokenSecret);
        account = new TwitterAccount(user);
    }

    @Test
    public void testComposeNewTweet( ) throws TwitterActionException {
        account.composeNewTweet("TEST CWIERKACZ TWEET " + ( new Date() ).getTime());
    }

    @Test
    public void testDeleteTweet( ) throws TwitterActionException {
        Tweet tweet = account.composeNewTweet("TEST CWIERKACZ TWEET TO DELETE " + ( new Date() ).getTime());
        account.deleteTweet(tweet);
    }

    @Test
    public void testGetTweetsSince( ) throws TwitterActionException {
        fail("Not working yet");
        //TODO
        ImmutableList<Tweet> tt = account.getTweetsSince(new LocalDate(2013, 3, 22));
    }

}
