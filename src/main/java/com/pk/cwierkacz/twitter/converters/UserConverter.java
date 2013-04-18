package com.pk.cwierkacz.twitter.converters;

import com.pk.cwierkacz.model.dao.UserDao;

public class UserConverter
{
    public UserDao toModelUser( twitter4j.User tweetUser ) {
        //TODO maybe we should get user from DB if exist?? Or maybe instead use user object we should create some kind of fake user 
        return UserDao.create(tweetUser.getId(), 0, tweetUser.getName(), null, null);
    }
}
