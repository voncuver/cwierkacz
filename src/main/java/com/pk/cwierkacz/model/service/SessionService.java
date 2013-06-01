package com.pk.cwierkacz.model.service;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.dao.SessionDao;

public class SessionService extends AbstractService<SessionDao>
{

    public SessionService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public List<SessionDao> getAll( ) {

        Criterion[] criteria = new Criterion[] {};
        List<SessionDao> result = getListByCriteria(Arrays.asList(criteria), SessionDao.class);

        return result;
    }

    public SessionDao getByToken( Long token ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("currentToken", token)};
        SessionDao result = getUniqueByCriteria(Arrays.asList(criteria), SessionDao.class);

        return result;
    }

}
