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
        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualTweets( ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("isDeleted", false));
        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    public TweetDao getTweetById( Long id ) {
        Criteria criteria = getCriteria(TweetDao.class);
        criteria.add(Restrictions.eq("Id", id));
        TweetDao result = (TweetDao) criteria.uniqueResult();
        commit();
        return result;
    }

    public TweetDao getByExternalId( Long id ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("externalId", id));
        TweetDao result = (TweetDao) criteria.uniqueResult();
        commit();
        return result;
    }
}
