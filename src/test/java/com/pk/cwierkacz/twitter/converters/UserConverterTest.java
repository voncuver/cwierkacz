package com.pk.cwierkacz.twitter.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import org.junit.Before;
import org.junit.Test;

import com.pk.cwierkacz.model.dao.UserDao;

public class UserConverterTest
{

    @Before
    public void setUp( ) throws Exception {
    }

    @Test
    public void toModelUserTest( ) {
        UserConverter converter = new UserConverter();

        twitter4j.User tweetUser = mock(twitter4j.User.class);
        stub(tweetUser.getId()).toReturn(77L);
        stub(tweetUser.getScreenName()).toReturn("test name");

        UserDao user = converter.toModelUser(tweetUser);
        assertEquals(user.getId(), tweetUser.getId());
        assertEquals(user.getId(), 77);
        assertEquals(user.getName(), tweetUser.getScreenName());
        assertEquals(user.getName(), "test name");
    }
}
