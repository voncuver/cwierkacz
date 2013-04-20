package com.pk.cwierkacz.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;

public class OAuthAuthentication
{
    private static final Logger LOGGER = LoggerFactory.getLogger(OAuthAuthentication.class);
    private static final TwitterFactory FACTORY = new TwitterFactory();
    private TwitterAccountDao account;
    private final Twitter twitter;
    private RequestToken requestToken;

    /**
     * initialize user authentication service
     * 
     * @param user
     *            user which we wont authenticate
     */
    public OAuthAuthentication( TwitterAccountDao account ) {
        this.account = account;
        this.twitter = FACTORY.getInstance();
    }

    /**
     * get information about if user is authenticate - in other words we check
     * if user have saved access token and secret
     */
    public boolean isAuthenticate( ) {
        return account.getAccessToken() != null && account.getAccessTokenSecret() != null;
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
            LOGGER.error(e.getMessage());
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
    public TwitterAccountDao authenticate( String pin, boolean forceAuthorizations ) throws TwitterAuthenticationException {
        if ( isAuthenticate() && !forceAuthorizations )
            return account;

        try {
            AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, pin);
            TwitterAccountDao authUser = TwitterAccountDao.create(account.getId(),
                                                                  account.getUserId(),
                                                                  account.getAccountName(),
                                                                  accessToken.getToken(),
                                                                  accessToken.getTokenSecret());
            this.account = authUser;
            return authUser;
        }
        catch ( TwitterException e ) {
            LOGGER.error(e.getMessage());
            throw new TwitterAuthenticationException("Access token generation failure");
        }
        catch ( IllegalStateException e ) {
            LOGGER.error(e.getMessage());
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
    public TwitterAccountDao authenticate( String pin ) throws TwitterAuthenticationException {
        return authenticate(pin, false);
    }
}
