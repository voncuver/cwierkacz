package com.pk.cwierkacz.processor.handlers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.edu.pk.ias.types.Item;

import com.pk.cwierkacz.http.response.dto.Message;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.dao.BridgeImgMetadataDao;
import com.pk.cwierkacz.model.service.BridgeImgMetadataService;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.processor.handlers.helpers.FetchResult;
import com.pk.cwierkacz.processor.handlers.helpers.ImageSaveException;
import com.pk.cwierkacz.processor.handlers.helpers.ImageUtil;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

abstract public class FetchBridgeMessagesHandler extends AbstractHandler
{
    private final BridgeImgMetadataService bridgeImgMetadataService = ServiceRepo.getInstance()
                                                                                 .getService(BridgeImgMetadataService.class);

    private static final Logger LOGGER = LoggerFactory.getLogger(BridgeImgMetadataService.class);

    private final ImageUtil imgUtil = new ImageUtil();

    public FetchResult itemsToMessages( List<Item> items, AccountType accountType ) {
        List<Message> messages = new ArrayList<Message>();
        StringBuilder errorBuilder = new StringBuilder();
        for ( Item item : items ) {

            String path = bridgeImgMetadataService.getPathAndUpdate(item.getId().getId(),
                                                                    item.getId().getLss(),
                                                                    accountType);
            if ( path == null ) {
                byte[] bytes = null;
                if ( item.getFile() != null ) {
                    try {
                        bytes = Base64.decode(item.getFile());
                    }
                    catch ( Base64DecodingException e ) {
                        LOGGER.error(getError(e));
                        errorBuilder = appendError(errorBuilder, "Błąd dekowania pliku z base64 " +
                                                                 item.getId().getLss() +
                                                                 ".", e);
                    }
                }

                try {
                    path = imgUtil.saveImage(bytes, item.getName(), null).getImgPath();
                }
                catch ( ImageSaveException e ) {
                    LOGGER.error(getError(e));
                    errorBuilder = appendError(errorBuilder, "Bład zapisu pliku.", e);
                }

                BridgeImgMetadataDao bridgeImgMetadataDao = new BridgeImgMetadataDao();
                bridgeImgMetadataDao.setBridgeId(item.getId().getId());
                bridgeImgMetadataDao.setAccountType(accountType);
                bridgeImgMetadataDao.setLss(item.getId().getLss());
                bridgeImgMetadataDao.setPath(path);

                bridgeImgMetadataService.save(bridgeImgMetadataDao);
            }

            messages.add(Message.apply(accountType, path, item));
        }

        return new FetchResult(messages, errorBuilder);
    };
}
