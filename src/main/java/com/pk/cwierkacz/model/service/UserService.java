package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.dao.UserDao;

public class UserService extends AbstractService<UserDao>
{
    public UserService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    @SuppressWarnings( "unchecked" )
    public List<UserDao> getAllUsers( ) {
        Criteria criteria = getCriteria(UserDao.class);
        List<UserDao> userDao = criteria.list();
        commit();
        return userDao;
    }

    @SuppressWarnings( "unchecked" )
    public List<UserDao> getActualUsers( ) {
        Criteria criteria = getCriteria(UserDao.class).add(Restrictions.eq("isDeleted", false));
        List<UserDao> userDao = criteria.list();
        commit();
        return userDao;
    }

    public UserDao getByUserName( String name ) {
        Criteria criteria = getCriteria(UserDao.class);
        criteria.add(Restrictions.eq("name", name));
        UserDao userDao = (UserDao) criteria.uniqueResult();
        commit();
        return userDao;
    }
}
