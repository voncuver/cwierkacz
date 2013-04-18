package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.pk.cwierkacz.model.dao.Tweet;

public class TweetService extends AbstractService<Tweet>
{

    public TweetService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public List<Tweet> getTweets( ) {
        return getListByQuery("From Tweets");
    }

}
