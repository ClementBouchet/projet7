
package generated.ouvrage;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OuvrageManagerImpl", targetNamespace = "http://service.ocproject.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OuvrageManagerImpl {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "prolonger", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.Prolonger")
    @ResponseWrapper(localName = "prolongerResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.ProlongerResponse")
    @Action(input = "http://service.ocproject.org/OuvrageManagerImpl/prolongerRequest", output = "http://service.ocproject.org/OuvrageManagerImpl/prolongerResponse")
    public String prolonger(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns generated.ouvrage.Ouvrage
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "emprunterOuvrage", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.EmprunterOuvrage")
    @ResponseWrapper(localName = "emprunterOuvrageResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.EmprunterOuvrageResponse")
    @Action(input = "http://service.ocproject.org/OuvrageManagerImpl/emprunterOuvrageRequest", output = "http://service.ocproject.org/OuvrageManagerImpl/emprunterOuvrageResponse")
    public Ouvrage emprunterOuvrage(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "rendre", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.Rendre")
    @ResponseWrapper(localName = "rendreResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.RendreResponse")
    @Action(input = "http://service.ocproject.org/OuvrageManagerImpl/rendreRequest", output = "http://service.ocproject.org/OuvrageManagerImpl/rendreResponse")
    public int rendre(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns generated.ouvrage.Ouvrage
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readInfoUser", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.ReadInfoUser")
    @ResponseWrapper(localName = "readInfoUserResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.ReadInfoUserResponse")
    @Action(input = "http://service.ocproject.org/OuvrageManagerImpl/readInfoUserRequest", output = "http://service.ocproject.org/OuvrageManagerImpl/readInfoUserResponse")
    public Ouvrage readInfoUser(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns generated.ouvrage.Ouvrage
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readInfoLivre", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.ReadInfoLivre")
    @ResponseWrapper(localName = "readInfoLivreResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.ReadInfoLivreResponse")
    @Action(input = "http://service.ocproject.org/OuvrageManagerImpl/readInfoLivreRequest", output = "http://service.ocproject.org/OuvrageManagerImpl/readInfoLivreResponse")
    public Ouvrage readInfoLivre(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<generated.ouvrage.Ouvrage>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkEmprunts", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.CheckEmprunts")
    @ResponseWrapper(localName = "checkEmpruntsResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.ouvrage.CheckEmpruntsResponse")
    @Action(input = "http://service.ocproject.org/OuvrageManagerImpl/checkEmpruntsRequest", output = "http://service.ocproject.org/OuvrageManagerImpl/checkEmpruntsResponse")
    public List<Ouvrage> checkEmprunts();

}
