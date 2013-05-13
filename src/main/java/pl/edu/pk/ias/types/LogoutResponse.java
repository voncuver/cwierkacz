
package pl.edu.pk.ias.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for logoutResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="logoutResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isOperationSuccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "logoutResponse", propOrder = {
    "isOperationSuccess"
})
public class LogoutResponse {

    protected boolean isOperationSuccess;

    /**
     * Gets the value of the isOperationSuccess property.
     * 
     */
    public boolean isIsOperationSuccess() {
        return isOperationSuccess;
    }

    /**
     * Sets the value of the isOperationSuccess property.
     * 
     */
    public void setIsOperationSuccess(boolean value) {
        this.isOperationSuccess = value;
    }

}
