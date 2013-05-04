package com.pk.cwierkacz.http.request;

// AddTweeterAccountRequest, DelTweeterAccountRequest
public interface AddTweeterAccountRequest extends Request
{

    String getLoginTweet( );

    String getPasswordTweet( );
}
