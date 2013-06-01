package com.pk.cwierkacz.model.service;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.UserDao;

public class UserService extends AbstractService<UserDao>
{
    public UserService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public List<UserDao> getAllUsers( ) {
        Criterion[] criteria = new Criterion[] {};
        List<UserDao> result = getListByCriteria(Arrays.asList(criteria), UserDao.class);

        return result;
    }

    public List<UserDao> getActualUsers( ) {
        Criterion[] criteria = new Criterion[] {Restrictions.eq("isDeleted", false)};
        List<UserDao> result = getListByCriteria(Arrays.asList(criteria), UserDao.class);

        return result;
    }

    public UserDao getByUserName( String name ) {
        Criterion[] criteria = new Criterion[] {Restrictions.eq("name", name)};
        UserDao result = getUniqueByCriteria(Arrays.asList(criteria), UserDao.class);

        return result;
    }

    public UserDao getBySessionId( SessionDao sessionDao ) {
        Criterion[] criteria = new Criterion[] {Restrictions.eq("session", sessionDao)};
        UserDao result = getUniqueByCriteria(Arrays.asList(criteria), UserDao.class);

        return result;
    }
}
