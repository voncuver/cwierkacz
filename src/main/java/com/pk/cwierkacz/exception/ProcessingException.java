package com.pk.cwierkacz.exception;

public class ProcessingException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 8901828326107571270L;

    public ProcessingException( String message, Throwable ex ) {
        super(message, ex);
    }
}
