package com.pk.cwierkacz.processor.handlers.helpers;

import java.util.List;

import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;

public class AccountManager
{
    private List<Account> twitterAccounts;

    private List<Account> bridgeAccounts;

    private List<String> twitterAccountLogins;

    //

    public AccountManager( List<Account> accounts ) {
        accountsForMultipleTypes(accounts);
    }

    public AccountManager( List<Account> accounts, long tokenId ) {
        if ( accounts.size() != 0 )
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
        //TODO for bridge accounts
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
