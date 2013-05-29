
package pl.edu.pk.ias.socialserviceintegration;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "tokenExpiredFault", targetNamespace = "http://pk.edu.pl/ias/types")
public class TokenExpiredFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private pl.edu.pk.ias.types.TokenExpiredFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public TokenExpiredFault(String message, pl.edu.pk.ias.types.TokenExpiredFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public TokenExpiredFault(String message, pl.edu.pk.ias.types.TokenExpiredFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: pl.edu.pk.ias.types.TokenExpiredFault
     */
    public pl.edu.pk.ias.types.TokenExpiredFault getFaultInfo() {
        return faultInfo;
    }

}
