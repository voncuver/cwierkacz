package com.pk.cwierkacz.model.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Data access object of system user - contain many twitter account
 * 
 */
@Entity
@Table( name = "Users" )
public class UserDao
{
    //TODO 1: dodać adnotacje do accounts i przetestowac
    //TODO 2: szyfrowanie password

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    private String name;

    private String password;

    private List<TwitterAccountDao> accounts;

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

    public List<TwitterAccountDao> getAccounts( ) {
        return accounts;
    }

    public void setAccounts( List<TwitterAccountDao> accounts ) {
        this.accounts = accounts;

    }

    public static UserDao create( long id, String name, String accessToken, String accessTokenSecret ) {
        UserDao user = new UserDao();
        user.setId(id);
        user.setName(name);
        return user;
    }

}
