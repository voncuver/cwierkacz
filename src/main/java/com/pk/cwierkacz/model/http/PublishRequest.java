package com.pk.cwierkacz.model.http;

import java.sql.Timestamp;
import java.util.List;

public class PublishRequest extends Request
{
    private long replayForId;

    private final String tweet;

    private final List<String> accounts;

    public PublishRequest( Action action,
                           Timestamp timestamp,
                           String functionalUserName,
                           long tokenId,
                           String tweet,
                           List<String> accounts ) {
        super(action, timestamp, functionalUserName, tokenId);
        this.tweet = tweet;
        this.accounts = accounts;
    }

    public PublishRequest( Action action,
                           Timestamp timestamp,
                           String functionalUserName,
                           long tokenId,
                           String tweet,
                           List<String> accounts,
                           long replayForId ) {
        super(action, timestamp, functionalUserName, tokenId);
        this.tweet = tweet;
        this.accounts = accounts;
        this.replayForId = replayForId;
    }

    public long getReplayForId( ) {
        return replayForId;
    }

    public String getTweet( ) {
        return tweet;
    }

    public List<String> getAccounts( ) {
        return accounts;
    }

}
