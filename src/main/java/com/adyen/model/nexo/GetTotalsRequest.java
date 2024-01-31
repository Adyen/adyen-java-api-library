package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Get Totals Request messageType. -- Usage: It conveys information from the Sale System related to the scope and the format of the totals to be computed by the POI System.
 *
 * <p>Java class for GetTotalsRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetTotalsRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TotalDetails" type="{}TotalDetails" minOccurs="0"/&gt;
 *         &lt;element name="TotalFilter" type="{}TotalFilter" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTotalsRequest", propOrder = {
        "totalDetails",
        "totalFilter"
})
public class GetTotalsRequest {

    /**
     * The Total details.
     */
    @XmlList
    @XmlElement(name = "TotalDetails")
    @Schema(description = "Indicates the hierarchical structure of the reconciliation result of the Sale to POI reconciliation. --Rule: Require to present totals per value of element included in this cluster (POI Terminal, Sale Terminal, Cashier, Shift,")
    protected List<TotalDetailsType> totalDetails;
    /**
     * The Total filter.
     */
    @XmlElement(name = "TotalFilter")
    @Schema(description = "Filter to compute the totals. --Rule: If structure is not empty")
    protected TotalFilter totalFilter;

    /**
     * Gets the value of the totalDetails property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalDetails property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalDetails().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotalDetailsType }
     *
     * @return the total details
     */
    public List<TotalDetailsType> getTotalDetails() {
        if (totalDetails == null) {
            totalDetails = new ArrayList<>();
        }
        return this.totalDetails;
    }

    /**
     * Gets the value of the totalFilter property.
     *
     * @return possible      object is     {@link TotalFilter }
     */
    public TotalFilter getTotalFilter() {
        return totalFilter;
    }

    /**
     * Sets the value of the totalFilter property.
     *
     * @param value allowed object is     {@link TotalFilter }
     */
    public void setTotalFilter(TotalFilter value) {
        this.totalFilter = value;
    }

}
