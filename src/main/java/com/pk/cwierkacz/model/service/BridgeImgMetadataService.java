package com.pk.cwierkacz.model.service;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.BridgeImgMetadataDao;

public class BridgeImgMetadataService extends AbstractService<BridgeImgMetadataDao>
{
    public BridgeImgMetadataService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public BridgeImgMetadataDao getBridgeImgMetadata( String id, String lss, AccountType accountType ) {
        Criteria criteria = getCriteria(BridgeImgMetadataDao.class);
        criteria.add(Restrictions.eq("bridgeId", id));
        criteria.add(Restrictions.eq("lss", lss));
        criteria.add(Restrictions.eq("accountType", accountType));
        BridgeImgMetadataDao dao = (BridgeImgMetadataDao) criteria.uniqueResult();
        commit();
        return dao;
    }

    public String getPathAndUpdate( String bridgeId, String lss, AccountType accountType ) {
        BridgeImgMetadataDao readed = getBridgeImgMetadata(bridgeId, lss, accountType);

        if ( readed == null ) {
            return null;
        }
        else {
            readed.setAccessDate(new DateTime());
            saveOrUpdate(readed);

            return readed.getPath();
        }
    }

}
