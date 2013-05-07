package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;

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

    public TweetDao getLastActualTweetForAccount( TwitterAccountDao account, DateTime since ) {
        List<TweetDao> t = getActualTweetForAccount(account, null, null, 1);
        if ( t.size() >= 1 )
            return t.get(0);
        else
            return null;
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualTweetForAccount( TwitterAccountDao account,
                                                    DateTime since,
                                                    DateTime to,
                                                    Integer maxResult ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("creator", account))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));

        if ( maxResult != null && maxResult > 0 )
            criteria = criteria.setMaxResults(maxResult);

        if ( since != null )
            criteria = criteria.add(Restrictions.ge("cratedDate", since));

        if ( to != null )
            criteria = criteria.add(Restrictions.ge("cratedDate", to));

        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualTweetForAccounts( List<TwitterAccountDao> accounts,
                                                     DateTime since,
                                                     DateTime to,
                                                     Integer maxResult ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.in("creator", accounts))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));

        if ( maxResult != null && maxResult > 0 )
            criteria = criteria.setMaxResults(maxResult);
        if ( since != null )
            criteria = criteria.add(Restrictions.ge("cratedDate", since));

        if ( to != null )
            criteria = criteria.add(Restrictions.ge("cratedDate", to));

        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualRetweets( TweetDao retweeted ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("retweeted", retweeted))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));

        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    public TweetDao getLastActualReplies( TweetDao inReplyTo ) {
        List<TweetDao> t = getActualReplies(inReplyTo);
        if ( t.size() >= 1 )
            return t.get(0);
        else
            return null;
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualReplies( TweetDao inReplyTo ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("inReplyTo", inReplyTo))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));

        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

}
