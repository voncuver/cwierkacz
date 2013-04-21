package com.pk.cwierkacz.model.dao;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Data access object of system user - contain many twitter account
 * 
 */
@Entity
@Table( name = "Users" )
public class UserDao implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 5884676710697619214L;

    //TODO 2: szyfrowanie password - na poziomie handlera raczej

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    private String password;

    @OneToMany( fetch = FetchType.LAZY,
                targetEntity = TwitterAccountDao.class,
                mappedBy = "user",
                cascade = {CascadeType.ALL} )
    private Set<TwitterAccountDao> accounts;

    private boolean isDeleted;

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

    public Set<TwitterAccountDao> getAccounts( ) {
        return accounts;
    }

    public void setAccounts( Set<TwitterAccountDao> accounts ) {
        this.accounts = accounts;

    }

    public static UserDao create( long id, String name, String accessToken, String accessTokenSecret ) {
        UserDao user = new UserDao();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public boolean isDeleted( ) {
        return isDeleted;
    }

    public void setDeleted( boolean isDeleted ) {
        this.isDeleted = isDeleted;
    }

}
