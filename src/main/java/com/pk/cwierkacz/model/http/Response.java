package com.pk.cwierkacz.model.http;

public class Response
{
    private final Status status;

    private final String message;

    private final long tokenId;

    public Response( Status status, String message, long tokenId ) {
        this.status = status;
        this.message = message;
        this.tokenId = tokenId;
    }

    public static Response createFailResponse( String message, long tokenId ) {
        return new Response(Status.ERROR, message, tokenId);
    }

    public Status getStatus( ) {
        return status;
    }

    public String getMessage( ) {
        return message;
    }

    public long getTokenId( ) {
        return tokenId;
    }
}
