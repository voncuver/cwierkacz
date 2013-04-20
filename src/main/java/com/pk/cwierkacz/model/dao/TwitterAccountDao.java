package com.pk.cwierkacz.model.dao;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

/**
 * Data access object of single twitter account
 * 
 */
@Entity
@Table( name = "Twitter_Accounts" )
public final class TwitterAccountDao implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -4397008154952109275L;

    //TODO 5: zmodyfikować ciało metody create tak aby nadal przyjmowala userId - ale było to mapowane na Usera - tak stworzony TwitterAccountDao powinien byc z metody crete przed zwrócieniem zapisany w DB - na poziomie DAO nie powinnismy siegac do bazy zeby uzupelnic dane, dane powinny byc raczej dostarczone
    //TODO 6: szyfrowania accessToken i accessTokenSecret - na poziomie handlera

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( length = 255 )
    private Long id;

    @ManyToOne( fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )
    @JoinColumn( nullable = false, name = "userId", referencedColumnName = "id" )
    private UserDao userId;
    private String accountName;
    private String accessToken;
    private String accessTokenSecret;

    @OneToMany( fetch = FetchType.LAZY,
                targetEntity = TweetDao.class,
                mappedBy = "creatorId",
                cascade = {CascadeType.ALL},
                orphanRemoval = true )
    private Set<TweetDao> tweets;

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public UserDao getUserId( ) {
        return userId;
    }

    public void setUserId( UserDao userId ) {
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

    public Set<TweetDao> getTweets( ) {
        return tweets;
    }

    public void setTweets( Set<TweetDao> tweets ) {
        this.tweets = tweets;
    }

    @Transient
    public long getUserIdByValue( ) {
        return this.userId.getId();
    }

    @Transient
    public boolean isOAuthAvailable( ) {
        return !StringUtils.isEmpty(accessToken) && !StringUtils.isEmpty(accessTokenSecret);
    }

    public static TwitterAccountDao create( long externalId,
                                            UserDao userId,
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
}
