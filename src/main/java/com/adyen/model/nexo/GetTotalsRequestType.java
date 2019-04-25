
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Get Totals Request message. -- Usage: It conveys information from the Sale System related to the scope and the format of the totals to be computed by the POI System.
 * 
 * <p>Java class for GetTotalsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTotalsRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalDetails" type="{}TotalDetailsType" minOccurs="0"/>
 *         &lt;element name="TotalFilter" type="{}TotalFilterType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTotalsRequestType", propOrder = {
    "totalDetails",
    "totalFilter"
})
public class GetTotalsRequestType {

    @XmlList
    @XmlElement(name = "TotalDetails")
    protected List<String> totalDetails;
    @XmlElement(name = "TotalFilter")
    protected TotalFilterType totalFilter;

    /**
     * Gets the value of the totalDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTotalDetails() {
        if (totalDetails == null) {
            totalDetails = new ArrayList<String>();
        }
        return this.totalDetails;
    }

    /**
     * Gets the value of the totalFilter property.
     * 
     * @return
     *     possible object is
     *     {@link TotalFilterType }
     *     
     */
    public TotalFilterType getTotalFilter() {
        return totalFilter;
    }

    /**
     * Sets the value of the totalFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalFilterType }
     *     
     */
    public void setTotalFilter(TotalFilterType value) {
        this.totalFilter = value;
    }

}
