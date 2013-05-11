package com.pk.cwierkacz.model.service;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.dao.SettingsDao;

public class SettingsService extends AbstractService<SettingsDao>
{

    public SettingsService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public SettingsDao getConsumerSettings( ) {
        Criteria criteria = getCriteria(SettingsDao.class);
        criteria.add(Restrictions.eq("settings", "consumer"));
        SettingsDao dao = (SettingsDao) criteria.uniqueResult();
        commit();
        return dao;
    }

    public void setConsumerSettings( String consumerKey, String consumerSecret ) {
        SettingsDao dao = new SettingsDao();
        dao.setSettings("consumer");
        dao.setConsumerKey(consumerKey);
        dao.setConsumerSecret(consumerSecret);
        save(dao);
    }

}
