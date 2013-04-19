package com.pk.cwierkacz.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Users" )
public class UserDao
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    private String name;

    private String password;

    private String accessToken;

    private String accessTokenSecret;

    public long getId( ) {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPassword( ) {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
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

    public static UserDao create( long id, int i, String name, String accessToken, String accessTokenSecret ) {
        UserDao user = new UserDao();
        user.setId(id);
        user.setName(name);
        user.setAccessToken(accessToken);
        user.setAccessTokenSecret(accessTokenSecret);
        return user;
    }

    public int getCustomerId( ) {
        // TODO Auto-generated method stub
        // RT comment: what is this ?
        return 0;
    }

    public boolean isOAuthAvailable( ) {
        if ( accessToken != null && accessTokenSecret != null )
            return true;
        else
            return false;
    }

}
