
package generated.ouvrage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.ouvrage package. 
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

    private final static QName _EmprunterOuvrageResponse_QNAME = new QName("http://service.ocproject.org/", "emprunterOuvrageResponse");
    private final static QName _ReadInfoUser_QNAME = new QName("http://service.ocproject.org/", "readInfoUser");
    private final static QName _Rendre_QNAME = new QName("http://service.ocproject.org/", "rendre");
    private final static QName _ReadInfoUserResponse_QNAME = new QName("http://service.ocproject.org/", "readInfoUserResponse");
    private final static QName _ProlongerResponse_QNAME = new QName("http://service.ocproject.org/", "prolongerResponse");
    private final static QName _ReadInfoLivreResponse_QNAME = new QName("http://service.ocproject.org/", "readInfoLivreResponse");
    private final static QName _Prolonger_QNAME = new QName("http://service.ocproject.org/", "prolonger");
    private final static QName _CheckEmprunts_QNAME = new QName("http://service.ocproject.org/", "checkEmprunts");
    private final static QName _EmprunterOuvrage_QNAME = new QName("http://service.ocproject.org/", "emprunterOuvrage");
    private final static QName _CheckEmpruntsResponse_QNAME = new QName("http://service.ocproject.org/", "checkEmpruntsResponse");
    private final static QName _RendreResponse_QNAME = new QName("http://service.ocproject.org/", "rendreResponse");
    private final static QName _ReadInfoLivre_QNAME = new QName("http://service.ocproject.org/", "readInfoLivre");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.ouvrage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProlongerResponse }
     * 
     */
    public ProlongerResponse createProlongerResponse() {
        return new ProlongerResponse();
    }

    /**
     * Create an instance of {@link ReadInfoLivreResponse }
     * 
     */
    public ReadInfoLivreResponse createReadInfoLivreResponse() {
        return new ReadInfoLivreResponse();
    }

    /**
     * Create an instance of {@link Prolonger }
     * 
     */
    public Prolonger createProlonger() {
        return new Prolonger();
    }

    /**
     * Create an instance of {@link EmprunterOuvrageResponse }
     * 
     */
    public EmprunterOuvrageResponse createEmprunterOuvrageResponse() {
        return new EmprunterOuvrageResponse();
    }

    /**
     * Create an instance of {@link ReadInfoUser }
     * 
     */
    public ReadInfoUser createReadInfoUser() {
        return new ReadInfoUser();
    }

    /**
     * Create an instance of {@link ReadInfoUserResponse }
     * 
     */
    public ReadInfoUserResponse createReadInfoUserResponse() {
        return new ReadInfoUserResponse();
    }

    /**
     * Create an instance of {@link Rendre }
     * 
     */
    public Rendre createRendre() {
        return new Rendre();
    }

    /**
     * Create an instance of {@link RendreResponse }
     * 
     */
    public RendreResponse createRendreResponse() {
        return new RendreResponse();
    }

    /**
     * Create an instance of {@link CheckEmpruntsResponse }
     * 
     */
    public CheckEmpruntsResponse createCheckEmpruntsResponse() {
        return new CheckEmpruntsResponse();
    }

    /**
     * Create an instance of {@link ReadInfoLivre }
     * 
     */
    public ReadInfoLivre createReadInfoLivre() {
        return new ReadInfoLivre();
    }

    /**
     * Create an instance of {@link CheckEmprunts }
     * 
     */
    public CheckEmprunts createCheckEmprunts() {
        return new CheckEmprunts();
    }

    /**
     * Create an instance of {@link EmprunterOuvrage }
     * 
     */
    public EmprunterOuvrage createEmprunterOuvrage() {
        return new EmprunterOuvrage();
    }

    /**
     * Create an instance of {@link Ouvrage }
     * 
     */
    public Ouvrage createOuvrage() {
        return new Ouvrage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmprunterOuvrageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "emprunterOuvrageResponse")
    public JAXBElement<EmprunterOuvrageResponse> createEmprunterOuvrageResponse(EmprunterOuvrageResponse value) {
        return new JAXBElement<EmprunterOuvrageResponse>(_EmprunterOuvrageResponse_QNAME, EmprunterOuvrageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadInfoUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "readInfoUser")
    public JAXBElement<ReadInfoUser> createReadInfoUser(ReadInfoUser value) {
        return new JAXBElement<ReadInfoUser>(_ReadInfoUser_QNAME, ReadInfoUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rendre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "rendre")
    public JAXBElement<Rendre> createRendre(Rendre value) {
        return new JAXBElement<Rendre>(_Rendre_QNAME, Rendre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadInfoUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "readInfoUserResponse")
    public JAXBElement<ReadInfoUserResponse> createReadInfoUserResponse(ReadInfoUserResponse value) {
        return new JAXBElement<ReadInfoUserResponse>(_ReadInfoUserResponse_QNAME, ReadInfoUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProlongerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "prolongerResponse")
    public JAXBElement<ProlongerResponse> createProlongerResponse(ProlongerResponse value) {
        return new JAXBElement<ProlongerResponse>(_ProlongerResponse_QNAME, ProlongerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadInfoLivreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "readInfoLivreResponse")
    public JAXBElement<ReadInfoLivreResponse> createReadInfoLivreResponse(ReadInfoLivreResponse value) {
        return new JAXBElement<ReadInfoLivreResponse>(_ReadInfoLivreResponse_QNAME, ReadInfoLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prolonger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "prolonger")
    public JAXBElement<Prolonger> createProlonger(Prolonger value) {
        return new JAXBElement<Prolonger>(_Prolonger_QNAME, Prolonger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmprunts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "checkEmprunts")
    public JAXBElement<CheckEmprunts> createCheckEmprunts(CheckEmprunts value) {
        return new JAXBElement<CheckEmprunts>(_CheckEmprunts_QNAME, CheckEmprunts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmprunterOuvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "emprunterOuvrage")
    public JAXBElement<EmprunterOuvrage> createEmprunterOuvrage(EmprunterOuvrage value) {
        return new JAXBElement<EmprunterOuvrage>(_EmprunterOuvrage_QNAME, EmprunterOuvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmpruntsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "checkEmpruntsResponse")
    public JAXBElement<CheckEmpruntsResponse> createCheckEmpruntsResponse(CheckEmpruntsResponse value) {
        return new JAXBElement<CheckEmpruntsResponse>(_CheckEmpruntsResponse_QNAME, CheckEmpruntsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RendreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "rendreResponse")
    public JAXBElement<RendreResponse> createRendreResponse(RendreResponse value) {
        return new JAXBElement<RendreResponse>(_RendreResponse_QNAME, RendreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadInfoLivre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "readInfoLivre")
    public JAXBElement<ReadInfoLivre> createReadInfoLivre(ReadInfoLivre value) {
        return new JAXBElement<ReadInfoLivre>(_ReadInfoLivre_QNAME, ReadInfoLivre.class, null, value);
    }

}
