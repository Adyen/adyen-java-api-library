
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Batch Request message. -- Usage: Message to send Payment, Loyalty and Reversal transactions to be performed without the Sale System, or to request the Payment, Loyalty and Reversal transactions that has been performed without the Sale System.
 * 
 * <p>Java class for BatchRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionToPerform" type="{}TransactionToPerformType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RemoveAllFlag" type="{}RemoveAllFlagType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchRequestType", propOrder = {
    "transactionToPerform"
})
public class BatchRequestType {

    @XmlElement(name = "TransactionToPerform")
    protected List<TransactionToPerformType> transactionToPerform;
    @XmlAttribute(name = "RemoveAllFlag")
    protected Boolean removeAllFlag;

    /**
     * Gets the value of the transactionToPerform property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionToPerform property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionToPerform().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionToPerformType }
     * 
     * 
     */
    public List<TransactionToPerformType> getTransactionToPerform() {
        if (transactionToPerform == null) {
            transactionToPerform = new ArrayList<TransactionToPerformType>();
        }
        return this.transactionToPerform;
    }

    /**
     * Gets the value of the removeAllFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRemoveAllFlag() {
        return removeAllFlag;
    }

    /**
     * Sets the value of the removeAllFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRemoveAllFlag(Boolean value) {
        this.removeAllFlag = value;
    }

}
