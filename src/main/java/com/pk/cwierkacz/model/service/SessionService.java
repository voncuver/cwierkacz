package com.pk.cwierkacz.model.service;

import org.hibernate.SessionFactory;

import com.pk.cwierkacz.model.dao.Session;

public class SessionService extends AbstractService<Session>
{

    public SessionService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public Session getByUserId( long id ) {
        return getByQuery("From Session where Session.userid = " + Long.toString(id));
    }

}
