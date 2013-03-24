package com.tguzik.cwierkacz.cache.dataobject;

import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class User extends DataObject
{

    //TODO issue of access token secret security
    //TODO add properties enabling log in by oAuth instead login/password

    private final Long externalId;

    private final String name;

    private String accessToken;

    private String accessTokenSecret;

    @Override
    public UniqueKey getUniqueKey( ) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * returns a name of user
     */
    public String getName( ) {
        return name;
    }

    /**
     * returns a id stored in twitter
     */
    public Long getExternalId( ) {
        return externalId;
    }

    /**
     * create instance of user
     * 
     * @param externalId
     *            Identifier of user - same as stored in twitter db
     * @param name
     *            name of user
     */
    public User( Long externalId, String name ) {
        this.name = name;
        this.externalId = externalId;
    }

    /**
     * returns a access token for this user
     */
    public String getAccessToken( ) {
        return accessToken;
    }

    /**
     * returns a access token secret for this user
     */
    public String getAccessTokenSecret( ) {
        return accessTokenSecret;
    }

    /**
     * Method which grant acces to user through saving access credentials
     * 
     * @param accessToken
     * @param accessTokenSecret
     */
    public void grantAccess( String accessToken, String accessTokenSecret ) {
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }

    /**
     * returns information if oAuth authentication is available
     */
    public boolean oAuthAuthenticationAvailable( ) {
        if ( accessToken == null || accessTokenSecret == null )
            return false;
        else
            return true;
    }
}
