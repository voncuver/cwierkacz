package com.pk.cwierkacz.http.response.dto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import pl.edu.pk.ias.types.Item;

import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SettingsService;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.utils.DateUtil;

public class Message implements Comparable<Message>
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

    private DateTime createdDate;

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

    public DateTime getCreatedDate( ) {
        return createdDate;
    }

    public void setCreatedDate( DateTime createdDate ) {
        this.createdDate = createdDate;
    }

    private static String pathToUrl( String path ) {
        final SettingsService settingsService = ServiceRepo.getInstance().getService(SettingsService.class);

        if ( path == null )
            return null;
        else {
            String newPath = path;
            if ( path.endsWith(File.separator) )
                newPath = path.substring(0, path.length() - 1);
            String partialUrl = newPath.replace(File.separator, "/");
            return settingsService.getAppAddress() + partialUrl;

        }
    }

    public static Message apply( TweetDao tweetDao ) {
        TweetService tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        Message tweet = new Message();
        Account account = new Account();
        if ( tweetDao.getCreator() != null ) {
            account.setLogin(tweetDao.getCreator().getAccountName());
            account.setName(tweetDao.getCreator().getName());
        }
        account.setType(AccountType.TWITTER);
        tweet.setAccount(account);
        tweet.setCreatedDate(tweetDao.getCratedDate());
        tweet.setDeleted(tweetDao.isDeleted());
        tweet.setId(tweetDao.getId());

        tweet.setImagePath(pathToUrl(tweetDao.getImagePath()));

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

    public static Message apply( String accountName, AccountType accountType, String path, Item item ) {

        Message tweet = new Message();
        Account account = new Account(accountName, accountName, accountType);
        tweet.setAccount(account);
        tweet.setCreatedDate(DateUtil.convertDateUTC(item.getDate())); //TODO jak już będzie data w itemie to tutaj dodac!!
        tweet.setDeleted(false);
        tweet.setId(Long.parseLong(item.getId().getId()));
        tweet.setImagePath(pathToUrl(path));
        tweet.setInReplyToId(null);
        tweet.setRetweetedId(null);
        tweet.setText(item.getMessage());
        tweet.setNbOfReplies(0L);
        tweet.setNbOfRetweets(0L);

        return tweet;

    }

    @Override
    public int compareTo( Message o ) {
        if ( this.createdDate == null && o.createdDate == null )
            return 0;
        if ( this.createdDate == null && o.createdDate != null )
            return 1;
        if ( this.createdDate != null && o.createdDate == null )
            return -1;

        if ( this.createdDate.isEqual(o.createdDate) )
            return 0;
        else if ( this.createdDate.isBefore(o.createdDate) )
            return 1;
        else
            return -1;

    }

}
