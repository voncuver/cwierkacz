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
import org.codehaus.jackson.annotate.JsonManagedReference;

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

    @Id
    @Column( length = 255 )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( unique = true, nullable = false )
    private Long externalId;

    @JsonManagedReference
    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( nullable = true, name = "user", referencedColumnName = "id" )
    //moze byc account bez usera - takiego nie śledzimy, ale może mieć tweety
    private UserDao user;
    @Column( unique = false, nullable = false )
    private String accountName;
    @Column( nullable = false )
    private String name;
    private String accessToken;
    private String accessTokenSecret;

    @OneToMany( fetch = FetchType.LAZY,
                targetEntity = TweetDao.class,
                mappedBy = "creator",
                cascade = {CascadeType.ALL} )
    private Set<TweetDao> tweets;

    private boolean isDeleted;

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public UserDao getUser( ) {
        return user;
    }

    public void setUser( UserDao userId ) {
        this.user = userId;
    }

    @Column( unique = true, nullable = false )
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
        return this.user.getId();
    }

    @Transient
    public boolean isOAuthAvailable( ) {
        return !StringUtils.isEmpty(accessToken) && !StringUtils.isEmpty(accessTokenSecret);
    }

    public static TwitterAccountDao create( long externalId,
                                            UserDao user,
                                            String accountName,
                                            String name,
                                            String accessToken,
                                            String accessTokenSecret ) {
        TwitterAccountDao dao = new TwitterAccountDao();
        dao.setExternalId(externalId);
        dao.setUser(user);
        dao.setAccountName(accountName);
        dao.setAccessToken(accessToken);
        dao.setAccessTokenSecret(accessTokenSecret);
        dao.setName(name);

        return dao;
    }

    public boolean isDeleted( ) {
        return isDeleted;
    }

    public void setDeleted( boolean isDeleted ) {
        this.isDeleted = isDeleted;
    }

    @Column( unique = true, nullable = false )
    public Long getExternalId( ) {
        return externalId;
    }

    public void setExternalId( Long externalId ) {
        this.externalId = externalId;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( ( obj == null ) || ( obj.getClass() != this.getClass() ) )
            return false;
        TwitterAccountDao twitterAccountDao = (TwitterAccountDao) obj;
        return twitterAccountDao.getExternalId().equals(externalId);
    }

    @Override
    public int hashCode( ) {
        return externalId.intValue();
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}
