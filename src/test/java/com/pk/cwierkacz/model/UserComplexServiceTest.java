package com.pk.cwierkacz.model;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.pk.cwierkacz.exception.StartException;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.model.service.UserService;

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class UserComplexServiceTest
{

    HibernateUtil hibernateUtil;

    @Before
    public void setup( ) throws StartException {
        hibernateUtil = new HibernateUtil();
        hibernateUtil.start();
    }

    @After
    public void close( ) throws StartException {
        hibernateUtil.stop();
    }

    @Test
    public void createUserWithAccountsAndDelete( ) throws StartException {
        UserDao userDao = new UserDao();
        userDao.setName("111");
        userDao.setPassword("Test");
        TwitterAccountDao twitterAccountDao = TwitterAccountDao.create(22,
                                                                       userDao,
                                                                       "Twitter",
                                                                       "1234",
                                                                       "secret1234");
        Set<TwitterAccountDao> accounts = new HashSet<>();
        accounts.add(twitterAccountDao);
        userDao.setAccounts(accounts);

        UserService service = new UserService(hibernateUtil.getSessionFactory());
        TwitterAccountService serviceAccount = new TwitterAccountService(hibernateUtil.getSessionFactory());
        service.save(userDao);

        assertEquals(1L, service.getAllUsers().size());
        assertEquals(1L, serviceAccount.getAccounts().size());
        assertEquals(22L, serviceAccount.getAccounts().get(0).getExternalId().longValue());
        assertEquals("Test", service.getAllUsers().get(0).getPassword());
        assertEquals("1234", serviceAccount.getAccounts().get(0).getAccessToken());
        assertEquals("secret1234", serviceAccount.getAccounts().get(0).getAccessTokenSecret());

        twitterAccountDao.setDeleted(true);
        userDao.setDeleted(true);
        service.saveOrUpdate(userDao);
        assertEquals(0L, service.getActualUsers().size());
        assertEquals(0L, serviceAccount.getActualAccounts().size());

    }

    //@Test
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

    //@Test
    public void saveLoadRemoveTest( ) {
        UserService userService = new UserService(hibernateUtil.getSessionFactory());
        List<UserDao> users = userService.getAllUsers();

        UserDao user = users.get(0);
        userService.delete(user);
        users = userService.getAllUsers();
        Assert.assertEquals(0, users.size());
    }

}
