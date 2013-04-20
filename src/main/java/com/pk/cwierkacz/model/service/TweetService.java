package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import com.pk.cwierkacz.model.dao.TweetDao;

public class TweetService extends AbstractService<TweetDao>
{

    public TweetService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getTweets( ) {
        Criteria criteria = getCriteria(TweetDao.class);
        return criteria.list();
    }

}
