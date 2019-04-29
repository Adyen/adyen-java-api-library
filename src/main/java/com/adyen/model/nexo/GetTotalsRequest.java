
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Get Totals Request messageType. -- Usage: It conveys information from the Sale System related to the scope and the format of the totals to be computed by the POI System.
 *
 * <p>Java class for GetTotalsRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetTotalsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalDetails" type="{}TotalDetails" minOccurs="0"/>
 *         &lt;element name="TotalFilter" type="{}TotalFilter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTotalsRequest", propOrder = {
    "totalDetails",
    "totalFilter"
})
public class GetTotalsRequest {

    @XmlList
    @XmlElement(name = "TotalDetails")
    protected List<TotalDetailsType> totalDetails;
    @XmlElement(name = "TotalFilter")
    protected TotalFilter totalFilter;

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
     * {@link TotalDetailsType }
     *
     *
     */
    public List<TotalDetailsType> getTotalDetails() {
        if (totalDetails == null) {
            totalDetails = new ArrayList<TotalDetailsType>();
        }
        return this.totalDetails;
    }

    /**
     * Gets the value of the totalFilter property.
     *
     * @return
     *     possible object is
     *     {@link TotalFilter }
     *
     */
    public TotalFilter getTotalFilter() {
        return totalFilter;
    }

    /**
     * Sets the value of the totalFilter property.
     *
     * @param value
     *     allowed object is
     *     {@link TotalFilter }
     *
     */
    public void setTotalFilter(TotalFilter value) {
        this.totalFilter = value;
    }

}
