package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Reconciliation Request messageType. -- Usage: It conveys Information related to the Reconciliation requested by the Sale System: Type of reconciliation (with or without closure of the reconciliation time period) The Acquirers identification if they are involved and could be selected
 *
 * <p>Java class for ReconciliationRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ReconciliationRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AcquirerID" type="{}AcquirerID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Reconciliation" use="required" type="{}ReconciliationType" /&gt;
 *       &lt;attribute name="POIReconciliationID" type="{}POIReconciliationID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReconciliationRequest", propOrder = {
        "acquirerID"
})
public class ReconciliationRequest {

    /**
     * The Acquirer id.
     */
    @XmlElement(name = "AcquirerID")
    @Schema(description = "Identification of the Acquirer --Rule: Could be present only if ReconciliationType is \"AcquirerReconciliation\" or \"AcquirerSynchronisation\"")
    protected List<String> acquirerID;
    /**
     * The Reconciliation.
     */
    @XmlElement(name = "ReconciliationType", required = true)
    @Schema(description = "Type of Reconciliation requested by the Sale to the POI.")
    protected ReconciliationType reconciliationType;
    /**
     * The Poi reconciliation id.
     */
    @XmlElement(name = "POIReconciliationID")
    @Schema(description = "Identification of the reconciliation period between Sale and POI.  --Rule: Absent if ReconciliationType is not \"PreviousReconciliation\"")
    protected String poiReconciliationID;

    /**
     * Gets the value of the acquirerID property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acquirerID property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcquirerID().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     * @return the acquirer id
     */
    public List<String> getAcquirerID() {
        if (acquirerID == null) {
            acquirerID = new ArrayList<>();
        }
        return this.acquirerID;
    }

    /**
     * Gets the value of the reconciliationType property.
     *
     * @return possible      object is     {@link ReconciliationType }
     */
    public ReconciliationType getReconciliationType() {
        return reconciliationType;
    }

    /**
     * Sets the value of the reconciliationType property.
     *
     * @param value allowed object is     {@link ReconciliationType }
     */
    public void setReconciliationType(ReconciliationType value) {
        this.reconciliationType = value;
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
