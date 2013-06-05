package com.pk.cwierkacz.model.service;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.BridgeAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;

public class BridgeAccountService extends AbstractService<BridgeAccountDao>
{

    public BridgeAccountService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public List<BridgeAccountDao> getAccountsForUser( UserDao user ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("u.id", user.getId()),
                                                Restrictions.eq("deleted", false)};

        List<BridgeAccountDao> result = getListByCriteria(Arrays.asList(criteria),
                                                          BridgeAccountDao.class,
                                                          null,
                                                          null,
                                                          true);

        return result;
    }

    public BridgeAccountDao getAccountByName( String name, AccountType type ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("accountType", type),
                                                Restrictions.eq("name", name),
                                                Restrictions.eq("deleted", false)};
        BridgeAccountDao result = getUniqueByCriteria(Arrays.asList(criteria), BridgeAccountDao.class);

        return result;
    }

    public BridgeAccountDao getAccountByNameFalse( String name, AccountType type ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("accountType", type),
                                                Restrictions.eq("name", name)};
        BridgeAccountDao result = getUniqueByCriteria(Arrays.asList(criteria), BridgeAccountDao.class);

        return result;
    }
}
