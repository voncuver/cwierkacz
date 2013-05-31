/**
 * SocialServiceIntegrationStub.java
 * 
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package pl.edu.pk.ias.socialserviceintegrationClient;

/*
 * SocialServiceIntegrationStub java implementation
 */

public class SocialServiceIntegrationStub extends org.apache.axis2.client.Stub
{
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private final java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private final java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private final java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized java.lang.String getUniqueSuffix( ) {
        // reset the counter if it is greater than 99999
        if ( counter > 99999 ) {
            counter = 0;
        }
        counter = counter + 1;
        return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
    }

    private void populateAxisService( ) throws org.apache.axis2.AxisFault {

        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("SocialServiceIntegration" +
                                                                getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[7];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                          "logout"));
        _service.addOperation(__operation);

        _operations[ 0 ] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                          "getItemsPreviews"));
        _service.addOperation(__operation);

        _operations[ 1 ] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                          "accounts"));
        _service.addOperation(__operation);

        _operations[ 2 ] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                          "login"));
        _service.addOperation(__operation);

        _operations[ 3 ] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                          "publish"));
        _service.addOperation(__operation);

        _operations[ 4 ] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                          "remove"));
        _service.addOperation(__operation);

        _operations[ 5 ] = __operation;

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                          "getItems"));
        _service.addOperation(__operation);

        _operations[ 6 ] = __operation;

    }

    //populates the faults
    private void populateFaults( ) {

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                        "tokenExpiredFault"),
                                                                          "getItemsPreviews"),
                                  "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                             "tokenExpiredFault"),
                                                                               "getItemsPreviews"),
                                       "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                  "tokenExpiredFault"),
                                                                    "getItemsPreviews"),
                            "pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegrationStub$TokenExpiredFault");

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                        "tokenExpiredFault"),
                                                                          "accounts"),
                                  "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                             "tokenExpiredFault"),
                                                                               "accounts"),
                                       "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                  "tokenExpiredFault"),
                                                                    "accounts"),
                            "pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegrationStub$TokenExpiredFault");

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                        "userNotExistFault"),
                                                                          "login"),
                                  "pl.edu.pk.ias.socialserviceintegration.UserNotExistFault");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                             "userNotExistFault"),
                                                                               "login"),
                                       "pl.edu.pk.ias.socialserviceintegration.UserNotExistFault");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                  "userNotExistFault"),
                                                                    "login"),
                            "pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegrationStub$UserNotExistFault");

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                        "incorrectPasswordFault"),
                                                                          "login"),
                                  "pl.edu.pk.ias.socialserviceintegration.IncorrectPasswordFault");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                             "incorrectPasswordFault"),
                                                                               "login"),
                                       "pl.edu.pk.ias.socialserviceintegration.IncorrectPasswordFault");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                  "incorrectPasswordFault"),
                                                                    "login"),
                            "pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegrationStub$IncorrectPasswordFault");

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                        "tokenExpiredFault"),
                                                                          "publish"),
                                  "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                             "tokenExpiredFault"),
                                                                               "publish"),
                                       "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                  "tokenExpiredFault"),
                                                                    "publish"),
                            "pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegrationStub$TokenExpiredFault");

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                        "tokenExpiredFault"),
                                                                          "remove"),
                                  "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                             "tokenExpiredFault"),
                                                                               "remove"),
                                       "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                  "tokenExpiredFault"),
                                                                    "remove"),
                            "pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegrationStub$TokenExpiredFault");

        faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                        "tokenExpiredFault"),
                                                                          "getItems"),
                                  "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                             "tokenExpiredFault"),
                                                                               "getItems"),
                                       "pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault");
        faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                                  "tokenExpiredFault"),
                                                                    "getItems"),
                            "pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegrationStub$TokenExpiredFault");

    }

    /**
     * Constructor that takes in a configContext
     */

    public SocialServiceIntegrationStub( org.apache.axis2.context.ConfigurationContext configurationContext,
                                         java.lang.String targetEndpoint ) throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext and useseperate listner
     */
    public SocialServiceIntegrationStub( org.apache.axis2.context.ConfigurationContext configurationContext,
                                         java.lang.String targetEndpoint,
                                         boolean useSeparateListener ) throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

    }

    /**
     * Default Constructor
     */
    public SocialServiceIntegrationStub( org.apache.axis2.context.ConfigurationContext configurationContext ) throws org.apache.axis2.AxisFault {

        this(configurationContext, "http://cwierkacz.tk:8080/cwierkacz-0.0.1-SNAPSHOT/Integration");

    }

    /**
     * Default Constructor
     */
    public SocialServiceIntegrationStub() throws org.apache.axis2.AxisFault {

        this("http://cwierkacz.tk:8080/cwierkacz-0.0.1-SNAPSHOT/Integration");

    }

    /**
     * Constructor taking the target endpoint
     */
    public SocialServiceIntegrationStub( java.lang.String targetEndpoint ) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    /**
     * Auto generated method signature Wylogowanie z aplikacji
     * 
     * @see pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration#logout
     * @param logoutRequest
     */

    public LogoutResponseE logout(

    LogoutRequestE logoutRequest )

    throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[ 0 ].getName());
            _operationClient.getOptions()
                            .setAction("http://pk.edu.pl/ias/socialserviceintegration/action/logout");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             logoutRequest,
                             optimizeContent(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                           "logout")),
                             new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                           "logout"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                                             LogoutResponseE.class,
                                             getEnvelopeNamespaces(_returnEnv));

            return (LogoutResponseE) object;

        }
        catch ( org.apache.axis2.AxisFault f ) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if ( faultElt != null ) {
                if ( faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                               "logout")) ) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                                        "logout"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                           "logout"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[] {messageClass});
                        m.invoke(ex, new java.lang.Object[] {messageObject});

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }
                    catch ( java.lang.ClassCastException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.ClassNotFoundException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.NoSuchMethodException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.reflect.InvocationTargetException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.IllegalAccessException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.InstantiationException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }
                else {
                    throw f;
                }
            }
            else {
                throw f;
            }
        }
        finally {
            if ( _messageContext.getTransportOut() != null ) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature Pobranie listy dostępnych elementów ( ID
     * + Name). Element jest bytem różniącym się dla każdego serwisu
     * społecznościowego
     * 
     * @see pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration#getItemsPreviews
     * @param getItemsPreviewsRequest
     * 
     * @throws pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault
     *             :
     */

    public GetItemsPreviewsResponseE getItemsPreviews(

    GetItemsPreviewsRequestE getItemsPreviewsRequest )

    throws java.rmi.RemoteException

    , pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[ 1 ].getName());
            _operationClient.getOptions()
                            .setAction("http://pk.edu.pl/ias/socialserviceintegration/action/getItemsPreviews");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             getItemsPreviewsRequest,
                             optimizeContent(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                           "getItemsPreviews")),
                             new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                           "getItemsPreviews"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                                             GetItemsPreviewsResponseE.class,
                                             getEnvelopeNamespaces(_returnEnv));

            return (GetItemsPreviewsResponseE) object;

        }
        catch ( org.apache.axis2.AxisFault f ) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if ( faultElt != null ) {
                if ( faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                               "getItemsPreviews")) ) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                                        "getItemsPreviews"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                           "getItemsPreviews"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[] {messageClass});
                        m.invoke(ex, new java.lang.Object[] {messageObject});

                        if ( ex instanceof pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault ) {
                            throw (pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }
                    catch ( java.lang.ClassCastException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.ClassNotFoundException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.NoSuchMethodException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.reflect.InvocationTargetException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.IllegalAccessException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.InstantiationException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }
                else {
                    throw f;
                }
            }
            else {
                throw f;
            }
        }
        finally {
            if ( _messageContext.getTransportOut() != null ) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature Pobranie list kont serwisów
     * społecznościowych, dla zalogowanego użytkownika
     * 
     * @see pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration#accounts
     * @param accountsRequest
     * 
     * @throws pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault
     *             :
     */

    public AccountsResponseE accounts(

    AccountsRequestE accountsRequest )

    throws java.rmi.RemoteException

    , pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[ 2 ].getName());
            _operationClient.getOptions()
                            .setAction("http://pk.edu.pl/ias/socialserviceintegration/action/accounts");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             accountsRequest,
                             optimizeContent(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                           "accounts")),
                             new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                           "accounts"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                                             AccountsResponseE.class,
                                             getEnvelopeNamespaces(_returnEnv));

            return (AccountsResponseE) object;

        }
        catch ( org.apache.axis2.AxisFault f ) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if ( faultElt != null ) {
                if ( faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                               "accounts")) ) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                                        "accounts"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                           "accounts"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[] {messageClass});
                        m.invoke(ex, new java.lang.Object[] {messageObject});

                        if ( ex instanceof pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault ) {
                            throw (pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }
                    catch ( java.lang.ClassCastException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.ClassNotFoundException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.NoSuchMethodException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.reflect.InvocationTargetException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.IllegalAccessException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.InstantiationException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }
                else {
                    throw f;
                }
            }
            else {
                throw f;
            }
        }
        finally {
            if ( _messageContext.getTransportOut() != null ) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature Logowanie do aplikacji
     * 
     * @see pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration#login
     * @param loginRequest
     * 
     * @throws pl.edu.pk.ias.socialserviceintegration.UserNotExistFault
     *             :
     * @throws pl.edu.pk.ias.socialserviceintegration.IncorrectPasswordFault
     *             :
     */

    public LoginResponseE login(

    LoginRequestE loginRequest )

                                throws java.rmi.RemoteException

                                ,
                                pl.edu.pk.ias.socialserviceintegration.UserNotExistFault,
                                pl.edu.pk.ias.socialserviceintegration.IncorrectPasswordFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[ 3 ].getName());
            _operationClient.getOptions()
                            .setAction("http://pk.edu.pl/ias/socialserviceintegration/action/login");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             loginRequest,
                             optimizeContent(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                           "login")),
                             new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                           "login"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                                             LoginResponseE.class,
                                             getEnvelopeNamespaces(_returnEnv));

            return (LoginResponseE) object;

        }
        catch ( org.apache.axis2.AxisFault f ) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if ( faultElt != null ) {
                if ( faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                               "login")) ) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                                        "login"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                           "login"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[] {messageClass});
                        m.invoke(ex, new java.lang.Object[] {messageObject});

                        if ( ex instanceof pl.edu.pk.ias.socialserviceintegration.UserNotExistFault ) {
                            throw (pl.edu.pk.ias.socialserviceintegration.UserNotExistFault) ex;
                        }

                        if ( ex instanceof pl.edu.pk.ias.socialserviceintegration.IncorrectPasswordFault ) {
                            throw (pl.edu.pk.ias.socialserviceintegration.IncorrectPasswordFault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }
                    catch ( java.lang.ClassCastException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.ClassNotFoundException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.NoSuchMethodException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.reflect.InvocationTargetException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.IllegalAccessException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.InstantiationException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }
                else {
                    throw f;
                }
            }
            else {
                throw f;
            }
        }
        finally {
            if ( _messageContext.getTransportOut() != null ) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature Publikacja treści w serwisie
     * społecznościowym
     * 
     * @see pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration#publish
     * @param publishRequest
     * 
     * @throws pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault
     *             :
     */

    public PublishResponseE publish(

    PublishRequestE publishRequest )

    throws java.rmi.RemoteException

    , pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[ 4 ].getName());
            _operationClient.getOptions()
                            .setAction("http://pk.edu.pl/ias/socialserviceintegration/action/publish");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             publishRequest,
                             optimizeContent(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                           "publish")),
                             new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                           "publish"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                                             PublishResponseE.class,
                                             getEnvelopeNamespaces(_returnEnv));

            return (PublishResponseE) object;

        }
        catch ( org.apache.axis2.AxisFault f ) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if ( faultElt != null ) {
                if ( faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                               "publish")) ) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                                        "publish"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                           "publish"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[] {messageClass});
                        m.invoke(ex, new java.lang.Object[] {messageObject});

                        if ( ex instanceof pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault ) {
                            throw (pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }
                    catch ( java.lang.ClassCastException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.ClassNotFoundException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.NoSuchMethodException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.reflect.InvocationTargetException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.IllegalAccessException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.InstantiationException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }
                else {
                    throw f;
                }
            }
            else {
                throw f;
            }
        }
        finally {
            if ( _messageContext.getTransportOut() != null ) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature Usunięcie wybranych elementów
     * 
     * @see pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration#remove
     * @param removeRequest
     * 
     * @throws pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault
     *             :
     */

    public RemoveResponseE remove(

    RemoveRequestE removeRequest )

    throws java.rmi.RemoteException

    , pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[ 5 ].getName());
            _operationClient.getOptions()
                            .setAction("http://pk.edu.pl/ias/socialserviceintegration/action/remove");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             removeRequest,
                             optimizeContent(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                           "remove")),
                             new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                           "remove"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                                             RemoveResponseE.class,
                                             getEnvelopeNamespaces(_returnEnv));

            return (RemoveResponseE) object;

        }
        catch ( org.apache.axis2.AxisFault f ) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if ( faultElt != null ) {
                if ( faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                               "remove")) ) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                                        "remove"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                           "remove"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[] {messageClass});
                        m.invoke(ex, new java.lang.Object[] {messageObject});

                        if ( ex instanceof pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault ) {
                            throw (pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }
                    catch ( java.lang.ClassCastException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.ClassNotFoundException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.NoSuchMethodException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.reflect.InvocationTargetException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.IllegalAccessException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.InstantiationException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }
                else {
                    throw f;
                }
            }
            else {
                throw f;
            }
        }
        finally {
            if ( _messageContext.getTransportOut() != null ) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature Pobranie kompletnych elementów. Element
     * jest bytem różniącym się dla każdego serwisu społecznościowego
     * 
     * @see pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration#getItems
     * @param getItemsRequest
     * 
     * @throws pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault
     *             :
     */

    public GetItemsResponseE getItems(

    GetItemsRequestE getItemsRequest )

    throws java.rmi.RemoteException

    , pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[ 6 ].getName());
            _operationClient.getOptions()
                            .setAction("http://pk.edu.pl/ias/socialserviceintegration/action/getItems");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient,
                                         org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
                                         "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                             getItemsRequest,
                             optimizeContent(new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                                           "getItems")),
                             new javax.xml.namespace.QName("http://pk.edu.pl/ias/socialserviceintegration",
                                                           "getItems"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
                                             GetItemsResponseE.class,
                                             getEnvelopeNamespaces(_returnEnv));

            return (GetItemsResponseE) object;

        }
        catch ( org.apache.axis2.AxisFault f ) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if ( faultElt != null ) {
                if ( faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                               "getItems")) ) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                                        "getItems"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
                                                                                                                                           "getItems"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                                                              new java.lang.Class[] {messageClass});
                        m.invoke(ex, new java.lang.Object[] {messageObject});

                        if ( ex instanceof pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault ) {
                            throw (pl.edu.pk.ias.socialserviceintegration.TokenExpiredFault) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }
                    catch ( java.lang.ClassCastException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.ClassNotFoundException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.NoSuchMethodException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.reflect.InvocationTargetException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.IllegalAccessException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                    catch ( java.lang.InstantiationException e ) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }
                else {
                    throw f;
                }
            }
            else {
                throw f;
            }
        }
        finally {
            if ( _messageContext.getTransportOut() != null ) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
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

    private final javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent( javax.xml.namespace.QName opName ) {

        if ( opNameArray == null ) {
            return false;
        }
        for ( int i = 0; i < opNameArray.length; i++ ) {
            if ( opName.equals(opNameArray[ i ]) ) {
                return true;
            }
        }
        return false;
    }

    //http://cwierkacz.tk:8080/cwierkacz-0.0.1-SNAPSHOT/Integration
    public static class LogoutResponse implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = logoutResponse
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for IsOperationSuccess
         */

        protected IsOperationSuccess localIsOperationSuccess;

        /**
         * Auto generated getter method
         * 
         * @return IsOperationSuccess
         */
        public IsOperationSuccess getIsOperationSuccess( ) {
            return localIsOperationSuccess;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            IsOperationSuccess
         */
        public void setIsOperationSuccess( IsOperationSuccess param ) {

            this.localIsOperationSuccess = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":logoutResponse",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "logoutResponse",
                                   xmlWriter);
                }

            }

            if ( localIsOperationSuccess == null ) {
                throw new org.apache.axis2.databinding.ADBException("isOperationSuccess cannot be null!!");
            }
            localIsOperationSuccess.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                            "isOperationSuccess"), xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "isOperationSuccess"));

            if ( localIsOperationSuccess == null ) {
                throw new org.apache.axis2.databinding.ADBException("isOperationSuccess cannot be null!!");
            }
            elementList.add(localIsOperationSuccess);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static LogoutResponse parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                LogoutResponse object = new LogoutResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"logoutResponse".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (LogoutResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "isOperationSuccess").equals(reader.getName()) ) {

                        object.setIsOperationSuccess(IsOperationSuccess.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class Password implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "password",
                                                                                               "ns1");

        /**
         * field for Password
         */

        protected java.lang.String localPassword;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getPassword( ) {
            return localPassword;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Password
         */
        public void setPassword( java.lang.String param ) {

            if ( ( 1 <= java.lang.String.valueOf(param).length() ) &&
                 ( java.lang.String.valueOf(param).length() <= 30 ) ) {
                this.localPassword = param;
            }
            else {
                throw new java.lang.RuntimeException();
            }

        }

        @Override
        public java.lang.String toString( ) {

            return localPassword.toString();

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":password",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "password",
                                   xmlWriter);
                }
            }

            if ( localPassword == null ) {

                throw new org.apache.axis2.databinding.ADBException("password cannot be null !!");

            }
            else {

                xmlWriter.writeCharacters(localPassword);

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPassword)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static Password fromString( java.lang.String value, java.lang.String namespaceURI ) {
                Password returnValue = new Password();

                returnValue.setPassword(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static Password fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                               java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return Password.Factory.fromString(content, namespaceUri);
                }
                else {
                    return Password.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static Password parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                Password object = new Password();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "password"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setPassword(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class Login implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "login",
                                                                                               "ns1");

        /**
         * field for Login
         */

        protected java.lang.String localLogin;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getLogin( ) {
            return localLogin;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Login
         */
        public void setLogin( java.lang.String param ) {

            if ( ( 1 <= java.lang.String.valueOf(param).length() ) &&
                 ( java.lang.String.valueOf(param).length() <= 30 ) ) {
                this.localLogin = param;
            }
            else {
                throw new java.lang.RuntimeException();
            }

        }

        @Override
        public java.lang.String toString( ) {

            return localLogin.toString();

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":login",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "login",
                                   xmlWriter);
                }
            }

            if ( localLogin == null ) {

                throw new org.apache.axis2.databinding.ADBException("login cannot be null !!");

            }
            else {

                xmlWriter.writeCharacters(localLogin);

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLogin)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static Login fromString( java.lang.String value, java.lang.String namespaceURI ) {
                Login returnValue = new Login();

                returnValue.setLogin(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static Login fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                            java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return Login.Factory.fromString(content, namespaceUri);
                }
                else {
                    return Login.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static Login parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                Login object = new Login();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "login"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setLogin(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class DateTo implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "dateTo",
                                                                                               "ns1");

        /**
         * field for DateTo
         */

        protected java.util.Calendar localDateTo;

        /**
         * Auto generated getter method
         * 
         * @return java.util.Calendar
         */
        public java.util.Calendar getDateTo( ) {
            return localDateTo;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            DateTo
         */
        public void setDateTo( java.util.Calendar param ) {

            this.localDateTo = param;

        }

        @Override
        public java.lang.String toString( ) {

            return org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDateTo);

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":dateTo",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "dateTo",
                                   xmlWriter);
                }
            }

            if ( localDateTo == null ) {

                throw new org.apache.axis2.databinding.ADBException("dateTo cannot be null !!");

            }
            else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDateTo));

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDateTo)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static DateTo fromString( java.lang.String value, java.lang.String namespaceURI ) {
                DateTo returnValue = new DateTo();

                returnValue.setDateTo(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(value));

                return returnValue;
            }

            public static DateTo fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                             java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return DateTo.Factory.fromString(content, namespaceUri);
                }
                else {
                    return DateTo.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static DateTo parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                DateTo object = new DateTo();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "dateTo"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setDateTo(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class AccountsResponseE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "accountsResponse",
                                                                                               "ns1");

        /**
         * field for AccountsResponse
         */

        protected AccountsResponse localAccountsResponse;

        /**
         * Auto generated getter method
         * 
         * @return AccountsResponse
         */
        public AccountsResponse getAccountsResponse( ) {
            return localAccountsResponse;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            AccountsResponse
         */
        public void setAccountsResponse( AccountsResponse param ) {

            this.localAccountsResponse = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localAccountsResponse == null ) {
                throw new org.apache.axis2.databinding.ADBException("accountsResponse cannot be null!");
            }
            localAccountsResponse.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localAccountsResponse.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static AccountsResponseE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                AccountsResponseE object = new AccountsResponseE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                               "accountsResponse").equals(reader.getName()) ) {

                                object.setAccountsResponse(AccountsResponse.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class Filename implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "filename",
                                                                                               "ns1");

        /**
         * field for Filename
         */

        protected java.lang.String localFilename;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getFilename( ) {
            return localFilename;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Filename
         */
        public void setFilename( java.lang.String param ) {

            if ( ( 1 <= java.lang.String.valueOf(param).length() ) ) {
                this.localFilename = param;
            }
            else {
                throw new java.lang.RuntimeException();
            }

        }

        @Override
        public java.lang.String toString( ) {

            return localFilename.toString();

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":filename",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "filename",
                                   xmlWriter);
                }
            }

            if ( localFilename == null ) {

                throw new org.apache.axis2.databinding.ADBException("filename cannot be null !!");

            }
            else {

                xmlWriter.writeCharacters(localFilename);

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilename)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static Filename fromString( java.lang.String value, java.lang.String namespaceURI ) {
                Filename returnValue = new Filename();

                returnValue.setFilename(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static Filename fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                               java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return Filename.Factory.fromString(content, namespaceUri);
                }
                else {
                    return Filename.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static Filename parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                Filename object = new Filename();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "filename"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setFilename(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class IncorrectPasswordFault implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "incorrectPasswordFault",
                                                                                               "ns1");

        /**
         * field for ErrorMsg
         */

        protected java.lang.String localErrorMsg;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getErrorMsg( ) {
            return localErrorMsg;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            ErrorMsg
         */
        public void setErrorMsg( java.lang.String param ) {

            this.localErrorMsg = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":incorrectPasswordFault",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "incorrectPasswordFault",
                                   xmlWriter);
                }

            }

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "errorMsg", xmlWriter);

            if ( localErrorMsg == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localErrorMsg);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg"));

            if ( localErrorMsg != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static IncorrectPasswordFault parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                IncorrectPasswordFault object = new IncorrectPasswordFault();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"incorrectPasswordFault".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (IncorrectPasswordFault) ExtensionMapper.getTypeObject(nsUri,
                                                                                              type,
                                                                                              reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "errorMsg"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setErrorMsg(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class Item implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = item
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Id
         */

        protected ItemId localId;

        /**
         * Auto generated getter method
         * 
         * @return ItemId
         */
        public ItemId getId( ) {
            return localId;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Id
         */
        public void setId( ItemId param ) {

            this.localId = param;

        }

        /**
         * field for Name
         */

        protected java.lang.String localName;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getName( ) {
            return localName;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Name
         */
        public void setName( java.lang.String param ) {

            this.localName = param;

        }

        /**
         * field for Date
         */

        protected java.util.Calendar localDate;

        /**
         * Auto generated getter method
         * 
         * @return java.util.Calendar
         */
        public java.util.Calendar getDate( ) {
            return localDate;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Date
         */
        public void setDate( java.util.Calendar param ) {

            this.localDate = param;

        }

        /**
         * field for Message
         */

        protected java.lang.String localMessage;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getMessage( ) {
            return localMessage;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Message
         */
        public void setMessage( java.lang.String param ) {

            this.localMessage = param;

        }

        /**
         * field for Filename
         */

        protected java.lang.String localFilename;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getFilename( ) {
            return localFilename;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Filename
         */
        public void setFilename( java.lang.String param ) {

            this.localFilename = param;

        }

        /**
         * field for File
         */

        protected javax.activation.DataHandler localFile;

        /**
         * Auto generated getter method
         * 
         * @return javax.activation.DataHandler
         */
        public javax.activation.DataHandler getFile( ) {
            return localFile;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            File
         */
        public void setFile( javax.activation.DataHandler param ) {

            this.localFile = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":item",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "item",
                                   xmlWriter);
                }

            }

            if ( localId == null ) {
                throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
            }
            localId.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id"), xmlWriter);

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "name", xmlWriter);

            if ( localName == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localName);

            }

            xmlWriter.writeEndElement();

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "date", xmlWriter);

            if ( localDate == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("date cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDate));

            }

            xmlWriter.writeEndElement();

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "message", xmlWriter);

            if ( localMessage == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("message cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localMessage);

            }

            xmlWriter.writeEndElement();

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "filename", xmlWriter);

            if ( localFilename == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("filename cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localFilename);

            }

            xmlWriter.writeEndElement();

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "file", xmlWriter);

            if ( localFile != null ) {
                try {
                    org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter,
                                                                                     localFile,
                                                                                     null,
                                                                                     true);
                }
                catch ( java.io.IOException ex ) {
                    throw new javax.xml.stream.XMLStreamException("Unable to read data handler for file", ex);
                }
            }
            else {

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id"));

            if ( localId == null ) {
                throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
            }
            elementList.add(localId);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "name"));

            if ( localName != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "date"));

            if ( localDate != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDate));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("date cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "message"));

            if ( localMessage != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMessage));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("message cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "filename"));

            if ( localFilename != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilename));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("filename cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "file"));

            elementList.add(localFile);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static Item parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                Item object = new Item();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"item".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (Item) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id").equals(reader.getName()) ) {

                        object.setId(ItemId.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "name").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "name"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "date").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "date"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setDate(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "message").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "message"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setMessage(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "filename").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "filename"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setFilename(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "file").equals(reader.getName()) ) {

                        object.setFile(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class PublishResponse implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = publishResponse
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Id
         */

        protected ItemId localId;

        /**
         * Auto generated getter method
         * 
         * @return ItemId
         */
        public ItemId getId( ) {
            return localId;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Id
         */
        public void setId( ItemId param ) {

            this.localId = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":publishResponse",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "publishResponse",
                                   xmlWriter);
                }

            }

            if ( localId == null ) {
                throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
            }
            localId.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id"), xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id"));

            if ( localId == null ) {
                throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
            }
            elementList.add(localId);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static PublishResponse parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                PublishResponse object = new PublishResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"publishResponse".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (PublishResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id").equals(reader.getName()) ) {

                        object.setId(ItemId.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class LoginResponseE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "loginResponse",
                                                                                               "ns1");

        /**
         * field for LoginResponse
         */

        protected LoginResponse localLoginResponse;

        /**
         * Auto generated getter method
         * 
         * @return LoginResponse
         */
        public LoginResponse getLoginResponse( ) {
            return localLoginResponse;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            LoginResponse
         */
        public void setLoginResponse( LoginResponse param ) {

            this.localLoginResponse = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localLoginResponse == null ) {
                throw new org.apache.axis2.databinding.ADBException("loginResponse cannot be null!");
            }
            localLoginResponse.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localLoginResponse.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static LoginResponseE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                LoginResponseE object = new LoginResponseE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "loginResponse").equals(reader.getName()) ) {

                                object.setLoginResponse(LoginResponse.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class TokenExpiredFault implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "tokenExpiredFault",
                                                                                               "ns1");

        /**
         * field for ErrorMsg
         */

        protected java.lang.String localErrorMsg;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getErrorMsg( ) {
            return localErrorMsg;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            ErrorMsg
         */
        public void setErrorMsg( java.lang.String param ) {

            this.localErrorMsg = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":tokenExpiredFault",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "tokenExpiredFault",
                                   xmlWriter);
                }

            }

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "errorMsg", xmlWriter);

            if ( localErrorMsg == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localErrorMsg);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg"));

            if ( localErrorMsg != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static TokenExpiredFault parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                TokenExpiredFault object = new TokenExpiredFault();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"tokenExpiredFault".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (TokenExpiredFault) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "errorMsg"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setErrorMsg(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class GetItemsRequestE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "getItemsRequest",
                                                                                               "ns1");

        /**
         * field for GetItemsRequest
         */

        protected GetItemsRequest localGetItemsRequest;

        /**
         * Auto generated getter method
         * 
         * @return GetItemsRequest
         */
        public GetItemsRequest getGetItemsRequest( ) {
            return localGetItemsRequest;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            GetItemsRequest
         */
        public void setGetItemsRequest( GetItemsRequest param ) {

            this.localGetItemsRequest = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localGetItemsRequest == null ) {
                throw new org.apache.axis2.databinding.ADBException("getItemsRequest cannot be null!");
            }
            localGetItemsRequest.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localGetItemsRequest.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetItemsRequestE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                GetItemsRequestE object = new GetItemsRequestE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                               "getItemsRequest").equals(reader.getName()) ) {

                                object.setGetItemsRequest(GetItemsRequest.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class LogoutRequestE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "logoutRequest",
                                                                                               "ns1");

        /**
         * field for LogoutRequest
         */

        protected LogoutRequest localLogoutRequest;

        /**
         * Auto generated getter method
         * 
         * @return LogoutRequest
         */
        public LogoutRequest getLogoutRequest( ) {
            return localLogoutRequest;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            LogoutRequest
         */
        public void setLogoutRequest( LogoutRequest param ) {

            this.localLogoutRequest = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localLogoutRequest == null ) {
                throw new org.apache.axis2.databinding.ADBException("logoutRequest cannot be null!");
            }
            localLogoutRequest.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localLogoutRequest.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static LogoutRequestE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                LogoutRequestE object = new LogoutRequestE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "logoutRequest").equals(reader.getName()) ) {

                                object.setLogoutRequest(LogoutRequest.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ExtensionMapper
    {

        public static java.lang.Object getTypeObject( java.lang.String namespaceURI,
                                                      java.lang.String typeName,
                                                      javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "removeResponse".equals(typeName) ) {

                return RemoveResponse.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "itemPreview".equals(typeName) ) {

                return ItemPreview.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "password".equals(typeName) ) {

                return Password.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "removeRequest".equals(typeName) ) {

                return RemoveRequest.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "token".equals(typeName) ) {

                return Token.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "file".equals(typeName) ) {

                return File.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "loginRequest".equals(typeName) ) {

                return LoginRequest.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) &&
                 "getItemsPreviewsResponse".equals(typeName) ) {

                return GetItemsPreviewsResponse.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "dateFrom".equals(typeName) ) {

                return DateFrom.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "logoutResponse".equals(typeName) ) {

                return LogoutResponse.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "login".equals(typeName) ) {

                return Login.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "publishResponse".equals(typeName) ) {

                return PublishResponse.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "loginResponse".equals(typeName) ) {

                return LoginResponse.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "accountsRequest".equals(typeName) ) {

                return AccountsRequest.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "dateTo".equals(typeName) ) {

                return DateTo.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "getItemsResponse".equals(typeName) ) {

                return GetItemsResponse.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "lss".equals(typeName) ) {

                return Lss.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "itemId".equals(typeName) ) {

                return ItemId.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "logoutRequest".equals(typeName) ) {

                return LogoutRequest.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) &&
                 "getItemsPreviewsRequest".equals(typeName) ) {

                return GetItemsPreviewsRequest.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "getItemsRequest".equals(typeName) ) {

                return GetItemsRequest.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "item".equals(typeName) ) {

                return Item.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "message".equals(typeName) ) {

                return Message.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "accountsResponse".equals(typeName) ) {

                return AccountsResponse.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "publishRequest".equals(typeName) ) {

                return PublishRequest.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "isOperationSuccess".equals(typeName) ) {

                return IsOperationSuccess.Factory.parse(reader);

            }

            if ( "http://pk.edu.pl/ias/types".equals(namespaceURI) && "filename".equals(typeName) ) {

                return Filename.Factory.parse(reader);

            }

            throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
                                                                namespaceURI +
                                                                " " +
                                                                typeName);
        }

    }

    public static class Lss implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "lss",
                                                                                               "ns1");

        /**
         * field for Lss
         */

        protected java.lang.String localLss;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getLss( ) {
            return localLss;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Lss
         */
        public void setLss( java.lang.String param ) {

            if ( ( 1 <= java.lang.String.valueOf(param).length() ) ) {
                this.localLss = param;
            }
            else {
                throw new java.lang.RuntimeException();
            }

        }

        @Override
        public java.lang.String toString( ) {

            return localLss.toString();

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":lss",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "lss",
                                   xmlWriter);
                }
            }

            if ( localLss == null ) {

                throw new org.apache.axis2.databinding.ADBException("lss cannot be null !!");

            }
            else {

                xmlWriter.writeCharacters(localLss);

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLss)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static Lss fromString( java.lang.String value, java.lang.String namespaceURI ) {
                Lss returnValue = new Lss();

                returnValue.setLss(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static Lss fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                          java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return Lss.Factory.fromString(content, namespaceUri);
                }
                else {
                    return Lss.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static Lss parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                Lss object = new Lss();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "lss"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setLss(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class LogoutRequest implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = logoutRequest
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Token
         */

        protected Token localToken;

        /**
         * Auto generated getter method
         * 
         * @return Token
         */
        public Token getToken( ) {
            return localToken;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Token
         */
        public void setToken( Token param ) {

            this.localToken = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":logoutRequest",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "logoutRequest",
                                   xmlWriter);
                }

            }

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            localToken.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"),
                                 xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"));

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            elementList.add(localToken);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static LogoutRequest parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                LogoutRequest object = new LogoutRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"logoutRequest".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (LogoutRequest) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token").equals(reader.getName()) ) {

                        object.setToken(Token.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class LoginResponse implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = loginResponse
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Token
         */

        protected Token localToken;

        /**
         * Auto generated getter method
         * 
         * @return Token
         */
        public Token getToken( ) {
            return localToken;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Token
         */
        public void setToken( Token param ) {

            this.localToken = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":loginResponse",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "loginResponse",
                                   xmlWriter);
                }

            }

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            localToken.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"),
                                 xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"));

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            elementList.add(localToken);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static LoginResponse parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                LoginResponse object = new LoginResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"loginResponse".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (LoginResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token").equals(reader.getName()) ) {

                        object.setToken(Token.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class UserNotExistFault implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "userNotExistFault",
                                                                                               "ns1");

        /**
         * field for ErrorMsg
         */

        protected java.lang.String localErrorMsg;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getErrorMsg( ) {
            return localErrorMsg;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            ErrorMsg
         */
        public void setErrorMsg( java.lang.String param ) {

            this.localErrorMsg = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":userNotExistFault",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "userNotExistFault",
                                   xmlWriter);
                }

            }

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "errorMsg", xmlWriter);

            if ( localErrorMsg == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localErrorMsg);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg"));

            if ( localErrorMsg != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static UserNotExistFault parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                UserNotExistFault object = new UserNotExistFault();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"userNotExistFault".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (UserNotExistFault) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "errorMsg"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setErrorMsg(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class GetItemsPreviewsResponse implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = getItemsPreviewsResponse
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for ItemPreviewsList This was an Array!
         */

        protected ItemPreview[] localItemPreviewsList;

        /*  This tracker boolean wil be used to detect whether the user called the set method
        *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localItemPreviewsListTracker = false;

        public boolean isItemPreviewsListSpecified( ) {
            return localItemPreviewsListTracker;
        }

        /**
         * Auto generated getter method
         * 
         * @return ItemPreview[]
         */
        public ItemPreview[] getItemPreviewsList( ) {
            return localItemPreviewsList;
        }

        /**
         * validate the array for ItemPreviewsList
         */
        protected void validateItemPreviewsList( ItemPreview[] param ) {

        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            ItemPreviewsList
         */
        public void setItemPreviewsList( ItemPreview[] param ) {

            validateItemPreviewsList(param);

            localItemPreviewsListTracker = param != null;

            this.localItemPreviewsList = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * 
         * @param param
         *            ItemPreview
         */
        public void addItemPreviewsList( ItemPreview param ) {
            if ( localItemPreviewsList == null ) {
                localItemPreviewsList = new ItemPreview[] {};
            }

            //update the setting tracker
            localItemPreviewsListTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localItemPreviewsList);
            list.add(param);
            this.localItemPreviewsList = (ItemPreview[]) list.toArray(new ItemPreview[list.size()]);

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":getItemsPreviewsResponse",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "getItemsPreviewsResponse",
                                   xmlWriter);
                }

            }
            if ( localItemPreviewsListTracker ) {
                if ( localItemPreviewsList != null ) {
                    for ( int i = 0; i < localItemPreviewsList.length; i++ ) {
                        if ( localItemPreviewsList[ i ] != null ) {
                            localItemPreviewsList[ i ].serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "itemPreviewsList"),
                                                                 xmlWriter);
                        }
                        else {

                            // we don't have to do any thing since minOccures is zero

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("itemPreviewsList cannot be null!!");

                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if ( localItemPreviewsListTracker ) {
                if ( localItemPreviewsList != null ) {
                    for ( int i = 0; i < localItemPreviewsList.length; i++ ) {

                        if ( localItemPreviewsList[ i ] != null ) {
                            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                          "itemPreviewsList"));
                            elementList.add(localItemPreviewsList[ i ]);
                        }
                        else {

                            // nothing to do

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("itemPreviewsList cannot be null!!");

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetItemsPreviewsResponse parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                GetItemsPreviewsResponse object = new GetItemsPreviewsResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"getItemsPreviewsResponse".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (GetItemsPreviewsResponse) ExtensionMapper.getTypeObject(nsUri,
                                                                                                type,
                                                                                                reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "itemPreviewsList").equals(reader.getName()) ) {

                        // Process the array and step past its final element's end.
                        list1.add(ItemPreview.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while ( !loopDone1 ) {
                            // We should be at the end element, but make sure
                            while ( !reader.isEndElement() )
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while ( !reader.isStartElement() && !reader.isEndElement() )
                                reader.next();
                            if ( reader.isEndElement() ) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            }
                            else {
                                if ( new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                   "itemPreviewsList").equals(reader.getName()) ) {
                                    list1.add(ItemPreview.Factory.parse(reader));

                                }
                                else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setItemPreviewsList((ItemPreview[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(ItemPreview.class,
                                                                                                                                   list1));

                    } // End of if for expected property start element

                    else {

                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class RemoveResponseE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "removeResponse",
                                                                                               "ns1");

        /**
         * field for RemoveResponse
         */

        protected RemoveResponse localRemoveResponse;

        /**
         * Auto generated getter method
         * 
         * @return RemoveResponse
         */
        public RemoveResponse getRemoveResponse( ) {
            return localRemoveResponse;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            RemoveResponse
         */
        public void setRemoveResponse( RemoveResponse param ) {

            this.localRemoveResponse = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localRemoveResponse == null ) {
                throw new org.apache.axis2.databinding.ADBException("removeResponse cannot be null!");
            }
            localRemoveResponse.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localRemoveResponse.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static RemoveResponseE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                RemoveResponseE object = new RemoveResponseE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "removeResponse").equals(reader.getName()) ) {

                                object.setRemoveResponse(RemoveResponse.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class RemoveResponse implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = removeResponse
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for IdsList This was an Array!
         */

        protected ItemId[] localIdsList;

        /*  This tracker boolean wil be used to detect whether the user called the set method
        *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localIdsListTracker = false;

        public boolean isIdsListSpecified( ) {
            return localIdsListTracker;
        }

        /**
         * Auto generated getter method
         * 
         * @return ItemId[]
         */
        public ItemId[] getIdsList( ) {
            return localIdsList;
        }

        /**
         * validate the array for IdsList
         */
        protected void validateIdsList( ItemId[] param ) {

        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            IdsList
         */
        public void setIdsList( ItemId[] param ) {

            validateIdsList(param);

            localIdsListTracker = param != null;

            this.localIdsList = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * 
         * @param param
         *            ItemId
         */
        public void addIdsList( ItemId param ) {
            if ( localIdsList == null ) {
                localIdsList = new ItemId[] {};
            }

            //update the setting tracker
            localIdsListTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localIdsList);
            list.add(param);
            this.localIdsList = (ItemId[]) list.toArray(new ItemId[list.size()]);

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":removeResponse",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "removeResponse",
                                   xmlWriter);
                }

            }
            if ( localIdsListTracker ) {
                if ( localIdsList != null ) {
                    for ( int i = 0; i < localIdsList.length; i++ ) {
                        if ( localIdsList[ i ] != null ) {
                            localIdsList[ i ].serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                      "idsList"),
                                                        xmlWriter);
                        }
                        else {

                            // we don't have to do any thing since minOccures is zero

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("idsList cannot be null!!");

                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if ( localIdsListTracker ) {
                if ( localIdsList != null ) {
                    for ( int i = 0; i < localIdsList.length; i++ ) {

                        if ( localIdsList[ i ] != null ) {
                            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                          "idsList"));
                            elementList.add(localIdsList[ i ]);
                        }
                        else {

                            // nothing to do

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("idsList cannot be null!!");

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static RemoveResponse parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                RemoveResponse object = new RemoveResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"removeResponse".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (RemoveResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "idsList").equals(reader.getName()) ) {

                        // Process the array and step past its final element's end.
                        list1.add(ItemId.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while ( !loopDone1 ) {
                            // We should be at the end element, but make sure
                            while ( !reader.isEndElement() )
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while ( !reader.isStartElement() && !reader.isEndElement() )
                                reader.next();
                            if ( reader.isEndElement() ) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            }
                            else {
                                if ( new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "idsList").equals(reader.getName()) ) {
                                    list1.add(ItemId.Factory.parse(reader));

                                }
                                else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setIdsList((ItemId[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(ItemId.class,
                                                                                                                     list1));

                    } // End of if for expected property start element

                    else {

                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class AccountsRequestE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "accountsRequest",
                                                                                               "ns1");

        /**
         * field for AccountsRequest
         */

        protected AccountsRequest localAccountsRequest;

        /**
         * Auto generated getter method
         * 
         * @return AccountsRequest
         */
        public AccountsRequest getAccountsRequest( ) {
            return localAccountsRequest;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            AccountsRequest
         */
        public void setAccountsRequest( AccountsRequest param ) {

            this.localAccountsRequest = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localAccountsRequest == null ) {
                throw new org.apache.axis2.databinding.ADBException("accountsRequest cannot be null!");
            }
            localAccountsRequest.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localAccountsRequest.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static AccountsRequestE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                AccountsRequestE object = new AccountsRequestE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                               "accountsRequest").equals(reader.getName()) ) {

                                object.setAccountsRequest(AccountsRequest.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class GetItemsPreviewsRequestE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "getItemsPreviewsRequest",
                                                                                               "ns1");

        /**
         * field for GetItemsPreviewsRequest
         */

        protected GetItemsPreviewsRequest localGetItemsPreviewsRequest;

        /**
         * Auto generated getter method
         * 
         * @return GetItemsPreviewsRequest
         */
        public GetItemsPreviewsRequest getGetItemsPreviewsRequest( ) {
            return localGetItemsPreviewsRequest;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            GetItemsPreviewsRequest
         */
        public void setGetItemsPreviewsRequest( GetItemsPreviewsRequest param ) {

            this.localGetItemsPreviewsRequest = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localGetItemsPreviewsRequest == null ) {
                throw new org.apache.axis2.databinding.ADBException("getItemsPreviewsRequest cannot be null!");
            }
            localGetItemsPreviewsRequest.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localGetItemsPreviewsRequest.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetItemsPreviewsRequestE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                GetItemsPreviewsRequestE object = new GetItemsPreviewsRequestE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                               "getItemsPreviewsRequest").equals(reader.getName()) ) {

                                object.setGetItemsPreviewsRequest(GetItemsPreviewsRequest.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class GetItemsPreviewsRequest implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = getItemsPreviewsRequest
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Token
         */

        protected Token localToken;

        /**
         * Auto generated getter method
         * 
         * @return Token
         */
        public Token getToken( ) {
            return localToken;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Token
         */
        public void setToken( Token param ) {

            this.localToken = param;

        }

        /**
         * field for Lss
         */

        protected Lss localLss;

        /**
         * Auto generated getter method
         * 
         * @return Lss
         */
        public Lss getLss( ) {
            return localLss;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Lss
         */
        public void setLss( Lss param ) {

            this.localLss = param;

        }

        /**
         * field for DateFrom
         */

        protected DateFrom localDateFrom;

        /**
         * Auto generated getter method
         * 
         * @return DateFrom
         */
        public DateFrom getDateFrom( ) {
            return localDateFrom;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            DateFrom
         */
        public void setDateFrom( DateFrom param ) {

            this.localDateFrom = param;

        }

        /**
         * field for DateTo
         */

        protected DateTo localDateTo;

        /**
         * Auto generated getter method
         * 
         * @return DateTo
         */
        public DateTo getDateTo( ) {
            return localDateTo;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            DateTo
         */
        public void setDateTo( DateTo param ) {

            this.localDateTo = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":getItemsPreviewsRequest",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "getItemsPreviewsRequest",
                                   xmlWriter);
                }

            }

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            localToken.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"),
                                 xmlWriter);

            if ( localLss == null ) {
                throw new org.apache.axis2.databinding.ADBException("lss cannot be null!!");
            }
            localLss.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss"), xmlWriter);

            if ( localDateFrom == null ) {
                throw new org.apache.axis2.databinding.ADBException("dateFrom cannot be null!!");
            }
            localDateFrom.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "dateFrom"),
                                    xmlWriter);

            if ( localDateTo == null ) {
                throw new org.apache.axis2.databinding.ADBException("dateTo cannot be null!!");
            }
            localDateTo.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "dateTo"),
                                  xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"));

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            elementList.add(localToken);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss"));

            if ( localLss == null ) {
                throw new org.apache.axis2.databinding.ADBException("lss cannot be null!!");
            }
            elementList.add(localLss);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "dateFrom"));

            if ( localDateFrom == null ) {
                throw new org.apache.axis2.databinding.ADBException("dateFrom cannot be null!!");
            }
            elementList.add(localDateFrom);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "dateTo"));

            if ( localDateTo == null ) {
                throw new org.apache.axis2.databinding.ADBException("dateTo cannot be null!!");
            }
            elementList.add(localDateTo);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetItemsPreviewsRequest parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                GetItemsPreviewsRequest object = new GetItemsPreviewsRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"getItemsPreviewsRequest".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (GetItemsPreviewsRequest) ExtensionMapper.getTypeObject(nsUri,
                                                                                               type,
                                                                                               reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token").equals(reader.getName()) ) {

                        object.setToken(Token.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss").equals(reader.getName()) ) {

                        object.setLss(Lss.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "dateFrom").equals(reader.getName()) ) {

                        object.setDateFrom(DateFrom.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "dateTo").equals(reader.getName()) ) {

                        object.setDateTo(DateTo.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ServiceUnavailableFault implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "serviceUnavailableFault",
                                                                                               "ns1");

        /**
         * field for ErrorMsg
         */

        protected java.lang.String localErrorMsg;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getErrorMsg( ) {
            return localErrorMsg;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            ErrorMsg
         */
        public void setErrorMsg( java.lang.String param ) {

            this.localErrorMsg = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":serviceUnavailableFault",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "serviceUnavailableFault",
                                   xmlWriter);
                }

            }

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "errorMsg", xmlWriter);

            if ( localErrorMsg == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localErrorMsg);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg"));

            if ( localErrorMsg != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ServiceUnavailableFault parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                ServiceUnavailableFault object = new ServiceUnavailableFault();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"serviceUnavailableFault".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (ServiceUnavailableFault) ExtensionMapper.getTypeObject(nsUri,
                                                                                               type,
                                                                                               reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "errorMsg"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setErrorMsg(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class InvalidLoginOrPasswordFault implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "invalidLoginOrPasswordFault",
                                                                                               "ns1");

        /**
         * field for ErrorMsg
         */

        protected java.lang.String localErrorMsg;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getErrorMsg( ) {
            return localErrorMsg;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            ErrorMsg
         */
        public void setErrorMsg( java.lang.String param ) {

            this.localErrorMsg = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":invalidLoginOrPasswordFault",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "invalidLoginOrPasswordFault",
                                   xmlWriter);
                }

            }

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "errorMsg", xmlWriter);

            if ( localErrorMsg == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localErrorMsg);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg"));

            if ( localErrorMsg != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static InvalidLoginOrPasswordFault parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                InvalidLoginOrPasswordFault object = new InvalidLoginOrPasswordFault();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"invalidLoginOrPasswordFault".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (InvalidLoginOrPasswordFault) ExtensionMapper.getTypeObject(nsUri,
                                                                                                   type,
                                                                                                   reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "errorMsg"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setErrorMsg(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class Message implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "message",
                                                                                               "ns1");

        /**
         * field for Message
         */

        protected java.lang.String localMessage;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getMessage( ) {
            return localMessage;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Message
         */
        public void setMessage( java.lang.String param ) {

            this.localMessage = param;

        }

        @Override
        public java.lang.String toString( ) {

            return localMessage.toString();

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":message",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "message",
                                   xmlWriter);
                }
            }

            if ( localMessage == null ) {

                throw new org.apache.axis2.databinding.ADBException("message cannot be null !!");

            }
            else {

                xmlWriter.writeCharacters(localMessage);

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMessage)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static Message fromString( java.lang.String value, java.lang.String namespaceURI ) {
                Message returnValue = new Message();

                returnValue.setMessage(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static Message fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                              java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return Message.Factory.fromString(content, namespaceUri);
                }
                else {
                    return Message.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static Message parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                Message object = new Message();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "message"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setMessage(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class DateFrom implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "dateFrom",
                                                                                               "ns1");

        /**
         * field for DateFrom
         */

        protected java.util.Calendar localDateFrom;

        /**
         * Auto generated getter method
         * 
         * @return java.util.Calendar
         */
        public java.util.Calendar getDateFrom( ) {
            return localDateFrom;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            DateFrom
         */
        public void setDateFrom( java.util.Calendar param ) {

            this.localDateFrom = param;

        }

        @Override
        public java.lang.String toString( ) {

            return org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDateFrom);

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":dateFrom",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "dateFrom",
                                   xmlWriter);
                }
            }

            if ( localDateFrom == null ) {

                throw new org.apache.axis2.databinding.ADBException("dateFrom cannot be null !!");

            }
            else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDateFrom));

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDateFrom)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static DateFrom fromString( java.lang.String value, java.lang.String namespaceURI ) {
                DateFrom returnValue = new DateFrom();

                returnValue.setDateFrom(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(value));

                return returnValue;
            }

            public static DateFrom fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                               java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return DateFrom.Factory.fromString(content, namespaceUri);
                }
                else {
                    return DateFrom.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static DateFrom parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                DateFrom object = new DateFrom();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "dateFrom"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setDateFrom(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class File implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "file",
                                                                                               "ns1");

        /**
         * field for File
         */

        protected javax.activation.DataHandler localFile;

        /**
         * Auto generated getter method
         * 
         * @return javax.activation.DataHandler
         */
        public javax.activation.DataHandler getFile( ) {
            return localFile;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            File
         */
        public void setFile( javax.activation.DataHandler param ) {

            this.localFile = param;

        }

        @Override
        public java.lang.String toString( ) {

            return localFile.toString();

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":file",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "file",
                                   xmlWriter);
                }
            }

            if ( localFile == null ) {

                throw new org.apache.axis2.databinding.ADBException("file cannot be null !!");

            }
            else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFile));

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFile)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static File fromString( java.lang.String value, java.lang.String namespaceURI ) {
                File returnValue = new File();

                returnValue.setFile(org.apache.axis2.databinding.utils.ConverterUtil.convertToBase64Binary(value));

                return returnValue;
            }

            public static File fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                           java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return File.Factory.fromString(content, namespaceUri);
                }
                else {
                    return File.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static File parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                File object = new File();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "file"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setFile(org.apache.axis2.databinding.utils.ConverterUtil.convertToBase64Binary(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class IsOperationSuccess implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "isOperationSuccess",
                                                                                               "ns1");

        /**
         * field for IsOperationSuccess
         */

        protected boolean localIsOperationSuccess;

        /**
         * Auto generated getter method
         * 
         * @return boolean
         */
        public boolean getIsOperationSuccess( ) {
            return localIsOperationSuccess;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            IsOperationSuccess
         */
        public void setIsOperationSuccess( boolean param ) {

            this.localIsOperationSuccess = param;

        }

        @Override
        public java.lang.String toString( ) {

            return org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsOperationSuccess);

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":isOperationSuccess",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "isOperationSuccess",
                                   xmlWriter);
                }
            }

            if ( false ) {

                throw new org.apache.axis2.databinding.ADBException("property value cannot be null!!");

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsOperationSuccess));
            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsOperationSuccess)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static IsOperationSuccess fromString( java.lang.String value, java.lang.String namespaceURI ) {
                IsOperationSuccess returnValue = new IsOperationSuccess();

                returnValue.setIsOperationSuccess(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(value));

                return returnValue;
            }

            public static IsOperationSuccess fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                         java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return IsOperationSuccess.Factory.fromString(content, namespaceUri);
                }
                else {
                    return IsOperationSuccess.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static IsOperationSuccess parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                IsOperationSuccess object = new IsOperationSuccess();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "isOperationSuccess"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setIsOperationSuccess(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class PublishRequest implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = publishRequest
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Token
         */

        protected Token localToken;

        /**
         * Auto generated getter method
         * 
         * @return Token
         */
        public Token getToken( ) {
            return localToken;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Token
         */
        public void setToken( Token param ) {

            this.localToken = param;

        }

        /**
         * field for Lss
         */

        protected Lss localLss;

        /**
         * Auto generated getter method
         * 
         * @return Lss
         */
        public Lss getLss( ) {
            return localLss;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Lss
         */
        public void setLss( Lss param ) {

            this.localLss = param;

        }

        /**
         * field for File
         */

        protected File localFile;

        /**
         * Auto generated getter method
         * 
         * @return File
         */
        public File getFile( ) {
            return localFile;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            File
         */
        public void setFile( File param ) {

            this.localFile = param;

        }

        /**
         * field for Filename
         */

        protected Filename localFilename;

        /**
         * Auto generated getter method
         * 
         * @return Filename
         */
        public Filename getFilename( ) {
            return localFilename;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Filename
         */
        public void setFilename( Filename param ) {

            this.localFilename = param;

        }

        /**
         * field for Message
         */

        protected Message localMessage;

        /**
         * Auto generated getter method
         * 
         * @return Message
         */
        public Message getMessage( ) {
            return localMessage;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Message
         */
        public void setMessage( Message param ) {

            this.localMessage = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":publishRequest",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "publishRequest",
                                   xmlWriter);
                }

            }

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            localToken.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"),
                                 xmlWriter);

            if ( localLss == null ) {
                throw new org.apache.axis2.databinding.ADBException("lss cannot be null!!");
            }
            localLss.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss"), xmlWriter);

            if ( localFile == null ) {
                throw new org.apache.axis2.databinding.ADBException("file cannot be null!!");
            }
            localFile.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "file"),
                                xmlWriter);

            if ( localFilename == null ) {
                throw new org.apache.axis2.databinding.ADBException("filename cannot be null!!");
            }
            localFilename.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "filename"),
                                    xmlWriter);

            if ( localMessage == null ) {
                throw new org.apache.axis2.databinding.ADBException("message cannot be null!!");
            }
            localMessage.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "message"),
                                   xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"));

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            elementList.add(localToken);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss"));

            if ( localLss == null ) {
                throw new org.apache.axis2.databinding.ADBException("lss cannot be null!!");
            }
            elementList.add(localLss);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "file"));

            if ( localFile == null ) {
                throw new org.apache.axis2.databinding.ADBException("file cannot be null!!");
            }
            elementList.add(localFile);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "filename"));

            if ( localFilename == null ) {
                throw new org.apache.axis2.databinding.ADBException("filename cannot be null!!");
            }
            elementList.add(localFilename);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "message"));

            if ( localMessage == null ) {
                throw new org.apache.axis2.databinding.ADBException("message cannot be null!!");
            }
            elementList.add(localMessage);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static PublishRequest parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                PublishRequest object = new PublishRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"publishRequest".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (PublishRequest) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token").equals(reader.getName()) ) {

                        object.setToken(Token.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss").equals(reader.getName()) ) {

                        object.setLss(Lss.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "file").equals(reader.getName()) ) {

                        object.setFile(File.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "filename").equals(reader.getName()) ) {

                        object.setFilename(Filename.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "message").equals(reader.getName()) ) {

                        object.setMessage(Message.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ItemId implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = itemId
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Id
         */

        protected java.lang.String localId;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getId( ) {
            return localId;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Id
         */
        public void setId( java.lang.String param ) {

            this.localId = param;

        }

        /**
         * field for Lss
         */

        protected java.lang.String localLss;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getLss( ) {
            return localLss;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Lss
         */
        public void setLss( java.lang.String param ) {

            this.localLss = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":itemId",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "itemId",
                                   xmlWriter);
                }

            }

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "id", xmlWriter);

            if ( localId == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localId);

            }

            xmlWriter.writeEndElement();

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "lss", xmlWriter);

            if ( localLss == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("lss cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localLss);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id"));

            if ( localId != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss"));

            if ( localLss != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLss));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("lss cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ItemId parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                ItemId object = new ItemId();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"itemId".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (ItemId) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "id"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "lss"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setLss(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class GetItemsResponse implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = getItemsResponse
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for ItemsList This was an Array!
         */

        protected Item[] localItemsList;

        /*  This tracker boolean wil be used to detect whether the user called the set method
        *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localItemsListTracker = false;

        public boolean isItemsListSpecified( ) {
            return localItemsListTracker;
        }

        /**
         * Auto generated getter method
         * 
         * @return Item[]
         */
        public Item[] getItemsList( ) {
            return localItemsList;
        }

        /**
         * validate the array for ItemsList
         */
        protected void validateItemsList( Item[] param ) {

        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            ItemsList
         */
        public void setItemsList( Item[] param ) {

            validateItemsList(param);

            localItemsListTracker = param != null;

            this.localItemsList = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * 
         * @param param
         *            Item
         */
        public void addItemsList( Item param ) {
            if ( localItemsList == null ) {
                localItemsList = new Item[] {};
            }

            //update the setting tracker
            localItemsListTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localItemsList);
            list.add(param);
            this.localItemsList = (Item[]) list.toArray(new Item[list.size()]);

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":getItemsResponse",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "getItemsResponse",
                                   xmlWriter);
                }

            }
            if ( localItemsListTracker ) {
                if ( localItemsList != null ) {
                    for ( int i = 0; i < localItemsList.length; i++ ) {
                        if ( localItemsList[ i ] != null ) {
                            localItemsList[ i ].serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                        "itemsList"),
                                                          xmlWriter);
                        }
                        else {

                            // we don't have to do any thing since minOccures is zero

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("itemsList cannot be null!!");

                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if ( localItemsListTracker ) {
                if ( localItemsList != null ) {
                    for ( int i = 0; i < localItemsList.length; i++ ) {

                        if ( localItemsList[ i ] != null ) {
                            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                          "itemsList"));
                            elementList.add(localItemsList[ i ]);
                        }
                        else {

                            // nothing to do

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("itemsList cannot be null!!");

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetItemsResponse parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                GetItemsResponse object = new GetItemsResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"getItemsResponse".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (GetItemsResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "itemsList").equals(reader.getName()) ) {

                        // Process the array and step past its final element's end.
                        list1.add(Item.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while ( !loopDone1 ) {
                            // We should be at the end element, but make sure
                            while ( !reader.isEndElement() )
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while ( !reader.isStartElement() && !reader.isEndElement() )
                                reader.next();
                            if ( reader.isEndElement() ) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            }
                            else {
                                if ( new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "itemsList").equals(reader.getName()) ) {
                                    list1.add(Item.Factory.parse(reader));

                                }
                                else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setItemsList((Item[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(Item.class,
                                                                                                                     list1));

                    } // End of if for expected property start element

                    else {

                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class RemoveRequest implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = removeRequest
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Token
         */

        protected Token localToken;

        /**
         * Auto generated getter method
         * 
         * @return Token
         */
        public Token getToken( ) {
            return localToken;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Token
         */
        public void setToken( Token param ) {

            this.localToken = param;

        }

        /**
         * field for IdsList This was an Array!
         */

        protected ItemId[] localIdsList;

        /*  This tracker boolean wil be used to detect whether the user called the set method
        *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localIdsListTracker = false;

        public boolean isIdsListSpecified( ) {
            return localIdsListTracker;
        }

        /**
         * Auto generated getter method
         * 
         * @return ItemId[]
         */
        public ItemId[] getIdsList( ) {
            return localIdsList;
        }

        /**
         * validate the array for IdsList
         */
        protected void validateIdsList( ItemId[] param ) {

        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            IdsList
         */
        public void setIdsList( ItemId[] param ) {

            validateIdsList(param);

            localIdsListTracker = param != null;

            this.localIdsList = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * 
         * @param param
         *            ItemId
         */
        public void addIdsList( ItemId param ) {
            if ( localIdsList == null ) {
                localIdsList = new ItemId[] {};
            }

            //update the setting tracker
            localIdsListTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localIdsList);
            list.add(param);
            this.localIdsList = (ItemId[]) list.toArray(new ItemId[list.size()]);

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":removeRequest",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "removeRequest",
                                   xmlWriter);
                }

            }

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            localToken.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"),
                                 xmlWriter);
            if ( localIdsListTracker ) {
                if ( localIdsList != null ) {
                    for ( int i = 0; i < localIdsList.length; i++ ) {
                        if ( localIdsList[ i ] != null ) {
                            localIdsList[ i ].serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                      "idsList"),
                                                        xmlWriter);
                        }
                        else {

                            // we don't have to do any thing since minOccures is zero

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("idsList cannot be null!!");

                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"));

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            elementList.add(localToken);
            if ( localIdsListTracker ) {
                if ( localIdsList != null ) {
                    for ( int i = 0; i < localIdsList.length; i++ ) {

                        if ( localIdsList[ i ] != null ) {
                            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                          "idsList"));
                            elementList.add(localIdsList[ i ]);
                        }
                        else {

                            // nothing to do

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("idsList cannot be null!!");

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static RemoveRequest parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                RemoveRequest object = new RemoveRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"removeRequest".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (RemoveRequest) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list2 = new java.util.ArrayList();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token").equals(reader.getName()) ) {

                        object.setToken(Token.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "idsList").equals(reader.getName()) ) {

                        // Process the array and step past its final element's end.
                        list2.add(ItemId.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone2 = false;
                        while ( !loopDone2 ) {
                            // We should be at the end element, but make sure
                            while ( !reader.isEndElement() )
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while ( !reader.isStartElement() && !reader.isEndElement() )
                                reader.next();
                            if ( reader.isEndElement() ) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone2 = true;
                            }
                            else {
                                if ( new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "idsList").equals(reader.getName()) ) {
                                    list2.add(ItemId.Factory.parse(reader));

                                }
                                else {
                                    loopDone2 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setIdsList((ItemId[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(ItemId.class,
                                                                                                                     list2));

                    } // End of if for expected property start element

                    else {

                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class BadRequestFault implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "badRequestFault",
                                                                                               "ns1");

        /**
         * field for ErrorMsg
         */

        protected java.lang.String localErrorMsg;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getErrorMsg( ) {
            return localErrorMsg;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            ErrorMsg
         */
        public void setErrorMsg( java.lang.String param ) {

            this.localErrorMsg = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":badRequestFault",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "badRequestFault",
                                   xmlWriter);
                }

            }

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "errorMsg", xmlWriter);

            if ( localErrorMsg == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localErrorMsg);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg"));

            if ( localErrorMsg != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("errorMsg cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static BadRequestFault parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                BadRequestFault object = new BadRequestFault();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"badRequestFault".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (BadRequestFault) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "errorMsg").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "errorMsg"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setErrorMsg(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class LoginRequest implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = loginRequest
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Login
         */

        protected Login localLogin;

        /**
         * Auto generated getter method
         * 
         * @return Login
         */
        public Login getLogin( ) {
            return localLogin;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Login
         */
        public void setLogin( Login param ) {

            this.localLogin = param;

        }

        /**
         * field for Password
         */

        protected Password localPassword;

        /**
         * Auto generated getter method
         * 
         * @return Password
         */
        public Password getPassword( ) {
            return localPassword;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Password
         */
        public void setPassword( Password param ) {

            this.localPassword = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":loginRequest",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "loginRequest",
                                   xmlWriter);
                }

            }

            if ( localLogin == null ) {
                throw new org.apache.axis2.databinding.ADBException("login cannot be null!!");
            }
            localLogin.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "login"),
                                 xmlWriter);

            if ( localPassword == null ) {
                throw new org.apache.axis2.databinding.ADBException("password cannot be null!!");
            }
            localPassword.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "password"),
                                    xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "login"));

            if ( localLogin == null ) {
                throw new org.apache.axis2.databinding.ADBException("login cannot be null!!");
            }
            elementList.add(localLogin);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "password"));

            if ( localPassword == null ) {
                throw new org.apache.axis2.databinding.ADBException("password cannot be null!!");
            }
            elementList.add(localPassword);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static LoginRequest parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                LoginRequest object = new LoginRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"loginRequest".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (LoginRequest) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "login").equals(reader.getName()) ) {

                        object.setLogin(Login.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "password").equals(reader.getName()) ) {

                        object.setPassword(Password.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class LoginRequestE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "loginRequest",
                                                                                               "ns1");

        /**
         * field for LoginRequest
         */

        protected LoginRequest localLoginRequest;

        /**
         * Auto generated getter method
         * 
         * @return LoginRequest
         */
        public LoginRequest getLoginRequest( ) {
            return localLoginRequest;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            LoginRequest
         */
        public void setLoginRequest( LoginRequest param ) {

            this.localLoginRequest = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localLoginRequest == null ) {
                throw new org.apache.axis2.databinding.ADBException("loginRequest cannot be null!");
            }
            localLoginRequest.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localLoginRequest.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static LoginRequestE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                LoginRequestE object = new LoginRequestE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "loginRequest").equals(reader.getName()) ) {

                                object.setLoginRequest(LoginRequest.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class Token implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "token",
                                                                                               "ns1");

        /**
         * field for Token
         */

        protected java.lang.String localToken;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getToken( ) {
            return localToken;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Token
         */
        public void setToken( java.lang.String param ) {

            if ( ( 1 <= java.lang.String.valueOf(param).length() ) ) {
                this.localToken = param;
            }
            else {
                throw new java.lang.RuntimeException();
            }

        }

        @Override
        public java.lang.String toString( ) {

            return localToken.toString();

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if ( serializeType ) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":token",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "token",
                                   xmlWriter);
                }
            }

            if ( localToken == null ) {

                throw new org.apache.axis2.databinding.ADBException("token cannot be null !!");

            }
            else {

                xmlWriter.writeCharacters(localToken);

            }

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                                                                                        new java.lang.Object[] {org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                                                                                                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localToken)},
                                                                                        null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            public static Token fromString( java.lang.String value, java.lang.String namespaceURI ) {
                Token returnValue = new Token();

                returnValue.setToken(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static Token fromString( javax.xml.stream.XMLStreamReader xmlStreamReader,
                                            java.lang.String content ) {
                if ( content.indexOf(":") > -1 ) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext()
                                                                   .getNamespaceURI(prefix);
                    return Token.Factory.fromString(content, namespaceUri);
                }
                else {
                    return Token.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static Token parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                Token object = new Token();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() || reader.hasText() ) {

                            if ( reader.isStartElement() || reader.hasText() ) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                         "nil");
                                if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                        + "token"
                                                                                        + "  cannot be null");
                                }

                                java.lang.String content = reader.getElementText();

                                object.setToken(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ItemPreview implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = itemPreview
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Id
         */

        protected ItemId localId;

        /**
         * Auto generated getter method
         * 
         * @return ItemId
         */
        public ItemId getId( ) {
            return localId;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Id
         */
        public void setId( ItemId param ) {

            this.localId = param;

        }

        /**
         * field for Name
         */

        protected java.lang.String localName;

        /**
         * Auto generated getter method
         * 
         * @return java.lang.String
         */
        public java.lang.String getName( ) {
            return localName;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Name
         */
        public void setName( java.lang.String param ) {

            this.localName = param;

        }

        /**
         * field for Date
         */

        protected java.util.Calendar localDate;

        /**
         * Auto generated getter method
         * 
         * @return java.util.Calendar
         */
        public java.util.Calendar getDate( ) {
            return localDate;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Date
         */
        public void setDate( java.util.Calendar param ) {

            this.localDate = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":itemPreview",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "itemPreview",
                                   xmlWriter);
                }

            }

            if ( localId == null ) {
                throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
            }
            localId.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id"), xmlWriter);

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "name", xmlWriter);

            if ( localName == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(localName);

            }

            xmlWriter.writeEndElement();

            namespace = "http://pk.edu.pl/ias/types";
            writeStartElement(null, namespace, "date", xmlWriter);

            if ( localDate == null ) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("date cannot be null!!");

            }
            else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDate));

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id"));

            if ( localId == null ) {
                throw new org.apache.axis2.databinding.ADBException("id cannot be null!!");
            }
            elementList.add(localId);

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "name"));

            if ( localName != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "date"));

            if ( localDate != null ) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDate));
            }
            else {
                throw new org.apache.axis2.databinding.ADBException("date cannot be null!!");
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ItemPreview parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                ItemPreview object = new ItemPreview();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"itemPreview".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (ItemPreview) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "id").equals(reader.getName()) ) {

                        object.setId(ItemId.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "name").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "name"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "date").equals(reader.getName()) ) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                 "nil");
                        if ( "true".equals(nillableValue) || "1".equals(nillableValue) ) {
                            throw new org.apache.axis2.databinding.ADBException("The element: "
                                                                                + "date"
                                                                                + "  cannot be null");
                        }

                        java.lang.String content = reader.getElementText();

                        object.setDate(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class RemoveRequestE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "removeRequest",
                                                                                               "ns1");

        /**
         * field for RemoveRequest
         */

        protected RemoveRequest localRemoveRequest;

        /**
         * Auto generated getter method
         * 
         * @return RemoveRequest
         */
        public RemoveRequest getRemoveRequest( ) {
            return localRemoveRequest;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            RemoveRequest
         */
        public void setRemoveRequest( RemoveRequest param ) {

            this.localRemoveRequest = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localRemoveRequest == null ) {
                throw new org.apache.axis2.databinding.ADBException("removeRequest cannot be null!");
            }
            localRemoveRequest.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localRemoveRequest.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static RemoveRequestE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                RemoveRequestE object = new RemoveRequestE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "removeRequest").equals(reader.getName()) ) {

                                object.setRemoveRequest(RemoveRequest.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class GetItemsResponseE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "getItemsResponse",
                                                                                               "ns1");

        /**
         * field for GetItemsResponse
         */

        protected GetItemsResponse localGetItemsResponse;

        /**
         * Auto generated getter method
         * 
         * @return GetItemsResponse
         */
        public GetItemsResponse getGetItemsResponse( ) {
            return localGetItemsResponse;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            GetItemsResponse
         */
        public void setGetItemsResponse( GetItemsResponse param ) {

            this.localGetItemsResponse = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localGetItemsResponse == null ) {
                throw new org.apache.axis2.databinding.ADBException("getItemsResponse cannot be null!");
            }
            localGetItemsResponse.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localGetItemsResponse.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetItemsResponseE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                GetItemsResponseE object = new GetItemsResponseE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                               "getItemsResponse").equals(reader.getName()) ) {

                                object.setGetItemsResponse(GetItemsResponse.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class GetItemsPreviewsResponseE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "getItemsPreviewsResponse",
                                                                                               "ns1");

        /**
         * field for GetItemsPreviewsResponse
         */

        protected GetItemsPreviewsResponse localGetItemsPreviewsResponse;

        /**
         * Auto generated getter method
         * 
         * @return GetItemsPreviewsResponse
         */
        public GetItemsPreviewsResponse getGetItemsPreviewsResponse( ) {
            return localGetItemsPreviewsResponse;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            GetItemsPreviewsResponse
         */
        public void setGetItemsPreviewsResponse( GetItemsPreviewsResponse param ) {

            this.localGetItemsPreviewsResponse = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localGetItemsPreviewsResponse == null ) {
                throw new org.apache.axis2.databinding.ADBException("getItemsPreviewsResponse cannot be null!");
            }
            localGetItemsPreviewsResponse.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localGetItemsPreviewsResponse.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetItemsPreviewsResponseE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                GetItemsPreviewsResponseE object = new GetItemsPreviewsResponseE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                               "getItemsPreviewsResponse").equals(reader.getName()) ) {

                                object.setGetItemsPreviewsResponse(GetItemsPreviewsResponse.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class PublishRequestE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "publishRequest",
                                                                                               "ns1");

        /**
         * field for PublishRequest
         */

        protected PublishRequest localPublishRequest;

        /**
         * Auto generated getter method
         * 
         * @return PublishRequest
         */
        public PublishRequest getPublishRequest( ) {
            return localPublishRequest;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            PublishRequest
         */
        public void setPublishRequest( PublishRequest param ) {

            this.localPublishRequest = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localPublishRequest == null ) {
                throw new org.apache.axis2.databinding.ADBException("publishRequest cannot be null!");
            }
            localPublishRequest.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localPublishRequest.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static PublishRequestE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                PublishRequestE object = new PublishRequestE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "publishRequest").equals(reader.getName()) ) {

                                object.setPublishRequest(PublishRequest.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class PublishResponseE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "publishResponse",
                                                                                               "ns1");

        /**
         * field for PublishResponse
         */

        protected PublishResponse localPublishResponse;

        /**
         * Auto generated getter method
         * 
         * @return PublishResponse
         */
        public PublishResponse getPublishResponse( ) {
            return localPublishResponse;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            PublishResponse
         */
        public void setPublishResponse( PublishResponse param ) {

            this.localPublishResponse = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localPublishResponse == null ) {
                throw new org.apache.axis2.databinding.ADBException("publishResponse cannot be null!");
            }
            localPublishResponse.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localPublishResponse.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static PublishResponseE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                PublishResponseE object = new PublishResponseE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                               "publishResponse").equals(reader.getName()) ) {

                                object.setPublishResponse(PublishResponse.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class AccountsRequest implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = accountsRequest
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Token
         */

        protected Token localToken;

        /**
         * Auto generated getter method
         * 
         * @return Token
         */
        public Token getToken( ) {
            return localToken;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Token
         */
        public void setToken( Token param ) {

            this.localToken = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":accountsRequest",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "accountsRequest",
                                   xmlWriter);
                }

            }

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            localToken.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"),
                                 xmlWriter);

            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"));

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            elementList.add(localToken);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static AccountsRequest parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                AccountsRequest object = new AccountsRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"accountsRequest".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (AccountsRequest) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token").equals(reader.getName()) ) {

                        object.setToken(Token.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class LogoutResponseE implements org.apache.axis2.databinding.ADBBean
    {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                               "logoutResponse",
                                                                                               "ns1");

        /**
         * field for LogoutResponse
         */

        protected LogoutResponse localLogoutResponse;

        /**
         * Auto generated getter method
         * 
         * @return LogoutResponse
         */
        public LogoutResponse getLogoutResponse( ) {
            return localLogoutResponse;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            LogoutResponse
         */
        public void setLogoutResponse( LogoutResponse param ) {

            this.localLogoutResponse = param;

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it

            if ( localLogoutResponse == null ) {
                throw new org.apache.axis2.databinding.ADBException("logoutResponse cannot be null!");
            }
            localLogoutResponse.serialize(MY_QNAME, xmlWriter);

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localLogoutResponse.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static LogoutResponseE parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                LogoutResponseE object = new LogoutResponseE();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while ( !reader.isEndElement() ) {
                        if ( reader.isStartElement() ) {

                            if ( reader.isStartElement() &&
                                 new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "logoutResponse").equals(reader.getName()) ) {

                                object.setLogoutResponse(LogoutResponse.Factory.parse(reader));

                            } // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                                    reader.getName());
                            }

                        }
                        else {
                            reader.next();
                        }
                    } // end of while loop

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class GetItemsRequest implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = getItemsRequest
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Token
         */

        protected Token localToken;

        /**
         * Auto generated getter method
         * 
         * @return Token
         */
        public Token getToken( ) {
            return localToken;
        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Token
         */
        public void setToken( Token param ) {

            this.localToken = param;

        }

        /**
         * field for IdsList This was an Array!
         */

        protected ItemId[] localIdsList;

        /*  This tracker boolean wil be used to detect whether the user called the set method
        *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localIdsListTracker = false;

        public boolean isIdsListSpecified( ) {
            return localIdsListTracker;
        }

        /**
         * Auto generated getter method
         * 
         * @return ItemId[]
         */
        public ItemId[] getIdsList( ) {
            return localIdsList;
        }

        /**
         * validate the array for IdsList
         */
        protected void validateIdsList( ItemId[] param ) {

        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            IdsList
         */
        public void setIdsList( ItemId[] param ) {

            validateIdsList(param);

            localIdsListTracker = param != null;

            this.localIdsList = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * 
         * @param param
         *            ItemId
         */
        public void addIdsList( ItemId param ) {
            if ( localIdsList == null ) {
                localIdsList = new ItemId[] {};
            }

            //update the setting tracker
            localIdsListTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localIdsList);
            list.add(param);
            this.localIdsList = (ItemId[]) list.toArray(new ItemId[list.size()]);

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":getItemsRequest",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "getItemsRequest",
                                   xmlWriter);
                }

            }

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            localToken.serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"),
                                 xmlWriter);
            if ( localIdsListTracker ) {
                if ( localIdsList != null ) {
                    for ( int i = 0; i < localIdsList.length; i++ ) {
                        if ( localIdsList[ i ] != null ) {
                            localIdsList[ i ].serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                      "idsList"),
                                                        xmlWriter);
                        }
                        else {

                            // we don't have to do any thing since minOccures is zero

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("idsList cannot be null!!");

                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token"));

            if ( localToken == null ) {
                throw new org.apache.axis2.databinding.ADBException("token cannot be null!!");
            }
            elementList.add(localToken);
            if ( localIdsListTracker ) {
                if ( localIdsList != null ) {
                    for ( int i = 0; i < localIdsList.length; i++ ) {

                        if ( localIdsList[ i ] != null ) {
                            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                          "idsList"));
                            elementList.add(localIdsList[ i ]);
                        }
                        else {

                            // nothing to do

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("idsList cannot be null!!");

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static GetItemsRequest parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                GetItemsRequest object = new GetItemsRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"getItemsRequest".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (GetItemsRequest) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list2 = new java.util.ArrayList();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "token").equals(reader.getName()) ) {

                        object.setToken(Token.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());
                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "idsList").equals(reader.getName()) ) {

                        // Process the array and step past its final element's end.
                        list2.add(ItemId.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone2 = false;
                        while ( !loopDone2 ) {
                            // We should be at the end element, but make sure
                            while ( !reader.isEndElement() )
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while ( !reader.isStartElement() && !reader.isEndElement() )
                                reader.next();
                            if ( reader.isEndElement() ) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone2 = true;
                            }
                            else {
                                if ( new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "idsList").equals(reader.getName()) ) {
                                    list2.add(ItemId.Factory.parse(reader));

                                }
                                else {
                                    loopDone2 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setIdsList((ItemId[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(ItemId.class,
                                                                                                                     list2));

                    } // End of if for expected property start element

                    else {

                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class AccountsResponse implements org.apache.axis2.databinding.ADBBean
    {
        /* This type was generated from the piece of schema that had
                name = accountsResponse
                Namespace URI = http://pk.edu.pl/ias/types
                Namespace Prefix = ns1
                */

        /**
         * field for Lss This was an Array!
         */

        protected Lss[] localLss;

        /*  This tracker boolean wil be used to detect whether the user called the set method
        *   for this attribute. It will be used to determine whether to include this field
        *   in the serialized XML
        */
        protected boolean localLssTracker = false;

        public boolean isLssSpecified( ) {
            return localLssTracker;
        }

        /**
         * Auto generated getter method
         * 
         * @return Lss[]
         */
        public Lss[] getLss( ) {
            return localLss;
        }

        /**
         * validate the array for Lss
         */
        protected void validateLss( Lss[] param ) {

        }

        /**
         * Auto generated setter method
         * 
         * @param param
         *            Lss
         */
        public void setLss( Lss[] param ) {

            validateLss(param);

            localLssTracker = param != null;

            this.localLss = param;
        }

        /**
         * Auto generated add method for the array for convenience
         * 
         * @param param
         *            Lss
         */
        public void addLss( Lss param ) {
            if ( localLss == null ) {
                localLss = new Lss[] {};
            }

            //update the setting tracker
            localLssTracker = true;

            java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localLss);
            list.add(param);
            this.localLss = (Lss[]) list.toArray(new Lss[list.size()]);

        }

        /**
         * 
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        @Override
        public org.apache.axiom.om.OMElement getOMElement( final javax.xml.namespace.QName parentQName,
                                                           final org.apache.axiom.om.OMFactory factory ) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                                                                                                         parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException,
                                                                           org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        @Override
        public void serialize( final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType ) throws javax.xml.stream.XMLStreamException,
                                                      org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if ( serializeType ) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://pk.edu.pl/ias/types");
                if ( ( namespacePrefix != null ) && ( namespacePrefix.trim().length() > 0 ) ) {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   namespacePrefix + ":accountsResponse",
                                   xmlWriter);
                }
                else {
                    writeAttribute("xsi",
                                   "http://www.w3.org/2001/XMLSchema-instance",
                                   "type",
                                   "accountsResponse",
                                   xmlWriter);
                }

            }
            if ( localLssTracker ) {
                if ( localLss != null ) {
                    for ( int i = 0; i < localLss.length; i++ ) {
                        if ( localLss[ i ] != null ) {
                            localLss[ i ].serialize(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types",
                                                                                  "lss"),
                                                    xmlWriter);
                        }
                        else {

                            // we don't have to do any thing since minOccures is zero

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("lss cannot be null!!");

                }
            }
            xmlWriter.writeEndElement();

        }

        private static java.lang.String generatePrefix( java.lang.String namespace ) {
            if ( namespace.equals("http://pk.edu.pl/ias/types") ) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement( java.lang.String prefix,
                                        java.lang.String namespace,
                                        java.lang.String localPart,
                                        javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if ( writerPrefix != null ) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if ( namespace.length() == 0 ) {
                    prefix = "";
                }
                else if ( prefix == null ) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute( java.lang.String prefix,
                                     java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( xmlWriter.getPrefix(namespace) == null ) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute( java.lang.String namespace,
                                     java.lang.String attName,
                                     java.lang.String attValue,
                                     javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute( java.lang.String namespace,
                                          java.lang.String attName,
                                          javax.xml.namespace.QName qname,
                                          javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if ( attributePrefix == null ) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if ( attributePrefix.trim().length() > 0 ) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }

            if ( namespace.equals("") ) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */

        private void writeQName( javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if ( namespaceURI != null ) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if ( prefix == null ) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if ( prefix.trim().length() > 0 ) {
                    xmlWriter.writeCharacters(prefix +
                                              ":" +
                                              org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }
                else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            }
            else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames( javax.xml.namespace.QName[] qnames,
                                  javax.xml.stream.XMLStreamWriter xmlWriter ) throws javax.xml.stream.XMLStreamException {

            if ( qnames != null ) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for ( int i = 0; i < qnames.length; i++ ) {
                    if ( i > 0 ) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[ i ].getNamespaceURI();
                    if ( namespaceURI != null ) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ( ( prefix == null ) || ( prefix.length() == 0 ) ) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if ( prefix.trim().length() > 0 ) {
                            stringToWrite.append(prefix)
                                         .append(":")
                                         .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                        else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                        }
                    }
                    else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[ i ]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix( javax.xml.stream.XMLStreamWriter xmlWriter,
                                                 java.lang.String namespace ) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if ( prefix == null ) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while ( true ) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if ( uri == null || uri.length() == 0 ) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         * 
         */
        @Override
        public javax.xml.stream.XMLStreamReader getPullParser( javax.xml.namespace.QName qName ) throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if ( localLssTracker ) {
                if ( localLss != null ) {
                    for ( int i = 0; i < localLss.length; i++ ) {

                        if ( localLss[ i ] != null ) {
                            elementList.add(new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss"));
                            elementList.add(localLss[ i ]);
                        }
                        else {

                            // nothing to do

                        }

                    }
                }
                else {

                    throw new org.apache.axis2.databinding.ADBException("lss cannot be null!!");

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
                                                                                        elementList.toArray(),
                                                                                        attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory
        {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static AccountsResponse parse( javax.xml.stream.XMLStreamReader reader ) throws java.lang.Exception {
                AccountsResponse object = new AccountsResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null ) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                                                                 "type");
                        if ( fullTypeName != null ) {
                            java.lang.String nsPrefix = null;
                            if ( fullTypeName.indexOf(":") > -1 ) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if ( !"accountsResponse".equals(type) ) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext()
                                                               .getNamespaceURI(nsPrefix);
                                return (AccountsResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() &&
                         new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss").equals(reader.getName()) ) {

                        // Process the array and step past its final element's end.
                        list1.add(Lss.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while ( !loopDone1 ) {
                            // We should be at the end element, but make sure
                            while ( !reader.isEndElement() )
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while ( !reader.isStartElement() && !reader.isEndElement() )
                                reader.next();
                            if ( reader.isEndElement() ) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            }
                            else {
                                if ( new javax.xml.namespace.QName("http://pk.edu.pl/ias/types", "lss").equals(reader.getName()) ) {
                                    list1.add(Lss.Factory.parse(reader));

                                }
                                else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setLss((Lss[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(Lss.class,
                                                                                                              list1));

                    } // End of if for expected property start element

                    else {

                    }

                    while ( !reader.isStartElement() && !reader.isEndElement() )
                        reader.next();

                    if ( reader.isStartElement() )
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
                                                                            reader.getName());

                }
                catch ( javax.xml.stream.XMLStreamException e ) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    private org.apache.axiom.om.OMElement toOM( LogoutRequestE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(LogoutRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( LogoutResponseE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(LogoutResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( GetItemsPreviewsRequestE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(GetItemsPreviewsRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( GetItemsPreviewsResponseE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(GetItemsPreviewsResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( TokenExpiredFault param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(TokenExpiredFault.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( AccountsRequestE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(AccountsRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( AccountsResponseE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(AccountsResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( LoginRequestE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(LoginRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( LoginResponseE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(LoginResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( UserNotExistFault param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(UserNotExistFault.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( IncorrectPasswordFault param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(IncorrectPasswordFault.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( PublishRequestE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(PublishRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( PublishResponseE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(PublishResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( RemoveRequestE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(RemoveRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( RemoveResponseE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(RemoveResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( GetItemsRequestE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(GetItemsRequestE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM( GetItemsResponseE param, boolean optimizeContent ) throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(GetItemsResponseE.MY_QNAME,
                                      org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           LogoutRequestE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(LogoutRequestE.MY_QNAME, factory));
            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           GetItemsPreviewsRequestE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(GetItemsPreviewsRequestE.MY_QNAME, factory));
            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           AccountsRequestE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(AccountsRequestE.MY_QNAME, factory));
            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           LoginRequestE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(LoginRequestE.MY_QNAME, factory));
            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           PublishRequestE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(PublishRequestE.MY_QNAME, factory));
            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           RemoveRequestE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(RemoveRequestE.MY_QNAME, factory));
            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope( org.apache.axiom.soap.SOAPFactory factory,
                                                           GetItemsRequestE param,
                                                           boolean optimizeContent,
                                                           javax.xml.namespace.QName methodQName ) throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(GetItemsRequestE.MY_QNAME, factory));
            return emptyEnvelope;
        }
        catch ( org.apache.axis2.databinding.ADBException e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */

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

            if ( LogoutRequestE.class.equals(type) ) {

                return LogoutRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( LogoutResponseE.class.equals(type) ) {

                return LogoutResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( GetItemsPreviewsRequestE.class.equals(type) ) {

                return GetItemsPreviewsRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( GetItemsPreviewsResponseE.class.equals(type) ) {

                return GetItemsPreviewsResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( TokenExpiredFault.class.equals(type) ) {

                return TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( AccountsRequestE.class.equals(type) ) {

                return AccountsRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( AccountsResponseE.class.equals(type) ) {

                return AccountsResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( TokenExpiredFault.class.equals(type) ) {

                return TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( LoginRequestE.class.equals(type) ) {

                return LoginRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( LoginResponseE.class.equals(type) ) {

                return LoginResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( UserNotExistFault.class.equals(type) ) {

                return UserNotExistFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( IncorrectPasswordFault.class.equals(type) ) {

                return IncorrectPasswordFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( PublishRequestE.class.equals(type) ) {

                return PublishRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( PublishResponseE.class.equals(type) ) {

                return PublishResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( TokenExpiredFault.class.equals(type) ) {

                return TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( RemoveRequestE.class.equals(type) ) {

                return RemoveRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( RemoveResponseE.class.equals(type) ) {

                return RemoveResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( TokenExpiredFault.class.equals(type) ) {

                return TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( GetItemsRequestE.class.equals(type) ) {

                return GetItemsRequestE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( GetItemsResponseE.class.equals(type) ) {

                return GetItemsResponseE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if ( TokenExpiredFault.class.equals(type) ) {

                return TokenExpiredFault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

        }
        catch ( java.lang.Exception e ) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }

}
