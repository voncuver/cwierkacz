package com.pk.cwierkacz.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table( name = "Tweets" )
public class Tweet
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long Id;
    private long inReplyTo;
    private long creatorId;
    private DateTime cratedDate;
    private String text;

    public long getId( ) {
        return Id;
    }

    public void setId( long id ) {
        Id = id;
    }

    public long getInReplyTo( ) {
        return inReplyTo;
    }

    public void setInReplyTo( long inReplyTo ) {
        this.inReplyTo = inReplyTo;
    }

    public long getCreatorId( ) {
        return creatorId;
    }

    public void setCreatorId( long creatorId ) {
        this.creatorId = creatorId;
    }

    public DateTime getCratedDate( ) {
        return cratedDate;
    }

    public void setCratedDate( DateTime cratedDate ) {
        this.cratedDate = cratedDate;
    }

    public String getText( ) {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public static Tweet create( long id2,
                                long id3,
                                long inReplyToStatusId,
                                DateTime convertDateUTC,
                                String text2 ) {
        // TODO Auto-generated method stub
        return null;
    }
}
