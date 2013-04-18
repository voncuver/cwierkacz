package com.pk.cwierkacz.model.http;

import java.sql.Timestamp;

public class AddTweeterRequest extends Request
{
    private final String accountTweet;

    private final String passTweet;

    public AddTweeterRequest( Action action,
                              Timestamp timestamp,
                              String functionalUserName,
                              long tokenId,
                              String accountTweet,
                              String passTweet ) {
        super(action, timestamp, functionalUserName, tokenId);
        this.accountTweet = accountTweet;
        this.passTweet = passTweet;
    }

    public String getAccountTweet( ) {
        return accountTweet;
    }

    public String getPassTweet( ) {
        return passTweet;
    }
}
