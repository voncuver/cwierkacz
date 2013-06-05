package com.pk.cwierkacz.model.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
    @ManyToMany( fetch = FetchType.EAGER )
    @JoinColumn( nullable = true, name = "user", referencedColumnName = "id" )
    private Set<UserDao> user;

    @Column( nullable = false )
    private String name;

    private String accessToken;

    private AccountType accountType;

    private boolean deleted;

    public boolean isDeleted( ) {
        return deleted;
    }

    public void setDeleted( boolean deleted ) {
        this.deleted = deleted;
    }

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Set<UserDao> getUser( ) {
        return user;
    }

    public void setUser( Set<UserDao> user ) {
        this.user = user;
    }

    public void addUser( UserDao userId ) {
        if ( this.user == null )
            this.user = new HashSet<>();
        this.user.add(userId);
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

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( ( obj == null ) || ( obj.getClass() != this.getClass() ) )
            return false;
        BridgeAccountDao bridgeAccountDao = (BridgeAccountDao) obj;
        return bridgeAccountDao.getName().equals(this.getName()) &&
               bridgeAccountDao.getAccountType().equals(this.getAccountType());
    }

    @Override
    public int hashCode( ) {
        return name.hashCode();
    }
}
