package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the POI System. -- Usage: In the Message Response, identification of the POI transaction.
 *
 * <p>Java class for POIData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="POIData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="POITransactionID" type="{}TransactionIdentification"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="POIReconciliationID" type="{}POIReconciliationID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POIData", propOrder = {
        "poiTransactionID"
})
public class POIData {

    /**
     * The Poi transaction id.
     */
    @XmlElement(name = "POITransactionID", required = true)
    @Schema(description = "Unique identification of a POI transaction for a POI")
    protected TransactionIdentification poiTransactionID;
    /**
     * The Poi reconciliation id.
     */
    @XmlElement(name = "POIReconciliationID")
    @Schema(description = "Identification of the reconciliation period between Sale and POI.  --Rule: If Result is Success")
    protected String poiReconciliationID;

    /**
     * Gets the value of the poiTransactionID property.
     *
     * @return possible      object is     {@link TransactionIdentification }
     */
    public TransactionIdentification getPOITransactionID() {
        return poiTransactionID;
    }

    /**
     * Sets the value of the poiTransactionID property.
     *
     * @param value allowed object is     {@link TransactionIdentification }
     */
    public void setPOITransactionID(TransactionIdentification value) {
        this.poiTransactionID = value;
    }

    /**
     * Gets the value of the poiReconciliationID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getPOIReconciliationID() {
        return poiReconciliationID;
    }

    /**
     * Sets the value of the poiReconciliationID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setPOIReconciliationID(String value) {
        this.poiReconciliationID = value;
    }

}
