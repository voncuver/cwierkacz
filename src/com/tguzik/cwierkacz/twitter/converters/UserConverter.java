package com.tguzik.cwierkacz.twitter.converters;

import com.tguzik.cwierkacz.cache.dataobject.User;

public class UserConverter
{
    public User toModelUser( twitter4j.User tweetUser ) {
        //TODO maybe we should get user from DB if exist?? Or maybe instead use user object we should create some kind of fake user 
        return User.create(tweetUser.getId(), tweetUser.getName());
    }
}
