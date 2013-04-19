package com.tguzik.cwierkacz.twitter.converters;

import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;

public class UserConverter
{
    public FunctionalAccount toModelUser( twitter4j.User tweetUser ) {
        //TODO maybe we should get user from DB if exist?? Or maybe instead use user object we should create some kind of fake user 
        return FunctionalAccount.create(tweetUser.getId(), 0, tweetUser.getScreenName(), null, null);
    }
}
