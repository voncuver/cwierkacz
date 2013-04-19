package com.pk.cwierkacz.twitter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.pk.cwierkacz.model.dao.UserDao;

// important! This class contain no-automatic tests, because to authenticate
// user we must put PIN manually
public class OAuthAuthenticationTest
{

    //external identifier of User is a FAKE
    private UserDao user;
    private OAuthAuthentication userAuthentication;

    @Before
    public void setUp( ) throws Exception {
        user = UserDao.create(22L, 0, "cwierkacz1", null, null);
        userAuthentication = new OAuthAuthentication(user);
    }

    @Test
    public void testIsAuthenticate( ) {
        assertFalse(userAuthentication.isAuthenticate());
    }

    @Test
    public void getAuthenticationURLTest( ) throws TwitterAuthenticationException {
        String url = userAuthentication.getAuthenticationURL();
        assertTrue(url.startsWith("http://api.twitter.com/oauth/authenticate?oauth_token="));

    }

    @Test( expected = TwitterAuthenticationException.class )
    public void authenticateWithoutRequesting( ) throws TwitterAuthenticationException {
        userAuthentication.authenticate("3333");
    }

    @Test( expected = TwitterAuthenticationException.class )
    public void authenticateWitRequesting( ) throws TwitterAuthenticationException {
        String url = userAuthentication.getAuthenticationURL();
        userAuthentication.authenticate("3333");
    }

    //NO AUTOMATIC TEST - probably to MOVE from this class
    //Tomek: Ok, now here's a little philosophy question, why do we have manual tests in our automatic unit test suite? :) (Added @Ignore)
    @Test
    @Ignore
    public void testComplexAuthentication( ) throws IOException,
                                            TwitterAuthenticationException,
                                            InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your twitter username: for example 'cwierkacz1'");
        String username = br.readLine();
        user = UserDao.create(22L, 0, username, null, null);
        userAuthentication = new OAuthAuthentication(user);

        String url = userAuthentication.getAuthenticationURL();
        System.out.println("Belows you see a OAuth URL - copy it to your browser, next login to your twitter account and next grant access for this application to manage your account");
        System.out.println(url);

        System.out.print("Enter the PIN:");
        String pin = br.readLine();
        user = userAuthentication.authenticate(pin, true);

        System.out.println("Access Token : " + user.getAccessToken());
        System.out.println("Access Token Secret: " + user.getAccessTokenSecret());

        assertTrue(userAuthentication.isAuthenticate());
    }

}
