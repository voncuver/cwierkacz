package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.pk.cwierkacz.model.dao.UserDao;

public class UserService extends AbstractService<UserDao>
{
    public UserService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public List<UserDao> getAllUsers( ) {
        return getListByQuery("From Users");
    }

    public UserDao getByUserId( String name ) {
        return getByQuery("From Users where Users.name = " + name);
    }
}
