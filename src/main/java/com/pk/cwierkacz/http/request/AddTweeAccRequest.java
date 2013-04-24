package com.pk.cwierkacz.http.request;

public interface AddTweeAccRequest extends Request
{

    String getAccountTweet( );

    String getPassTweet( );

    Long getPin( );
}
