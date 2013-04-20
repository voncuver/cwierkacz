package com.pk.cwierkacz.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.pk.cwierkacz.exception.StartException;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.UserService;

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class UserComplexServiceTest
{

    static HibernateUtil hibernateUtil;

    @BeforeClass
    public static void setup( ) throws StartException {
        hibernateUtil = new HibernateUtil();
        hibernateUtil.start();
    }

    @Test
    public void saveLoadAddTest( ) {
        UserDao userDao = new UserDao();
        userDao.setName("11");
        userDao.setPassword("Test");

        UserService userService = new UserService(hibernateUtil.getSessionFactory());

        userService.save(userDao);

        List<UserDao> users = userService.getAllUsers();
        Assert.assertEquals(1, users.size());
        Assert.assertEquals("11", users.get(0).getName());
        Assert.assertEquals("Test", users.get(0).getPassword());
    }

    @Test
    public void saveLoadSessionAddTest( ) {
        SessionDao sessionDao = new SessionDao();
        sessionDao.setCurrentToken(1234l);
        sessionDao.setLastActive(new Timestamp(new Date().getTime()));
        sessionDao.setUserId(1234l);

        SessionService sessionService = new SessionService(hibernateUtil.getSessionFactory());
        sessionService.save(sessionDao);
    }

    @Test
    public void saveLoadChangeTest( ) {
        UserService userService = new UserService(hibernateUtil.getSessionFactory());
        List<UserDao> users = userService.getAllUsers();

        UserDao user = users.get(0);
        user.setName("ABC");

        userService.saveOrUpdate(user);

        users = userService.getAllUsers();
        Assert.assertEquals(1, users.size());
        Assert.assertEquals("ABC", users.get(0).getName());
        Assert.assertEquals("Test", users.get(0).getPassword());
    }

    @Test
    public void saveLoadRemoveTest( ) {
        UserService userService = new UserService(hibernateUtil.getSessionFactory());
        List<UserDao> users = userService.getAllUsers();

        UserDao user = users.get(0);
        userService.delete(user);
        users = userService.getAllUsers();
        Assert.assertEquals(0, users.size());
    }

}
