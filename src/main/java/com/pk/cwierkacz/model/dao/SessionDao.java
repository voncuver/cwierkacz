package com.pk.cwierkacz.model.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table( name = "Session" )
public class SessionDao
{
    //TODO 16: zamiast idka userId referencja

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    private long userId;

    @Column
    @Type( type = "org.jadira.usertype.dateandtime.legacyjdk.PersistentTimestamp" )
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
