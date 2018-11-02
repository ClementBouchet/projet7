
package generated.reservation;

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
@WebService(name = "ReservationManagerImpl", targetNamespace = "http://service.ocproject.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReservationManagerImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<generated.reservation.Reservation>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "selectByIdLivre", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.SelectByIdLivre")
    @ResponseWrapper(localName = "selectByIdLivreResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.SelectByIdLivreResponse")
    @Action(input = "http://service.ocproject.org/ReservationManagerImpl/selectByIdLivreRequest", output = "http://service.ocproject.org/ReservationManagerImpl/selectByIdLivreResponse")
    public List<Reservation> selectByIdLivre(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<generated.reservation.Reservation>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "selectAll", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.SelectAll")
    @ResponseWrapper(localName = "selectAllResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.SelectAllResponse")
    @Action(input = "http://service.ocproject.org/ReservationManagerImpl/selectAllRequest", output = "http://service.ocproject.org/ReservationManagerImpl/selectAllResponse")
    public List<Reservation> selectAll();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<generated.reservation.Reservation>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "selectByIdUser", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.SelectByIdUser")
    @ResponseWrapper(localName = "selectByIdUserResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.SelectByIdUserResponse")
    @Action(input = "http://service.ocproject.org/ReservationManagerImpl/selectByIdUserRequest", output = "http://service.ocproject.org/ReservationManagerImpl/selectByIdUserResponse")
    public List<Reservation> selectByIdUser(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "reserver", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.Reserver")
    @ResponseWrapper(localName = "reserverResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.ReserverResponse")
    @Action(input = "http://service.ocproject.org/ReservationManagerImpl/reserverRequest", output = "http://service.ocproject.org/ReservationManagerImpl/reserverResponse")
    public void reserver(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "manageCurrentDate", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.ManageCurrentDate")
    @ResponseWrapper(localName = "manageCurrentDateResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.ManageCurrentDateResponse")
    @Action(input = "http://service.ocproject.org/ReservationManagerImpl/manageCurrentDateRequest", output = "http://service.ocproject.org/ReservationManagerImpl/manageCurrentDateResponse")
    public void manageCurrentDate(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "annulerReservation", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.AnnulerReservation")
    @ResponseWrapper(localName = "annulerReservationResponse", targetNamespace = "http://service.ocproject.org/", className = "generated.reservation.AnnulerReservationResponse")
    @Action(input = "http://service.ocproject.org/ReservationManagerImpl/annulerReservationRequest", output = "http://service.ocproject.org/ReservationManagerImpl/annulerReservationResponse")
    public void annulerReservation(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}