package com.pk.cwierkacz.model;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.UserService;

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TwitterServiceTest
{

    @Test
    public void simulateTweeting( ) {
        //create user with one account

        UserDao userDao = new UserDao();
        userDao.setName("111");
        userDao.setPassword("Test");
        TwitterAccountDao twitterAccountDao = TwitterAccountDao.create(24,
                                                                       userDao,
                                                                       "Twitter",
                                                                       "1234",
                                                                       "secret1234");
        Set<TwitterAccountDao> accounts = new HashSet<>();
        accounts.add(twitterAccountDao);
        userDao.setAccounts(accounts);

        UserService service = ServiceRepo.getInstance().getService(UserService.class);
        service.save(userDao);

        //create next user with one account

        UserDao userDao2 = new UserDao();
        userDao2.setName("111");
        userDao2.setPassword("Test");
        TwitterAccountDao twitterAccountDao2 = TwitterAccountDao.create(25,
                                                                        userDao,
                                                                        "Twitter2",
                                                                        "1234",
                                                                        "secret1234");
        Set<TwitterAccountDao> accounts2 = new HashSet<>();
        accounts2.add(twitterAccountDao2);
        userDao2.setAccounts(accounts2);

        service = ServiceRepo.getInstance().getService(UserService.class);
        service.save(userDao2);

        //create new tweet for account1

        TweetDao tweet = TweetDao.create(10L, twitterAccountDao, null, null, new DateTime(), "TEST1");
        TweetService tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        tweetService.save(tweet);
        List<TweetDao> actual = tweetService.getActualTweets();
        assertEquals(1L, actual.size());
        long mainId = actual.get(0).getId();

        //add own reply tweet 
        TweetDao rtweet = TweetDao.create(11L, twitterAccountDao, tweet, null, new DateTime(), "TEST2");
        tweetService.save(rtweet);
        //add reply tweet by other
        TweetDao rtweet2 = TweetDao.create(12L, twitterAccountDao2, tweet, null, new DateTime(), "TEST3");
        tweetService.save(rtweet2);

        TweetDao mainTweet = tweetService.getTweetById(mainId);
        assertEquals(2, mainTweet.getReplies().size());

        //add some retweet
        TweetDao re = TweetDao.create(13L, twitterAccountDao2, null, tweet, new DateTime(), "TEST4");
        tweetService.save(re);
        TweetDao mainTweet2 = tweetService.getTweetById(mainId);
        assertEquals(1, mainTweet2.getRetweets().size());

    }
}
