package com.pk.cwierkacz.processor;

import java.util.ArrayList;
import java.util.List;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.processor.handlers.CreateAccountHandler;
import com.pk.cwierkacz.processor.handlers.DeleteAccountHandler;
import com.pk.cwierkacz.processor.handlers.FetchTweetByIdHandler;
import com.pk.cwierkacz.processor.handlers.FetchTweetsHandler;
import com.pk.cwierkacz.processor.handlers.Handler;
import com.pk.cwierkacz.processor.handlers.ListTweetAccounts;
import com.pk.cwierkacz.processor.handlers.LoginHandler;
import com.pk.cwierkacz.processor.handlers.LogoutHandler;
import com.pk.cwierkacz.processor.handlers.ModifyAccountHandler;
import com.pk.cwierkacz.processor.handlers.PublishMessagesHandler;
import com.pk.cwierkacz.processor.handlers.PublishReplyHandler;
import com.pk.cwierkacz.processor.handlers.PublishRetweetHandler;
import com.pk.cwierkacz.processor.handlers.UnwireTweetAcocunt;
import com.pk.cwierkacz.processor.handlers.WireTweetAccount;

public class MainProcessor
{
    private final ChainProcessor chainProcessor;

    private MainProcessor() {
        List<Handler> handlers = new ArrayList<>();
        handlers.add(new CreateAccountHandler());
        handlers.add(new ModifyAccountHandler());
        handlers.add(new DeleteAccountHandler());
        handlers.add(new FetchTweetsHandler());
        handlers.add(new LoginHandler());
        handlers.add(new LogoutHandler());
        handlers.add(new PublishMessagesHandler());
        handlers.add(new PublishReplyHandler());
        handlers.add(new PublishRetweetHandler());
        handlers.add(new WireTweetAccount());
        handlers.add(new UnwireTweetAcocunt());
        handlers.add(new ListTweetAccounts());
        handlers.add(new FetchTweetByIdHandler());

        chainProcessor = new ChainProcessor(handlers);
    }

    private static class InstanceHolder
    {
        public static MainProcessor mainProcessor = new MainProcessor();
    }

    public static MainProcessor getInstance( ) {
        return InstanceHolder.mainProcessor;
    }

    public ApplicationData process( Request request ) {
        ApplicationData applicationData = new ApplicationData();

        if ( request.getAction().equals(Action.NOTRECOGNIZED) ) {
            applicationData.setResponse(ResponseImpl.create(Status.ERROR,
                                                            "No handler for found Action",
                                                            request.getTokenId()));

        }
        else {

            applicationData.setRequest(request);

            chainProcessor.handle(applicationData);
        }
        return applicationData;
    }
}
