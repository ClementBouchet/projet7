
package generated.ouvrage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ouvrage complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ouvrage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date_emprunt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date_retour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_emprunteur" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_livre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prolongement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ouvrage", propOrder = {
    "dateEmprunt",
    "dateRetour",
    "id",
    "idEmprunteur",
    "idLivre",
    "prolongement"
})
public class Ouvrage {

    @XmlElement(name = "date_emprunt")
    protected String dateEmprunt;
    @XmlElement(name = "date_retour")
    protected String dateRetour;
    protected int id;
    @XmlElement(name = "id_emprunteur")
    protected int idEmprunteur;
    @XmlElement(name = "id_livre")
    protected int idLivre;
    protected boolean prolongement;

    /**
     * Obtient la valeur de la propriété dateEmprunt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateEmprunt() {
        return dateEmprunt;
    }

    /**
     * Définit la valeur de la propriété dateEmprunt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateEmprunt(String value) {
        this.dateEmprunt = value;
    }

    /**
     * Obtient la valeur de la propriété dateRetour.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateRetour() {
        return dateRetour;
    }

    /**
     * Définit la valeur de la propriété dateRetour.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateRetour(String value) {
        this.dateRetour = value;
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
     * Obtient la valeur de la propriété idEmprunteur.
     * 
     */
    public int getIdEmprunteur() {
        return idEmprunteur;
    }

    /**
     * Définit la valeur de la propriété idEmprunteur.
     * 
     */
    public void setIdEmprunteur(int value) {
        this.idEmprunteur = value;
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
     * Obtient la valeur de la propriété prolongement.
     * 
     */
    public boolean isProlongement() {
        return prolongement;
    }

    /**
     * Définit la valeur de la propriété prolongement.
     * 
     */
    public void setProlongement(boolean value) {
        this.prolongement = value;
    }

}
