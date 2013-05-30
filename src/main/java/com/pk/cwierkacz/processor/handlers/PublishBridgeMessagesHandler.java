package com.pk.cwierkacz.processor.handlers;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.edu.pk.ias.types.ItemId;

import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.dao.BridgeImgMetadataDao;
import com.pk.cwierkacz.model.service.BridgeImgMetadataService;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.processor.handlers.helpers.FileData;
import com.pk.cwierkacz.ws.BridgeException;
import com.pk.cwierkacz.ws.SsiAdapter;

abstract public class PublishBridgeMessagesHandler extends AbstractHandler
{
    private final SsiAdapter ssiAdapter = SsiAdapter.getInstance();
    private final BridgeImgMetadataService bridgeImgMetadataService = ServiceRepo.getInstance()
                                                                                 .getService(BridgeImgMetadataService.class);
    private static final Logger LOGGER = LoggerFactory.getLogger(PublishBridgeMessagesHandler.class);

    public StringBuilder handleToBridges( String text, List<Account> twitterAccounts, FileData fileData ) {

        StringBuilder errorBuilder = new StringBuilder();

        for ( Account account : twitterAccounts ) {
            try {
                ItemId itemId = ssiAdapter.publishTweet(account.getType(),
                                                        text,
                                                        account.getLogin(),
                                                        fileData.getImgName(),
                                                        Base64.encodeBase64(fileData.getBytes()));

                if ( fileData.getImgPath() != null ) {
                    BridgeImgMetadataDao bridgeImgMetadataDao = new BridgeImgMetadataDao();
                    bridgeImgMetadataDao.setPath(fileData.getImgPath());
                    bridgeImgMetadataDao.setLss(itemId.getLss());
                    bridgeImgMetadataDao.setBridgeId(itemId.getId());
                    bridgeImgMetadataDao.setAccountType(account.getType());
                    bridgeImgMetadataService.save(bridgeImgMetadataDao);
                }
            }
            catch ( BridgeException be ) {
                LOGGER.error(getError(be));
                errorBuilder = appendError(errorBuilder,
                                           "Bład mostu dla konta " + account.getLogin() + ".",
                                           be);
            }
            catch ( Throwable e ) {
                LOGGER.error(getError(e));
                errorBuilder = appendError(errorBuilder, "Bład aplikacji dla konta " +
                                                         account.getLogin() +
                                                         ".", e);
            }
        }

        return new StringBuilder();

    }
}
