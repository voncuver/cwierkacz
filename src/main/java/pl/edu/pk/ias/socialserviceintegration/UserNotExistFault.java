
/**
 * UserNotExistFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package pl.edu.pk.ias.socialserviceintegration;

public class UserNotExistFault extends java.lang.Exception{

    private static final long serialVersionUID = 1370036791741L;
    
    private pl.edu.pk.ias.types.UserNotExistFault faultMessage;

    
        public UserNotExistFault() {
            super("UserNotExistFault");
        }

        public UserNotExistFault(java.lang.String s) {
           super(s);
        }

        public UserNotExistFault(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public UserNotExistFault(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(pl.edu.pk.ias.types.UserNotExistFault msg){
       faultMessage = msg;
    }
    
    public pl.edu.pk.ias.types.UserNotExistFault getFaultMessage(){
       return faultMessage;
    }
}
    