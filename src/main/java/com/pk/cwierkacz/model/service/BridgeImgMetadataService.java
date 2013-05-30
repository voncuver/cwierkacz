package com.pk.cwierkacz.model.service;

import java.math.BigInteger;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.BridgeImgMetadataDao;

public class BridgeImgMetadataService extends AbstractService<BridgeImgMetadataDao>
{
    public BridgeImgMetadataService( SessionFactory sessionFactory ) {
        super(sessionFactory);
    }

    public BridgeImgMetadataDao getBridgeImgMetadata( BigInteger id, String lss, AccountType accountType ) {
        Criteria criteria = getCriteria(BridgeImgMetadataDao.class);
        criteria.add(Restrictions.eq("bridgeId", id));
        criteria.add(Restrictions.eq("lss", lss));
        criteria.add(Restrictions.eq("accountType", accountType));
        BridgeImgMetadataDao dao = (BridgeImgMetadataDao) criteria.uniqueResult();
        commit();
        return dao;
    }

    public void saveIfNotExist( BridgeImgMetadataDao bridgeImgMetadataDao ) {
        BridgeImgMetadataDao readed = getBridgeImgMetadata(bridgeImgMetadataDao.getBridgeId(),
                                                           bridgeImgMetadataDao.getLss(),
                                                           bridgeImgMetadataDao.getAccountType());

        if ( readed == null ) {
            save(bridgeImgMetadataDao);
        }
    }

}
