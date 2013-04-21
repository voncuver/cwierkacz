package com.pk.cwierkacz.model.instance;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;

public class ServiceRepoTest
{
    ServiceRepo serviceRepo;

    @Before
    public void setUp( ) {
        serviceRepo = ServiceRepo.getInstance();
    }

    @Test
    public void createInstanceTest( ) {
        SessionService service = serviceRepo.getService(SessionService.class);

        //check is working properly
        SessionDao sessionDao = new SessionDao();
        sessionDao.setCurrentToken(1234L);
        sessionDao.setLastActive(new Timestamp(1));
        sessionDao.setUserId(124);

        service.save(sessionDao);

        SessionDao persis = service.getByUserId(124);

        assertEquals(1234, persis.getCurrentToken());

    }

    @Test
    public void createInstanceAndGetFromCacheTest( ) {
        SessionService service = serviceRepo.getService(SessionService.class);

        SessionService serviceCached = serviceRepo.getService(SessionService.class);
        assertEquals(service, serviceCached);

    }
}
