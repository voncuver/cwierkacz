package com.pk.cwierkacz.ws.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated
 * source version: 2.2
 * 
 */
@WebServiceClient( name = "SocialServiceIntegrationImplService",
                   targetNamespace = "http://ws.cwierkacz.pk.com/",
                   wsdlLocation = "http://localhost:8080/cwierkacz/Integration?wsdl" )
public class SocialServiceIntegrationImplService extends Service
{

    private static URL SOCIALSERVICEINTEGRATIONIMPLSERVICE_WSDL_LOCATION;
    private static WebServiceException SOCIALSERVICEINTEGRATIONIMPLSERVICE_EXCEPTION;
    private static QName SOCIALSERVICEINTEGRATIONIMPLSERVICE_QNAME = new QName("http://ws.cwierkacz.pk.com/",
                                                                               "SocialServiceIntegrationImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/cwierkacz/Integration?wsdl");
        }
        catch ( MalformedURLException ex ) {
            e = new WebServiceException(ex);
        }
        SOCIALSERVICEINTEGRATIONIMPLSERVICE_WSDL_LOCATION = url;
        SOCIALSERVICEINTEGRATIONIMPLSERVICE_EXCEPTION = e;
    }

    public SocialServiceIntegrationImplService() {
        super(__getWsdlLocation(), SOCIALSERVICEINTEGRATIONIMPLSERVICE_QNAME);
    }

    public SocialServiceIntegrationImplService( String urlPath ) {
        super(__getWsdlLocation(), SOCIALSERVICEINTEGRATIONIMPLSERVICE_QNAME);
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL(urlPath);
        }
        catch ( MalformedURLException ex ) {
            e = new WebServiceException(ex);
        }
        SOCIALSERVICEINTEGRATIONIMPLSERVICE_WSDL_LOCATION = url;
        SOCIALSERVICEINTEGRATIONIMPLSERVICE_EXCEPTION = e;
    }

    public SocialServiceIntegrationImplService( WebServiceFeature... features ) {
        super(__getWsdlLocation(), SOCIALSERVICEINTEGRATIONIMPLSERVICE_QNAME, features);
    }

    public SocialServiceIntegrationImplService( URL wsdlLocation ) {
        super(wsdlLocation, SOCIALSERVICEINTEGRATIONIMPLSERVICE_QNAME);
    }

    public SocialServiceIntegrationImplService( URL wsdlLocation, WebServiceFeature... features ) {
        super(wsdlLocation, SOCIALSERVICEINTEGRATIONIMPLSERVICE_QNAME, features);
    }

    public SocialServiceIntegrationImplService( URL wsdlLocation, QName serviceName ) {
        super(wsdlLocation, serviceName);
    }

    public SocialServiceIntegrationImplService( URL wsdlLocation,
                                                QName serviceName,
                                                WebServiceFeature... features ) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return returns SocialServiceIntegration
     */
    @WebEndpoint( name = "SocialServiceIntegrationImplPort" )
    public SocialServiceIntegration getSocialServiceIntegrationImplPort( ) {
        return super.getPort(new QName("http://ws.cwierkacz.pk.com/", "SocialServiceIntegrationImplPort"),
                             SocialServiceIntegration.class);
    }

    /**
     * 
     * @param features
     *            A list of {@link javax.xml.ws.WebServiceFeature} to configure
     *            on the proxy. Supported features not in the
     *            <code>features</code> parameter will have their default
     *            values.
     * @return returns SocialServiceIntegration
     */
    @WebEndpoint( name = "SocialServiceIntegrationImplPort" )
    public SocialServiceIntegration getSocialServiceIntegrationImplPort( WebServiceFeature... features ) {
        return super.getPort(new QName("http://ws.cwierkacz.pk.com/", "SocialServiceIntegrationImplPort"),
                             SocialServiceIntegration.class,
                             features);
    }

    private static URL __getWsdlLocation( ) {
        if ( SOCIALSERVICEINTEGRATIONIMPLSERVICE_EXCEPTION != null ) {
            throw SOCIALSERVICEINTEGRATIONIMPLSERVICE_EXCEPTION;
        }
        return SOCIALSERVICEINTEGRATIONIMPLSERVICE_WSDL_LOCATION;
    }

}