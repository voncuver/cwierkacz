package com.pk.cwierkacz.ws;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import pl.edu.pk.ias.socialserviceintegration.IncorrectPasswordFault;
import pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration;
import pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault;
import pl.edu.pk.ias.socialserviceintegration.UserNotExistFault;
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
import pl.edu.pk.ias.types.RemoveRequest;
import pl.edu.pk.ias.types.RemoveResponse;

import com.pk.cwierkacz.controller.SecurityController;
import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.RequestBuilder;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.response.FetchMessagesResponse;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.http.response.dto.Message;
import com.pk.cwierkacz.model.ApplicationData;

@WebService( endpointInterface = "pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration" )
public class SocialServiceIntegrationImpl implements SocialServiceIntegration
{

    private final SecurityController securityController;

    public SocialServiceIntegrationImpl() {
        securityController = new SecurityController();
    }

    @Override
    @WebMethod( action = "http://pk.edu.pl/ias/socialserviceintegration/action/login" )
    @WebResult( name = "loginResponse",
                targetNamespace = "http://pk.edu.pl/ias/types",
                partName = "parameters" )
    public LoginResponse login( @WebParam( name = "loginRequest",
                                           targetNamespace = "http://pk.edu.pl/ias/types",
                                           partName = "parameters" ) LoginRequest parameters ) throws IncorrectPasswordFault,
                                                                                              UserNotExistFault {
        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.USERNAME, new String[] {parameters.getLogin()});
        parametersMap.put(RequestBuilder.PASSWORD, new String[] {parameters.getPassword()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.SIGNIN.getActionName()});

        Response response = securityController.handle(parametersMap, new byte[0]).getResponse();

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(Long.toString(response.getTokenId()));
        return loginResponse;
    }

    @Override
    @WebMethod( action = "http://pk.edu.pl/ias/socialserviceintegration/action/logout" )
    @WebResult( name = "logoutResponse",
                targetNamespace = "http://pk.edu.pl/ias/types",
                partName = "parameters" )
    public LogoutResponse logout( @WebParam( name = "logoutRequest",
                                             targetNamespace = "http://pk.edu.pl/ias/types",
                                             partName = "parameters" ) LogoutRequest parameters ) {

        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN, new String[] {parameters.getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.SIGNOUT.getActionName()});

        Response response = securityController.handle(parametersMap, new byte[0]).getResponse();

        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setIsOperationSuccess(response.getStatus().equals(Status.OK));
        return logoutResponse;
    }

    @Override
    @WebMethod( action = "http://pk.edu.pl/ias/socialserviceintegration/action/accounts" )
    @WebResult( name = "accountsResponse",
                targetNamespace = "http://pk.edu.pl/ias/types",
                partName = "parameters" )
    public AccountsResponse accounts( @WebParam( name = "accountsRequest",
                                                 targetNamespace = "http://pk.edu.pl/ias/types",
                                                 partName = "parameters" ) AccountsRequest parameters ) throws TokenExpiredFault {
        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN, new String[] {parameters.getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM,
                          new String[] {Action.FETCHSOCIALACCOUNTS.getActionName()});

        com.pk.cwierkacz.http.response.LoginResponse response = (com.pk.cwierkacz.http.response.LoginResponse) securityController.handle(parametersMap,
                                                                                                                                         new byte[0])
                                                                                                                                 .getResponse();
        Set<Account> accounts = response.getAccounts();
        List<String> accountsNames = new ArrayList<>();
        for ( Account account : accounts ) {
            accountsNames.add(account.getLogin());
        }

        AccountsResponse accountsResponse = new AccountsResponse();
        accountsResponse.getLss().addAll(accountsNames);
        return accountsResponse;
    }

    @Override
    @WebMethod( action = "http://pk.edu.pl/ias/socialserviceintegration/action/publish" )
    @WebResult( name = "publishResponse",
                targetNamespace = "http://pk.edu.pl/ias/types",
                partName = "parameters" )
    public PublishResponse publish( @WebParam( name = "publishRequest",
                                               targetNamespace = "http://pk.edu.pl/ias/types",
                                               partName = "parameters" ) PublishRequest parameters ) throws TokenExpiredFault {

        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN, new String[] {parameters.getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.PUBLISHMESSAGE.getActionName()});
        parametersMap.put(RequestBuilder.IMGNAME, new String[] {parameters.getFilename()});
        parametersMap.put(RequestBuilder.TWEET, new String[] {parameters.getDescription()});
        parametersMap.put(RequestBuilder.ACCOUNTS, new String[] {parameters.getLss()});

        ApplicationData response = securityController.handle(parametersMap, parameters.getFile());

        List<String> ids = response.getParam("TweetId");

        ItemId itemId = new ItemId();
        itemId.setId(new BigInteger(ids.get(0)));
        itemId.setLss(parameters.getLss());

        PublishResponse publishResponse = new PublishResponse();
        publishResponse.setId(itemId);
        return publishResponse;
    }

    @Override
    @WebMethod( action = "http://pk.edu.pl/ias/socialserviceintegration/action/getItemsPreviews" )
    @WebResult( name = "getItemsPreviewsResponse",
                targetNamespace = "http://pk.edu.pl/ias/types",
                partName = "parameters" )
    public GetItemsPreviewsResponse getItemsPreviews( @WebParam( name = "getItemsPreviewsRequest",
                                                                 targetNamespace = "http://pk.edu.pl/ias/types",
                                                                 partName = "parameters" ) GetItemsPreviewsRequest parameters ) throws TokenExpiredFault {

        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN, new String[] {parameters.getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.FETCHMESSAGES.getActionName()});
        parametersMap.put(RequestBuilder.DATEFROM, new String[] {parameters.getDateFrom().toString()});
        parametersMap.put(RequestBuilder.DATETO, new String[] {parameters.getDateTo().toString()});
        parametersMap.put(RequestBuilder.ACCOUNTS, new String[] {parameters.getLss()});

        FetchMessagesResponse response = (FetchMessagesResponse) securityController.handle(parametersMap,
                                                                                           new byte[0])
                                                                                   .getResponse();

        GetItemsPreviewsResponse getItemsPreviewsResponse = new GetItemsPreviewsResponse();

        for ( Message message : response.getMessages() ) {

            ItemId itemId = new ItemId();
            itemId.setLss(message.getAccount().getLogin());
            itemId.setId(BigInteger.valueOf(message.getId()));
            ItemPreview itemPreview = new ItemPreview();

            itemPreview.setId(itemId);
            if ( message.getText().length() > 10 ) {
                itemPreview.setName(message.getText().substring(0, 10) + "...");
            }
            else {
                itemPreview.setName(message.getText());
            }

            getItemsPreviewsResponse.getItemPreviewsList().add(itemPreview);

        }
        return getItemsPreviewsResponse;
    }

    @Override
    @WebMethod( action = "http://pk.edu.pl/ias/socialserviceintegration/action/getItems" )
    @WebResult( name = "getItemsResponse",
                targetNamespace = "http://pk.edu.pl/ias/types",
                partName = "parameters" )
    public GetItemsResponse getItems( @WebParam( name = "getItemsRequest",
                                                 targetNamespace = "http://pk.edu.pl/ias/types",
                                                 partName = "parameters" ) GetItemsRequest parameters ) throws TokenExpiredFault {

        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN, new String[] {parameters.getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.FETCHMESSAGEBYID.getActionName()});

        List<String> ids = new ArrayList<>();
        for ( ItemId id : parameters.getIdsList() ) {
            ids.add(id.getId().toString());
        }

        parametersMap.put(RequestBuilder.IDS, ids.toArray(new String[0]));

        FetchMessagesResponse response = (FetchMessagesResponse) securityController.handle(parametersMap,
                                                                                           new byte[0])
                                                                                   .getResponse();

        GetItemsResponse getItemsResponse = new GetItemsResponse();

        for ( Message message : response.getMessages() ) {

            ItemId itemId = new ItemId();
            itemId.setLss(message.getAccount().getLogin());
            itemId.setId(BigInteger.valueOf(message.getId()));
            Item item = new Item();
            item.setDescription(message.getText());
            if ( message.getText().length() > 10 ) {
                item.setName(message.getText().substring(0, 10) + "...");
            }
            else {
                item.setName(message.getText());
            }

            getItemsResponse.getItemsList().add(item);

        }
        return getItemsResponse;
    }

    @Override
    @WebMethod( action = "http://pk.edu.pl/ias/socialserviceintegration/action/remove" )
    @WebResult( name = "removeResponse",
                targetNamespace = "http://pk.edu.pl/ias/types",
                partName = "parameters" )
    public RemoveResponse remove( @WebParam( name = "removeRequest",
                                             targetNamespace = "http://pk.edu.pl/ias/types",
                                             partName = "parameters" ) RemoveRequest parameters ) throws TokenExpiredFault {
        return null;
    }

}
