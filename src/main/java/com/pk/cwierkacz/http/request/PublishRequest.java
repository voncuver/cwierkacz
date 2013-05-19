package com.pk.cwierkacz.http.request;

import java.util.List;

import com.pk.cwierkacz.http.response.dto.Account;

// PublishRequest
public interface PublishRequest extends Request
{
    long getReplayFor( );

    long getRetweetFor( );

    String getTweetText( );

    List<Account> getAccounts( );

    public byte[] getBody( );

    public String getImgName( );
}
