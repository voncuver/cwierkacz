package com.pk.cwierkacz.model.service;

import java.util.Arrays;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
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
        Criterion[] criteria = new Criterion[] {Restrictions.eq("bridgeId", id),
                                                Restrictions.eq("lss", lss),
                                                Restrictions.eq("accountType", accountType)};
        BridgeImgMetadataDao result = getUniqueByCriteria(Arrays.asList(criteria), BridgeImgMetadataDao.class);

        return result;
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
