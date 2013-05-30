package com.pk.cwierkacz.processor.handlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.PublishMessageRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.Result;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.processor.handlers.helpers.AccountManager;
import com.pk.cwierkacz.processor.handlers.helpers.AccountPermissionValidator;
import com.pk.cwierkacz.processor.handlers.helpers.FileData;
import com.pk.cwierkacz.processor.handlers.helpers.ImageSaveException;
import com.pk.cwierkacz.processor.handlers.helpers.ImageUtil;
import com.pk.cwierkacz.twitter.TwitterAccount;
import com.pk.cwierkacz.twitter.TwitterAccountMap;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class PublishMessagesHandler extends PublishBridgeMessagesHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PublishMessagesHandler.class);

    private final TweetService tweetService;

    private final TwitterAccountService accountService;

    private final ImageUtil imageSaver;

    public PublishMessagesHandler() {
        super();
        this.tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        this.accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
        this.imageSaver = new ImageUtil();
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.PUBLISHMESSAGE);
    }

    @Override
    public Result checkSecurity( ApplicationData appData ) {
        PublishMessageRequest publishRequest = (PublishMessageRequest) appData.getRequest();

        if ( !AccountPermissionValidator.checkPermissionForName(publishRequest.getAccounts(),
                                                                publishRequest.getTokenId()) ) {
            return new Result("Brak uprawnień do przynajmniej jednego konta.", Status.DENY);
        }

        if ( publishRequest.getTweetText() == null ) {
            return new Result("Brak treści tweetu.", Status.ERROR);
        }

        if ( publishRequest.getBody() != null &&
             publishRequest.getImgName() == null ||
             publishRequest.getBody() == null &&
             publishRequest.getImgName() != null ) {
            return new Result("Brak pliku zdjęcia albo jego nazwy.", Status.ERROR);
        }

        if ( publishRequest.getImgName() != null && publishRequest.getImgURL() != null ) {
            return new Result("Niejednoznaczne dane na temat obrazka. Nie można załączyć obrazka wprost i jednocześnie podać URL gdzie go szukać",
                              Status.ERROR);
        }

        return new Result("OK", Status.OK);
    }

    @Override
    public void handle( ApplicationData appData ) {

        PublishMessageRequest publishRequest = (PublishMessageRequest) appData.getRequest();

        AccountManager accountManager = new AccountManager(publishRequest.getAccounts(),
                                                           publishRequest.getTokenId());

        StringBuilder errorsBuilder = new StringBuilder();
        StringBuilder twitterErrorsBuilder = new StringBuilder();
        StringBuilder bridgesErrorsBuilder = new StringBuilder();

        try {
            FileData fileData = imageSaver.saveImage(publishRequest.getBody(),
                                                     publishRequest.getImgName(),
                                                     publishRequest.getImgURL());

            twitterErrorsBuilder = handleToTwitter(publishRequest.getTweetText(),
                                                   accountManager.getTwitterAccountLogins(),
                                                   fileData);

            bridgesErrorsBuilder = handleToBridges(publishRequest.getTweetText(),
                                                   accountManager.getBridgeAccounts(),
                                                   fileData);

        }
        catch ( ImageSaveException ex ) {
            LOGGER.error(getError(ex));
            errorsBuilder = appendError(errorsBuilder, "Bład zapisu pliku.", ex);
        }

        Response response;
        errorsBuilder = errorsBuilder.append(twitterErrorsBuilder).append(bridgesErrorsBuilder);
        String errorsMsg = errorsBuilder.toString();
        if ( errorsMsg.isEmpty() ) {
            response = ResponseImpl.create(Status.OK,
                                           "Pomyślnie dodano wszystkie wiadomości.",
                                           appData.getRequest().getTokenId());

        }
        else {
            response = ResponseImpl.create(Status.ERROR,
                                           "Wiadomości nie dla wszystkich kont zostały dodane poprawnie. " +
                                                   errorsMsg,
                                           appData.getRequest().getTokenId());
        }
        appData.setResponse(response);
    }

    public StringBuilder handleToTwitter( String text, List<String> twitterAccountLogins, FileData fileData ) {

        StringBuilder errorBuilder = new StringBuilder();
        for ( String accountName : twitterAccountLogins ) {
            try {

                TwitterAccountDao accountDao = accountService.getAccountByName(accountName);
                if ( accountDao == null ) {
                    errorBuilder.append("Konto " + accountName + " nie istnieje.");
                }
                else {
                    TwitterAccount account = TwitterAccountMap.getTwitterAccount(accountDao);
                    TweetDao newTweet = account.composeNewTweet(text, fileData.getAttachments());

                    newTweet.setCreator(accountDao);
                    if ( fileData.getImgPath() != null )
                        newTweet.setImagePath(fileData.getImgPath());

                    tweetService.save(newTweet);
                }
            }
            catch ( TwitterAuthenticationException e ) {
                LOGGER.error(getError(e));
                errorBuilder = appendError(errorBuilder, "Bład autoryzacji dla konta " + accountName + ".", e);
            }
            catch ( TwitterActionException e ) {
                LOGGER.error(getError(e));
                errorBuilder = appendError(errorBuilder, "Bład komunikacji dla konta " + accountName + ".", e);
            }
            catch ( Throwable e ) {
                LOGGER.error(getError(e));
                errorBuilder = appendError(errorBuilder, "Bład aplikacji dla konta " + accountName + ".", e);
            }
        }

        return errorBuilder;
    }

}
