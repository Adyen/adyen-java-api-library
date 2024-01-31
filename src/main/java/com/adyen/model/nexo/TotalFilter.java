package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Filter to compute the totals. -- Usage: Used for the Get Totals, to request totals for a (or a combination of) particular value of the POI Terminal, Sale Terminal, Cashier, Shift or TotalsGroupID.
 *
 * <p>Java class for TotalFilter complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TotalFilter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="POIID" type="{}POIID" /&gt;
 *       &lt;attribute name="SaleID" type="{}SaleID" /&gt;
 *       &lt;attribute name="OperatorID" type="{}OperatorID" /&gt;
 *       &lt;attribute name="ShiftNumber" type="{}ShiftNumber" /&gt;
 *       &lt;attribute name="TotalsGroupID" type="{}TotalsGroupID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalFilter")
public class TotalFilter {

    /**
     * The Poiid.
     */
    @XmlElement(name = "POIID")
    @Schema(description = "Identification of a POI System or a POI Terminal for the Sale to POI protocol --Rule: If totals in the response have to be computed only for this particular value of POIID")
    protected String poiid;
    /**
     * The Sale id.
     */
    @XmlElement(name = "SaleID")
    @Schema(description = "Identification of a Sale System or a Sale Terminal for the Sale to POI protocol --Rule: If totals in the response have to be computed only for this particular value of SaleID")
    protected String saleID;
    /**
     * The Operator id.
     */
    @XmlElement(name = "OperatorID")
    @Schema(description = "Identification of the Cashier or Operator. --Rule: If totals in the response have to be computed only for this particular value of OperatorID")
    protected String operatorID;
    /**
     * The Shift number.
     */
    @XmlElement(name = "ShiftNumber")
    @Schema(description = "Shift number. --Rule: If totals in the response have to be computed only for this particular value of ShiftNumber")
    protected String shiftNumber;
    /**
     * The Totals group id.
     */
    @XmlElement(name = "TotalsGroupID")
    @Schema(description = "Identification of a group of transaction on a POI Terminal, having the same Sale features. --Rule: If totals in the response have to be computed only for this particular value of TotalsGroupID", minLength = 1, maxLength = 16)
    protected String totalsGroupID;

    /**
     * Gets the value of the poiid property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPOIID() {
        return poiid;
    }

    /**
     * Sets the value of the poiid property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPOIID(String value) {
        this.poiid = value;
    }

    /**
     * Gets the value of the saleID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getSaleID() {
        return saleID;
    }

    /**
     * Sets the value of the saleID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSaleID(String value) {
        this.saleID = value;
    }

    /**
     * Gets the value of the operatorID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getOperatorID() {
        return operatorID;
    }

    /**
     * Sets the value of the operatorID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setOperatorID(String value) {
        this.operatorID = value;
    }

    /**
     * Gets the value of the shiftNumber property.
     *
     * @return possible      object is     {@link String }
     */
    public String getShiftNumber() {
        return shiftNumber;
    }

    /**
     * Sets the value of the shiftNumber property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setShiftNumber(String value) {
        this.shiftNumber = value;
    }

    /**
     * Gets the value of the totalsGroupID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getTotalsGroupID() {
        return totalsGroupID;
    }

    /**
     * Sets the value of the totalsGroupID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setTotalsGroupID(String value) {
        this.totalsGroupID = value;
    }

}
