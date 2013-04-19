package com.tguzik.cwierkacz.twitter;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;
import com.tguzik.cwierkacz.cache.dataobject.Tweet;

public class TwitterAccountTest
{

    private final String username = "cwierkacz1";
    private final String accessToken = "1291752048-EINIa817O7rBs5FTcyQu6dozbgV6KQJx339Cn3I";
    private final String accessTokenSecret = "sIxeZvvJ0eSxgy3Zj27829De0KI0HytKtPcWrLK9Y";
    private final long userId = 1291752048;

    /*private final String username = "cwierkacz13";
    private final String accessToken = "1291708484-x2GIuJprsYm4Wf2MWSFvsRYkdVPxUZncUxzKaJw";
    private final String accessTokenSecret = "jxqddQ8NdcFa0uqJJGuQcMgBifjj0us8BX4GNto4YQ";
    private final long userId = 1291708484;*/

    private TwitterAccount account;

    @Before
    public void setUp( ) throws Exception {
        FunctionalAccount user = FunctionalAccount.create(userId,
                                                          -1,
                                                          username,
                                                          accessToken,
                                                          accessTokenSecret);
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
}
