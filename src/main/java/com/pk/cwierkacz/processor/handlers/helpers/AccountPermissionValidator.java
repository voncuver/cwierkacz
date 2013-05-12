package com.pk.cwierkacz.processor.handlers.helpers;

import java.util.List;

import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.model.service.UserService;

// TODO jak lepiej dla metod statycznych inicjalizować serwisy? gdzie to robić?
public class AccountPermissionValidator
{

    public static boolean checkPermissionForName( List<String> accountsName, long tokenId ) {
        boolean perm = true;
        for ( String name : accountsName ) {
            if ( checkPermissionForName(name, tokenId) == false )
                perm = false;
        }
        return perm;
    }

    public static boolean checkPermissionForName( String accountsName, long tokenId ) {
        TwitterAccountService accountService = ServiceRepo.getInstance()
                                                          .getService(TwitterAccountService.class);
        return checkPermission(accountService.getAccountByName(accountsName), tokenId);
    }

    public static boolean checkPermission( List<TwitterAccountDao> accounts, long tokenId ) {
        boolean perm = true;
        for ( TwitterAccountDao account : accounts ) {
            if ( checkPermission(account, tokenId) == false )
                perm = false;
        }
        return perm;
    }

    public static boolean checkPermission( TwitterAccountDao account, long tokenId ) {
        UserService userService = ServiceRepo.getInstance().getService(UserService.class);
        SessionService sessionService = ServiceRepo.getInstance().getService(SessionService.class);
        TwitterAccountService accountService = ServiceRepo.getInstance()
                                                          .getService(TwitterAccountService.class);

        SessionDao sessionDao = sessionService.getByToken(tokenId);
        UserDao user = userService.getBySessionId(sessionDao);
        List<TwitterAccountDao> accountsDao = accountService.getAccountsForUser(user);
        if ( accountsDao.contains(account) )
            return true;
        else
            return false;

    }
}
