
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the payment and loyalty transaction. -- Usage: Elements requested by the Sale System that are global to the payment or loyalty transaction.
 * 
 * <p>Java class for PaymentTransactionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentTransactionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmountsReq" type="{}AmountsReqType"/>
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransactionType" minOccurs="0"/>
 *         &lt;element name="TransactionConditions" type="{}TransactionConditionsType" minOccurs="0"/>
 *         &lt;element name="SaleItem" type="{}SaleItemType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransactionType", propOrder = {
    "amountsReq",
    "originalPOITransaction",
    "transactionConditions",
    "saleItem"
})
public class PaymentTransactionType {

    @XmlElement(name = "AmountsReq", required = true)
    protected AmountsReqType amountsReq;
    @XmlElement(name = "OriginalPOITransaction")
    protected OriginalPOITransactionType originalPOITransaction;
    @XmlElement(name = "TransactionConditions")
    protected TransactionConditionsType transactionConditions;
    @XmlElement(name = "SaleItem")
    protected List<SaleItemType> saleItem;

    /**
     * Gets the value of the amountsReq property.
     * 
     * @return
     *     possible object is
     *     {@link AmountsReqType }
     *     
     */
    public AmountsReqType getAmountsReq() {
        return amountsReq;
    }

    /**
     * Sets the value of the amountsReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountsReqType }
     *     
     */
    public void setAmountsReq(AmountsReqType value) {
        this.amountsReq = value;
    }

    /**
     * Gets the value of the originalPOITransaction property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalPOITransactionType }
     *     
     */
    public OriginalPOITransactionType getOriginalPOITransaction() {
        return originalPOITransaction;
    }

    /**
     * Sets the value of the originalPOITransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalPOITransactionType }
     *     
     */
    public void setOriginalPOITransaction(OriginalPOITransactionType value) {
        this.originalPOITransaction = value;
    }

    /**
     * Gets the value of the transactionConditions property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionConditionsType }
     *     
     */
    public TransactionConditionsType getTransactionConditions() {
        return transactionConditions;
    }

    /**
     * Sets the value of the transactionConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionConditionsType }
     *     
     */
    public void setTransactionConditions(TransactionConditionsType value) {
        this.transactionConditions = value;
    }

    /**
     * Gets the value of the saleItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saleItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSaleItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SaleItemType }
     * 
     * 
     */
    public List<SaleItemType> getSaleItem() {
        if (saleItem == null) {
            saleItem = new ArrayList<SaleItemType>();
        }
        return this.saleItem;
    }

}
