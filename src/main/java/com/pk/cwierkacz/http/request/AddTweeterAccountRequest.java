package com.pk.cwierkacz.http.request;

import com.pk.cwierkacz.model.AccountType;

// AddTweeterAccountRequest, DelTweeterAccountRequest
public interface AddTweeterAccountRequest extends Request
{

    String getLoginTweet( );

    String getPasswordTweet( );

    AccountType getAccountType( );
}
