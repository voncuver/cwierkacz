package com.pk.cwierkacz.model.http;

import java.util.List;

import org.joda.time.DateTime;

public class FetchTweetsRequest
{
    private Request request;

    private List<String> accounts;

    private int size;

    private DateTime date;
    
    public static FetchTweetsRequest buildLoginRequest( Request request, List<String> accounts ) {
        FetchTweetsRequest fetchTweetsRequest = new FetchTweetsRequest();
        fetchTweetsRequest.request = request;
        fetchTweetsRequest.accounts = accounts;
        return fetchTweetsRequest;
    }
    
    public static FetchTweetsRequest buildLoginRequest( Request request, List<String> accounts, int size, DateTime dateTime ) {
        FetchTweetsRequest fetchTweetsRequest = new FetchTweetsRequest();
        fetchTweetsRequest.request = request;
        fetchTweetsRequest.accounts = accounts;
        fetchTweetsRequest.size = size;
        fetchTweetsRequest.date = dateTime;
        return fetchTweetsRequest;
    }

    public Request getRequest( ) {
        return request;
    }

    public List<String> getAccounts( ) {
        return accounts;
    }

    public int getSize( ) {
        return size;
    }

    public DateTime getDate( ) {
        return date;
    }    
}
