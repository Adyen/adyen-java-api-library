
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Reconciliation Request message. -- Usage: It conveys Information related to the Reconciliation requested by the Sale System: Type of reconciliation (with or without closure of the reconciliation time period) The Acquirers identification if they are involved and could be selected
 * 
 * <p>Java class for ReconciliationRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReconciliationRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcquirerID" type="{}AcquirerIDType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ReconciliationType" use="required" type="{}ReconciliationTypeTypeCode" />
 *       &lt;attribute name="POIReconciliationID" type="{}POIReconciliationIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReconciliationRequestType", propOrder = {
    "acquirerID"
})
public class ReconciliationRequestType {

    @XmlElement(name = "AcquirerID")
    protected List<String> acquirerID;
    @XmlAttribute(name = "ReconciliationType", required = true)
    protected String reconciliationType;
    @XmlAttribute(name = "POIReconciliationID")
    protected String poiReconciliationID;

    /**
     * Gets the value of the acquirerID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acquirerID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcquirerID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAcquirerID() {
        if (acquirerID == null) {
            acquirerID = new ArrayList<String>();
        }
        return this.acquirerID;
    }

    /**
     * Gets the value of the reconciliationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReconciliationType() {
        return reconciliationType;
    }

    /**
     * Sets the value of the reconciliationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReconciliationType(String value) {
        this.reconciliationType = value;
    }

    /**
     * Gets the value of the poiReconciliationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOIReconciliationID() {
        return poiReconciliationID;
    }

    /**
     * Sets the value of the poiReconciliationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOIReconciliationID(String value) {
        this.poiReconciliationID = value;
    }

}
