package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Batch Request messageType. -- Usage: Message to send Payment, Loyalty and Reversal transactions to be performed without the Sale System, or to request the Payment, Loyalty and Reversal transactions that has been performed without the Sale System.
 *
 * <p>Java class for BatchRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BatchRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransactionToPerform" type="{}TransactionToPerform" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="RemoveAllFlag" type="{}RemoveAllFlag" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchRequest", propOrder = {
        "transactionToPerform"
})
public class BatchRequest {

    /**
     * The Transaction to perform.
     */
    @XmlElement(name = "TransactionToPerform")
    protected List<TransactionToPerform> transactionToPerform;
    /**
     * The Remove all flag.
     */
    @XmlAttribute(name = "RemoveAllFlag")
    protected Boolean removeAllFlag;

    /**
     * Gets the value of the transactionToPerform property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionToPerform property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionToPerform().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionToPerform }
     *
     * @return the transaction to perform
     */
    public List<TransactionToPerform> getTransactionToPerform() {
        if (transactionToPerform == null) {
            transactionToPerform = new ArrayList<>();
        }
        return this.transactionToPerform;
    }

    /**
     * Gets the value of the removeAllFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public Boolean isRemoveAllFlag() {
        return removeAllFlag;
    }

    /**
     * Sets the value of the removeAllFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setRemoveAllFlag(Boolean value) {
        this.removeAllFlag = value;
    }

}
