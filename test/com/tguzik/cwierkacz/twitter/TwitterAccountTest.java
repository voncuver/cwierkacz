package com.tguzik.cwierkacz.twitter;

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
    private final long userId = 1291752048;

    private TwitterAccount account;

    @Before
    public void setUp( ) throws Exception {
        User user = User.create(userId, username);
        user.grantAccess(accessToken, accessTokenSecret);
        account = new TwitterAccount(user);
    }

    @Test
    public void testComposeNewTweet( ) throws TwitterActionException {
        account.composeNewTweet("TEST CWIERKACZ TWEET " + ( new Date() ).getTime());
    }

    @Test
    public void testComposeMaxSizeNewTweet( ) throws TwitterActionException {
        StringBuilder builder = new StringBuilder(140);
        for ( int i = 0; i < 127; i++ )
            builder.append('a');
        builder.append(( new Date() ).getTime());
        account.composeNewTweet(builder.toString());
    }

    @Test( expected = TwitterActionException.class )
    public void testComposeTooBigNewTweet( ) throws TwitterActionException {
        StringBuilder builder = new StringBuilder(141);
        for ( int i = 0; i < 128; i++ )
            builder.append('a');
        builder.append(( new Date() ).getTime());
        account.composeNewTweet(builder.toString());
    }

    @Test
    public void testComposeNewReplyTweet( ) throws TwitterActionException {
        Tweet tweet = account.composeNewTweet("TEST CWIERKACZ TWEET FOR REPLY" + ( new Date() ).getTime());
        account.composeNewReplyTweet("TEST CWIERKACZ REPLY TWEET FOR" + ( new Date() ).getTime(), tweet);
    }

    @Test( expected = TwitterActionException.class )
    public void testComposeNewReTweet( ) throws TwitterActionException {
        Tweet tweet = account.composeNewTweet("TEST CWIERKACZ TWEET WHICH WILL BE RETWEETED" +
                                              ( new Date() ).getTime());
        account.composeNewReTweet(tweet);
    }

    @Test
    public void testDeleteTweet( ) throws TwitterActionException {
        Tweet tweet = account.composeNewTweet("TEST CWIERKACZ TWEET TO DELETE " + ( new Date() ).getTime());
        account.deleteTweet(tweet);
    }

    @Test
    public void testGetTweetsSince( ) throws TwitterActionException {

        ImmutableList<Tweet> tweets = account.getTweetsSince(new LocalDate(2013, 3, 25));

        System.out.println(tweets.size());
        System.out.println("============");

        for ( int i = 0; i < tweets.size(); i++ ) {
            System.out.println(tweets.get(i).getExternalId());
            System.out.println(tweets.get(i).getText());
            System.out.println(tweets.get(i).getInReplyTo());
            System.out.println("==============");
        }
    }

}
