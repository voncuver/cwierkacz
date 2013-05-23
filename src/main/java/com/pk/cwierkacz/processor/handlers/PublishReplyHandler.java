package com.pk.cwierkacz.processor.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.PublishReplyRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.Result;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.processor.handlers.helpers.AccountPermissionValidator;
import com.pk.cwierkacz.processor.handlers.helpers.AttachmentsWithResources;
import com.pk.cwierkacz.processor.handlers.helpers.ImageSaveException;
import com.pk.cwierkacz.processor.handlers.helpers.ImageSaver;
import com.pk.cwierkacz.twitter.TwitterAccount;
import com.pk.cwierkacz.twitter.TwitterAccountMap;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;
import com.pk.cwierkacz.twitter.attachment.TweetAttachments;

public class PublishReplyHandler extends AbstractHandler
{
    private final TweetService tweetService;

    private final TwitterAccountService accountService;

    private final ImageSaver imageSaver;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishReplyHandler.class);

    public PublishReplyHandler() {
        this.tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        this.accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
        this.imageSaver = new ImageSaver();
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.PUBLISHREPLY);
    }

    @Override
    public Result checkSecurity( ApplicationData appData ) {
        PublishReplyRequest publishRequest = (PublishReplyRequest) appData.getRequest();

        if ( !AccountPermissionValidator.checkPermissionForName(publishRequest.getLoginTweet(),
                                                                publishRequest.getTokenId()) ) {
            return new Result("Brak uprawnień do przynajmniej jednego konta.", Status.DENY);
        }
        if ( publishRequest.getReplayFor() <= 0 ) {
            return new Result("Aby stworzyć odpowiedź musisz podać identyfikator tweeta na który chcesz odpowiedzieć.",
                              Status.ERROR);
        }
        if ( publishRequest.getTweetText() == null ) {
            return new Result("Brak treści tweetu.", Status.ERROR);
        }

        if ( publishRequest.getLoginTweet() == null ) {
            return new Result("Brak nazwy konta dla którego chcesz opublikować odpowiedź.", Status.ERROR);
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
        PublishReplyRequest publishRequest = (PublishReplyRequest) appData.getRequest();

        StringBuilder errorBuilder = new StringBuilder();

        String login = publishRequest.getLoginTweet();

        TweetDao inReply = tweetService.getTweetById(publishRequest.getReplayFor());

        if ( publishRequest.getReplayFor() > 0 && inReply == null ) {
            errorBuilder.append("Tweet na którego chcesz odpowiedzieć nie istnieje.");
        }
        else {
            String filename = null;
            TweetAttachments attachments = TweetAttachments.empty();
            try {
                AttachmentsWithResources awr = imageSaver.saveImage(publishRequest.getBody(),
                                                                    publishRequest.getImgName(),
                                                                    publishRequest.getImgURL());

                if ( awr != null ) {
                    filename = awr.getImgPath();
                    attachments = awr.getAttachments();
                }

                TwitterAccountDao accountDao = accountService.getAccountByName(login);
                if ( accountDao == null ) {
                    errorBuilder.append("Konto " + login + " nie istnieje.");
                }
                else {
                    TwitterAccount account = TwitterAccountMap.getTwitterAccount(accountDao);
                    TweetDao newTweet = account.composeNewReplyTweet(publishRequest.getTweetText(),
                                                                     inReply,
                                                                     attachments);

                    newTweet.setCreator(accountDao);
                    if ( filename != null )
                        newTweet.setImagePath(filename);

                    tweetService.save(newTweet);
                    appData.setParam("TweetId", newTweet.getId().toString());

                }

            }
            catch ( ImageSaveException ex ) {
                errorBuilder.append("Bład zapisu pliku.");
            }
            catch ( TwitterAuthenticationException e ) {
                LOGGER.error(e.getMessage());
                errorBuilder.append("Bład autoryzacji dla konta " + login + ".");
            }
            catch ( TwitterActionException e ) {
                LOGGER.error(e.getMessage());
                errorBuilder.append("Bład komunikacji dla konta " + login + ".");
            }
            catch ( Throwable e ) {
                LOGGER.error(e.getMessage());
                errorBuilder.append("Bład aplikacji dla konta " + login + ".");
            }
        }

        Response response;
        String errorsMsg = errorBuilder.toString();

        if ( errorsMsg.isEmpty() ) {
            response = ResponseImpl.create(Status.OK,
                                           "Pomyślnie dodano wszystkie tweety.",
                                           appData.getRequest().getTokenId());
        }
        else {
            response = ResponseImpl.create(Status.ERROR,
                                           "Tweety nie dla wszystkich kont zostały dodane poprawnie: - " +
                                                   errorsMsg,
                                           appData.getRequest().getTokenId());
        }
        appData.setResponse(response);
    }

}
