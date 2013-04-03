package com.tguzik.cwierkacz.twitter.converters;

import twitter4j.StatusUpdate;

import com.google.common.base.Function;
import com.tguzik.cwierkacz.cache.dataobject.Tweet;

class ToStatusUpdateConverter implements Function<Tweet, StatusUpdate>
{

    @Override
    public StatusUpdate apply( Tweet input ) {
        // TODO Auto-generated method stub
        return null;
    }

}
