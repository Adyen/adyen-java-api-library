package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

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
    @Schema(description = "Various amounts related to the payment and loyalty request from the Sale System.")
    protected AmountsReq amountsReq;
    /**
     * The Original poi transaction.
     */
    @XmlElement(name = "OriginalPOITransaction")
    @Schema(description = "Identification of a previous POI transaction. --Rule: if UpdateReservation, Completion or Refund")
    protected OriginalPOITransaction originalPOITransaction;
    /**
     * The Transaction conditions.
     */
    @XmlElement(name = "TransactionConditions")
    @Schema(description = "Conditions on which the transaction must be processed. --Rule: If one data element is present")
    protected TransactionConditions transactionConditions;
    /**
     * The Sale item.
     */
    @XmlElement(name = "SaleItem")
    @Schema(description = "Sale items of a transaction. --Rule: If purchased products are required for the payment")
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
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the saleItem property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSaleItem().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
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
