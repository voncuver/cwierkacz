package com.pk.cwierkacz.processor.handlers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.AddTweeterAccountRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.BridgeAccountDao;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.BridgeAccountService;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.model.service.UserService;

public class UnwireTweetAcocunt extends AbstractHandler
{

    private final UserService userService;
    private final SessionService sessionService;
    private final TwitterAccountService accountService;
    private final BridgeAccountService bridgeAccountService;

    public UnwireTweetAcocunt() {
        super();
        userService = ServiceRepo.getInstance().getService(UserService.class);
        sessionService = ServiceRepo.getInstance().getService(SessionService.class);
        accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
        bridgeAccountService = ServiceRepo.getInstance().getService(BridgeAccountService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.UNLINKSOCIALACCOUNT);
    }

    @Override
    public void handle( ApplicationData appData ) {
        AddTweeterAccountRequest accRequest = (AddTweeterAccountRequest) appData.getRequest();
        if ( accRequest.getAccountType().getType().equals(AccountType.TWITTER.getType()) ) {
            handleTwitter(appData);
        }
        else {
            handleBridgeAccount(appData);
        }
    }

    private void handleBridgeAccount( ApplicationData appData ) {
        AddTweeterAccountRequest accRequest = (AddTweeterAccountRequest) appData.getRequest();
        SessionDao sessionDao = sessionService.getByToken(accRequest.getTokenId());
        UserDao user = userService.getBySessionId(sessionDao);
        if ( user != null && user.getSession().getCurrentToken() != accRequest.getTokenId() ) {
            Response response = ResponseImpl.create(Status.DENY, "Zły token.", accRequest.getTokenId());
            appData.setResponse(response);
            return;
        }

        Set<BridgeAccountDao> bridgeAccounts = user.getBridgeAccounts();
        BridgeAccountDao accountToremowe = null;

        for ( BridgeAccountDao accountDao : bridgeAccounts ) {
            List<Account> accounts = ssiAdapter.getAccounts(accountDao.getAccessToken(),
                                                            accountDao.getAccountType());
            for ( Account account : accounts ) {
                if ( account.getLogin().equals(accRequest.getLoginTweet()) ) {
                    accountToremowe = accountDao;
                    break;
                }
            }
        }

        if ( accountToremowe != null ) {

            accountToremowe.getUser().remove(user);
            bridgeAccountService.saveOrUpdate(accountToremowe);

            user.getAccounts().remove(accountToremowe);
            userService.saveOrUpdate(user);
        }
        Response response = ResponseImpl.create(Status.OK, "Konto odwiązano.", accRequest.getTokenId());
        appData.setResponse(response);
    }

    private void handleTwitter( ApplicationData appData ) {
        AddTweeterAccountRequest accRequest = (AddTweeterAccountRequest) appData.getRequest();
        SessionDao sessionDao = sessionService.getByToken(accRequest.getTokenId());
        UserDao user = userService.getBySessionId(sessionDao);
        if ( user != null && user.getSession().getCurrentToken() != accRequest.getTokenId() ) {
            Response response = ResponseImpl.create(Status.DENY, "Zły token.", accRequest.getTokenId());
            appData.setResponse(response);
            return;
        }

        Set<TwitterAccountDao> accounts = user.getAccounts();

        Set<TwitterAccountDao> accountsNew = new HashSet<>();
        TwitterAccountDao accountDaoToRemove = null;

        for ( TwitterAccountDao accountDao : accounts ) {
            if ( accountDao.getAccountName().equals(accRequest.getLoginTweet()) ) {
                accountDaoToRemove = accountDao;
            }
            else {
                accountsNew.add(accountDao);
            }
        }

        accountDaoToRemove.getUser().remove(user);
        accountService.saveOrUpdate(accountDaoToRemove);

        user.getAccounts().remove(accountDaoToRemove);
        userService.saveOrUpdate(user);

        Response response = ResponseImpl.create(Status.OK, "Konto odwiązano.", accRequest.getTokenId());
        appData.setResponse(response);
        return;
    }
}
