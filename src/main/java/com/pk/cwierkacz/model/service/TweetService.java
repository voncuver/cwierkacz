package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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

    public List<TweetDao> getActualTweets( ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("isDeleted", false));
        return criteria.list();
    }

    public TweetDao getTweetById( Long id ) {
        Criteria criteria = getCriteria(TweetDao.class);
        criteria.add(Restrictions.eq("Id", id));
        return (TweetDao) criteria.uniqueResult();
    }

    public TweetDao getByExternalId( Long id ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("externalId", id));
        return (TweetDao) criteria.uniqueResult();
    }
}
