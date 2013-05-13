
package pl.edu.pk.ias.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getItemsPreviewsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getItemsPreviewsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lss" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateFrom" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *         &lt;element name="dateTo" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getItemsPreviewsRequest", propOrder = {
    "token",
    "lss",
    "dateFrom",
    "dateTo"
})
public class GetItemsPreviewsRequest {

    @XmlElement(required = true)
    protected String token;
    @XmlElement(required = true)
    protected String lss;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object dateFrom;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object dateTo;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the lss property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLss() {
        return lss;
    }

    /**
     * Sets the value of the lss property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLss(String value) {
        this.lss = value;
    }

    /**
     * Gets the value of the dateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDateFrom() {
        return dateFrom;
    }

    /**
     * Sets the value of the dateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDateFrom(Object value) {
        this.dateFrom = value;
    }

    /**
     * Gets the value of the dateTo property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDateTo() {
        return dateTo;
    }

    /**
     * Sets the value of the dateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDateTo(Object value) {
        this.dateTo = value;
    }

}
