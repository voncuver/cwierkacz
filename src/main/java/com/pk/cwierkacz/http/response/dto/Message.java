package com.pk.cwierkacz.http.response.dto;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import pl.edu.pk.ias.types.Item;

import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;

public class Message
{
    private Long Id;

    private Long inReplyToId;

    private Long retweetedId;

    private Account account;

    private String text;

    private String imagePath;

    private boolean isDeleted;

    private Long nbOfRetweets;

    private Long nbOfReplies;

    private DateTime cratedDate;

    public Long getId( ) {
        return Id;
    }

    public void setId( Long id ) {
        Id = id;
    }

    public Long getInReplyToId( ) {
        return inReplyToId;
    }

    public void setInReplyToId( Long inReplyToId ) {
        this.inReplyToId = inReplyToId;
    }

    public String getText( ) {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public String getImagePath( ) {
        return imagePath;
    }

    public void setImagePath( String imagePath ) {
        this.imagePath = imagePath;
    }

    public boolean isDeleted( ) {
        return isDeleted;
    }

    public void setDeleted( boolean isDeleted ) {
        this.isDeleted = isDeleted;
    }

    public Long getRetweetedId( ) {
        return retweetedId;
    }

    public void setRetweetedId( Long retweetedId ) {
        this.retweetedId = retweetedId;
    }

    public Long getNbOfRetweets( ) {
        return nbOfRetweets;
    }

    public void setNbOfRetweets( Long nbOfRetweets ) {
        this.nbOfRetweets = nbOfRetweets;
    }

    public Long getNbOfReplies( ) {
        return nbOfReplies;
    }

    public void setNbOfReplies( Long nbOfReplies ) {
        this.nbOfReplies = nbOfReplies;
    }

    public Account getAccount( ) {
        return account;
    }

    public void setAccount( Account account ) {
        this.account = account;
    }

    public DateTime getCratedDate( ) {
        return cratedDate;
    }

    public void setCratedDate( DateTime cratedDate ) {
        this.cratedDate = cratedDate;
    }

    public static Message apply( TweetDao tweetDao ) {
        TweetService tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        Message tweet = new Message();
        Account account = new Account();
        if ( tweetDao.getCreator() != null ) {
            account.setLogin(tweetDao.getCreator().getAccountName());
        }
        account.setType(AccountType.TWITTER);
        tweet.setAccount(account);
        tweet.setCratedDate(tweetDao.getCratedDate());
        tweet.setDeleted(tweetDao.isDeleted());
        tweet.setId(tweetDao.getId());
        tweet.setImagePath(tweetDao.getImagePath());

        if ( tweetDao.getInReplyTo() != null )
            tweet.setInReplyToId(tweetDao.getInReplyTo().getId());
        if ( tweetDao.getRetweeted() != null )
            tweet.setRetweetedId(tweetDao.getRetweeted().getId());
        tweet.setText(tweetDao.getText());
        tweet.setNbOfReplies(tweetService.countActualReplies(tweetDao));
        tweet.setNbOfRetweets(tweetService.countActualRetweets(tweetDao));

        return tweet;

    }

    public static List<Message> apply( List<TweetDao> tweetDaos ) {
        List<Message> msgs = new ArrayList<Message>();
        for ( TweetDao dao : tweetDaos ) {
            msgs.add(Message.apply(dao));
        }
        return msgs;
    }

    public static Message apply( String accountName, AccountType accountType, Item item ) {

        //TODO przed uzyciem tego zastanowic sie nad tym,pewnie trzeba cos tu pozmienia, chocby ten file?
        Message tweet = new Message();
        Account account = new Account(accountName, accountType);
        tweet.setAccount(account);
        tweet.setCratedDate(null); //brak daty - przejebane
        tweet.setDeleted(false);
        tweet.setId(item.getId().getId().longValue());
        tweet.setImagePath(null); //TODO co z tym imagem? jak to robic?
        tweet.setInReplyToId(null);
        tweet.setRetweetedId(null);
        tweet.setText(item.getDescription());
        tweet.setNbOfReplies(0L);
        tweet.setNbOfRetweets(0L);

        return tweet;

    }

}
