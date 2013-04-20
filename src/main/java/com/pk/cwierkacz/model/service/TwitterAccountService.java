package com.pk.cwierkacz.model.service;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;

public class TwitterAccountService extends AbstractService<TwitterAccountDao>
{

    public TwitterAccountService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public TwitterAccountDao getAccountById( Long id ) {
        Criteria criteria = getCriteria(TwitterAccountDao.class);
        criteria.add(Restrictions.eq("Id", id));
        return (TwitterAccountDao) criteria.list().get(0);
    }
}
