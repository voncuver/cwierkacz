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
        return criteria.list();
    }

    public UserDao getByUserId( String name ) {
        Criteria criteria = getCriteria(UserDao.class);
        criteria.add(Restrictions.eq("name", name));
        return (UserDao) criteria.list().get(0);
    }
}
