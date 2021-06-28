package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Definition: Content of the Reversal Request messageType. -- Usage: It conveys Information related to the reversal of a previous payment or a loyalty transaction.
 *
 * <p>Java class for ReversalRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ReversalRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OriginalPOITransaction" type="{}OriginalPOITransaction"/&gt;
 *         &lt;element name="CustomerOrderID" type="{}CustomerOrder" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="SaleReferenceID" type="{}SaleReferenceID" /&gt;
 *       &lt;attribute name="ReversalReason" use="required" type="{}ReversalReasonType" /&gt;
 *       &lt;attribute name="ReversedAmount" type="{}SimpleAmountType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReversalRequest", propOrder = {
        "originalPOITransaction",
        "customerOrderID"
})
public class ReversalRequest {

    /**
     * The Original poi transaction.
     */
    @XmlElement(name = "OriginalPOITransaction", required = true)
    @Schema(description = "Identification of a previous POI transaction.")
    protected OriginalPOITransaction originalPOITransaction;
    /**
     * The Customer order id.
     */
    @XmlElement(name = "CustomerOrderID")
    @Schema(description = "If the reversal is performed inside a customer order.")
    protected CustomerOrder customerOrderID;
    /**
     * The Sale reference id.
     */
    @XmlElement(name = "SaleReferenceID")
    @Schema(description = "Identification of a Sale global transaction for a sequence of related POI transactions --Rule: If payment reservation reversal")
    protected String saleReferenceID;
    /**
     * The Reversal reason.
     */
    @XmlElement(name = "ReversalReason", required = true)
    @Schema(description = "Reason of the payment or loyalty reversal..")
    protected ReversalReasonType reversalReason;
    /**
     * The Reversed amount.
     */
    @XmlElement(name = "ReversedAmount")
    @Schema(description = "Amount of the payment or loyalty to reverse.. --Rule: ReversedAmount is implicitely the AuthorizedAmount if absent.")
    protected BigDecimal reversedAmount;
    /**
     * The Sale data.
     */
    @XmlElement(name = "SaleData")
    protected SaleData saleData;

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
     * Gets the value of the customerOrderID property.
     *
     * @return possible      object is     {@link CustomerOrder }
     */
    public CustomerOrder getCustomerOrderID() {
        return customerOrderID;
    }

    /**
     * Sets the value of the customerOrderID property.
     *
     * @param value allowed object is     {@link CustomerOrder }
     */
    public void setCustomerOrderID(CustomerOrder value) {
        this.customerOrderID = value;
    }

    /**
     * Gets the value of the saleReferenceID property.
     *
     * @return possible      object is     {@link String }
     */
    public String getSaleReferenceID() {
        return saleReferenceID;
    }

    /**
     * Sets the value of the saleReferenceID property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setSaleReferenceID(String value) {
        this.saleReferenceID = value;
    }

    /**
     * Gets the value of the reversalReason property.
     *
     * @return possible      object is     {@link ReversalReasonType }
     */
    public ReversalReasonType getReversalReason() {
        return reversalReason;
    }

    /**
     * Sets the value of the reversalReason property.
     *
     * @param value allowed object is     {@link ReversalReasonType }
     */
    public void setReversalReason(ReversalReasonType value) {
        this.reversalReason = value;
    }

    /**
     * Gets the value of the reversedAmount property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getReversedAmount() {
        return reversedAmount;
    }

    /**
     * Sets the value of the reversedAmount property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setReversedAmount(BigDecimal value) {
        this.reversedAmount = value;
    }

    /**
     * Gets the value of the saleData property.
     *
     * @return possible      object is     {@link SaleData }
     */
    public SaleData getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     *
     * @param value allowed object is     {@link SaleData }
     */
    public void setSaleData(SaleData value) {
        this.saleData = value;
    }
}
