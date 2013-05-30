package com.pk.cwierkacz.processor.handlers.helpers;

import java.util.List;

import com.pk.cwierkacz.model.dao.BridgeAccountDao;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.BridgeAccountService;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.model.service.UserService;

public class UserAccounts
{
    UserService userService = ServiceRepo.getInstance().getService(UserService.class);
    SessionService sessionService = ServiceRepo.getInstance().getService(SessionService.class);
    TwitterAccountService accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
    BridgeAccountService bridgeAccountService = ServiceRepo.getInstance()
                                                           .getService(BridgeAccountService.class);

    private final List<TwitterAccountDao> twitterAccounts;
    private final List<BridgeAccountDao> bridgesAccounts;

    //TODO bridgeAccount

    public UserAccounts( long tokenId ) {
        SessionDao sessionDao = sessionService.getByToken(tokenId);
        UserDao user = userService.getBySessionId(sessionDao);
        twitterAccounts = accountService.getAccountsForUser(user);
        bridgesAccounts = bridgeAccountService.getAccountsForUser(user);
    }

    public List<TwitterAccountDao> getTwitterAccounts( ) {
        return twitterAccounts;
    }

    public List<BridgeAccountDao> getBridgesAccounts( ) {
        return bridgesAccounts;
    }

}
