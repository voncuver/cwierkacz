package com.pk.cwierkacz.http.request;

import java.util.List;

public interface PublishRequest extends Request
{
    long getReplayForId( );

    String getTweetText( );

    List<String> getAccounts( );
}
