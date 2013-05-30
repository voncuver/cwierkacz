
package pl.edu.pk.ias.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="token" type="{http://pk.edu.pl/ias/types}token"/>
 *         &lt;element name="lss" type="{http://pk.edu.pl/ias/types}lss"/>
 *         &lt;element name="dateFrom" type="{http://pk.edu.pl/ias/types}dateFrom"/>
 *         &lt;element name="dateTo" type="{http://pk.edu.pl/ias/types}dateTo"/>
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
    protected XMLGregorianCalendar dateFrom;
    @XmlElement(required = true)
    protected XMLGregorianCalendar dateTo;

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
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFrom() {
        return dateFrom;
    }

    /**
     * Sets the value of the dateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFrom(XMLGregorianCalendar value) {
        this.dateFrom = value;
    }

    /**
     * Gets the value of the dateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTo() {
        return dateTo;
    }

    /**
     * Sets the value of the dateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTo(XMLGregorianCalendar value) {
        this.dateTo = value;
    }

}
