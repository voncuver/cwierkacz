package com.pk.cwierkacz.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.edu.pk.ias.types.AccountsRequest;
import pl.edu.pk.ias.types.AccountsResponse;
import pl.edu.pk.ias.types.GetItemsPreviewsRequest;
import pl.edu.pk.ias.types.GetItemsPreviewsResponse;
import pl.edu.pk.ias.types.GetItemsRequest;
import pl.edu.pk.ias.types.GetItemsResponse;
import pl.edu.pk.ias.types.Item;
import pl.edu.pk.ias.types.ItemPreview;
import pl.edu.pk.ias.types.LoginRequest;
import pl.edu.pk.ias.types.LoginResponse;
import pl.edu.pk.ias.types.LogoutRequest;
import pl.edu.pk.ias.types.LogoutResponse;
import pl.edu.pk.ias.types.PublishRequest;

import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.http.response.dto.Message;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.ws.client.IncorrectPasswordFault;
import com.pk.cwierkacz.ws.client.SocialServiceIntegration;
import com.pk.cwierkacz.ws.client.SocialServiceIntegrationImplService;
import com.pk.cwierkacz.ws.client.TokenExpiredFault;
import com.pk.cwierkacz.ws.client.UserNotExistFault;

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
        facebookService = new SocialServiceIntegrationImplService("");
        flickrService = new SocialServiceIntegrationImplService("https://37.28.156.233:8181/FilckrIAS/services/integration/socialserviceintegration?wsdl");
        twitpicService = new SocialServiceIntegrationImplService("http://twitpic.piotrkubowicz.pl/soap");
    }

    public boolean login( String login, String password, AccountType accountType ) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin(login);
        loginRequest.setPassword(password);

        boolean result = false;
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

    private boolean loginToPort( LoginRequest loginRequest,
                                 SocialServiceIntegration port,
                                 AccountType accountType ) {
        try {
            LoginResponse loginResponse = port.login(loginRequest);
            //TODO: persist token
        }
        catch ( IncorrectPasswordFault | UserNotExistFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
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

        LogoutResponse logoutResponse = port.logout(logoutRequest);
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
        try {
            AccountsResponse response = wsPort.accounts(accountsRequest);
            for ( String name : response.getLss() ) {
                accounts.add(new Account(name, accountType));
            }
        }
        catch ( TokenExpiredFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return accounts;
    }

    public void publishTweet( AccountType accountType, String description, String account ) {
        publishTweet(accountType, description, account, null, null);
    }

    public void publishTweet( AccountType accountType,
                              String description,
                              String account,
                              String fileName,
                              byte[] file ) {
        PublishRequest publishRequest = new PublishRequest();
        publishRequest.setDescription(description);
        publishRequest.setFile(file);
        publishRequest.setFilename(fileName);
        publishRequest.setLss(account);
        publishRequest.setToken(null);
        //TODO: get token by accounType
        try {
            if ( AccountType.FACEBOOKBRIDGE.equals(accountType) ) {
                SocialServiceIntegration facePort = facebookService.getSocialServiceIntegrationImplPort();
                facePort.publish(publishRequest);
            }
            else if ( AccountType.FLICKERBRIDGE.equals(accountType) ) {
                SocialServiceIntegration flickPort = flickrService.getSocialServiceIntegrationImplPort();
                flickPort.publish(publishRequest);
            }
            else if ( AccountType.TWITPICBRIDGE.equals(accountType) ) {
                SocialServiceIntegration twitpicPort = twitpicService.getSocialServiceIntegrationImplPort();
                twitpicPort.publish(publishRequest);
            }
        }
        catch ( TokenExpiredFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Message> fetchIteams( Date dateFrom, Date dateTo, String account ) {
        List<Message> messages = new ArrayList<>();
        messages.addAll(fetchIteams(AccountType.FACEBOOKBRIDGE, dateFrom, dateTo, account));
        messages.addAll(fetchIteams(AccountType.FLICKERBRIDGE, dateFrom, dateTo, account));
        messages.addAll(fetchIteams(AccountType.TWITPICBRIDGE, dateFrom, dateTo, account));
        return messages;
    }

    public List<Message> fetchIteams( AccountType accountType, Date dateFrom, Date dateTo, String account ) {
        GetItemsPreviewsRequest getItemsPreviewsRequest = new GetItemsPreviewsRequest();
        getItemsPreviewsRequest.setDateFrom(dateFrom);
        getItemsPreviewsRequest.setDateTo(dateTo);
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

        List<Message> messages = new ArrayList<>();

        for ( Item iteam : getItemsResponse.getItemsList() ) {
            Message message = new Message();

            message.setAccount(new Account(account, accountType));
            message.setText(iteam.getDescription());
            message.setId(iteam.getId().getId().longValue());
            messages.add(message);
        }

        return messages;
    }

    private GetItemsPreviewsResponse getPrieviews( AccountType accountType,
                                                   GetItemsPreviewsRequest getItemsPreviewsRequest ) {
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
        }
        catch ( TokenExpiredFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return getItemsPreviewsResponse;
    }

    private GetItemsResponse getIteams( AccountType accountType, GetItemsRequest getItemsRequest ) {
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
        }
        catch ( TokenExpiredFault e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return getItemsResponse;
    }
}
