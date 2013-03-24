package com.tguzik.cwierkacz.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.tguzik.cwierkacz.cache.dataobject.User;

public class OAuthAuthentication
{

    private final User user;

    private RequestToken requestToken;

    private final Twitter twitter;

    private final Logger log = LoggerFactory.getLogger(OAuthAuthentication.class);

    /**
     * initialize user authentication service
     * 
     * @param user
     *            user which we wont authenticate
     */
    public OAuthAuthentication( User user ) {
        this.user = user;
        TwitterFactory factory = new TwitterFactory();
        this.twitter = factory.getInstance();
    }

    /**
     * get information about if user is authenticate - in other words we check
     * if user have saved access token and secret
     */
    public boolean isAuthenticate( ) {
        if ( user.getAccessToken() == null || user.getAccessTokenSecret() == null )
            return false;
        else
            return true;
    }

    /**
     * This method return URL where user may get PIN to app
     * 
     * @throws TwitterAuthenticationException
     */
    public String getAuthenticationURL( ) throws TwitterAuthenticationException {
        try {
            requestToken = twitter.getOAuthRequestToken();
            return requestToken.getAuthenticationURL();
        }
        catch ( TwitterException e ) {
            log.error(e.getMessage());
            throw new TwitterAuthenticationException("Request token generation failure");
        }
    }

    /**
     * Authenticate current user.
     * 
     * @param pin
     *            PIN which user must put. Method getAuthenticationURL() allow
     *            user get this PIN
     * @param forceAuthorizations
     *            If false and if user is authenticate before do method do
     *            nothing.
     * @return user with access token and access token secret
     * @throws TwitterAuthenticationException
     */
    public User authenticate( String pin, boolean forceAuthorizations ) throws TwitterAuthenticationException {
        if ( isAuthenticate() && !forceAuthorizations )
            return user;

        try {
            AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, pin);
            user.grantAccess(accessToken.getToken(), accessToken.getTokenSecret());
            return user;
        }
        catch ( TwitterException e ) {
            log.error(e.getMessage());
            throw new TwitterAuthenticationException("Access token generation failure");
        }
        catch ( IllegalStateException e ) {
            log.error(e.getMessage());
            throw new TwitterAuthenticationException("Access token generation failure - no token available");
        }

    }

    /**
     * Authenticate current user. If user is authenticate before do nothing.
     * 
     * @param pin
     *            PIN which user must put. Method getAuthenticationURL() allow
     *            user get this PIN
     * @return user with access token and access token secret
     * @throws TwitterAuthenticationException
     */
    public User authenticate( String pin ) throws TwitterAuthenticationException {
        return authenticate(pin, false);
    }
}
