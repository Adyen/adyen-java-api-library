
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the POI System. -- Usage: In the Message Response, identification of the POI transaction.
 * 
 * <p>Java class for POIDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="POIDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="POITransactionID" type="{}TransactionIdentificationType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="POIReconciliationID" type="{}POIReconciliationIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POIDataType", propOrder = {
    "poiTransactionID"
})
public class POIDataType {

    @XmlElement(name = "POITransactionID", required = true)
    protected TransactionIdentificationType poiTransactionID;
    @XmlAttribute(name = "POIReconciliationID")
    protected String poiReconciliationID;

    /**
     * Gets the value of the poiTransactionID property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public TransactionIdentificationType getPOITransactionID() {
        return poiTransactionID;
    }

    /**
     * Sets the value of the poiTransactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIdentificationType }
     *     
     */
    public void setPOITransactionID(TransactionIdentificationType value) {
        this.poiTransactionID = value;
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
