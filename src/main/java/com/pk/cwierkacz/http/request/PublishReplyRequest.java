package com.pk.cwierkacz.http.request;

public interface PublishReplyRequest extends Request
{
    long getReplayFor( );

    String getTweetText( );

    byte[] getBody( );

    String getLoginTweet( );
}
