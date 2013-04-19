package com.tguzik.cwierkacz.twitter;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;
import com.tguzik.cwierkacz.cache.dataobject.Tweet;
import com.tguzik.cwierkacz.twitter.attachment.ImageAttachment;
import com.tguzik.cwierkacz.twitter.attachment.TweetAttachments;

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
    public void testComposeNewTweetWithImg( ) throws TwitterActionException, URISyntaxException {
        ImageAttachment image = new ImageAttachment(new File("resources/lena.PNG"));
        account.composeNewTweet("11 TEST CWIERKACZ TWEET " + ( new Date() ).getTime(),
                                TweetAttachments.createImage(image));
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

    @Test
    public void testComposeNewReplyTweetWithImg( ) throws TwitterActionException {
        Tweet tweet = account.composeNewTweet("TEST CWIERKACZ TWEET FOR REPLY" + ( new Date() ).getTime());
        ImageAttachment image = new ImageAttachment(new File("resources/lena.PNG"));
        account.composeNewReplyTweet("QQ TEST CWIERKACZ REPLY TWEET FOR" + ( new Date() ).getTime(),
                                     tweet,
                                     TweetAttachments.createImage(image));
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
    public void testGetTweetsFromHomeTimeline( ) throws TwitterActionException {
        for ( int i = 0; i < 100; i++ ) {
            account.composeNewTweet("TEST CWIERKACZ TWEET " + ( new Date() ).getTime());
        }

        ImmutableList<Tweet> tweets10 = account.getTweetsFromHomeTimeline(10);
        assertEquals(10, tweets10.size());

        ImmutableList<Tweet> tweets20 = account.getTweetsFromHomeTimeline(20);
        assertEquals(20, tweets20.size());

        ImmutableList<Tweet> tweets100 = account.getTweetsFromHomeTimeline(100);
        assertEquals(100, tweets100.size());

    }
}
