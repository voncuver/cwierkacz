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

    private long accessToken;

    private long accessTokenSecret;

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

    public Long getAccessToken( ) {
        return accessToken;
    }

    public void setAccessToken( long accessToken ) {
        this.accessToken = accessToken;
    }

    public Long getAccessTokenSecret( ) {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret( long accessTokenSecret ) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public static UserDao create( long id2, int i, String name2, Object object, Object object2 ) {
        // TODO Auto-generated method stub
        return null;
    }

    public int getCustomerId( ) {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean isOAuthAvailable( ) {
        // TODO Auto-generated method stub
        return false;
    }

}