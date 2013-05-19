package com.pk.cwierkacz.twitter.converters;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TwitterAccountService;

public class TwitterAcountConverter
{
    private final TwitterAccountService service = ServiceRepo.getInstance()
                                                             .getService(TwitterAccountService.class);

    public TwitterAccountDao toAccount( twitter4j.User tweetUser ) {
        TwitterAccountDao accountDao = service.getAccountByExternalId(tweetUser.getId());
        if ( accountDao != null )
            return accountDao;
        else {
            return toAccountFromTwitter(tweetUser);
        }
    }

    public TwitterAccountDao toAccountFromTwitter( twitter4j.User tweetUser ) {
        return TwitterAccountDao.create(tweetUser.getId(),
                                        null,
                                        tweetUser.getScreenName(),
                                        tweetUser.getName(),
                                        null,
                                        null);
    }
}
