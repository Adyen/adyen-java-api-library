package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Reconciliation Response messageType. -- Usage: It conveys Information related to the Reconciliation transaction processed by the POI System
 *
 * <p>Java class for ReconciliationResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ReconciliationResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response" type="{}Response"/&gt;
 *         &lt;element name="TransactionTotals" type="{}TransactionTotals" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Reconciliation" use="required" type="{}ReconciliationType" /&gt;
 *       &lt;attribute name="POIReconciliationID" type="{}POIReconciliationID" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReconciliationResponse", propOrder = {
        "response",
        "transactionTotals"
})
public class ReconciliationResponse {

    /**
     * The Response.
     */
    @XmlElement(name = "Response", required = true)
    protected Response response;
    /**
     * The Transaction totals.
     */
    @XmlElement(name = "TransactionTotals")
    protected List<TransactionTotals> transactionTotals;
    /**
     * The Reconciliation.
     */
    @XmlAttribute(name = "ReconciliationType", required = true)
    protected ReconciliationType reconciliationType;
    /**
     * The Poi reconciliation id.
     */
    @XmlAttribute(name = "POIReconciliationID")
    protected String poiReconciliationID;

    /**
     * Gets the value of the response property.
     *
     * @return possible      object is     {@link Response }
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value allowed object is     {@link Response }
     */
    public void setResponse(Response value) {
        this.response = value;
    }

    /**
     * Gets the value of the transactionTotals property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionTotals property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionTotals().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionTotals }
     *
     * @return the transaction totals
     */
    public List<TransactionTotals> getTransactionTotals() {
        if (transactionTotals == null) {
            transactionTotals = new ArrayList<>();
        }
        return this.transactionTotals;
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
