/**
 * SocialServiceIntegrationMessageReceiverInOut.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package pl.edu.pk.ias.socialserviceintegration;

/**
 * SocialServiceIntegrationMessageReceiverInOut message receiver
 */

public class SocialServiceIntegrationMessageReceiverInOut extends
                                                         org.apache.axis2.receivers.AbstractInOutMessageReceiver
{

    @Override
    public void invokeBusinessLogic( org.apache.axis2.context.MessageContext msgContext,
                                     org.apache.axis2.context.MessageContext newMsgContext ) throws org.apache.axis2.AxisFault {

        try {

            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            SocialServiceIntegrationSkeletonInterface skel = (SocialServiceIntegrationSkeletonInterface) obj;
            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;
            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();
            if ( op == null ) {
                throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;
            if ( ( op.getName() != null ) &&
                 ( ( methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName()
                                                                                            .getLocalPart()) ) != null ) ) {

                if ( "logout".equals(methodName) ) {

                    pl.edu.pk.ias.types.LogoutResponseE logoutResponse15 = null;
                    pl.edu.pk.ias.types.LogoutRequestE wrappedParam = (pl.edu.pk.ias.types.LogoutRequestE) fromOM(msgContext.getEnvelope()
                                                                                                                            .getBody()
                                                                                                                            .getFirstElement(),
                                                                                                                  pl.edu.pk.ias.types.LogoutRequestE.class,
                                                                                                                  getEnvelopeNamespaces(msgContext.getEnvelope()));

                    logoutResponse15 =

                    skel.logout(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                                          logoutResponse15,
                                          false,
                                          new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                        "logout"));
                }
                else

                if ( "getItemsPreviews".equals(methodName) ) {

                    pl.edu.pk.ias.types.GetItemsPreviewsResponseE getItemsPreviewsResponse17 = null;
                    pl.edu.pk.ias.types.GetItemsPreviewsRequestE wrappedParam = (pl.edu.pk.ias.types.GetItemsPreviewsRequestE) fromOM(msgContext.getEnvelope()
                                                                                                                                                .getBody()
                                                                                                                                                .getFirstElement(),
                                                                                                                                      pl.edu.pk.ias.types.GetItemsPreviewsRequestE.class,
                                                                                                                                      getEnvelopeNamespaces(msgContext.getEnvelope()));

                    getItemsPreviewsResponse17 =

                    skel.getItemsPreviews(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                                          getItemsPreviewsResponse17,
                                          false,
                                          new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                        "getItemsPreviews"));
                }
                else

                if ( "accounts".equals(methodName) ) {

                    pl.edu.pk.ias.types.AccountsResponseE accountsResponse19 = null;
                    pl.edu.pk.ias.types.AccountsRequestE wrappedParam = (pl.edu.pk.ias.types.AccountsRequestE) fromOM(msgContext.getEnvelope()
                                                                                                                                .getBody()
                                                                                                                                .getFirstElement(),
                                                                                                                      pl.edu.pk.ias.types.AccountsRequestE.class,
                                                                                                                      getEnvelopeNamespaces(msgContext.getEnvelope()));

                    accountsResponse19 =

                    skel.accounts(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                                          accountsResponse19,
                                          false,
                                          new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                        "accounts"));
                }
                else

                if ( "login".equals(methodName) ) {

                    pl.edu.pk.ias.types.LoginResponseE loginResponse21 = null;
                    pl.edu.pk.ias.types.LoginRequestE wrappedParam = (pl.edu.pk.ias.types.LoginRequestE) fromOM(msgContext.getEnvelope()
                                                                                                                          .getBody()
                                                                                                                          .getFirstElement(),
                                                                                                                pl.edu.pk.ias.types.LoginRequestE.class,
                                                                                                                getEnvelopeNamespaces(msgContext.getEnvelope()));

                    loginResponse21 =

                    skel.login(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                                          loginResponse21,
                                          false,
                                          new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                        "login"));
                }
                else

                if ( "publish".equals(methodName) ) {

                    pl.edu.pk.ias.types.PublishResponseE publishResponse23 = null;
                    pl.edu.pk.ias.types.PublishRequestE wrappedParam = (pl.edu.pk.ias.types.PublishRequestE) fromOM(msgContext.getEnvelope()
                                                                                                                              .getBody()
                                                                                                                              .getFirstElement(),
                                                                                                                    pl.edu.pk.ias.types.PublishRequestE.class,
                                                                                                                    getEnvelopeNamespaces(msgContext.getEnvelope()));

                    publishResponse23 =

                    skel.publish(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                                          publishResponse23,
                                          false,
                                          new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                        "publish"));
                }
                else

                if ( "remove".equals(methodName) ) {

                    pl.edu.pk.ias.types.RemoveResponseE removeResponse25 = null;
                    pl.edu.pk.ias.types.RemoveRequestE wrappedParam = (pl.edu.pk.ias.types.RemoveRequestE) fromOM(msgContext.getEnvelope()
                                                                                                                            .getBody()
                                                                                                                            .getFirstElement(),
                                                                                                                  pl.edu.pk.ias.types.RemoveRequestE.class,
                                                                                                                  getEnvelopeNamespaces(msgContext.getEnvelope()));

                    removeResponse25 =

                    skel.remove(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                                          removeResponse25,
                                          false,
                                          new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                        "remove"));
                }
                else

                if ( "getItems".equals(methodName) ) {

                    pl.edu.pk.ias.types.GetItemsResponseE getItemsResponse27 = null;
                    pl.edu.pk.ias.types.GetItemsRequestE wrappedParam = (pl.edu.pk.ias.types.GetItemsRequestE) fromOM(msgContext.getEnvelope()
                                                                                                                                .getBody()
                                                                                                                                .getFirstElement(),
                                                                                                                      pl.edu.pk.ias.types.GetItemsRequestE.class,
                                                                                                                      getEnvelopeNamespaces(msgContext.getEnvelope()));

                    getItemsResponse27 =

                    skel.getItems(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                                          getItemsResponse27,
                                          false,
                                          new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                        "getItems"));

                }
                else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        }
        catch ( IncorrectPasswordFault e ) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME, "incorrectPasswordFault");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if ( e.getFaultMessage() != null ) {
                f.setDetail(toOM(e.getFaultMessage(), false));
            }
            throw f;
        }
        catch ( UserNotExistFault e ) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME, "userNotExistFault");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if ( e.getFaultMessage() != null ) {
                f.setDetail(toOM(e.getFaultMessage(), false));
            }
            throw f;
        }
        catch ( TokenExpiredFault e ) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME, "tokenExpiredFault");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if ( e.getFaultMessage() != null ) {
                f.setDetail(toOM(e.getFaultMessage(), false));
            }
            throw f;
        }

        catch ( java.lang.Exception e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.LogoutRequestE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.LogoutRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.LogoutResponseE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.LogoutResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.GetItemsPreviewsRequestE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.GetItemsPreviewsRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.GetItemsPreviewsResponseE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.GetItemsPreviewsResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.TokenExpiredFault param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.TokenExpiredFault.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.AccountsRequestE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.AccountsRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.AccountsResponseE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.AccountsResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.LoginRequestE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.LoginRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.LoginResponseE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.LoginResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.UserNotExistFault param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.UserNotExistFault.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.IncorrectPasswordFault param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.IncorrectPasswordFault.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.PublishRequestE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.PublishRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.PublishResponseE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.PublishResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.RemoveRequestE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.RemoveRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.RemoveResponseE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.RemoveResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.GetItemsRequestE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.GetItemsRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( pl.edu.pk.ias.types.GetItemsResponseE param,
                                                boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(pl.edu.pk.ias.types.GetItemsResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           pl.edu.pk.ias.types.LogoutResponseE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(pl.edu.pk.ias.types.LogoutResponseE.MY_QNAME,
                                                                factory));

            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private pl.edu.pk.ias.types.LogoutResponseE wraplogout( ) {
        pl.edu.pk.ias.types.LogoutResponseE wrappedElement = new pl.edu.pk.ias.types.LogoutResponseE();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           pl.edu.pk.ias.types.GetItemsPreviewsResponseE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(pl.edu.pk.ias.types.GetItemsPreviewsResponseE.MY_QNAME,
                                                      factory));

            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private pl.edu.pk.ias.types.GetItemsPreviewsResponseE wrapgetItemsPreviews( ) {
        pl.edu.pk.ias.types.GetItemsPreviewsResponseE wrappedElement = new pl.edu.pk.ias.types.GetItemsPreviewsResponseE();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           pl.edu.pk.ias.types.AccountsResponseE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(pl.edu.pk.ias.types.AccountsResponseE.MY_QNAME, factory));

            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private pl.edu.pk.ias.types.AccountsResponseE wrapaccounts( ) {
        pl.edu.pk.ias.types.AccountsResponseE wrappedElement = new pl.edu.pk.ias.types.AccountsResponseE();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           pl.edu.pk.ias.types.LoginResponseE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(pl.edu.pk.ias.types.LoginResponseE.MY_QNAME,
                                                                factory));

            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private pl.edu.pk.ias.types.LoginResponseE wraplogin( ) {
        pl.edu.pk.ias.types.LoginResponseE wrappedElement = new pl.edu.pk.ias.types.LoginResponseE();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           pl.edu.pk.ias.types.PublishResponseE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(pl.edu.pk.ias.types.PublishResponseE.MY_QNAME, factory));

            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private pl.edu.pk.ias.types.PublishResponseE wrappublish( ) {
        pl.edu.pk.ias.types.PublishResponseE wrappedElement = new pl.edu.pk.ias.types.PublishResponseE();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           pl.edu.pk.ias.types.RemoveResponseE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(pl.edu.pk.ias.types.RemoveResponseE.MY_QNAME,
                                                                factory));

            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private pl.edu.pk.ias.types.RemoveResponseE wrapremove( ) {
        pl.edu.pk.ias.types.RemoveResponseE wrappedElement = new pl.edu.pk.ias.types.RemoveResponseE();
        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           pl.edu.pk.ias.types.GetItemsResponseE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(pl.edu.pk.ias.types.GetItemsResponseE.MY_QNAME, factory));

            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private pl.edu.pk.ias.types.GetItemsResponseE wrapgetItems( ) {
        pl.edu.pk.ias.types.GetItemsResponseE wrappedElement = new pl.edu.pk.ias.types.GetItemsResponseE();
        return wrappedElement;
    }

    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory ) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM( org.apache.axiom.om.OMElement param,
                                     java.lang.Class type,
                                     java.util.Map extraNamespaces ) throws org.apache.axis2.AxisFault {

        try {

            if ( pl.edu.pk.ias.types.LogoutRequestE.class.equals(type) ) {

                return pl.edu.pk.ias.types.LogoutRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.LogoutResponseE.class.equals(type) ) {

                return pl.edu.pk.ias.types.LogoutResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.GetItemsPreviewsRequestE.class.equals(type) ) {

                return pl.edu.pk.ias.types.GetItemsPreviewsRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.GetItemsPreviewsResponseE.class.equals(type) ) {

                return pl.edu.pk.ias.types.GetItemsPreviewsResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.TokenExpiredFault.class.equals(type) ) {

                return pl.edu.pk.ias.types.TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.AccountsRequestE.class.equals(type) ) {

                return pl.edu.pk.ias.types.AccountsRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.AccountsResponseE.class.equals(type) ) {

                return pl.edu.pk.ias.types.AccountsResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.TokenExpiredFault.class.equals(type) ) {

                return pl.edu.pk.ias.types.TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.LoginRequestE.class.equals(type) ) {

                return pl.edu.pk.ias.types.LoginRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.LoginResponseE.class.equals(type) ) {

                return pl.edu.pk.ias.types.LoginResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.UserNotExistFault.class.equals(type) ) {

                return pl.edu.pk.ias.types.UserNotExistFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.IncorrectPasswordFault.class.equals(type) ) {

                return pl.edu.pk.ias.types.IncorrectPasswordFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.PublishRequestE.class.equals(type) ) {

                return pl.edu.pk.ias.types.PublishRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.PublishResponseE.class.equals(type) ) {

                return pl.edu.pk.ias.types.PublishResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.TokenExpiredFault.class.equals(type) ) {

                return pl.edu.pk.ias.types.TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.RemoveRequestE.class.equals(type) ) {

                return pl.edu.pk.ias.types.RemoveRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.RemoveResponseE.class.equals(type) ) {

                return pl.edu.pk.ias.types.RemoveResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.TokenExpiredFault.class.equals(type) ) {

                return pl.edu.pk.ias.types.TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.GetItemsRequestE.class.equals(type) ) {

                return pl.edu.pk.ias.types.GetItemsRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.GetItemsResponseE.class.equals(type) ) {

                return pl.edu.pk.ias.types.GetItemsResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( pl.edu.pk.ias.types.TokenExpiredFault.class.equals(type) ) {

                return pl.edu.pk.ias.types.TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

        }
        catch ( java.lang.Exception e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }

    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces( org.apache.axiom.soap.SOAPEnvelope env ) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while ( namespaceIterator.hasNext() ) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }

    private org.apache.axis2.AxisFault createAxisFault( java.lang.Exception e ) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if ( cause != null ) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        }
        else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

}//end of class
