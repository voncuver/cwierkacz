package com.tguzik.cwierkacz.twitter;

public class TwitterAuthenticationException extends Exception
{
    private static final long serialVersionUID = 2434389819051006384L;

    public TwitterAuthenticationException( String msg ) {
        super(msg);
    }

}
