/**
 * UserNotExistFault.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */

package pl.edu.pk.ias.socialserviceintegrationClient;

public class UserNotExistFault extends java.lang.Exception
{

    private static final long serialVersionUID = 1370037000883L;

    private UserNotExistFault faultMessage;

    public UserNotExistFault() {
        super("UserNotExistFault");
    }

    public UserNotExistFault( java.lang.String s ) {
        super(s);
    }

    public UserNotExistFault( java.lang.String s, java.lang.Throwable ex ) {
        super(s, ex);
    }

    public UserNotExistFault( java.lang.Throwable cause ) {
        super(cause);
    }

    public void setFaultMessage( UserNotExistFault msg ) {
        faultMessage = msg;
    }

    public UserNotExistFault getFaultMessage( ) {
        return faultMessage;
    }
}
