package com.pk.cwierkacz.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table( name = "Tweets" )
public class TweetDao
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long Id;
    private Long inReplyTo;
    private Long retweetedId;
    private Long creatorId;
    private DateTime cratedDate;
    private String text;
    private String creatorName; // Redundant information, but useful

    public Long getId( ) {
        return Id;
    }

    public void setId( Long id ) {
        Id = id;
    }

    public Long getInReplyTo( ) {
        return inReplyTo;
    }

    public void setInReplyTo( Long inReplyTo ) {
        this.inReplyTo = inReplyTo;
    }

    public Long getCreatorId( ) {
        return creatorId;
    }

    public void setCreatorId( Long creatorId ) {
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

    public String getCreatorName( ) {
        return creatorName;
    }

    public void setCreatorName( String creatorName ) {
        this.creatorName = creatorName;
    }

    public Long getRetweetedId( ) {
        return retweetedId;
    }

    public void setRetweetedId( Long retweetedId ) {
        this.retweetedId = retweetedId;
    }

    public static TweetDao create( Long id,
                                   Long userId,
                                   String username,
                                   Long inReplyToStatusId,
                                   Long retweetedId,
                                   DateTime convertDateUTC,
                                   String text ) {
        TweetDao t = new TweetDao();
        t.setCratedDate(convertDateUTC);
        t.setCreatorId(userId);
        t.setCreatorName(username);
        t.setId(id);
        t.setInReplyTo(inReplyToStatusId);
        t.setText(text);
        t.setRetweetedId(retweetedId);

        return t;
    }

}
