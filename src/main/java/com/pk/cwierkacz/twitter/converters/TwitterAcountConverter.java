package com.pk.cwierkacz.twitter.converters;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;

public class TwitterAcountConverter
{
    public TwitterAccountDao toAccount( twitter4j.User tweetUser ) {
        //TODO zamiast tworzenia trzeba czytac z bazy !!!!!!!!!!!!!!
        UserDao userDao = new UserDao();
        return TwitterAccountDao.create(tweetUser.getId(), userDao, tweetUser.getScreenName(), null, null);
    }
}
