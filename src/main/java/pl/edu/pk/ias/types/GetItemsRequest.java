package pl.edu.pk.ias.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getItemsRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="getItemsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="token" type="{http://pk.edu.pl/ias/types}token"/>
 *         &lt;element name="idsList" type="{http://pk.edu.pl/ias/types}itemId" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "getItemsRequest", propOrder = {"token", "idsList"} )
public class GetItemsRequest
{

    @XmlElement( required = true )
    protected String token;
    protected List<ItemId> idsList;

    /**
     * Gets the value of the token property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getToken( ) {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setToken( String value ) {
        this.token = value;
    }

    /**
     * Gets the value of the idsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the idsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getIdsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link ItemId }
     * 
     * 
     */
    public List<ItemId> getIdsList( ) {
        if ( idsList == null ) {
            idsList = new ArrayList<ItemId>();
        }
        return this.idsList;
    }

    public void setIdsList( List<ItemId> idsList ) {
        this.idsList = idsList;
    }

}
