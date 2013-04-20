package com.pk.cwierkacz.twitter.converters;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;

public class TwitterAcountConverter
{
    public TwitterAccountDao toAccount( twitter4j.User tweetUser ) {
        //TODO zamiast tworzenia trzeba czytac z bazy !!!!!!!!!!!!!!
        return TwitterAccountDao.create(tweetUser.getId(), 0, tweetUser.getScreenName(), null, null);
    }
}
