package com.pk.cwierkacz.model.service;

import org.hibernate.SessionFactory;

import com.pk.cwierkacz.model.dao.BridgeAccountDao;

public class BridgeAccountService extends AbstractService<BridgeAccountDao>
{

    public BridgeAccountService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

}
