package com.pk.cwierkacz.processor.handlers;

import java.util.ArrayList;
import java.util.List;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.FetchMessagesRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.http.response.dto.Message;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.SessionDao;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SessionService;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.UserService;

public class GetMessagesHandler extends AbstractHandler
{
    private final UserService userService;
    private final SessionService sessionService;
    private final TweetService tweetService;

    public GetMessagesHandler() {
        userService = ServiceRepo.getInstance().getService(UserService.class);
        sessionService = ServiceRepo.getInstance().getService(SessionService.class);
        tweetService = ServiceRepo.getInstance().getService(TweetService.class);
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.GETMESSAGES);
    }

    //TODO a czy to na pewno nie ma byc synchronizacji z tweeterem? - co jesli chcemy pobrac tweeta po id ktorego nie ma w tej chwili jeszcze w bazie? nie wiem po co ten handler powstał - byc moze jest dobrze bo biznesowo taki przypadek jest nieuzasadniony?
    @Override
    public void handle( ApplicationData appData ) {
        FetchMessagesRequest accRequest = (FetchMessagesRequest) appData.getRequest();

        SessionDao sessionDao = sessionService.getByToken(accRequest.getTokenId());
        UserDao user = userService.getBySessionId(sessionDao);
        if ( user != null && user.getSession().getCurrentToken() != accRequest.getTokenId() ) {
            Response response = ResponseImpl.create(Status.DENY, "Zły token.", accRequest.getTokenId());
            appData.setResponse(response);
            return;
        }

        List<TweetDao> mergedTweets = new ArrayList<>();

        for ( Long id : accRequest.getIds() ) {
            TweetDao tweetDao = tweetService.getById(id);

            String login = tweetDao.getCreatorName();
            for ( TwitterAccountDao account : user.getAccounts() ) {
                if ( account.equals(login) ) {
                    mergedTweets.add(tweetDao);
                    break;
                }
            }
        }

        Response response = ResponseImpl.create(Status.OK,
                                                "Pobrano pomyślnie wszystkie tweety.",
                                                appData.getRequest().getTokenId())
                                        .buildFetchResponse(Message.apply(mergedTweets));
        appData.setResponse(response);
        return;
    }
}
