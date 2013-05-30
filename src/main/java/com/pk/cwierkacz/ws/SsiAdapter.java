package com.pk.cwierkacz.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.edu.pk.ias.socialserviceintegration.BadRequestFault;
import pl.edu.pk.ias.socialserviceintegration.InvalidLoginOrPasswordFault;
import pl.edu.pk.ias.socialserviceintegration.ServiceUnavailableFault;
import pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration;
import pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault;
import pl.edu.pk.ias.types.AccountsRequest;
import pl.edu.pk.ias.types.AccountsResponse;
import pl.edu.pk.ias.types.GetItemsPreviewsRequest;
import pl.edu.pk.ias.types.GetItemsPreviewsResponse;
import pl.edu.pk.ias.types.GetItemsRequest;
import pl.edu.pk.ias.types.GetItemsResponse;
import pl.edu.pk.ias.types.Item;
import pl.edu.pk.ias.types.ItemId;
import pl.edu.pk.ias.types.ItemPreview;
import pl.edu.pk.ias.types.LoginRequest;
import pl.edu.pk.ias.types.LoginResponse;
import pl.edu.pk.ias.types.LogoutRequest;
import pl.edu.pk.ias.types.LogoutResponse;
import pl.edu.pk.ias.types.PublishRequest;
import pl.edu.pk.ias.types.PublishResponse;

import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.ws.client.SocialServiceIntegrationImplService;

public class SsiAdapter
{
    private final SocialServiceIntegrationImplService facebookService;
    private final SocialServiceIntegrationImplService flickrService;
    private final SocialServiceIntegrationImplService twitpicService;

    private static class InstanceHolder
    {
        public static SsiAdapter ssiAdapter = new SsiAdapter();
    }

    public static SsiAdapter getInstance( ) {
        return InstanceHolder.ssiAdapter;
    }

    private SsiAdapter() {
        facebookService = new SocialServiceIntegrationImplService("http://fb.xlv.pl/cms");
        flickrService = new SocialServiceIntegrationImplService("https://37.28.156.233:8181/FilckrIAS/services/integration/socialserviceintegration");
        twitpicService = new SocialServiceIntegrationImplService("http://twitpic.piotrkubowicz.pl/soap");
    }

    public Result login( String login, String password, AccountType accountType ) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin(login);
        loginRequest.setPassword(password);

        Result result = null;
        if ( AccountType.FACEBOOKBRIDGE.equals(accountType) ) {
            SocialServiceIntegration facePort = facebookService.getSocialServiceIntegrationImplPort();
            result = loginToPort(loginRequest, facePort, accountType);
        }
        else if ( AccountType.FLICKERBRIDGE.equals(accountType) ) {
            SocialServiceIntegration flickPort = flickrService.getSocialServiceIntegrationImplPort();
            result = loginToPort(loginRequest, flickPort, accountType);
        }
        else if ( AccountType.TWITPICBRIDGE.equals(accountType) ) {
            SocialServiceIntegration twitpicPort = twitpicService.getSocialServiceIntegrationImplPort();
            result = loginToPort(loginRequest, twitpicPort, accountType);
        }
        return result;
    }

    private Result loginToPort( LoginRequest loginRequest,
                                SocialServiceIntegration port,
                                AccountType accountType ) {
        Result result = null;
        LoginResponse loginResponse = null;
        try {
            loginResponse = port.login(loginRequest);
        }
        catch ( InvalidLoginOrPasswordFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        result = new Result(true, "Zalogowano pomyślnie.");
        result.setToken(loginResponse.getToken());
        return result;
    }

    public boolean logout( String login, String password, AccountType accountType ) {

        boolean result = false;
        if ( AccountType.FACEBOOKBRIDGE.equals(accountType) ) {
            SocialServiceIntegration facePort = facebookService.getSocialServiceIntegrationImplPort();
            result = logoutToPort(facePort, accountType);
        }
        else if ( AccountType.FLICKERBRIDGE.equals(accountType) ) {
            SocialServiceIntegration flickPort = flickrService.getSocialServiceIntegrationImplPort();
            result = logoutToPort(flickPort, accountType);
        }
        else if ( AccountType.TWITPICBRIDGE.equals(accountType) ) {
            SocialServiceIntegration twitpicPort = twitpicService.getSocialServiceIntegrationImplPort();
            result = logoutToPort(twitpicPort, accountType);
        }
        return result;
    }

    private boolean logoutToPort( SocialServiceIntegration port, AccountType accountType ) {

        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setToken(null);
        //TODO: get token, remove on success

        LogoutResponse logoutResponse = null;
        try {
            logoutResponse = port.logout(logoutRequest);
        }
        catch ( TokenExpiredFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return logoutResponse.isIsOperationSuccess();
    }

    public List<Account> getAccounts( ) {

        List<Account> accounts = new ArrayList<>();

        SocialServiceIntegration facePort = facebookService.getSocialServiceIntegrationImplPort();
        accounts.addAll(getAccounts(facePort, AccountType.FACEBOOKBRIDGE));

        SocialServiceIntegration twitpPort = twitpicService.getSocialServiceIntegrationImplPort();
        accounts.addAll(getAccounts(twitpPort, AccountType.FACEBOOKBRIDGE));

        SocialServiceIntegration flickPort = flickrService.getSocialServiceIntegrationImplPort();
        accounts.addAll(getAccounts(flickPort, AccountType.FACEBOOKBRIDGE));

        return accounts;
    }

    private List<Account> getAccounts( SocialServiceIntegration wsPort, AccountType accountType ) {
        List<Account> accounts = new ArrayList<>();
        AccountsRequest accountsRequest = new AccountsRequest();
        accountsRequest.setToken(null);
        //TODO: get token by accounType
        AccountsResponse response = null;
        try {
            response = wsPort.accounts(accountsRequest);
        }
        catch ( BadRequestFault | ServiceUnavailableFault | TokenExpiredFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for ( String name : response.getLss() ) {
            accounts.add(new Account(name, name, accountType));
        }
        return accounts;
    }

    public ItemId publishTweet( AccountType accountType, String description, String account ) throws BridgeException {
        return publishTweet(accountType, description, account, null, null);
    }

    public ItemId publishTweet( AccountType accountType,
                                String description,
                                String account,
                                String fileName,
                                byte[] file ) throws BridgeException {
        PublishResponse resp = null;
        PublishRequest publishRequest = new PublishRequest();
        publishRequest.setMessage(description);
        publishRequest.setFile(file);
        publishRequest.setFilename(fileName);
        publishRequest.setLss(account);
        publishRequest.setToken(null);
        //TODO: get token by accounType
        try {
            if ( AccountType.FACEBOOKBRIDGE.equals(accountType) ) {
                SocialServiceIntegration facePort = facebookService.getSocialServiceIntegrationImplPort();
                resp = facePort.publish(publishRequest);
            }
            else if ( AccountType.FLICKERBRIDGE.equals(accountType) ) {
                SocialServiceIntegration flickPort = flickrService.getSocialServiceIntegrationImplPort();
                resp = flickPort.publish(publishRequest);
            }
            else if ( AccountType.TWITPICBRIDGE.equals(accountType) ) {
                SocialServiceIntegration twitpicPort = twitpicService.getSocialServiceIntegrationImplPort();
                resp = twitpicPort.publish(publishRequest);
            }
            return resp.getId();

        }
        catch ( BadRequestFault | ServiceUnavailableFault | TokenExpiredFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new BridgeException(e);
        }
    }

    public List<Item> fetchIteams( Date dateFrom, Date dateTo, String account ) throws BridgeException {
        List<Item> iteams = new ArrayList<>();
        iteams.addAll(fetchIteams(AccountType.FACEBOOKBRIDGE, dateFrom, dateTo, account));
        iteams.addAll(fetchIteams(AccountType.FLICKERBRIDGE, dateFrom, dateTo, account));
        iteams.addAll(fetchIteams(AccountType.TWITPICBRIDGE, dateFrom, dateTo, account));
        return iteams;
    }

    public List<Item> fetchIteams( AccountType accountType, Date dateFrom, Date dateTo, String account ) throws BridgeException {
        GetItemsPreviewsRequest getItemsPreviewsRequest = new GetItemsPreviewsRequest();
        //        getItemsPreviewsRequest.setDateFrom(dateFrom);
        //        getItemsPreviewsRequest.setDateTo(dateTo);
        getItemsPreviewsRequest.setLss(account);
        getItemsPreviewsRequest.setToken(null);
        //TODO: token
        GetItemsPreviewsResponse getItemsPreviewsResponse = getPrieviews(accountType, getItemsPreviewsRequest);

        List<ItemPreview> itemsPrevs = getItemsPreviewsResponse.getItemPreviewsList();

        GetItemsRequest getItemsRequest = new GetItemsRequest();
        getItemsRequest.setToken(null);
        //TODO: token

        for ( ItemPreview itemPreview : itemsPrevs ) {
            getItemsRequest.getIdsList().add(itemPreview.getId());
        }

        GetItemsResponse getItemsResponse = getIteams(accountType, getItemsRequest);

        return getItemsResponse.getItemsList();
    }

    private GetItemsPreviewsResponse getPrieviews( AccountType accountType,
                                                   GetItemsPreviewsRequest getItemsPreviewsRequest ) throws BridgeException {
        GetItemsPreviewsResponse getItemsPreviewsResponse = new GetItemsPreviewsResponse();
        try {
            if ( AccountType.FACEBOOKBRIDGE.equals(accountType) ) {
                SocialServiceIntegration facePort = facebookService.getSocialServiceIntegrationImplPort();
                getItemsPreviewsResponse = facePort.getItemsPreviews(getItemsPreviewsRequest);
            }
            else if ( AccountType.FLICKERBRIDGE.equals(accountType) ) {
                SocialServiceIntegration flickPort = flickrService.getSocialServiceIntegrationImplPort();
                getItemsPreviewsResponse = flickPort.getItemsPreviews(getItemsPreviewsRequest);
            }
            else if ( AccountType.TWITPICBRIDGE.equals(accountType) ) {
                SocialServiceIntegration twitpicPort = twitpicService.getSocialServiceIntegrationImplPort();
                getItemsPreviewsResponse = twitpicPort.getItemsPreviews(getItemsPreviewsRequest);
            }
            return getItemsPreviewsResponse;
        }
        catch ( BadRequestFault | ServiceUnavailableFault | TokenExpiredFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new BridgeException(e);
        }
    }

    private GetItemsResponse getIteams( AccountType accountType, GetItemsRequest getItemsRequest ) throws BridgeException {
        GetItemsResponse getItemsResponse = new GetItemsResponse();

        try {
            if ( AccountType.FACEBOOKBRIDGE.equals(accountType) ) {
                SocialServiceIntegration facePort = facebookService.getSocialServiceIntegrationImplPort();
                getItemsResponse = facePort.getItems(getItemsRequest);
            }
            else if ( AccountType.FLICKERBRIDGE.equals(accountType) ) {
                SocialServiceIntegration flickPort = flickrService.getSocialServiceIntegrationImplPort();
                getItemsResponse = flickPort.getItems(getItemsRequest);
            }
            else if ( AccountType.TWITPICBRIDGE.equals(accountType) ) {
                SocialServiceIntegration twitpicPort = twitpicService.getSocialServiceIntegrationImplPort();
                getItemsResponse = twitpicPort.getItems(getItemsRequest);
            }
            return getItemsResponse;
        }
        catch ( BadRequestFault | ServiceUnavailableFault | TokenExpiredFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new BridgeException(e);
        }
    }

    public class Result
    {
        private final boolean correct;

        private final String msg;

        private String token;

        public Result( boolean result, String msg ) {
            this.msg = msg;
            this.correct = result;
        }

        public String getToken( ) {
            return token;
        }

        public void setToken( String token ) {
            this.token = token;
        }

        public boolean isCorrect( ) {
            return correct;
        }

        public String getMsg( ) {
            return msg;
        }
    }
}
