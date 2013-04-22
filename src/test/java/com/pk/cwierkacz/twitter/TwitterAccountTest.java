package com.pk.cwierkacz.twitter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.twitter.attachment.ImageAttachment;
import com.pk.cwierkacz.twitter.attachment.TweetAttachments;

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

        UserDao userDao = new UserDao();

        TwitterAccountDao user = TwitterAccountDao.create(userId,
                                                          userDao,
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
        ImageAttachment image = new ImageAttachment(new File("src/test/java/com/pk/cwierkacz/twitter/lena.PNG"));
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
        TweetDao tweet = account.composeNewTweet("TEST CWIERKACZ TWEET FOR REPLY" + ( new Date() ).getTime());
        account.composeNewReplyTweet("TEST CWIERKACZ REPLY TWEET FOR" + ( new Date() ).getTime(), tweet);
    }

    @Test
    public void testComposeNewReplyTweetWithImg( ) throws TwitterActionException {
        TweetDao tweet = account.composeNewTweet("TEST CWIERKACZ TWEET FOR REPLY" + ( new Date() ).getTime());
        ImageAttachment image = new ImageAttachment(new File("src/test/java/com/pk/cwierkacz/twitter/lena.PNG"));
        account.composeNewReplyTweet("QQ TEST CWIERKACZ REPLY TWEET FOR" + ( new Date() ).getTime(),
                                     tweet,
                                     TweetAttachments.createImage(image));
    }

    @Test( expected = TwitterActionException.class )
    public void testComposeNewReTweet( ) throws TwitterActionException {
        TweetDao tweet = account.composeNewTweet("TEST CWIERKACZ TWEET WHICH WILL BE RETWEETED" +
                                                 ( new Date() ).getTime());
        account.composeNewReTweet(tweet);
    }

    @Test
    public void testDeleteTweet( ) throws TwitterActionException {
        TweetDao tweet = account.composeNewTweet("TEST CWIERKACZ TWEET TO DELETE " + ( new Date() ).getTime());
        account.deleteTweet(tweet);
    }

    @Test
    public void testGetTweetsFromHomeTimeline( ) throws TwitterActionException {
        for ( int i = 0; i < 20; i++ ) {
            account.composeNewTweet("TEST CWIERKACZ TWEET " + ( new Date() ).getTime());
        }

        ImmutableList<TweetDao> tweets10 = account.getTweetsFromHomeTimeline(10).getTweets();
        assertEquals(10, tweets10.size());

        ImmutableList<TweetDao> tweets30 = account.getTweetsFromHomeTimeline(30).getTweets();
        assertEquals(30, tweets30.size());

    }

    @Test
    @Ignore
    //save limits
    public void testGetTweetsFromHomeTimeline2( ) throws TwitterActionException {
        for ( int i = 0; i < 200; i++ ) {
            account.composeNewTweet("TEST CWIERKACZ TWEET " + ( new Date() ).getTime());
        }

        ImmutableList<TweetDao> tweets10 = account.getTweetsFromHomeTimeline(10).getTweets();
        assertEquals(10, tweets10.size());

        ImmutableList<TweetDao> tweets20 = account.getTweetsFromHomeTimeline(20).getTweets();
        assertEquals(20, tweets20.size());

        ImmutableList<TweetDao> tweets100 = account.getTweetsFromHomeTimeline(100).getTweets();
        assertEquals(100, tweets100.size());

        ImmutableList<TweetDao> tweets200 = account.getTweetsFromHomeTimeline(100).getTweets();
        assertEquals(200, tweets200.size());

    }

    @Test
    public void testGetTweetsFromHomeTimelineSinceDate( ) throws TwitterActionException {

        DateTime d = new DateTime();
        DateTime d1 = d.minusHours(1);
        TweetsResult res = account.getTweetsFromHomeTimeline(d1);
        assertTrue(res.isFullResult());
        TweetsResult res2 = account.getTweetsFromHomeTimeline(res.getTweets().size() + 1);
        assertTrue(res2.isFullResult());
        for ( int i = 0; i < res.getTweets().size(); i++ ) {
            assertTrue(res.getTweets().get(i).getCratedDate().isAfter(d1) ||
                       res.getTweets().get(i).getCratedDate().isEqual(d1));
        }

        if ( res2.getTweets().size() == res.getTweets().size() + 1 )
            assertTrue(res2.getTweets().get(res.getTweets().size()).getCratedDate().isBefore(d1));

    }

    @Test
    public void testGetTweetsFromMentionsTimelineSinceDate( ) throws TwitterActionException {

        DateTime d = new DateTime();
        DateTime d1 = d.minusHours(1);
        TweetsResult res = account.getTweetsFromMentionsTimeline(d1);
        assertTrue(res.isFullResult());
        TweetsResult res2 = account.getTweetsFromMentionsTimeline(res.getTweets().size() + 1);
        assertTrue(res2.isFullResult());
        for ( int i = 0; i < res.getTweets().size(); i++ ) {
            assertTrue(res.getTweets().get(i).getCratedDate().isAfter(d1) ||
                       res.getTweets().get(i).getCratedDate().isEqual(d1));
        }

        if ( res2.getTweets().size() == res.getTweets().size() + 1 )
            assertTrue(res2.getTweets().get(res.getTweets().size()).getCratedDate().isBefore(d1));

    }

    @Test
    public void testGetTweetsFromUserTimelineSinceTweet( ) throws TwitterActionException {
        ImmutableList<TweetDao> tweets30 = account.getTweetsFromHomeTimeline(30).getTweets();
        assertEquals(30, tweets30.size());
        TweetDao since = tweets30.get(29);

        TweetsResult res = account.getTweetsFromUserTimeline(since);
        assertEquals(29, res.size());
    }

    @Test
    public void testGetTweetsFromUserTimelineSinceDate( ) throws TwitterActionException {

        DateTime d = new DateTime();
        DateTime d1 = d.minusHours(1);
        TweetsResult res = account.getTweetsFromUserTimeline(d1);
        assertTrue(res.isFullResult());
        TweetsResult res2 = account.getTweetsFromUserTimeline(res.getTweets().size() + 1);
        assertTrue(res2.isFullResult());
        for ( int i = 0; i < res.getTweets().size(); i++ ) {
            assertTrue(res.getTweets().get(i).getCratedDate().isAfter(d1) ||
                       res.getTweets().get(i).getCratedDate().isEqual(d1));
        }

        if ( res2.getTweets().size() == res.getTweets().size() + 1 )
            assertTrue(res2.getTweets().get(res.getTweets().size()).getCratedDate().isBefore(d1));

    }

}
