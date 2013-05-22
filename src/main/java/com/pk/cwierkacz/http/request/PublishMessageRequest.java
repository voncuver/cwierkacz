package com.pk.cwierkacz.http.request;

import java.util.List;

import com.pk.cwierkacz.http.response.dto.Account;

// PublishRequest
public interface PublishMessageRequest extends Request
{
    String getTweetText( );

    List<Account> getAccounts( );

    byte[] getBody( );

    String getImgName( );

    String getImgURL( );
}
