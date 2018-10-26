
package generated.reservation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.reservation package. 
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

    private final static QName _ReserverResponse_QNAME = new QName("http://service.ocproject.org/", "reserverResponse");
    private final static QName _AnnulerReservation_QNAME = new QName("http://service.ocproject.org/", "annulerReservation");
    private final static QName _SelectAll_QNAME = new QName("http://service.ocproject.org/", "selectAll");
    private final static QName _SelectAllResponse_QNAME = new QName("http://service.ocproject.org/", "selectAllResponse");
    private final static QName _SelectByIdLivreResponse_QNAME = new QName("http://service.ocproject.org/", "selectByIdLivreResponse");
    private final static QName _AnnulerReservationResponse_QNAME = new QName("http://service.ocproject.org/", "annulerReservationResponse");
    private final static QName _SelectByIdUserResponse_QNAME = new QName("http://service.ocproject.org/", "selectByIdUserResponse");
    private final static QName _Reserver_QNAME = new QName("http://service.ocproject.org/", "reserver");
    private final static QName _SelectByIdLivre_QNAME = new QName("http://service.ocproject.org/", "selectByIdLivre");
    private final static QName _SelectByIdUser_QNAME = new QName("http://service.ocproject.org/", "selectByIdUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.reservation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnnulerReservation }
     * 
     */
    public AnnulerReservation createAnnulerReservation() {
        return new AnnulerReservation();
    }

    /**
     * Create an instance of {@link SelectAll }
     * 
     */
    public SelectAll createSelectAll() {
        return new SelectAll();
    }

    /**
     * Create an instance of {@link SelectAllResponse }
     * 
     */
    public SelectAllResponse createSelectAllResponse() {
        return new SelectAllResponse();
    }

    /**
     * Create an instance of {@link SelectByIdLivreResponse }
     * 
     */
    public SelectByIdLivreResponse createSelectByIdLivreResponse() {
        return new SelectByIdLivreResponse();
    }

    /**
     * Create an instance of {@link ReserverResponse }
     * 
     */
    public ReserverResponse createReserverResponse() {
        return new ReserverResponse();
    }

    /**
     * Create an instance of {@link SelectByIdUser }
     * 
     */
    public SelectByIdUser createSelectByIdUser() {
        return new SelectByIdUser();
    }

    /**
     * Create an instance of {@link Reserver }
     * 
     */
    public Reserver createReserver() {
        return new Reserver();
    }

    /**
     * Create an instance of {@link SelectByIdLivre }
     * 
     */
    public SelectByIdLivre createSelectByIdLivre() {
        return new SelectByIdLivre();
    }

    /**
     * Create an instance of {@link AnnulerReservationResponse }
     * 
     */
    public AnnulerReservationResponse createAnnulerReservationResponse() {
        return new AnnulerReservationResponse();
    }

    /**
     * Create an instance of {@link SelectByIdUserResponse }
     * 
     */
    public SelectByIdUserResponse createSelectByIdUserResponse() {
        return new SelectByIdUserResponse();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "reserverResponse")
    public JAXBElement<ReserverResponse> createReserverResponse(ReserverResponse value) {
        return new JAXBElement<ReserverResponse>(_ReserverResponse_QNAME, ReserverResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "annulerReservation")
    public JAXBElement<AnnulerReservation> createAnnulerReservation(AnnulerReservation value) {
        return new JAXBElement<AnnulerReservation>(_AnnulerReservation_QNAME, AnnulerReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "selectAll")
    public JAXBElement<SelectAll> createSelectAll(SelectAll value) {
        return new JAXBElement<SelectAll>(_SelectAll_QNAME, SelectAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "selectAllResponse")
    public JAXBElement<SelectAllResponse> createSelectAllResponse(SelectAllResponse value) {
        return new JAXBElement<SelectAllResponse>(_SelectAllResponse_QNAME, SelectAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByIdLivreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "selectByIdLivreResponse")
    public JAXBElement<SelectByIdLivreResponse> createSelectByIdLivreResponse(SelectByIdLivreResponse value) {
        return new JAXBElement<SelectByIdLivreResponse>(_SelectByIdLivreResponse_QNAME, SelectByIdLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "annulerReservationResponse")
    public JAXBElement<AnnulerReservationResponse> createAnnulerReservationResponse(AnnulerReservationResponse value) {
        return new JAXBElement<AnnulerReservationResponse>(_AnnulerReservationResponse_QNAME, AnnulerReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByIdUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "selectByIdUserResponse")
    public JAXBElement<SelectByIdUserResponse> createSelectByIdUserResponse(SelectByIdUserResponse value) {
        return new JAXBElement<SelectByIdUserResponse>(_SelectByIdUserResponse_QNAME, SelectByIdUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reserver }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "reserver")
    public JAXBElement<Reserver> createReserver(Reserver value) {
        return new JAXBElement<Reserver>(_Reserver_QNAME, Reserver.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByIdLivre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "selectByIdLivre")
    public JAXBElement<SelectByIdLivre> createSelectByIdLivre(SelectByIdLivre value) {
        return new JAXBElement<SelectByIdLivre>(_SelectByIdLivre_QNAME, SelectByIdLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByIdUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "selectByIdUser")
    public JAXBElement<SelectByIdUser> createSelectByIdUser(SelectByIdUser value) {
        return new JAXBElement<SelectByIdUser>(_SelectByIdUser_QNAME, SelectByIdUser.class, null, value);
    }

}
