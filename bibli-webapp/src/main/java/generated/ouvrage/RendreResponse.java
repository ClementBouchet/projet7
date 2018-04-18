
package generated.ouvrage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour rendreResponse complex type.
 * 
 * <p>Le fragment de schma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="rendreResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rendreResponse", propOrder = {
    "_return"
})
public class RendreResponse {

    @XmlElement(name = "return")
    protected int _return;

    /**
     * Obtient la valeur de la proprit return.
     * 
     */
    public int getReturn() {
        return _return;
    }

    /**
     * Dfinit la valeur de la proprit return.
     * 
     */
    public void setReturn(int value) {
        this._return = value;
    }

}
