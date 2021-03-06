package com.pk.cwierkacz.processor.handlers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.edu.pk.ias.socialserviceintegrationClient.SocialServiceIntegrationStub.Item;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.GetMessagesRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.http.response.dto.Message;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.Result;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.processor.handlers.helpers.FetchResult;
import com.pk.cwierkacz.ws.BridgeException;
import com.pk.cwierkacz.ws.SsiAdapter;

public class GetMessagesHandler extends FetchBridgeMessagesHandler
{
    private final TweetService tweetService;

    private static final Logger LOGGER = LoggerFactory.getLogger(GetMessagesHandler.class);

    private final SsiAdapter ssiAdapter;

    public GetMessagesHandler() {
        super();
        tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        this.ssiAdapter = SsiAdapter.getInstance();
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.GETMESSAGES);
    }

    @Override
    public Result checkSecurity( ApplicationData appData ) {
        GetMessagesRequest fetchRequest = (GetMessagesRequest) appData.getRequest();

        if ( fetchRequest.getIds().size() == 0 ) {
            return new Result("Aby pobrać wiadomości po identyfikatorach musisz podać co najmniej jeden identyfikator",
                              Status.ERROR);
        }

        if ( fetchRequest.getAccountType() == null ) {
            return new Result("Aby pobrać wiadomości po identyfikatorach musisz podać typ konta dla tych identyfikatorów",
                              Status.ERROR);
        }

        if ( fetchRequest.getAccountType() != AccountType.TWITTER && fetchRequest.getAccountLogins() == null ) {
            return new Result("Aby pobrać wiadomości z aplikacji zewnętrznych musisz podać loginy",
                              Status.ERROR);
        }

        return new Result("OK", Status.OK);
    }

    @Override
    public void handle( ApplicationData appData ) {
        GetMessagesRequest accRequest = (GetMessagesRequest) appData.getRequest();

        Response response;
        FetchResult fetchResult = null;

        if ( accRequest.getAccountType() == AccountType.TWITTER ) {
            fetchResult = getMessageForTweeter(accRequest.getIds());
        }
        else {
            fetchResult = getMessageForBridges(accRequest.getIds(),
                                               accRequest.getAccountLogins(),
                                               accRequest.getAccountType());
            fetchResult.sort();
        }

        String errors = fetchResult.getErrorBuilder().toString();
        if ( errors.isEmpty() ) {
            response = ResponseImpl.create(Status.OK,
                                           "Pobrano pomyślnie wszystkie tweety.",
                                           appData.getRequest().getTokenId())
                                   .buildFetchResponse(fetchResult.getMessages());
        }
        else {
            response = ResponseImpl.create(Status.ERROR, errors, appData.getRequest().getTokenId())
                                   .buildFetchResponse(fetchResult.getMessages());
        }

        appData.setResponse(response);
        return;
    }

    public FetchResult getMessageForTweeter( List<Long> ids ) {
        StringBuilder errorBuilder = new StringBuilder();
        List<TweetDao> mergedTweets = new ArrayList<TweetDao>();
        try {
            mergedTweets = tweetService.getByIds(ids);
        }
        catch ( Throwable e ) {
            LOGGER.error(getError(e));
            errorBuilder = appendError("Wewnętrzny bład aplikacji.", e);
        }
        return new FetchResult(Message.apply(mergedTweets), errorBuilder);
    }

    public FetchResult getMessageForBridges( List<Long> ids, List<String> logins, AccountType accountType ) {
        FetchResult result = new FetchResult();
        try {
            List<Item> items = ssiAdapter.getItems(accountType, logins, ids);
            result = itemsToMessages(items, accountType);
        }
        catch ( BridgeException e ) {
            LOGGER.error(getError(e));
            result.appendBuilder(appendError("Bład mostu dla pobierania wiadomości.", e));
        }

        return result;
    }
}
