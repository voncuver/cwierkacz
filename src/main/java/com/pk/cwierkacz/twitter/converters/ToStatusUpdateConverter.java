package com.pk.cwierkacz.twitter.converters;

import twitter4j.StatusUpdate;

import com.google.common.base.Function;
import com.pk.cwierkacz.model.dao.Tweet;

class ToStatusUpdateConverter implements Function<Tweet, StatusUpdate>
{

    @Override
    public StatusUpdate apply( Tweet input ) {
        // TODO Auto-generated method stub
        return null;
    }

}
