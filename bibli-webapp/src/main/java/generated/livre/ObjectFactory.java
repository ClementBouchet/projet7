
package generated.livre;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.livre package. 
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

    private final static QName _EmprunterLivreResponse_QNAME = new QName("http://service.ocproject.org/", "emprunterLivreResponse");
    private final static QName _EmprunterLivre_QNAME = new QName("http://service.ocproject.org/", "emprunterLivre");
    private final static QName _DetailLivre_QNAME = new QName("http://service.ocproject.org/", "detailLivre");
    private final static QName _DetailLivreResponse_QNAME = new QName("http://service.ocproject.org/", "detailLivreResponse");
    private final static QName _AllBooks_QNAME = new QName("http://service.ocproject.org/", "allBooks");
    private final static QName _AfficherResultatResponse_QNAME = new QName("http://service.ocproject.org/", "afficherResultatResponse");
    private final static QName _AfficherResultat_QNAME = new QName("http://service.ocproject.org/", "afficherResultat");
    private final static QName _AllBooksResponse_QNAME = new QName("http://service.ocproject.org/", "allBooksResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.livre
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DetailLivreResponse }
     * 
     */
    public DetailLivreResponse createDetailLivreResponse() {
        return new DetailLivreResponse();
    }

    /**
     * Create an instance of {@link EmprunterLivreResponse }
     * 
     */
    public EmprunterLivreResponse createEmprunterLivreResponse() {
        return new EmprunterLivreResponse();
    }

    /**
     * Create an instance of {@link DetailLivre }
     * 
     */
    public DetailLivre createDetailLivre() {
        return new DetailLivre();
    }

    /**
     * Create an instance of {@link EmprunterLivre }
     * 
     */
    public EmprunterLivre createEmprunterLivre() {
        return new EmprunterLivre();
    }

    /**
     * Create an instance of {@link AfficherResultat }
     * 
     */
    public AfficherResultat createAfficherResultat() {
        return new AfficherResultat();
    }

    /**
     * Create an instance of {@link AllBooksResponse }
     * 
     */
    public AllBooksResponse createAllBooksResponse() {
        return new AllBooksResponse();
    }

    /**
     * Create an instance of {@link AfficherResultatResponse }
     * 
     */
    public AfficherResultatResponse createAfficherResultatResponse() {
        return new AfficherResultatResponse();
    }

    /**
     * Create an instance of {@link AllBooks }
     * 
     */
    public AllBooks createAllBooks() {
        return new AllBooks();
    }

    /**
     * Create an instance of {@link Livre }
     * 
     */
    public Livre createLivre() {
        return new Livre();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmprunterLivreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "emprunterLivreResponse")
    public JAXBElement<EmprunterLivreResponse> createEmprunterLivreResponse(EmprunterLivreResponse value) {
        return new JAXBElement<EmprunterLivreResponse>(_EmprunterLivreResponse_QNAME, EmprunterLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmprunterLivre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "emprunterLivre")
    public JAXBElement<EmprunterLivre> createEmprunterLivre(EmprunterLivre value) {
        return new JAXBElement<EmprunterLivre>(_EmprunterLivre_QNAME, EmprunterLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetailLivre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "detailLivre")
    public JAXBElement<DetailLivre> createDetailLivre(DetailLivre value) {
        return new JAXBElement<DetailLivre>(_DetailLivre_QNAME, DetailLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetailLivreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "detailLivreResponse")
    public JAXBElement<DetailLivreResponse> createDetailLivreResponse(DetailLivreResponse value) {
        return new JAXBElement<DetailLivreResponse>(_DetailLivreResponse_QNAME, DetailLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "allBooks")
    public JAXBElement<AllBooks> createAllBooks(AllBooks value) {
        return new JAXBElement<AllBooks>(_AllBooks_QNAME, AllBooks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AfficherResultatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "afficherResultatResponse")
    public JAXBElement<AfficherResultatResponse> createAfficherResultatResponse(AfficherResultatResponse value) {
        return new JAXBElement<AfficherResultatResponse>(_AfficherResultatResponse_QNAME, AfficherResultatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AfficherResultat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "afficherResultat")
    public JAXBElement<AfficherResultat> createAfficherResultat(AfficherResultat value) {
        return new JAXBElement<AfficherResultat>(_AfficherResultat_QNAME, AfficherResultat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ocproject.org/", name = "allBooksResponse")
    public JAXBElement<AllBooksResponse> createAllBooksResponse(AllBooksResponse value) {
        return new JAXBElement<AllBooksResponse>(_AllBooksResponse_QNAME, AllBooksResponse.class, null, value);
    }

}
