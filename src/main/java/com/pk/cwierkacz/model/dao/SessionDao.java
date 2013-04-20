package com.pk.cwierkacz.model.dao;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Session" )
public class SessionDao
{
    //TODO 16: zamiast idka userId referencja

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    private long userId;

    private Timestamp lastActive;

    private long currentToken;

    public long getUserId( ) {
        return userId;
    }

    public Timestamp getLastActive( ) {
        return lastActive;
    }

    public void setUserId( long userId ) {
        this.userId = userId;
    }

    public void setLastActive( Timestamp lastActive ) {
        this.lastActive = lastActive;
    }

    public long getCurrentToken( ) {
        return currentToken;
    }

    public void setCurrentToken( long currentToken ) {
        this.currentToken = currentToken;
    }
}
