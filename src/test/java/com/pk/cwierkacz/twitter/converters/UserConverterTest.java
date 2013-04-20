package com.pk.cwierkacz.twitter.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import org.junit.Before;
import org.junit.Test;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;

public class UserConverterTest
{

    @Before
    public void setUp( ) throws Exception {
    }

    @Test
    public void toModelUserTest( ) {
        TwitterAcountConverter converter = new TwitterAcountConverter();

        twitter4j.User tweetUser = mock(twitter4j.User.class);
        stub(tweetUser.getId()).toReturn(77L);
        stub(tweetUser.getScreenName()).toReturn("test name");

        TwitterAccountDao account = converter.toAccount(tweetUser);
        assertEquals(account.getId().longValue(), tweetUser.getId());
        assertEquals(account.getId().longValue(), 77);
        assertEquals(account.getAccountName(), tweetUser.getScreenName());
        assertEquals(account.getAccountName(), "test name");
    }
}
