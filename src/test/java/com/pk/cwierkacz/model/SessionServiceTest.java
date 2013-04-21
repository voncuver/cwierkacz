package com.pk.cwierkacz.model;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.UserService;

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class SessionServiceTest
{

    @Test
    public void save1LoadSessionAddTest( ) {
        UserDao userDao = new UserDao();
        userDao.setName("Test");
        userDao.setPassword("Test");

        UserService userService = ServiceRepo.getInstance().getService(UserService.class);
        userService.saveOrUpdate(userDao);

        SessionDao sessionDao = new SessionDao();
        sessionDao.setCurrentToken(1234l);
        sessionDao.setLastActive(new Timestamp(new Date().getTime()));

        userDao.setSession(sessionDao);

        userService.saveOrUpdate(userDao);

        UserDao userDao2 = userService.getByUserName("Test");

        assertEquals(1234, userDao2.getSession().getCurrentToken());
    }

    @Test
    public void save2LoadRemoveSessionTest( ) {
        UserService userService = ServiceRepo.getInstance().getService(UserService.class);
        SessionService sessionService = ServiceRepo.getInstance().getService(SessionService.class);
        UserDao userDao = userService.getByUserName("Test");
        SessionDao sessionDao = userDao.getSession();
        userDao.setSession(null);

        userService.saveOrUpdate(userDao);
        sessionService.deleteSession(sessionDao);

        assertEquals(null, userDao.getSession());
    }
}
