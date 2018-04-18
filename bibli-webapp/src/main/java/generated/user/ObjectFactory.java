
package generated.user;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.user package. 
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

    private final static QName _CreateUserResponse_QNAME = new QName("http://service.ocproject.org/", "createUserResponse");
    private final static QName _ConnectUser_QNAME = new QName("http://service.ocproject.org/", "connectUser");
    private final static QName _ConnectUserResponse_QNAME = new QName("http://service.ocproject.org/", "connectUserResponse");
    private final static QName _DetailUser_QNAME = new QName("http://service.ocproject.org/", "detailUser");
    private final static QName _ModifUser_QNAME = new QName("http://service.ocproject.org/", "modifUser");
    private final static QName _CreateUser_QNAME = new QName("http://service.ocproject.org/", "createUser");
    private final static QName _DetailUserResponse_QNAME = new QName("http://service.ocproject.org/", "detailUserResponse");
    private final static QName _ModifUserResponse_QNAME = new QName("http://service.ocproject.org/", "modifUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.user
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link ConnectUser }
     * 
     */
    public ConnectUser createConnectUser() {
        return new ConnectUser();
    }

    /**
     * Create an instance of {@link ConnectUserResponse }
     * 
     */
    public ConnectUserResponse createConnectUserResponse() {
        return new ConnectUserResponse();
    }

    /**
     * Create an instance of {@link DetailUser }
     * 
     */
    public DetailUser createDetailUser() {
        return new DetailUser();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link DetailUserResponse }
     * 
     */
    public DetailUserResponse createDetailUserResponse() {
        return new DetailUserResponse();
    }

    /**
     * Create an instance of {@link ModifUserResponse }
     * 
     */
    public ModifUserResponse createModifUserResponse() {
        return new ModifUserResponse();
    }

    /**
     * Create an instance of {@link ModifUser }
     * 
     */
    public ModifUser createModifUser() {
        return new ModifUser();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "connectUser")
    public JAXBElement<ConnectUser> createConnectUser(ConnectUser value) {
        return new JAXBElement<ConnectUser>(_ConnectUser_QNAME, ConnectUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "connectUserResponse")
    public JAXBElement<ConnectUserResponse> createConnectUserResponse(ConnectUserResponse value) {
        return new JAXBElement<ConnectUserResponse>(_ConnectUserResponse_QNAME, ConnectUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetailUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "detailUser")
    public JAXBElement<DetailUser> createDetailUser(DetailUser value) {
        return new JAXBElement<DetailUser>(_DetailUser_QNAME, DetailUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "modifUser")
    public JAXBElement<ModifUser> createModifUser(ModifUser value) {
        return new JAXBElement<ModifUser>(_ModifUser_QNAME, ModifUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetailUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "detailUserResponse")
    public JAXBElement<DetailUserResponse> createDetailUserResponse(DetailUserResponse value) {
        return new JAXBElement<DetailUserResponse>(_DetailUserResponse_QNAME, DetailUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "modifUserResponse")
    public JAXBElement<ModifUserResponse> createModifUserResponse(ModifUserResponse value) {
        return new JAXBElement<ModifUserResponse>(_ModifUserResponse_QNAME, ModifUserResponse.class, null, value);
    }

}
