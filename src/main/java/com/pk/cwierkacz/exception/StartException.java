package com.pk.cwierkacz.exception;

public class StartException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 5162710183389028791L;

    public StartException( String message, Throwable ex ) {
        super(message, ex);
    }
}
