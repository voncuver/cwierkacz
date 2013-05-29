
package pl.edu.pk.ias.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for publishRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="publishRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="token" type="{http://pk.edu.pl/ias/types}token"/>
 *         &lt;element name="lss" type="{http://pk.edu.pl/ias/types}lss"/>
 *         &lt;element name="file" type="{http://pk.edu.pl/ias/types}file"/>
 *         &lt;element name="filename" type="{http://pk.edu.pl/ias/types}filename"/>
 *         &lt;element name="message" type="{http://pk.edu.pl/ias/types}message"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publishRequest", propOrder = {
    "token",
    "lss",
    "file",
    "filename",
    "message"
})
public class PublishRequest {

    @XmlElement(required = true)
    protected String token;
    @XmlElement(required = true)
    protected String lss;
    @XmlElement(required = true)
    protected byte[] file;
    @XmlElement(required = true)
    protected String filename;
    @XmlElement(required = true)
    protected String message;

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
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFile(byte[] value) {
        this.file = value;
    }

    /**
     * Gets the value of the filename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the value of the filename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
