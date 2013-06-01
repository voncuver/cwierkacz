/**
 * SocialServiceIntegrationSkeleton.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package pl.edu.pk.ias.socialserviceintegration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataHandler;

import pl.edu.pk.ias.types.AccountsResponse;
import pl.edu.pk.ias.types.AccountsResponseE;
import pl.edu.pk.ias.types.GetItemsPreviewsResponse;
import pl.edu.pk.ias.types.GetItemsPreviewsResponseE;
import pl.edu.pk.ias.types.GetItemsResponse;
import pl.edu.pk.ias.types.GetItemsResponseE;
import pl.edu.pk.ias.types.IsOperationSuccess;
import pl.edu.pk.ias.types.Item;
import pl.edu.pk.ias.types.ItemId;
import pl.edu.pk.ias.types.ItemPreview;
import pl.edu.pk.ias.types.LoginResponse;
import pl.edu.pk.ias.types.LoginResponseE;
import pl.edu.pk.ias.types.LogoutResponse;
import pl.edu.pk.ias.types.LogoutResponseE;
import pl.edu.pk.ias.types.Lss;
import pl.edu.pk.ias.types.PublishResponse;
import pl.edu.pk.ias.types.PublishResponseE;
import pl.edu.pk.ias.types.Token;

import com.pk.cwierkacz.controller.SecurityController;
import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.RequestBuilder;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.response.FetchMessagesResponse;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.http.response.dto.Message;
import com.pk.cwierkacz.model.AccountType;
import com.pk.cwierkacz.model.ApplicationData;

/**
 * SocialServiceIntegrationSkeleton java skeleton for the axisService
 */
public class SocialServiceIntegrationSkeleton implements SocialServiceIntegrationSkeletonInterface
{

    private final SecurityController securityController;

    public SocialServiceIntegrationSkeleton() {
        securityController = new SecurityController();
    }

    /**
     * Auto generated method signature Logowanie do aplikacji
     * 
     * @param loginRequest6
     * @return loginResponse7
     * @throws UserNotExistFault
     * @throws IncorrectPasswordFault
     */

    @Override
    public pl.edu.pk.ias.types.LoginResponseE login( pl.edu.pk.ias.types.LoginRequestE loginRequest6 ) throws UserNotExistFault,
                                                                                                      IncorrectPasswordFault {
        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.USERNAME, new String[] {loginRequest6.getLoginRequest()
                                                                              .getLogin()
                                                                              .getLogin()});
        parametersMap.put(RequestBuilder.PASSWORD, new String[] {loginRequest6.getLoginRequest()
                                                                              .getPassword()
                                                                              .getPassword()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.SIGNIN.getActionName()});

        Response response = securityController.handle(parametersMap, new byte[0]).getResponse();

        LoginResponse loginResponse = new LoginResponse();
        Token token = new Token();
        token.setToken(new Long(response.getTokenId()).toString());
        loginResponse.setToken(token);

        LoginResponseE loginResponseE = new LoginResponseE();
        loginResponseE.setLoginResponse(loginResponse);
        return loginResponseE;
    }

    /**
     * Auto generated method signature Wylogowanie z aplikacji
     * 
     * @param logoutRequest0
     * @return logoutResponse1
     */

    @Override
    public pl.edu.pk.ias.types.LogoutResponseE logout( pl.edu.pk.ias.types.LogoutRequestE logoutRequest0 ) {
        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN, new String[] {logoutRequest0.getLogoutRequest()
                                                                            .getToken()
                                                                            .getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.SIGNOUT.getActionName()});

        Response response = securityController.handle(parametersMap, new byte[0]).getResponse();

        LogoutResponse logoutResponse = new LogoutResponse();
        IsOperationSuccess isOperationSuccess = new IsOperationSuccess();
        isOperationSuccess.setIsOperationSuccess(response.getStatus().equals(Status.OK));
        logoutResponse.setIsOperationSuccess(isOperationSuccess);

        LogoutResponseE logoutResponseE = new LogoutResponseE();
        logoutResponseE.setLogoutResponse(logoutResponse);
        return logoutResponseE;
    }

    /**
     * Auto generated method signature Pobranie list kont serwisów
     * społecznościowych, dla zalogowanego użytkownika
     * 
     * @param accountsRequest4
     * @return accountsResponse5
     * @throws TokenExpiredFault
     */

    @Override
    public pl.edu.pk.ias.types.AccountsResponseE accounts( pl.edu.pk.ias.types.AccountsRequestE accountsRequest4 ) throws TokenExpiredFault {
        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN, new String[] {accountsRequest4.getAccountsRequest()
                                                                              .getToken()
                                                                              .getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM,
                          new String[] {Action.FETCHSOCIALACCOUNTS.getActionName()});

        com.pk.cwierkacz.http.response.LoginResponse response = (com.pk.cwierkacz.http.response.LoginResponse) securityController.handle(parametersMap,
                                                                                                                                         new byte[0])
                                                                                                                                 .getResponse();
        Set<Account> accounts = response.getAccounts();
        List<Lss> accountsNames = new ArrayList<>();
        for ( Account account : accounts ) {
            Lss lss = new Lss();
            lss.setLss(account.getLogin());
            accountsNames.add(lss);
        }

        AccountsResponse accountsResponse = new AccountsResponse();

        accountsResponse.setLss(accountsNames.toArray(new Lss[0]));

        AccountsResponseE accountsResponseE = new AccountsResponseE();
        accountsResponseE.setAccountsResponse(accountsResponse);
        return accountsResponseE;
    }

    /**
     * Auto generated method signature Publikacja treści w serwisie
     * społecznościowym
     * 
     * @param publishRequest8
     * @return publishResponse9
     * @throws TokenExpiredFault
     */

    @Override
    public pl.edu.pk.ias.types.PublishResponseE publish( pl.edu.pk.ias.types.PublishRequestE publishRequest8 ) throws TokenExpiredFault {
        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN, new String[] {publishRequest8.getPublishRequest()
                                                                             .getToken()
                                                                             .getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.PUBLISHMESSAGE.getActionName()});
        parametersMap.put(RequestBuilder.IMGNAME, new String[] {publishRequest8.getPublishRequest()
                                                                               .getFilename()
                                                                               .getFilename()});
        parametersMap.put(RequestBuilder.TWEET, new String[] {publishRequest8.getPublishRequest()
                                                                             .getMessage()
                                                                             .getMessage()});
        parametersMap.put(RequestBuilder.ACCOUNTS, new String[] {publishRequest8.getPublishRequest()
                                                                                .getLss()
                                                                                .getLss()});
        byte[] file = null;
        DataHandler handler = publishRequest8.getPublishRequest().getFile().getFile();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            handler.writeTo(output);
            file = output.toByteArray();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }

        ApplicationData response = securityController.handle(parametersMap, file);

        List<String> ids = response.getParam("TweetId");

        ItemId itemId = new ItemId();
        itemId.setId(ids.get(0));
        itemId.setLss(publishRequest8.getPublishRequest().getLss().getLss());

        PublishResponse publishResponse = new PublishResponse();
        publishResponse.setId(itemId);

        PublishResponseE publishResponseE = new PublishResponseE();
        publishResponseE.setPublishResponse(publishResponse);

        return publishResponseE;
    }

    /**
     * Auto generated method signature Pobranie listy dostępnych elementów ( ID
     * + Name). Element jest bytem różniącym się dla każdego serwisu
     * społecznościowego
     * 
     * @param getItemsPreviewsRequest2
     * @return getItemsPreviewsResponse3
     * @throws TokenExpiredFault
     */

    @Override
    public pl.edu.pk.ias.types.GetItemsPreviewsResponseE getItemsPreviews( pl.edu.pk.ias.types.GetItemsPreviewsRequestE getItemsPreviewsRequest2 ) throws TokenExpiredFault {
        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN,
                          new String[] {getItemsPreviewsRequest2.getGetItemsPreviewsRequest()
                                                                .getToken()
                                                                .getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.FETCHMESSAGES.getActionName()});
        parametersMap.put(RequestBuilder.DATEFROM,
                          new String[] {new Long(getItemsPreviewsRequest2.getGetItemsPreviewsRequest()
                                                                         .getDateFrom()
                                                                         .getDateFrom()
                                                                         .getTime()
                                                                         .getTime()).toString()});
        parametersMap.put(RequestBuilder.DATETO,
                          new String[] {new Long(getItemsPreviewsRequest2.getGetItemsPreviewsRequest()
                                                                         .getDateTo()
                                                                         .getDateTo()
                                                                         .getTime()
                                                                         .getTime()).toString()});
        parametersMap.put(RequestBuilder.ACCOUNTS,
                          new String[] {getItemsPreviewsRequest2.getGetItemsPreviewsRequest()
                                                                .getLss()
                                                                .getLss()});

        parametersMap.put(RequestBuilder.ACCOUNTTYPE,
                          new String[] {getItemsPreviewsRequest2.getGetItemsPreviewsRequest()
                                                                .getLss()
                                                                .getLss()});

        FetchMessagesResponse response = (FetchMessagesResponse) securityController.handle(parametersMap,
                                                                                           new byte[0])
                                                                                   .getResponse();

        GetItemsPreviewsResponse getItemsPreviewsResponse = new GetItemsPreviewsResponse();

        for ( com.pk.cwierkacz.http.response.dto.Message message : response.getMessages() ) {

            ItemId itemId = new ItemId();
            itemId.setLss(message.getAccount().getLogin());
            itemId.setId(message.getId().toString());
            ItemPreview itemPreview = new ItemPreview();

            itemPreview.setId(itemId);
            if ( message.getText().length() > 10 ) {
                itemPreview.setName(message.getText().substring(0, 10) + "...");
            }
            else {
                itemPreview.setName(message.getText());
            }

            getItemsPreviewsResponse.addItemPreviewsList(itemPreview);

        }
        GetItemsPreviewsResponseE getItemsPreviewsResponseE = new GetItemsPreviewsResponseE();
        getItemsPreviewsResponseE.setGetItemsPreviewsResponse(getItemsPreviewsResponse);
        return getItemsPreviewsResponseE;
    }

    /**
     * Auto generated method signature Pobranie kompletnych elementów. Element
     * jest bytem różniącym się dla każdego serwisu społecznościowego
     * 
     * @param getItemsRequest12
     * @return getItemsResponse13
     * @throws TokenExpiredFault
     */

    @Override
    public pl.edu.pk.ias.types.GetItemsResponseE getItems( pl.edu.pk.ias.types.GetItemsRequestE getItemsRequest12 ) throws TokenExpiredFault {
        Map<String, String[]> parametersMap = new HashMap<String, String[]>();
        parametersMap.put(RequestBuilder.TOKEN, new String[] {getItemsRequest12.getGetItemsRequest()
                                                                               .getToken()
                                                                               .getToken()});
        parametersMap.put(RequestBuilder.ACTIONPARAM, new String[] {Action.GETMESSAGES.getActionName()});

        List<String> ids = new ArrayList<>();
        for ( ItemId id : getItemsRequest12.getGetItemsRequest().getIdsList() ) {
            ids.add(id.getId().toString());
        }

        parametersMap.put(RequestBuilder.IDS, ids.toArray(new String[0]));
        parametersMap.put(RequestBuilder.ACCOUNTTYPE, new String[] {AccountType.TWITTER.getType()});

        FetchMessagesResponse response = (FetchMessagesResponse) securityController.handle(parametersMap,
                                                                                           new byte[0])
                                                                                   .getResponse();

        GetItemsResponse getItemsResponse = new GetItemsResponse();

        for ( Message message : response.getMessages() ) {

            ItemId itemId = new ItemId();
            itemId.setLss(message.getAccount().getLogin());
            itemId.setId(message.getId().toString());
            Item item = new Item();
            item.setMessage(message.getText());
            if ( message.getText().length() > 10 ) {
                item.setName(message.getText().substring(0, 10) + "...");
            }
            else {
                item.setName(message.getText());
            }

            getItemsResponse.addItemsList(item);

        }

        GetItemsResponseE getItemsResponseE = new GetItemsResponseE();
        getItemsResponseE.setGetItemsResponse(getItemsResponse);

        return getItemsResponseE;
    }

    /**
     * Auto generated method signature Usunięcie wybranych elementów
     * 
     * @param removeRequest10
     * @return removeResponse11
     * @throws TokenExpiredFault
     */

    @Override
    public pl.edu.pk.ias.types.RemoveResponseE remove( pl.edu.pk.ias.types.RemoveRequestE removeRequest10 ) throws TokenExpiredFault {
        //TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Not supported by Twitter");
    }
}
