package com.tguzik.cwierkacz.twitter.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import org.junit.Before;
import org.junit.Test;

import com.tguzik.cwierkacz.cache.dataobject.User;

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
        stub(tweetUser.getName()).toReturn("test name");

        User user = converter.toModelUser(tweetUser);
        assertEquals(new Long(user.getExternalId()), new Long(tweetUser.getId()));
        assertEquals(new Long(user.getExternalId()), new Long(77));
        assertEquals(user.getName(), tweetUser.getName());
        assertEquals(user.getName(), "test name");
    }
}
