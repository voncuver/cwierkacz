package com.pk.cwierkacz.model.service;

import java.io.File;

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

    public SettingsDao getImageSettings( ) {
        Criteria criteria = getCriteria(SettingsDao.class);
        criteria.add(Restrictions.eq("settings", "image"));
        SettingsDao dao = (SettingsDao) criteria.uniqueResult();
        commit();
        return dao;
    }

    public void setImageSettings( String relativeImgPath ) {
        SettingsDao dao = new SettingsDao();
        dao.setSettings("image");
        dao.setRelativeImgPath(relativeImgPath);
        save(dao);
    }

    public SettingsDao getContainerSettings( ) {
        Criteria criteria = getCriteria(SettingsDao.class);
        criteria.add(Restrictions.eq("settings", "container"));
        SettingsDao dao = (SettingsDao) criteria.uniqueResult();
        commit();
        return dao;
    }

    public String getAppAddress( ) {
        Criteria criteria = getCriteria(SettingsDao.class);
        criteria.add(Restrictions.eq("settings", "www"));
        SettingsDao dao = (SettingsDao) criteria.uniqueResult();
        commit();
        if ( dao == null )
            return null;
        else if ( dao.getAppAddress().endsWith("/") )
            return dao.getAppAddress();
        else
            return dao.getAppAddress() + "/";
    }

    public void setAppAddess( String url ) {
        SettingsDao dao = new SettingsDao();
        dao.setSettings("www");
        dao.setAppAddress(url);
        save(dao);
    }

    public void setContainerSettings( String absoluteContainerPath ) {
        SettingsDao dao = new SettingsDao();
        dao.setSettings("container");
        dao.setAbsoluteContainerPath(absoluteContainerPath);
        save(dao);
    }

    public String getImageAbsolutePath( ) {
        String containerPath = getContainerSettings().getAbsoluteContainerPath();
        String imagePath = getImageSettings().getRelativeImgPath();
        String sl = "";
        if ( !containerPath.endsWith(( File.separator )) )
            sl = File.separator;

        return containerPath + sl + imagePath;
    }

}
