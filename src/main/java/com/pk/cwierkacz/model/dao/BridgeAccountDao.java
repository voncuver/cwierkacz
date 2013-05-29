package com.pk.cwierkacz.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.pk.cwierkacz.model.AccountType;

@Entity
@Table( name = "BridgeAccount" )
public class BridgeAccountDao
{
    @Id
    @Column( length = 255 )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @JsonManagedReference
    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( nullable = true, name = "user", referencedColumnName = "id" )
    private UserDao user;

    @Column( nullable = false )
    private String name;

    private String accessToken;

    private AccountType accountType;

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public UserDao getUser( ) {
        return user;
    }

    public void setUser( UserDao user ) {
        this.user = user;
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getAccessToken( ) {
        return accessToken;
    }

    public void setAccessToken( String accessToken ) {
        this.accessToken = accessToken;
    }

    public AccountType getAccountType( ) {
        return accountType;
    }

    public void setAccountType( AccountType accountType ) {
        this.accountType = accountType;
    }
}
