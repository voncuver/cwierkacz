package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;

public class TwitterAccountService extends AbstractService<TwitterAccountDao>
{

    public TwitterAccountService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    @SuppressWarnings( "unchecked" )
    public List<TwitterAccountDao> getAccounts( ) {
        Criteria criteria = getCriteria(TwitterAccountDao.class);
        return criteria.list();
    }

    @SuppressWarnings( "unchecked" )
    public List<TwitterAccountDao> getActualAccounts( ) {
        Criteria criteria = getCriteria(TwitterAccountDao.class).add(Restrictions.eq("isDeleted", false));
        return criteria.list();
    }

    public TwitterAccountDao getAccountById( Long id ) {
        Criteria criteria = getCriteria(TwitterAccountDao.class);
        criteria.add(Restrictions.eq("Id", id));
        return (TwitterAccountDao) criteria.uniqueResult();
    }

    public TwitterAccountDao getAccountByExternalId( Long id ) {
        Criteria criteria = getCriteria(TwitterAccountDao.class);
        criteria.add(Restrictions.eq("externalId", id));
        return (TwitterAccountDao) criteria.uniqueResult();
    }
}
