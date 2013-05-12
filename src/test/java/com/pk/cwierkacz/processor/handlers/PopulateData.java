package com.pk.cwierkacz.processor.handlers;

import java.sql.Timestamp;
import java.util.Date;

import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.SettingsService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.model.service.UserService;
import com.pk.cwierkacz.twitter.TwitterAccount;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

abstract public class PopulateData
{

    protected TwitterAccountService accountService;
    protected SessionService sessionService;
    protected UserService userService;
    protected SettingsService settingsService;

    protected final String username = "cwierkacz1";
    protected final String username2 = "cwierkacz13";
    protected final String username3 = "fake";
    protected final String sysUsername = "cwierkacz";

    protected final long token = 32453534543L;

    protected TwitterAccountDao twitterAccountDao;
    protected TwitterAccountDao twitterAccountDao2;
    protected TwitterAccountDao twitterAccountDao3;
    protected TwitterAccount twitterAccount;
    protected TwitterAccount twitterAccount2;
    protected UserDao userDao;

    protected String consumerKey = "ipOt0R7N7Ds9PTnT8Usfxw";
    protected String consumerSecret = "QDcJjMxF2wx6YNuiy7msid8QV0CjfA64laKSYfihRhU";

    protected String containerPath = System.getProperty("path.container");
    protected String imgPath = System.getProperty("path.img");

    public void populateUserAndAccount( ) throws TwitterAuthenticationException {
        accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
        userService = ServiceRepo.getInstance().getService(UserService.class);
        sessionService = ServiceRepo.getInstance().getService(SessionService.class);
        settingsService = ServiceRepo.getInstance().getService(SettingsService.class);

        String accessToken = "1291752048-EINIa817O7rBs5FTcyQu6dozbgV6KQJx339Cn3I";
        String accessTokenSecret = "sIxeZvvJ0eSxgy3Zj27829De0KI0HytKtPcWrLK9Y";
        long userId = 1291752048;

        String accessToken2 = "1291708484-x2GIuJprsYm4Wf2MWSFvsRYkdVPxUZncUxzKaJw";
        String accessTokenSecret2 = "jxqddQ8NdcFa0uqJJGuQcMgBifjj0us8BX4GNto4YQ";
        long userId2 = 1291708484;

        String accessToken3 = "fake";
        String accessTokenSecret3 = "fake";
        long userId3 = 333333;

        if ( settingsService.getConsumerSettings() == null )
            settingsService.setConsumerSettings(consumerKey, consumerSecret);

        if ( settingsService.getImageSettings() == null )
            settingsService.setImageSettings(imgPath);

        if ( settingsService.getContainerSettings() == null )
            settingsService.setContainerSettings(containerPath);

        userDao = userService.getByUserName(sysUsername);
        if ( userDao == null ) {
            SessionDao session = new SessionDao();
            session.setLastActive(new Timestamp(new Date().getTime()));
            session.setCurrentToken(token);
            sessionService.save(session);

            UserDao user = new UserDao();
            user.setName(sysUsername);
            user.setPassword("pass");
            user.setSession(session);

            userService.save(user);

            twitterAccountDao = accountService.getAccountByName(username);
            if ( twitterAccountDao == null ) {
                TwitterAccountDao account = TwitterAccountDao.create(userId,
                                                                     user,
                                                                     username,
                                                                     accessToken,
                                                                     accessTokenSecret);
                user.getAccounts().add(account);
                accountService.save(account);
            }
            twitterAccountDao2 = accountService.getAccountByName(username2);
            if ( twitterAccountDao2 == null ) {
                TwitterAccountDao account = TwitterAccountDao.create(userId2,
                                                                     user,
                                                                     username2,
                                                                     accessToken2,
                                                                     accessTokenSecret2);
                user.getAccounts().add(account);
                accountService.save(account);
            }

            twitterAccountDao3 = accountService.getAccountByName(username3);
            if ( twitterAccountDao3 == null ) {
                TwitterAccountDao account = TwitterAccountDao.create(userId3,
                                                                     null,
                                                                     username3,
                                                                     accessToken3,
                                                                     accessTokenSecret3);
                user.getAccounts().add(account);
                accountService.save(account);
            }

            userService.saveOrUpdate(user);
        }
        userDao = userService.getByUserName(sysUsername);
        twitterAccountDao = accountService.getAccountByName(username);
        twitterAccountDao2 = accountService.getAccountByName(username2);

        twitterAccount = new TwitterAccount(twitterAccountDao);
        twitterAccount2 = new TwitterAccount(twitterAccountDao2);
    }
}
