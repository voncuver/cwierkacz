package com.pk.cwierkacz.model.service;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.dao.SessionDao;

public class SessionService extends AbstractService<SessionDao>
{

    public SessionService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public SessionDao getByUserId( long id ) {
        Criteria criteria = getCriteria(SessionDao.class);
        criteria.add(Restrictions.eq("userId", id));
        return (SessionDao) criteria.list().get(0);
    }

}
