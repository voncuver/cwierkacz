package com.pk.cwierkacz.http.request;

// CreateAccountRequest, UpdateAccountRequest, DeleteAccountRequest
public interface AccountManageRequest extends Request
{
    String getPassword( );

    String getNewPassword( );

}
