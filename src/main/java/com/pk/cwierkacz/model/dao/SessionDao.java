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

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column
    @Type( type = "org.jadira.usertype.dateandtime.legacyjdk.PersistentTimestamp" )
    private Timestamp lastActive;

    private long currentToken;

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Timestamp getLastActive( ) {
        return lastActive;
    }

    public void setLastActive( Timestamp lastActive ) {
        this.lastActive = lastActive;
    }

    public long getCurrentToken( ) {
        return currentToken;
    }

    public void setCurrentToken( Long currentToken ) {
        this.currentToken = currentToken;
    }
}
