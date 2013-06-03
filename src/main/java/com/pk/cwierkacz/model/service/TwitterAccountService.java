package com.pk.cwierkacz.model.service;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;

public class TwitterAccountService extends AbstractService<TwitterAccountDao>
{

    public TwitterAccountService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public List<TwitterAccountDao> getAccounts( ) {
        Criterion[] criteria = new Criterion[] {};
        List<TwitterAccountDao> result = getListByCriteria(Arrays.asList(criteria), TwitterAccountDao.class);

        return result;
    }

    public List<TwitterAccountDao> getActualAccounts( ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("isDeleted", false)};
        List<TwitterAccountDao> result = getListByCriteria(Arrays.asList(criteria), TwitterAccountDao.class);

        return result;
    }

    public TwitterAccountDao getAccountById( Long id ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("Id", id)};
        TwitterAccountDao result = getUniqueByCriteria(Arrays.asList(criteria), TwitterAccountDao.class);

        return result;
    }

    public TwitterAccountDao getAccountByExternalId( Long id ) {
        Criterion[] criteria = new Criterion[] {Restrictions.eq("externalId", id)};
        TwitterAccountDao result = getUniqueByCriteria(Arrays.asList(criteria), TwitterAccountDao.class);

        return result;
    }

    public TwitterAccountDao getAccountByName( String name ) {
        Criterion[] criteria = new Criterion[] {Restrictions.eq("accountName", name)};
        TwitterAccountDao result = getUniqueByCriteria(Arrays.asList(criteria), TwitterAccountDao.class);

        return result;
    }

    public List<TwitterAccountDao> getAccountsForUser( UserDao user ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("u.id", user.getId())};
        List<TwitterAccountDao> result = getListByCriteria(Arrays.asList(criteria),
                                                           TwitterAccountDao.class,
                                                           null,
                                                           null,
                                                           true);

        return result;
    }
}
