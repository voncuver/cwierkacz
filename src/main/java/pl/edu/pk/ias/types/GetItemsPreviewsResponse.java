
package pl.edu.pk.ias.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getItemsPreviewsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getItemsPreviewsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemPreviewsList" type="{http://pk.edu.pl/ias/types}itemPreview" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getItemsPreviewsResponse", propOrder = {
    "itemPreviewsList"
})
public class GetItemsPreviewsResponse {

    protected List<ItemPreview> itemPreviewsList;

    /**
     * Gets the value of the itemPreviewsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemPreviewsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemPreviewsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemPreview }
     * 
     * 
     */
    public List<ItemPreview> getItemPreviewsList() {
        if (itemPreviewsList == null) {
            itemPreviewsList = new ArrayList<ItemPreview>();
        }
        return this.itemPreviewsList;
    }

}
