package com.pk.cwierkacz.model.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

/**
 * Data access object of single twitter account
 * 
 */
@Entity
@Table( name = "Twitter_Accounts" )
public final class TwitterAccountDao
{

    //TODO 3: wywalić pole userId i wprowadzić referencje do Usera + adontacja
    //TODO 4: dodać metode userId zwracajaca id usera
    //TODO 5: zmodyfikować ciało metody create tak aby nadal przyjmowala userId - ale było to mapowane na Usera - tak stworzony TwitterAccountDao powinien byc z metody crete przed zwrócieniem zapisany w DB
    //TODO 6: szyfrowania accessToken i accessTokenSecret
    //TODO 7: adnotacja nad tweets - to powinno byc LAZY

    private Long id;
    private Long userId;
    private String accountName;
    private String accessToken;
    private String accessTokenSecret;
    private List<TweetDao> tweets;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Long getUserId( ) {
        return userId;
    }

    public void setUserId( Long userId ) {
        this.userId = userId;
    }

    public String getAccountName( ) {
        return accountName;
    }

    public void setAccountName( String accountName ) {
        this.accountName = accountName;
    }

    public String getAccessToken( ) {
        return accessToken;
    }

    public void setAccessToken( String accessToken ) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenSecret( ) {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret( String accessTokenSecret ) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public boolean isOAuthAvailable( ) {
        return !StringUtils.isEmpty(accessToken) && !StringUtils.isEmpty(accessTokenSecret);
    }

    public static TwitterAccountDao create( long externalId,
                                            long userId,
                                            String accountName,
                                            String accessToken,
                                            String accessTokenSecret ) {
        TwitterAccountDao dao = new TwitterAccountDao();
        dao.setId(externalId);
        dao.setUserId(userId);
        dao.setAccountName(accountName);
        dao.setAccessToken(accessToken);
        dao.setAccessTokenSecret(accessTokenSecret);

        return dao;
    }

    public List<TweetDao> getTweets( ) {
        return tweets;
    }

    public void setTweets( List<TweetDao> tweets ) {
        this.tweets = tweets;
    }
}
