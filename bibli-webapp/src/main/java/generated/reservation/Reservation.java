
package generated.reservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour reservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateDispo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateRetourPrevu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idLivre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idUser" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ordre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
    "dateDispo",
    "dateRetourPrevu",
    "id",
    "idLivre",
    "idUser",
    "ordre"
})
public class Reservation {

    protected String dateDispo;
    protected String dateRetourPrevu;
    protected int id;
    protected int idLivre;
    protected int idUser;
    protected int ordre;

    /**
     * Obtient la valeur de la propriété dateDispo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateDispo() {
        return dateDispo;
    }

    /**
     * Définit la valeur de la propriété dateDispo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateDispo(String value) {
        this.dateDispo = value;
    }

    /**
     * Obtient la valeur de la propriété dateRetourPrevu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    /**
     * Définit la valeur de la propriété dateRetourPrevu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateRetourPrevu(String value) {
        this.dateRetourPrevu = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété idLivre.
     * 
     */
    public int getIdLivre() {
        return idLivre;
    }

    /**
     * Définit la valeur de la propriété idLivre.
     * 
     */
    public void setIdLivre(int value) {
        this.idLivre = value;
    }

    /**
     * Obtient la valeur de la propriété idUser.
     * 
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Définit la valeur de la propriété idUser.
     * 
     */
    public void setIdUser(int value) {
        this.idUser = value;
    }

    /**
     * Obtient la valeur de la propriété ordre.
     * 
     */
    public int getOrdre() {
        return ordre;
    }

    /**
     * Définit la valeur de la propriété ordre.
     * 
     */
    public void setOrdre(int value) {
        this.ordre = value;
    }

}
