package com.pk.cwierkacz.processor.handlers.helpers;

import java.util.List;

import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TwitterAccountService;

public class AccountPermissionValidator
{

    public static boolean checkPermissionForName( List<Account> list, long tokenId ) {
        boolean perm = true;
        for ( Account name : list ) {
            if ( checkPermissionForName(name.getLogin(), tokenId) == false )
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
        UserAccounts userAccounts = new UserAccounts(tokenId);
        if ( userAccounts.getTwitterAccounts().contains(account) )
            return true;
        else
            return false;

    }

}
