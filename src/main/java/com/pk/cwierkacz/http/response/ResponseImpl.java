package com.pk.cwierkacz.http.response;

import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.response.dto.Account;
import com.pk.cwierkacz.http.response.dto.Message;

@JsonSerialize( include = JsonSerialize.Inclusion.NON_NULL )
public class ResponseImpl implements Response, LoginResponse, FetchMessagesResponse
{

    private Status status;

    private String text;

    @JsonIgnore
    private long tokenId;

    private Set<Account> accounts;

    private List<Message> messages;

    public static ResponseImpl create( ) {
        ResponseImpl responseImpl = new ResponseImpl();
        return responseImpl;
    }

    public static ResponseImpl create( Status status, String errors, long tokenId ) {
        ResponseImpl responseImpl = new ResponseImpl();
        responseImpl.status = status;
        responseImpl.setText(errors);
        responseImpl.tokenId = tokenId;
        return responseImpl;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Response > T buildLoginResponse( Set<Account> accounts ) {
        this.accounts = accounts;
        return (T) this;
    }

    @SuppressWarnings( "unchecked" )
    public < T extends Response > T buildFetchResponse( List<Message> messages ) {
        this.messages = messages; //TODO może lepiej przechowywać odpowiedz jak mape list?
        return (T) this;
    }

    @Override
    public Status getStatus( ) {
        return status;
    }

    @Override
    public long getTokenId( ) {
        return tokenId;
    }

    @Override
    public Set<Account> getAccounts( ) {
        return accounts;
    }

    @Override
    public List<Message> getMessages( ) {
        return messages;
    }

    public void setMessages( List<Message> messages ) {
        this.messages = messages;
    }

    @Override
    public String getText( ) {
        return text;
    }

    public void setText( String errors ) {
        this.text = errors;
    }

}
