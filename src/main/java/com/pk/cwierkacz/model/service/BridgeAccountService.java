package com.pk.cwierkacz.model.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.BridgeAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;

public class BridgeAccountService extends AbstractService<BridgeAccountDao>
{

    public BridgeAccountService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    @SuppressWarnings( "unchecked" )
    public List<BridgeAccountDao> getAccountsForUser( UserDao user ) {
        Criteria criteria = getCriteria(BridgeAccountService.class);
        criteria.add(Restrictions.eq("user", user));
        List<BridgeAccountDao> result = criteria.list();
        commit();
        return result;
    }

    public BridgeAccountDao getAccountByName( String name, AccountType type ) {
        Criteria criteria = getCriteria(BridgeAccountDao.class);
        criteria.add(Restrictions.eq("name", name));
        criteria.add(Restrictions.eq("accountType", type));
        BridgeAccountDao result = (BridgeAccountDao) criteria.uniqueResult();
        commit();
        return result;
    }

}
