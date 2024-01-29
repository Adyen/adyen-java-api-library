package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the payment transaction. -- Usage: Elements requested by the Sale System that are related to the payment only.
 *
 * <p>Java class for PaymentData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CardAcquisitionReference" type="{}TransactionIdentification" minOccurs="0"/&gt;
 *         &lt;element name="RequestedValidityDate" type="{}ISODate" minOccurs="0"/&gt;
 *         &lt;element name="Instalment" type="{}Instalment" minOccurs="0"/&gt;
 *         &lt;element name="CustomerOrder" type="{}CustomerOrder" minOccurs="0"/&gt;
 *         &lt;element name="PaymentInstrumentData" type="{}PaymentInstrumentData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Payment" type="{}PaymentType" default="Normal" /&gt;
 *       &lt;attribute name="SplitPaymentFlag" type="{}SplitPaymentFlag" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentData", propOrder = {
        "cardAcquisitionReference",
        "requestedValidityDate",
        "instalment",
        "customerOrder",
        "paymentInstrumentData"
})
public class PaymentData {

    /**
     * The Card acquisition reference.
     */
    @XmlElement(name = "CardAcquisitionReference")
    @Schema(description = "Reference to the last CardAcquisition, to use the same card. --Rule: if the card data comes from a previous CardAcquisition")
    protected TransactionIdentification cardAcquisitionReference;
    /**
     * The Requested validity date.
     */
    @XmlElement(name = "RequestedValidityDate")
    @Schema(description = "Requested validity date for the reservation. --Rule: If time period of the OneTimeReservation, FirstReservation or UpdateReservation is requested")
    protected String requestedValidityDate;
    /**
     * The Instalment.
     */
    @XmlElement(name = "Instalment")
    @Schema(description = "Information related an instalment transaction. --Rule: If PaymentType is \"Instalment\" or \"IssuerInstalment\"")
    protected Instalment instalment;
    /**
     * The Customer order.
     */
    @XmlElement(name = "CustomerOrder")
    @Schema(description = "Customer order attached to a card, recorded in the POI system. --Rule: If a customer orders has to be created.")
    protected CustomerOrder customerOrder;
    /**
     * The Payment instrument data.
     */
    @XmlElement(name = "PaymentInstrumentData")
    @Schema(description = "Data related to the instrument of payment for the transaction. --Rule: If payment instrument data are read by the Sale System")
    protected PaymentInstrumentData paymentInstrumentData;
    /**
     * The Payment.
     */
    @XmlElement(name = "PaymentType")
    @Schema(description = "Type of payment transaction.")
    protected PaymentType paymentType;
    /**
     * The Split payment flag.
     */
    @XmlElement(name = "SplitPaymentFlag")
    @Schema(description = "Indicates if the payment of the Sale transaction is split.")
    protected Boolean splitPaymentFlag;

    /**
     * Gets the value of the cardAcquisitionReference property.
     *
     * @return possible      object is     {@link TransactionIdentification }
     */
    public TransactionIdentification getCardAcquisitionReference() {
        return cardAcquisitionReference;
    }

    /**
     * Sets the value of the cardAcquisitionReference property.
     *
     * @param value allowed object is     {@link TransactionIdentification }
     */
    public void setCardAcquisitionReference(TransactionIdentification value) {
        this.cardAcquisitionReference = value;
    }

    /**
     * Gets the value of the requestedValidityDate property.
     *
     * @return possible      object is     {@link String }
     */
    public String getRequestedValidityDate() {
        return requestedValidityDate;
    }

    /**
     * Sets the value of the requestedValidityDate property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setRequestedValidityDate(String value) {
        this.requestedValidityDate = value;
    }

    /**
     * Gets the value of the instalment property.
     *
     * @return possible      object is     {@link Instalment }
     */
    public Instalment getInstalment() {
        return instalment;
    }

    /**
     * Sets the value of the instalment property.
     *
     * @param value allowed object is     {@link Instalment }
     */
    public void setInstalment(Instalment value) {
        this.instalment = value;
    }

    /**
     * Gets the value of the customerOrder property.
     *
     * @return possible      object is     {@link CustomerOrder }
     */
    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    /**
     * Sets the value of the customerOrder property.
     *
     * @param value allowed object is     {@link CustomerOrder }
     */
    public void setCustomerOrder(CustomerOrder value) {
        this.customerOrder = value;
    }

    /**
     * Gets the value of the paymentInstrumentData property.
     *
     * @return possible      object is     {@link PaymentInstrumentData }
     */
    public PaymentInstrumentData getPaymentInstrumentData() {
        return paymentInstrumentData;
    }

    /**
     * Sets the value of the paymentInstrumentData property.
     *
     * @param value allowed object is     {@link PaymentInstrumentData }
     */
    public void setPaymentInstrumentData(PaymentInstrumentData value) {
        this.paymentInstrumentData = value;
    }

    /**
     * Gets the value of the PaymentType property.
     *
     * @return possible      object is     {@link PaymentType }
     */
    public PaymentType getPaymentType() {
        if (paymentType == null) {
            return PaymentType.NORMAL;
        } else {
            return paymentType;
        }
    }

    /**
     * Sets the value of the PaymentType property.
     *
     * @param value allowed object is     {@link PaymentType }
     */
    public void setPaymentType(PaymentType value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the splitPaymentFlag property.
     *
     * @return possible      object is     {@link Boolean }
     */
    public boolean isSplitPaymentFlag() {
        if (splitPaymentFlag == null) {
            return false;
        } else {
            return splitPaymentFlag;
        }
    }

    /**
     * Sets the value of the splitPaymentFlag property.
     *
     * @param value allowed object is     {@link Boolean }
     */
    public void setSplitPaymentFlag(Boolean value) {
        this.splitPaymentFlag = value;
    }

}
