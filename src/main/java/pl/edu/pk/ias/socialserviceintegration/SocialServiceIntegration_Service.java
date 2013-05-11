
package pl.edu.pk.ias.socialserviceintegration;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SocialServiceIntegration", targetNamespace = "http://pk.edu.pl/ias/socialserviceintegration", wsdlLocation = "file:/home/voncuver/Downloads/jaxws-ri/bin/SocialServiceIntegration.wsdl")
public class SocialServiceIntegration_Service
    extends Service
{

    private final static URL SOCIALSERVICEINTEGRATION_WSDL_LOCATION;
    private final static WebServiceException SOCIALSERVICEINTEGRATION_EXCEPTION;
    private final static QName SOCIALSERVICEINTEGRATION_QNAME = new QName("http://pk.edu.pl/ias/socialserviceintegration", "SocialServiceIntegration");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/voncuver/Downloads/jaxws-ri/bin/SocialServiceIntegration.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOCIALSERVICEINTEGRATION_WSDL_LOCATION = url;
        SOCIALSERVICEINTEGRATION_EXCEPTION = e;
    }

    public SocialServiceIntegration_Service() {
        super(__getWsdlLocation(), SOCIALSERVICEINTEGRATION_QNAME);
    }

    public SocialServiceIntegration_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOCIALSERVICEINTEGRATION_QNAME, features);
    }

    public SocialServiceIntegration_Service(URL wsdlLocation) {
        super(wsdlLocation, SOCIALSERVICEINTEGRATION_QNAME);
    }

    public SocialServiceIntegration_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOCIALSERVICEINTEGRATION_QNAME, features);
    }

    public SocialServiceIntegration_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SocialServiceIntegration_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SocialServiceIntegration
     */
    @WebEndpoint(name = "SocialServiceIntegrationEndpoint")
    public SocialServiceIntegration getSocialServiceIntegrationEndpoint() {
        return super.getPort(new QName("http://pk.edu.pl/ias/socialserviceintegration", "SocialServiceIntegrationEndpoint"), SocialServiceIntegration.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SocialServiceIntegration
     */
    @WebEndpoint(name = "SocialServiceIntegrationEndpoint")
    public SocialServiceIntegration getSocialServiceIntegrationEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://pk.edu.pl/ias/socialserviceintegration", "SocialServiceIntegrationEndpoint"), SocialServiceIntegration.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOCIALSERVICEINTEGRATION_EXCEPTION!= null) {
            throw SOCIALSERVICEINTEGRATION_EXCEPTION;
        }
        return SOCIALSERVICEINTEGRATION_WSDL_LOCATION;
    }

}