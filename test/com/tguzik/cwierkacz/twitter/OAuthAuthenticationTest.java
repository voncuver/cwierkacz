package com.tguzik.cwierkacz.twitter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

import com.tguzik.cwierkacz.cache.dataobject.User;

// important! This class contain no-automatic tests, because to authenticate
// user we must put PIN manually
public class OAuthAuthenticationTest
{

    //external identifier of User is a FAKE
    private User user;
    private OAuthAuthentication userAuthentication;

    @Before
    public void setUp( ) throws Exception {
        user = new User(22L, "cwierkacz1");
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
    @Test
    public void testComplexAuthentication( ) throws IOException,
                                            TwitterAuthenticationException,
                                            InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your twitter username: for example 'cwierkacz1'");
        String username = br.readLine();
        user = new User(22L, username);
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
