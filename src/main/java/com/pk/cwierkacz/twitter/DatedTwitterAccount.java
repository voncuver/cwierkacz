package com.pk.cwierkacz.twitter;

import org.joda.time.DateTime;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;

/**
 * contain TwitterAccount after authenticate and date when authenticate was
 * occurred. If timeout was expired then re-authenticate
 * 
 * @author radek
 * 
 */
public class DatedTwitterAccount
{
    private final int timeout = 600; //in minutes

    private final TwitterAccount account;

    private final DateTime authenticateDate;

    private DatedTwitterAccount( TwitterAccount account, DateTime authenticateDate ) {
        this.account = account;
        this.authenticateDate = authenticateDate;
    }

    public TwitterAccount getAccount( ) {
        return account;
    }

    public DateTime getAuthenticateDate( ) {
        return authenticateDate;
    }

    public boolean expired( ) {
        if ( authenticateDate.plusMinutes(timeout).isBefore(new DateTime()) )
            return true;
        else
            return false;
    }

    public DatedTwitterAccount refresh( ) throws TwitterAuthenticationException {
        return new DatedTwitterAccount(new TwitterAccount(account.getAccount()), new DateTime());
    }

    public static DatedTwitterAccount create( TwitterAccountDao dao ) throws TwitterAuthenticationException {
        return new DatedTwitterAccount(new TwitterAccount(dao), new DateTime());
    }

}
