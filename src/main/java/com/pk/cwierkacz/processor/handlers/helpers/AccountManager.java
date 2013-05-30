package com.pk.cwierkacz.processor.handlers.helpers;

import java.util.ArrayList;
import java.util.List;

import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.BridgeAccountDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;

public class AccountManager
{
    private final List<Account> twitterAccounts = new ArrayList<Account>();

    private final List<Account> bridgeAccounts = new ArrayList<Account>();

    private final List<String> twitterAccountLogins = new ArrayList<String>();

    public AccountManager( List<Account> accounts ) {
        accountsForMultipleTypes(accounts);
    }

    public AccountManager( List<Account> accounts, long tokenId ) {
        if ( accounts != null && accounts.size() != 0 )
            accountsForMultipleTypes(accounts);
        else
            allAccounts(tokenId);
    }

    private void accountsForMultipleTypes( List<Account> accounts ) {

        for ( Account a : accounts ) {
            if ( a.type.equals(AccountType.TWITTER) ) {
                twitterAccounts.add(a);
                twitterAccountLogins.add(a.login);
            }
            else {
                bridgeAccounts.add(a);
            }
        }

    }

    private void allAccounts( long tokenId ) {
        UserAccounts userAccounts = new UserAccounts(tokenId);
        for ( TwitterAccountDao accountDao : userAccounts.getTwitterAccounts() ) {
            twitterAccounts.add(new Account(accountDao.getAccountName(),
                                            accountDao.getName(),
                                            AccountType.TWITTER));
            twitterAccountLogins.add(accountDao.getAccountName());
        }
        for ( BridgeAccountDao accountDao : userAccounts.getBridgesAccounts() ) {
            bridgeAccounts.add(new Account(accountDao.getName(),
                                           accountDao.getName(),
                                           accountDao.getAccountType()));
        }
    }

    public AccountManager( List<String> accountNames, AccountType type ) {

        accountsForOneType(accountNames, type);
    }

    private void accountsForOneType( List<String> accountNames, AccountType type ) {

        if ( type.equals(AccountType.TWITTER) ) {
            for ( String n : accountNames ) {
                twitterAccountLogins.add(n);
                twitterAccounts.add(new Account(n, null, type));
            }
        }
        else {
            for ( String n : accountNames ) {
                bridgeAccounts.add(new Account(n, null, type));
            }
        }
    }

    public List<Account> getTwitterAccounts( ) {
        return twitterAccounts;
    }

    public List<String> getTwitterAccountLogins( ) {
        return twitterAccountLogins;
    }

    public List<Account> getBridgeAccounts( ) {
        return bridgeAccounts;
    }

}
