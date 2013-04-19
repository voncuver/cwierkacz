package com.tguzik.cwierkacz.twitter.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import org.junit.Before;
import org.junit.Test;

import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;

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

        FunctionalAccount user = converter.toModelUser(tweetUser);
        assertEquals(user.getAccountId().toValue(), new Long(tweetUser.getId()));
        assertEquals(user.getAccountId().toValue(), new Long(77));
        assertEquals(user.getAccountName().toValue(), tweetUser.getScreenName());
        assertEquals(user.getAccountName().toValue(), "test name");
    }
}
