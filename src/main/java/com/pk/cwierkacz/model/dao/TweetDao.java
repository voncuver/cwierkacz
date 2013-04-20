package com.pk.cwierkacz.model.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
    //TODO 8: wyrzucić inReplyTo oraz retweetedId zamiast tego wprowadzic referencje do Tweet - zostawiłem bez asocjacji bo nie wiem jaką chcemy, chyba ONE TO ONE będzie ok

    //TODO 12: zmodyfikować ciało metody create tak aby nadal przyjmowala idki (bez username) - ale zapisywala znalezione referencje - zapisywalo w baze i zwracalo - na bazie operuje się przez pakiet service

    //TODO 13: dodać do tej klasy Liste retweetów, Liste replyTweetow - hmm, ciekawe jak to zamodelowac w hibernacie

    //TODO 15: dodać odpowiednie metody moze zamiast publicznych setterow aby robily od razu wiazanie w dwie strony? - jak uwazasz  - mozna stworzyc jakies buildery, ale moze nie w dao tylko poza

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long Id;

    @OneToOne( cascade = CascadeType.ALL )
    private TweetDao inReplyTo;

    @OneToOne( cascade = CascadeType.ALL )
    private TweetDao retweetedId;

    @ManyToOne( fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )
    @JoinColumn( nullable = false, name = "creatorId", referencedColumnName = "id" )
    private TwitterAccountDao creatorId;
    private DateTime cratedDate;
    private String text;

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

    public TwitterAccountDao getCreatorId( ) {
        return creatorId;
    }

    public void setCreatorId( TwitterAccountDao creatorId ) {
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

    public TweetDao getRetweetedId( ) {
        return retweetedId;
    }

    public void setRetweetedId( TweetDao retweetedId ) {
        this.retweetedId = retweetedId;
    }

    @Transient
    public Long getInReplyToValue( ) {
        return inReplyTo.getId();
    }

    @Transient
    public Long getRetweetedIdValue( ) {
        return retweetedId.getId();
    }

    @Transient
    public Long getCreatorIdValue( ) {
        return creatorId.getId();
    }

    @Transient
    public String getCreatorName( ) {
        return creatorId.getAccountName();
    }

    public static TweetDao create( Long id,
                                   TwitterAccountDao userId,
                                   TweetDao inReplyToStatusId,
                                   TweetDao retweetedId,
                                   DateTime convertDateUTC,
                                   String text ) {
        TweetDao t = new TweetDao();
        t.setCratedDate(convertDateUTC);
        t.setCreatorId(userId);
        t.setId(id);
        t.setInReplyTo(inReplyToStatusId);
        t.setText(text);
        t.setRetweetedId(retweetedId);

        return t;
    }

}
