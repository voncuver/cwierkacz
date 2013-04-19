package com.pk.cwierkacz.twitter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pk.cwierkacz.model.dao.Tweet;
import com.pk.cwierkacz.model.dao.UserDao;

public class TwitterAccountListenerTest
{

    private final String username2 = "cwierkacz13";
    private final String accessToken2 = "1291708484-x2GIuJprsYm4Wf2MWSFvsRYkdVPxUZncUxzKaJw";
    private final String accessTokenSecret2 = "jxqddQ8NdcFa0uqJJGuQcMgBifjj0us8BX4GNto4YQ";
    private final long userId2 = 1291708484;

    private final String username = "cwierkacz1";
    private final String accessToken = "1291752048-EINIa817O7rBs5FTcyQu6dozbgV6KQJx339Cn3I";
    private final String accessTokenSecret = "sIxeZvvJ0eSxgy3Zj27829De0KI0HytKtPcWrLK9Y";
    private final long userId = 1291752048;

    private TwitterAccountListener listener;
    private MemoryTwitterStorage storage;

    UserDao user = UserDao.create(userId, -1, username, accessToken, accessTokenSecret);

    UserDao user2 = UserDao.create(userId2, -1, username2, accessToken2, accessTokenSecret2);

    TwitterAccount account1, account2;

    class MemoryTwitterStorage implements TwitterStorage
    {
        private final Map<Long, Tweet> tweets = new HashMap<Long, Tweet>();

        @Override
        public void addUnclassifiedTweet( Tweet tweet ) {
            tweets.put(tweet.getId(), tweet);

        }

        @Override
        public void removeTweet( long tweetId ) {
            tweets.remove(tweetId);
        }

        public int size( ) {
            return tweets.size();
        }

        public boolean contain( long tweetId ) {
            return tweets.containsKey(tweetId);
        }

        public boolean contain( Tweet tweet ) {
            return tweets.containsValue(tweet);
        }

        @Override
        public String toString( ) {
            Iterator<Entry<Long, Tweet>> it = tweets.entrySet().iterator();
            String msg = "";
            while ( it.hasNext() ) {
                Entry<Long, Tweet> pairs = it.next();
                msg += ( pairs.getKey() + " = " + pairs.getValue() + "\n" );
                it.remove();
            }
            return msg;
        }

    }

    @Before
    public void setUp( ) throws Exception {

        account1 = new TwitterAccount(user);
        account2 = new TwitterAccount(user2);

        listener = new TwitterAccountListener(user);

        storage = new MemoryTwitterStorage();

        listener.initialize(storage);
        listener.listen();
        Thread.sleep(1000); //waiting for fully start
    }

    @After
    public void closeAll( ) {
        listener.stopListen();
    }

    @Test
    public void testAddTweetByOwner( ) throws TwitterActionException,
                                      InterruptedException,
                                      TwitterAuthenticationException {

        Tweet tweet = account1.composeNewTweet("2MSGAAAAAaa " + new Date().getTime());
        Thread.sleep(1000);
        assertEquals(1, storage.size());
        assertTrue(storage.contain(tweet.getId()));
    }

    @Test
    public void testAddReplyTweetFromOther( ) throws TwitterActionException,
                                             InterruptedException,
                                             TwitterAuthenticationException {

        Tweet tweet = account1.composeNewTweet("2MSGAAAAAaa " + new Date().getTime());
        Tweet replyTweet = account2.composeNewReplyTweet("reply " + new Date().getTime(), tweet);
        Thread.sleep(1000);
        assertEquals(2, storage.size());
        assertTrue(storage.contain(tweet.getId()));
        assertTrue(storage.contain(replyTweet.getId()));
    }

    @Test
    public void testAddReplyTweetForOther( ) throws TwitterActionException,
                                            InterruptedException,
                                            TwitterAuthenticationException {

        Tweet tweet = account2.composeNewTweet("2MSGAAAAAaa " + new Date().getTime());
        Tweet replyTweet = account1.composeNewReplyTweet("reply " + new Date().getTime(), tweet);
        Thread.sleep(1000);
        assertEquals(1, storage.size());
        assertTrue(storage.contain(replyTweet.getId()));
    }

    @Test
    public void testAddRetweetOther( ) throws TwitterActionException,
                                      InterruptedException,
                                      TwitterAuthenticationException {

        Tweet tweet = account2.composeNewTweet("2MSGAAAAAaa " + new Date().getTime());
        Tweet retweetTweet = account1.composeNewReTweet(tweet);
        Thread.sleep(1000);
        assertEquals(1, storage.size());
        assertTrue(storage.contain(retweetTweet.getId()));
    }

    @Test
    public void testAddRetweetOwner( ) throws TwitterActionException,
                                      InterruptedException,
                                      TwitterAuthenticationException {

        Tweet tweet = account1.composeNewTweet("2MSGAAAAAaa " + new Date().getTime());
        Tweet retweetTweet = account2.composeNewReTweet(tweet);
        Thread.sleep(1000);
        assertEquals(2, storage.size());
        assertTrue(storage.contain(tweet.getId()));
        assertTrue(storage.contain(retweetTweet.getId()));
    }

    @Test
    public void testDeleteTweetByOwner( ) throws TwitterActionException, InterruptedException {
        Tweet tweet = account1.composeNewTweet("QQQMSGAAAAAaa " + new Date().getTime());
        Thread.sleep(1000);
        assertEquals(1, storage.size());

        account1.deleteTweet(tweet);

        Thread.sleep(1000);
        assertEquals(0, storage.size());
    }

    @Test
    public void testDeleteReplyTweetByOther( ) throws TwitterActionException, InterruptedException {
        Tweet tweet = account1.composeNewTweet("2MSGAAAAAaa " + new Date().getTime());
        Tweet replyTweet = account2.composeNewReplyTweet("reply " + new Date().getTime(), tweet);
        Thread.sleep(1000);
        assertEquals(2, storage.size());

        account2.deleteTweet(replyTweet);

        Thread.sleep(1000);
        assertEquals(1, storage.size());
        assertTrue(!storage.contain(replyTweet.getId()));
    }

}
