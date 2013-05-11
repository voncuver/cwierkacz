package com.pk.cwierkacz.ws;

import java.math.BigInteger;

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

@WebService( endpointInterface = "pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration" )
public class SocialServiceIntegrationImpl implements SocialServiceIntegration
{

    @Override
    @WebMethod( action = "http://pk.edu.pl/ias/socialserviceintegration/action/login" )
    @WebResult( name = "loginResponse",
                targetNamespace = "http://pk.edu.pl/ias/types",
                partName = "parameters" )
    public LoginResponse login( @WebParam( name = "loginRequest",
                                           targetNamespace = "http://pk.edu.pl/ias/types",
                                           partName = "parameters" ) LoginRequest parameters ) throws IncorrectPasswordFault,
                                                                                              UserNotExistFault {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken("1234");
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
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setIsOperationSuccess(true);
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
        AccountsResponse accountsResponse = new AccountsResponse();
        accountsResponse.getLss().add("AAA");
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
        ItemId itemId = new ItemId();
        itemId.setId(new BigInteger("1234"));
        itemId.setLss("test");

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
        GetItemsPreviewsResponse getItemsPreviewsRequest = new GetItemsPreviewsResponse();
        ItemPreview itemPreview = new ItemPreview();
        itemPreview.setName("aaa");
        getItemsPreviewsRequest.getItemPreviewsList().add(itemPreview);
        return getItemsPreviewsRequest;
    }

    @Override
    @WebMethod( action = "http://pk.edu.pl/ias/socialserviceintegration/action/getItems" )
    @WebResult( name = "getItemsResponse",
                targetNamespace = "http://pk.edu.pl/ias/types",
                partName = "parameters" )
    public GetItemsResponse getItems( @WebParam( name = "getItemsRequest",
                                                 targetNamespace = "http://pk.edu.pl/ias/types",
                                                 partName = "parameters" ) GetItemsRequest parameters ) throws TokenExpiredFault {
        Item item = new Item();
        item.setDescription("test");

        GetItemsResponse getItemsResponse = new GetItemsResponse();
        getItemsResponse.getItemsList().add(item);
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
        RemoveResponse removeResponse = new RemoveResponse();
        ItemId itemId = new ItemId();
        itemId.setLss("1111");
        removeResponse.getIdsList().add(itemId);
        return removeResponse;
    }

}
