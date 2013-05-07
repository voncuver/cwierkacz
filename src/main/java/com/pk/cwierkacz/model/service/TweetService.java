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
        List<TweetDao> t = getActualTweetForAccount(account, since, 1);
        if ( t.size() >= 1 )
            return t.get(0);
        else
            return null;
    }

    public List<TweetDao> getActualTweetForAccount( TwitterAccountDao account, DateTime since ) {
        return getActualTweetForAccount(account, since, null);
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualTweetForAccount( TwitterAccountDao account,
                                                    DateTime since,
                                                    Integer maxResult ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("creator", account))
                                                       .add(Restrictions.ge("cratedDate", since))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));

        if ( maxResult != null && maxResult > 0 )
            criteria = criteria.setMaxResults(maxResult);
        ;
        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    public List<TweetDao> getActualTweetForAccounts( List<TwitterAccountDao> accounts, DateTime since ) {
        return getActualTweetForAccounts(accounts, since, null);
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualTweetForAccounts( List<TwitterAccountDao> accounts,
                                                     DateTime since,
                                                     Integer maxResult ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.in("creator", accounts))
                                                       .add(Restrictions.ge("cratedDate", since))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));
        ;
        if ( maxResult != null && maxResult > 0 )
            criteria = criteria.setMaxResults(maxResult);
        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    public List<TweetDao> getActualRepliesForAccount( TwitterAccountDao account,
                                                      TweetDao inReplyTo,
                                                      DateTime since ) {
        return getActualRepliesForAccount(account, inReplyTo, since, null);
    }

    public TweetDao getLastActualRepliesForAccount( TwitterAccountDao account,
                                                    TweetDao inReplyTo,
                                                    DateTime since ) {
        List<TweetDao> t = getActualRepliesForAccount(account, inReplyTo, since, 1);
        if ( t.size() >= 1 )
            return t.get(0);
        else
            return null;
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualRepliesForAccount( TwitterAccountDao account,
                                                      TweetDao inReplyTo,
                                                      DateTime since,
                                                      Integer maxResult ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("creator", account))
                                                       .add(Restrictions.eq("inReplyTo", inReplyTo))
                                                       .add(Restrictions.ge("cratedDate", since))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));
        if ( maxResult != null && maxResult > 0 )
            criteria = criteria.setMaxResults(maxResult);
        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    public List<TweetDao> getActualRepliesForAccounts( List<TwitterAccountDao> accounts,
                                                       TweetDao inReplyTo,
                                                       DateTime since ) {
        return getActualRepliesForAccounts(accounts, inReplyTo, since, null);
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualRepliesForAccounts( List<TwitterAccountDao> accounts,
                                                       TweetDao inReplyTo,
                                                       DateTime since,
                                                       Integer maxResult ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.in("creator", accounts))
                                                       .add(Restrictions.eq("inReplyTo", inReplyTo))
                                                       .add(Restrictions.ge("cratedDate", since))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));
        if ( maxResult != null && maxResult > 0 )
            criteria = criteria.setMaxResults(maxResult);
        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    public List<TweetDao> getActualRetweetsForAccount( TwitterAccountDao account,
                                                       TweetDao retweeted,
                                                       DateTime since ) {
        return getActualRetweetsForAccount(account, retweeted, since, null);
    }

    public TweetDao getLastActualRetweetForAccount( TwitterAccountDao account,
                                                    TweetDao retweeted,
                                                    DateTime since ) {
        List<TweetDao> t = getActualRetweetsForAccount(account, retweeted, since, 1);
        if ( t.size() >= 1 )
            return t.get(0);
        else
            return null;
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualRetweetsForAccount( TwitterAccountDao account,
                                                       TweetDao retweeted,
                                                       DateTime since,
                                                       Integer maxResult ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.eq("creator", account))
                                                       .add(Restrictions.eq("retweeted", retweeted))
                                                       .add(Restrictions.ge("cratedDate", since))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));
        if ( maxResult != null && maxResult > 0 )
            criteria = criteria.setMaxResults(maxResult);
        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

    public List<TweetDao> getActualRetweetsForAccount( List<TwitterAccountDao> accounts,
                                                       TweetDao retweeted,
                                                       DateTime since ) {
        return getActualRetweetsForAccount(accounts, retweeted, since, null);
    }

    @SuppressWarnings( "unchecked" )
    public List<TweetDao> getActualRetweetsForAccount( List<TwitterAccountDao> accounts,
                                                       TweetDao retweeted,
                                                       DateTime since,
                                                       Integer maxResult ) {
        Criteria criteria = getCriteria(TweetDao.class).add(Restrictions.in("creator", accounts))
                                                       .add(Restrictions.eq("retweeted", retweeted))
                                                       .add(Restrictions.ge("cratedDate", since))
                                                       .add(Restrictions.eq("isDeleted", false))
                                                       .addOrder(Order.desc("cratedDate"));
        if ( maxResult != null && maxResult > 0 )
            criteria = criteria.setMaxResults(maxResult);
        List<TweetDao> result = criteria.list();
        commit();
        return result;
    }

}
