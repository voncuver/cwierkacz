package com.pk.cwierkacz.processor.handlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.PublishMessageRequest;
import com.pk.cwierkacz.http.request.PublishRetweetRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.Result;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.processor.handlers.helpers.AccountManager;
import com.pk.cwierkacz.processor.handlers.helpers.AccountPermissionValidator;
import com.pk.cwierkacz.twitter.TwitterAccount;
import com.pk.cwierkacz.twitter.TwitterAccountMap;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;

public class PublishRetweetHandler extends AbstractHandler
{
    private final TweetService tweetService;

    private final TwitterAccountService accountService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishRetweetHandler.class);

    public PublishRetweetHandler() {
        this.tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        this.accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.PUBLISHRETWEET);
    }

    @Override
    public Result checkSecurity( ApplicationData appData ) {
        PublishRetweetRequest publishRequest = (PublishRetweetRequest) appData.getRequest();

        if ( !AccountPermissionValidator.checkPermissionForName(publishRequest.getAccounts(),
                                                                publishRequest.getTokenId()) ) {
            return new Result("Brak uprawnień do przynajmniej jednego konta.", Status.DENY);
        }
        if ( publishRequest.getRetweetFor() <= 0 ) {
            return new Result("Aby stworzyć retweeta musisz podać identyfikator tweeta którego chcesz skopiować.",
                              Status.ERROR);
        }

        return new Result("OK", Status.OK);
    }

    @Override
    public void handle( ApplicationData appData ) {
        PublishRetweetRequest publishRequest = (PublishRetweetRequest) appData.getRequest();

        StringBuilder errorBuilder = new StringBuilder();
        StringBuilder twitterErrorsBuilder = new StringBuilder();
        StringBuilder bridgesErrorsBuilder = new StringBuilder();

        AccountManager accountManager = new AccountManager(publishRequest.getAccounts(),
                                                           publishRequest.getTokenId());

        TweetDao retweeted = tweetService.getTweetById(publishRequest.getRetweetFor());

        if ( publishRequest.getRetweetFor() > 0 && retweeted == null ) {
            errorBuilder.append("Tweet którego chcesz skopiować nie istnieje. ");
        }
        else {
            twitterErrorsBuilder = handleToTwitter(appData,
                                                   retweeted,
                                                   accountManager.getTwitterAccountLogins());

            bridgesErrorsBuilder = handleToBridges(appData, retweeted, accountManager.getBridgeAccounts());
        }

        Response response;
        errorBuilder = errorBuilder.append(twitterErrorsBuilder).append(bridgesErrorsBuilder);
        String errorsMsg = errorBuilder.toString();

        if ( errorsMsg.isEmpty() ) {
            response = ResponseImpl.create(Status.OK,
                                           "Pomyślnie dodano wszystkie tweety.",
                                           appData.getRequest().getTokenId());
        }
        else {
            response = ResponseImpl.create(Status.ERROR,
                                           "Tweety nie dla wszystkich kont zostały dodane poprawnie. " +
                                                   errorsMsg,
                                           appData.getRequest().getTokenId());
        }
        appData.setResponse(response);
    }

    public StringBuilder handleToTwitter( ApplicationData appData,
                                          TweetDao mainTweet,
                                          List<String> twitterAccountLogins ) {

        PublishMessageRequest publishRequest = (PublishMessageRequest) appData.getRequest();

        StringBuilder errorBuilder = new StringBuilder();

        for ( String accountName : twitterAccountLogins ) {
            try {
                //tranzakcyjność per jedno konto - a może inaczej?
                TwitterAccountDao accountDao = accountService.getAccountByName(accountName);
                if ( accountDao == null ) {
                    errorBuilder.append(accountName + " użytkownik nie istnieje.");
                }
                else {
                    TweetDao newTweet = null;
                    TwitterAccount account = TwitterAccountMap.getTwitterAccount(accountDao);

                    newTweet = account.composeNewReTweet(mainTweet);
                    newTweet.setCreator(accountDao);

                    tweetService.save(newTweet);
                    appData.setParam("TweetId", newTweet.getId().toString());
                }
            }
            catch ( TwitterAuthenticationException e ) {
                LOGGER.error(e.getMessage());
                errorBuilder.append("Bład autoryzacji dla konta " + accountName + ".");
            }
            catch ( TwitterActionException e ) {
                LOGGER.error(e.getMessage());
                errorBuilder.append("Bład komunikacji dla konta " + accountName + ".");
            }
            catch ( Throwable e ) {
                LOGGER.error(e.getMessage());
                errorBuilder.append("Bład aplikacji dla konta " + accountName + ".");
            }
        }

        return errorBuilder;
    }

    public StringBuilder handleToBridges( ApplicationData appData,
                                          TweetDao mainTweet,
                                          List<Account> twitterAccounts ) {
        //TODO
        return null;

    }

}
