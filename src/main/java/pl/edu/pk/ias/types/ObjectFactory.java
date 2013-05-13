
package pl.edu.pk.ias.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.pk.ias.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PublishResponse_QNAME = new QName("http://pk.edu.pl/ias/types", "publishResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://pk.edu.pl/ias/types", "loginResponse");
    private final static QName _AccountsRequest_QNAME = new QName("http://pk.edu.pl/ias/types", "accountsRequest");
    private final static QName _RemoveResponse_QNAME = new QName("http://pk.edu.pl/ias/types", "removeResponse");
    private final static QName _GetItemsResponse_QNAME = new QName("http://pk.edu.pl/ias/types", "getItemsResponse");
    private final static QName _RemoveRequest_QNAME = new QName("http://pk.edu.pl/ias/types", "removeRequest");
    private final static QName _LogoutRequest_QNAME = new QName("http://pk.edu.pl/ias/types", "logoutRequest");
    private final static QName _GetItemsPreviewsRequest_QNAME = new QName("http://pk.edu.pl/ias/types", "getItemsPreviewsRequest");
    private final static QName _GetItemsRequest_QNAME = new QName("http://pk.edu.pl/ias/types", "getItemsRequest");
    private final static QName _LoginRequest_QNAME = new QName("http://pk.edu.pl/ias/types", "loginRequest");
    private final static QName _GetItemsPreviewsResponse_QNAME = new QName("http://pk.edu.pl/ias/types", "getItemsPreviewsResponse");
    private final static QName _AccountsResponse_QNAME = new QName("http://pk.edu.pl/ias/types", "accountsResponse");
    private final static QName _PublishRequest_QNAME = new QName("http://pk.edu.pl/ias/types", "publishRequest");
    private final static QName _LogoutResponse_QNAME = new QName("http://pk.edu.pl/ias/types", "logoutResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.pk.ias.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetItemsResponse }
     * 
     */
    public GetItemsResponse createGetItemsResponse() {
        return new GetItemsResponse();
    }

    /**
     * Create an instance of {@link PublishResponse }
     * 
     */
    public PublishResponse createPublishResponse() {
        return new PublishResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link AccountsRequest }
     * 
     */
    public AccountsRequest createAccountsRequest() {
        return new AccountsRequest();
    }

    /**
     * Create an instance of {@link RemoveResponse }
     * 
     */
    public RemoveResponse createRemoveResponse() {
        return new RemoveResponse();
    }

    /**
     * Create an instance of {@link TokenExpiredFault }
     * 
     */
    public TokenExpiredFault createTokenExpiredFault() {
        return new TokenExpiredFault();
    }

    /**
     * Create an instance of {@link RemoveRequest }
     * 
     */
    public RemoveRequest createRemoveRequest() {
        return new RemoveRequest();
    }

    /**
     * Create an instance of {@link LogoutRequest }
     * 
     */
    public LogoutRequest createLogoutRequest() {
        return new LogoutRequest();
    }

    /**
     * Create an instance of {@link GetItemsPreviewsResponse }
     * 
     */
    public GetItemsPreviewsResponse createGetItemsPreviewsResponse() {
        return new GetItemsPreviewsResponse();
    }

    /**
     * Create an instance of {@link AccountsResponse }
     * 
     */
    public AccountsResponse createAccountsResponse() {
        return new AccountsResponse();
    }

    /**
     * Create an instance of {@link GetItemsPreviewsRequest }
     * 
     */
    public GetItemsPreviewsRequest createGetItemsPreviewsRequest() {
        return new GetItemsPreviewsRequest();
    }

    /**
     * Create an instance of {@link GetItemsRequest }
     * 
     */
    public GetItemsRequest createGetItemsRequest() {
        return new GetItemsRequest();
    }

    /**
     * Create an instance of {@link IncorrectPasswordFault }
     * 
     */
    public IncorrectPasswordFault createIncorrectPasswordFault() {
        return new IncorrectPasswordFault();
    }

    /**
     * Create an instance of {@link LoginRequest }
     * 
     */
    public LoginRequest createLoginRequest() {
        return new LoginRequest();
    }

    /**
     * Create an instance of {@link UserNotExistFault }
     * 
     */
    public UserNotExistFault createUserNotExistFault() {
        return new UserNotExistFault();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link PublishRequest }
     * 
     */
    public PublishRequest createPublishRequest() {
        return new PublishRequest();
    }

    /**
     * Create an instance of {@link ItemPreview }
     * 
     */
    public ItemPreview createItemPreview() {
        return new ItemPreview();
    }

    /**
     * Create an instance of {@link ItemId }
     * 
     */
    public ItemId createItemId() {
        return new ItemId();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "publishResponse")
    public JAXBElement<PublishResponse> createPublishResponse(PublishResponse value) {
        return new JAXBElement<PublishResponse>(_PublishResponse_QNAME, PublishResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "accountsRequest")
    public JAXBElement<AccountsRequest> createAccountsRequest(AccountsRequest value) {
        return new JAXBElement<AccountsRequest>(_AccountsRequest_QNAME, AccountsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "removeResponse")
    public JAXBElement<RemoveResponse> createRemoveResponse(RemoveResponse value) {
        return new JAXBElement<RemoveResponse>(_RemoveResponse_QNAME, RemoveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "getItemsResponse")
    public JAXBElement<GetItemsResponse> createGetItemsResponse(GetItemsResponse value) {
        return new JAXBElement<GetItemsResponse>(_GetItemsResponse_QNAME, GetItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "removeRequest")
    public JAXBElement<RemoveRequest> createRemoveRequest(RemoveRequest value) {
        return new JAXBElement<RemoveRequest>(_RemoveRequest_QNAME, RemoveRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "logoutRequest")
    public JAXBElement<LogoutRequest> createLogoutRequest(LogoutRequest value) {
        return new JAXBElement<LogoutRequest>(_LogoutRequest_QNAME, LogoutRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItemsPreviewsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "getItemsPreviewsRequest")
    public JAXBElement<GetItemsPreviewsRequest> createGetItemsPreviewsRequest(GetItemsPreviewsRequest value) {
        return new JAXBElement<GetItemsPreviewsRequest>(_GetItemsPreviewsRequest_QNAME, GetItemsPreviewsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItemsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "getItemsRequest")
    public JAXBElement<GetItemsRequest> createGetItemsRequest(GetItemsRequest value) {
        return new JAXBElement<GetItemsRequest>(_GetItemsRequest_QNAME, GetItemsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "loginRequest")
    public JAXBElement<LoginRequest> createLoginRequest(LoginRequest value) {
        return new JAXBElement<LoginRequest>(_LoginRequest_QNAME, LoginRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItemsPreviewsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "getItemsPreviewsResponse")
    public JAXBElement<GetItemsPreviewsResponse> createGetItemsPreviewsResponse(GetItemsPreviewsResponse value) {
        return new JAXBElement<GetItemsPreviewsResponse>(_GetItemsPreviewsResponse_QNAME, GetItemsPreviewsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "accountsResponse")
    public JAXBElement<AccountsResponse> createAccountsResponse(AccountsResponse value) {
        return new JAXBElement<AccountsResponse>(_AccountsResponse_QNAME, AccountsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "publishRequest")
    public JAXBElement<PublishRequest> createPublishRequest(PublishRequest value) {
        return new JAXBElement<PublishRequest>(_PublishRequest_QNAME, PublishRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pk.edu.pl/ias/types", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

}
