package com.pk.cwierkacz.twitter.converters;

import twitter4j.StatusUpdate;

import com.google.common.base.Function;
import com.pk.cwierkacz.model.dao.TweetDao;

class ToStatusUpdateConverter implements Function<TweetDao, StatusUpdate>
{

    @Override
    public StatusUpdate apply( TweetDao input ) {
        // TODO Auto-generated method stub
        return null;
    }

}
