package com.pk.cwierkacz.model.service;

import java.io.File;
import java.util.Arrays;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.dao.SettingsDao;

public class SettingsService extends AbstractService<SettingsDao>
{

    public SettingsService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public SettingsDao getConsumerSettings( ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("settings", "consumer")};
        SettingsDao result = getUniqueByCriteria(Arrays.asList(criteria), SettingsDao.class);
        return result;
    }

    public void setConsumerSettings( String consumerKey, String consumerSecret ) {
        SettingsDao dao = new SettingsDao();
        dao.setSettings("consumer");
        dao.setConsumerKey(consumerKey);
        dao.setConsumerSecret(consumerSecret);
        save(dao);
    }

    public SettingsDao getImageSettings( ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("settings", "image")};
        SettingsDao result = getUniqueByCriteria(Arrays.asList(criteria), SettingsDao.class);
        return result;
    }

    public void setImageSettings( String relativeImgPath ) {
        SettingsDao dao = new SettingsDao();
        dao.setSettings("image");
        dao.setRelativeImgPath(relativeImgPath);
        save(dao);
    }

    public SettingsDao getContainerSettings( ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("settings", "container")};
        SettingsDao result = getUniqueByCriteria(Arrays.asList(criteria), SettingsDao.class);
        return result;
    }

    public String getAppAddress( ) {

        Criterion[] criteria = new Criterion[] {Restrictions.eq("settings", "www")};
        SettingsDao dao = getUniqueByCriteria(Arrays.asList(criteria), SettingsDao.class);

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

    public SettingsDao getDefaultImage( ) {
        Criterion[] criteria = new Criterion[] {Restrictions.eq("settings", "defaultImg")};
        SettingsDao result = getUniqueByCriteria(Arrays.asList(criteria), SettingsDao.class);
        return result;
    }

}
