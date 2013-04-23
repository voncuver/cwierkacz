package com.pk.cwierkacz.twitter;

import java.util.HashMap;
import java.util.Map;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;

/**
 * Singleton which contain map of user to TwitterAccount connector
 * 
 * @author radek
 * 
 */
public class TwitterAccountMap
{
    private static volatile TwitterAccountMap instance;

    private final Map<TwitterAccountDao, DatedTwitterAccount> accounts;

    private TwitterAccountMap() {
        accounts = new HashMap<TwitterAccountDao, DatedTwitterAccount>();
    }

    private static TwitterAccountMap getInstance( ) {
        if ( instance == null ) {
            synchronized ( TwitterAccountMap.class ) {
                if ( instance == null ) {
                    instance = new TwitterAccountMap();
                }
            }
        }
        return instance;
    }

    public static TwitterAccount getTwitterAccount( TwitterAccountDao dao ) throws TwitterAuthenticationException {
        if ( getInstance().accounts.containsKey(dao) ) {
            DatedTwitterAccount datedAccount = getInstance().accounts.get(dao);
            if ( datedAccount.expired() ) {
                DatedTwitterAccount refreshedDatedAccount = datedAccount.refresh();
                getInstance().accounts.put(dao, refreshedDatedAccount);
                return refreshedDatedAccount.getAccount();
            }
            else
                return datedAccount.getAccount();
        }
        else {
            DatedTwitterAccount datedAccount = DatedTwitterAccount.create(dao);
            getInstance().accounts.put(dao, datedAccount);
            return datedAccount.getAccount();
        }

    }

}
