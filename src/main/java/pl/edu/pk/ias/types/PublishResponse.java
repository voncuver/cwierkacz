
package pl.edu.pk.ias.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for publishResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="publishResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://pk.edu.pl/ias/types}itemId"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publishResponse", propOrder = {
    "id"
})
public class PublishResponse {

    @XmlElement(required = true)
    protected ItemId id;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link ItemId }
     *     
     */
    public ItemId getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemId }
     *     
     */
    public void setId(ItemId value) {
        this.id = value;
    }

}
