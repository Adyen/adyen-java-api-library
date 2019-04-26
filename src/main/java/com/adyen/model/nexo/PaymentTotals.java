
package com.adyen.model.nexo;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Totals of the payment transaction during the reconciliation period.
 *
 * <p>Java class for PaymentTotals complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentTotals">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Transaction" use="required" type="{}TransactionType" />
 *       &lt;attribute name="TransactionCount" use="required" type="{}TransactionCount" />
 *       &lt;attribute name="TransactionAmount" use="required" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTotals")
public class PaymentTotals {

    @XmlAttribute(name = "Transaction", required = true)
    protected TransactionType transaction;
    @XmlAttribute(name = "TransactionCount", required = true)
    protected BigInteger transactionCount;
    @XmlAttribute(name = "TransactionAmount", required = true)
    protected BigDecimal transactionAmount;

    /**
     * Gets the value of the transaction property.
     *
     * @return
     *     possible object is
     *     {@link TransactionType }
     *
     */
    public TransactionType getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     *
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *
     */
    public void setTransaction(TransactionType value) {
        this.transaction = value;
    }

    /**
     * Gets the value of the transactionCount property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getTransactionCount() {
        return transactionCount;
    }

    /**
     * Sets the value of the transactionCount property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setTransactionCount(BigInteger value) {
        this.transactionCount = value;
    }

    /**
     * Gets the value of the transactionAmount property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setTransactionAmount(BigDecimal value) {
        this.transactionAmount = value;
    }

}
