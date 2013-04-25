package com.pk.cwierkacz.http.request;

import java.util.List;

public interface PublishRequest extends Request
{
    long getReplayForId( );

    //TODO dopisać id potencjalnego reteeta

    String getTweetText( );

    List<String> getAccounts( );
}
