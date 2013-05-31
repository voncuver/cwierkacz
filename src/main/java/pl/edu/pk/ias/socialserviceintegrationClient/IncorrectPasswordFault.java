/**
 * IncorrectPasswordFault.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */

package pl.edu.pk.ias.socialserviceintegrationClient;

public class IncorrectPasswordFault extends java.lang.Exception
{

    private static final long serialVersionUID = 1370037000874L;

    private IncorrectPasswordFault faultMessage;

    public IncorrectPasswordFault() {
        super("IncorrectPasswordFault");
    }

    public IncorrectPasswordFault( java.lang.String s ) {
        super(s);
    }

    public IncorrectPasswordFault( java.lang.String s, java.lang.Throwable ex ) {
        super(s, ex);
    }

    public IncorrectPasswordFault( java.lang.Throwable cause ) {
        super(cause);
    }

    public void setFaultMessage( IncorrectPasswordFault msg ) {
        faultMessage = msg;
    }

    public IncorrectPasswordFault getFaultMessage( ) {
        return faultMessage;
    }
}
