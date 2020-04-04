package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Data related to the payment and loyalty transaction. -- Usage: Elements requested by the Sale System that are global to the payment or loyalty transaction.
 *
 * <p>Java class for PaymentTransaction complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentTransaction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AmountsReq" type="{}AmountsReq"/&gt;
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransaction" minOccurs="0"/&gt;
 *         &lt;element name="TransactionConditions" type="{}TransactionConditions" minOccurs="0"/&gt;
 *         &lt;element name="SaleItem" type="{}SaleItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransaction", propOrder = {
        "amountsReq",
        "originalPOITransaction",
        "transactionConditions",
        "saleItem"
})
public class PaymentTransaction {

    /**
     * The Amounts req.
     */
    @XmlElement(name = "AmountsReq", required = true)
    protected AmountsReq amountsReq;
    /**
     * The Original poi transaction.
     */
    @XmlElement(name = "OriginalPOITransaction")
    protected OriginalPOITransaction originalPOITransaction;
    /**
     * The Transaction conditions.
     */
    @XmlElement(name = "TransactionConditions")
    protected TransactionConditions transactionConditions;
    /**
     * The Sale item.
     */
    @XmlElement(name = "SaleItem")
    protected List<SaleItem> saleItem;

    /**
     * Gets the value of the amountsReq property.
     *
     * @return possible      object is     {@link AmountsReq }
     */
    public AmountsReq getAmountsReq() {
        return amountsReq;
    }

    /**
     * Sets the value of the amountsReq property.
     *
     * @param value allowed object is     {@link AmountsReq }
     */
    public void setAmountsReq(AmountsReq value) {
        this.amountsReq = value;
    }

    /**
     * Gets the value of the originalPOITransaction property.
     *
     * @return possible      object is     {@link OriginalPOITransaction }
     */
    public OriginalPOITransaction getOriginalPOITransaction() {
        return originalPOITransaction;
    }

    /**
     * Sets the value of the originalPOITransaction property.
     *
     * @param value allowed object is     {@link OriginalPOITransaction }
     */
    public void setOriginalPOITransaction(OriginalPOITransaction value) {
        this.originalPOITransaction = value;
    }

    /**
     * Gets the value of the transactionConditions property.
     *
     * @return possible      object is     {@link TransactionConditions }
     */
    public TransactionConditions getTransactionConditions() {
        return transactionConditions;
    }

    /**
     * Sets the value of the transactionConditions property.
     *
     * @param value allowed object is     {@link TransactionConditions }
     */
    public void setTransactionConditions(TransactionConditions value) {
        this.transactionConditions = value;
    }

    /**
     * Gets the value of the saleItem property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saleItem property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSaleItem().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link SaleItem }
     *
     * @return the sale item
     */
    public List<SaleItem> getSaleItem() {
        if (saleItem == null) {
            saleItem = new ArrayList<>();
        }
        return this.saleItem;
    }

}
