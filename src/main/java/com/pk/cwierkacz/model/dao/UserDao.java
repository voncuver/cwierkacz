package com.pk.cwierkacz.model.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( unique = false, nullable = false )
    private String name;

    private String password;

    @JsonBackReference
    @Fetch( value = FetchMode.SUBSELECT )
    @ManyToMany( fetch = FetchType.EAGER,
                 targetEntity = TwitterAccountDao.class,
                 mappedBy = "user",
                 cascade = {CascadeType.ALL} )
    private Set<TwitterAccountDao> accounts = new HashSet<TwitterAccountDao>();

    @JsonBackReference
    @OneToMany( fetch = FetchType.EAGER,
                targetEntity = BridgeAccountDao.class,
                mappedBy = "user",
                cascade = {CascadeType.ALL} )
    private final Set<BridgeAccountDao> bridgeAccounts = new HashSet<BridgeAccountDao>();

    private boolean isDeleted;

    @OneToOne( cascade = CascadeType.ALL )
    private SessionDao session;

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @Column( unique = false, nullable = false )
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

    public Set<BridgeAccountDao> getBridgeAccounts( ) {
        return bridgeAccounts;
    }

    public Set<TwitterAccountDao> getAccounts( ) {
        return new HashSet<>(accounts);
    }

    public void setAccounts( Set<TwitterAccountDao> accounts ) {
        this.accounts = accounts;

    }

    public SessionDao getSession( ) {
        return session;
    }

    public void setSession( SessionDao session ) {
        this.session = session;
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

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( ( obj == null ) || ( obj.getClass() != this.getClass() ) )
            return false;
        UserDao userDao = (UserDao) obj;
        return userDao.getName().equals(name);
    }

    @Override
    public int hashCode( ) {
        return name.hashCode();
    }

}
