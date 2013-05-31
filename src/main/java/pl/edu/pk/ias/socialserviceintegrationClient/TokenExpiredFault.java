/**
 * TokenExpiredFault.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */

package pl.edu.pk.ias.socialserviceintegrationClient;

public class TokenExpiredFault extends java.lang.Exception
{

    private static final long serialVersionUID = 1370037000892L;

    private TokenExpiredFault faultMessage;

    public TokenExpiredFault() {
        super("TokenExpiredFault");
    }

    public TokenExpiredFault( java.lang.String s ) {
        super(s);
    }

    public TokenExpiredFault( java.lang.String s, java.lang.Throwable ex ) {
        super(s, ex);
    }

    public TokenExpiredFault( java.lang.Throwable cause ) {
        super(cause);
    }

    public void setFaultMessage( TokenExpiredFault msg ) {
        faultMessage = msg;
    }

    public TokenExpiredFault getFaultMessage( ) {
        return faultMessage;
    }
}
