package com.pk.cwierkacz.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Data access object of Tweet (no matter if is reTweet, replyTweet or new
 * no-reply Tweet or no-replyTweet)
 * 
 */
@Entity
@Table( name = "Tweets" )
public class TweetDao
{
    //TODO 15: dodać odpowiednie metody moze zamiast publicznych setterow aby robily od razu wiazanie w dwie strony? - jak uwazasz  - mozna stworzyc jakies buildery, ale moze nie w dao tylko poza

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long Id;

    @Column( unique = true, nullable = false )
    private Long externalId;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( nullable = true, name = "inReplyTo", referencedColumnName = "id" )
    private TweetDao inReplyTo;

    @Transient
    private Long inReplyToExtId;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( nullable = true, name = "retweeted", referencedColumnName = "id" )
    private TweetDao retweeted;

    @Transient
    private Long retweetedExtId;

    @OneToMany( fetch = FetchType.EAGER,
                targetEntity = TweetDao.class,
                mappedBy = "inReplyTo",
                cascade = {CascadeType.ALL} )
    private List<TweetDao> replies;

    @OneToMany( fetch = FetchType.EAGER,
                targetEntity = TweetDao.class,
                mappedBy = "retweeted",
                cascade = {CascadeType.ALL} )
    private List<TweetDao> retweets;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( nullable = false, name = "creator", referencedColumnName = "id" )
    private TwitterAccountDao creator;

    @Column
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime" )
    private DateTime cratedDate;
    private String text;

    private boolean isDeleted;

    @Transient
    public List<TweetDao> getActualReplies( ) {
        List<TweetDao> actual = new ArrayList<TweetDao>();
        for ( TweetDao r : getReplies() ) {
            actual.add(r);
        }
        return actual;
    }

    @Transient
    public List<TweetDao> getActualRetweets( ) {
        List<TweetDao> actual = new ArrayList<TweetDao>();
        for ( TweetDao r : getRetweets() ) {
            actual.add(r);
        }
        return actual;
    }

    public Long getId( ) {
        return Id;
    }

    public void setId( Long id ) {
        Id = id;
    }

    public TweetDao getInReplyTo( ) {
        return inReplyTo;
    }

    public void setInReplyTo( TweetDao inReplyTo ) {
        this.inReplyTo = inReplyTo;
    }

    public TwitterAccountDao getCreator( ) {
        return creator;
    }

    public void setCreator( TwitterAccountDao creator ) {
        this.creator = creator;
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

    public TweetDao getRetweeted( ) {
        return retweeted;
    }

    public void setRetweeted( TweetDao retweeted ) {
        this.retweeted = retweeted;
    }

    @Transient
    public Long getInReplyToValue( ) {
        return inReplyTo.getId();
    }

    @Transient
    public Long getRetweetedIdValue( ) {
        return retweeted.getId();
    }

    @Transient
    public Long getCreatorIdValue( ) {
        return creator.getId();
    }

    @Transient
    public String getCreatorName( ) {
        return creator.getAccountName();
    }

    public static TweetDao create( Long externalId,
                                   TwitterAccountDao creator,
                                   TweetDao inReplyToStatus,
                                   TweetDao retweeted,
                                   DateTime convertDateUTC,
                                   String text ) {
        TweetDao t = new TweetDao();
        t.setCratedDate(convertDateUTC);
        t.setCreator(creator);
        t.setExternalId(externalId);
        t.setInReplyTo(inReplyToStatus);
        t.setText(text);
        t.setRetweeted(retweeted);

        return t;
    }

    public List<TweetDao> getReplies( ) {
        return replies;
    }

    public void setReplies( List<TweetDao> replies ) {
        this.replies = replies;
    }

    public List<TweetDao> getRetweets( ) {
        return retweets;
    }

    public void setRetweets( List<TweetDao> retweets ) {
        this.retweets = retweets;
    }

    public boolean isDeleted( ) {
        return isDeleted;
    }

    public void setDeleted( boolean isDeleted ) {
        this.isDeleted = isDeleted;
    }

    @Column( unique = true, nullable = false )
    public Long getExternalId( ) {
        return externalId;
    }

    public void setExternalId( Long externalId ) {
        this.externalId = externalId;
    }

    @Transient
    public Long getInReplyToExtId( ) {
        if ( inReplyTo != null )
            return inReplyTo.getExternalId();
        else
            return inReplyToExtId;
    }

    public void setInReplyToExtId( Long inReplyToId ) {
        this.inReplyToExtId = inReplyToId;
    }

    @Transient
    public Long getRetweetedExtId( ) {
        if ( retweeted != null )
            return retweeted.getExternalId();
        else
            return retweetedExtId;
    }

    public void setRetweetedExtId( Long retweetedId ) {
        this.retweetedExtId = retweetedId;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( ( obj == null ) || ( obj.getClass() != this.getClass() ) )
            return false;
        TweetDao tweetDao = (TweetDao) obj;
        return tweetDao.getExternalId().equals(externalId);
    }

    @Override
    public int hashCode( ) {
        return externalId.intValue();
    }

}
