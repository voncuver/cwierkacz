package com.pk.cwierkacz.ws;

public class BridgeException extends Exception
{
    private static final long serialVersionUID = 6688460424035110731L;

    public BridgeException( String msg ) {
        super(msg);
    }

    public BridgeException( Exception ex ) {
        super(ex.getClass().getName() + "\n" + ex.getMessage());
    }
}
