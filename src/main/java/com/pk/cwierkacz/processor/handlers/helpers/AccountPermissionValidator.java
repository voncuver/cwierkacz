package com.pk.cwierkacz.processor.handlers.helpers;

import java.util.List;

import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.BridgeAccountDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.BridgeAccountService;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TwitterAccountService;

public class AccountPermissionValidator
{

    public static boolean checkPermissionForName( List<Account> list, long tokenId ) {

        if ( list == null )
            return true;

        boolean perm = true;
        for ( Account account : list ) {
            if ( checkPermissionForName(account.getLogin(), account.getType(), tokenId) == false )
                perm = false;
        }
        return perm;
    }

    public static boolean checkPermissionForName( String accountName, AccountType accountType, long tokenId ) {
        TwitterAccountService accountService = ServiceRepo.getInstance()
                                                          .getService(TwitterAccountService.class);
        BridgeAccountService bridgeAccountService = ServiceRepo.getInstance()
                                                               .getService(BridgeAccountService.class);

        if ( accountType == AccountType.TWITTER )
            return checkPermission(accountService.getAccountByName(accountName), tokenId);
        else
            return checkPermission(bridgeAccountService.getAccountByName(accountName, accountType), tokenId);

    }

    private static boolean checkPermission( TwitterAccountDao account, long tokenId ) {
        UserAccounts userAccounts = new UserAccounts(tokenId);
        if ( userAccounts.getTwitterAccounts().contains(account) )
            return true;
        else
            return false;

    }

    private static boolean checkPermission( BridgeAccountDao account, long tokenId ) {
        UserAccounts userAccounts = new UserAccounts(tokenId);
        if ( userAccounts.getBridgesAccounts().contains(account) )
            return true;
        else
            return false;

    }

}
