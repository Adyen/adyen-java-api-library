package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Data related to the instrument of payment for the transaction. -- Usage: Sent in the result of the payment transaction. For a card, it could also be sent in the CardAcquisition response, to be processed by the Sale System. In this case, the card or type of card has to be configured to have this behaviour. It is
 *
 * <p>Java class for PaymentInstrumentData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentInstrumentData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CardData" type="{}CardData" minOccurs="0"/&gt;
 *         &lt;element name="CheckData" type="{}CheckData" minOccurs="0"/&gt;
 *         &lt;element name="MobileData" type="{}MobileData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PaymentInstrument" use="required" type="{}PaymentInstrumentType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInstrumentData", propOrder = {
        "cardData",
        "checkData",
        "mobileData"
})
public class PaymentInstrumentData {

    /**
     * The Card data.
     */
    @XmlElement(name = "CardData")
    @Schema(description = "Information related to the payment card used for the transaction. --Rule: If PaymentInstrumentType is \"Card\"")
    protected CardData cardData;
    /**
     * The Check data.
     */
    @XmlElement(name = "CheckData")
    @Schema(description = "Information related to the paper check used for the transaction. --Rule: If PaymentInstrumentType is \"Check\"")
    protected CheckData checkData;
    /**
     * The Mobile data.
     */
    @XmlElement(name = "MobileData")
    @Schema(description = "Information related to the mobile for the payment transaction. --Rule: If PaymentInstrumentType is \"Mobile\"")
    protected MobileData mobileData;
    /**
     * The Payment instrument.
     */
    @XmlElement(name = "PaymentInstrumentType", required = true)
    @Schema(description = "Type of payment instrument.")
    protected PaymentInstrumentType paymentInstrumentType;
    /**
     * The Stored value account id.
     */
    @XmlElement(name = "StoredValueAccountID")
    protected StoredValueAccountID storedValueAccountID;
    /**
     * The Protected card data.
     */
    @XmlElement(name = "ProtectedCardData")
    protected String protectedCardData;

    /**
     * Gets the value of the cardData property.
     *
     * @return possible      object is     {@link CardData }
     */
    public CardData getCardData() {
        return cardData;
    }

    /**
     * Sets the value of the cardData property.
     *
     * @param value allowed object is     {@link CardData }
     */
    public void setCardData(CardData value) {
        this.cardData = value;
    }

    /**
     * Gets the value of the checkData property.
     *
     * @return possible      object is     {@link CheckData }
     */
    public CheckData getCheckData() {
        return checkData;
    }

    /**
     * Sets the value of the checkData property.
     *
     * @param value allowed object is     {@link CheckData }
     */
    public void setCheckData(CheckData value) {
        this.checkData = value;
    }

    /**
     * Gets the value of the mobileData property.
     *
     * @return possible      object is     {@link MobileData }
     */
    public MobileData getMobileData() {
        return mobileData;
    }

    /**
     * Sets the value of the mobileData property.
     *
     * @param value allowed object is     {@link MobileData }
     */
    public void setMobileData(MobileData value) {
        this.mobileData = value;
    }

    /**
     * Gets the value of the paymentInstrumentType property.
     *
     * @return possible      object is     {@link PaymentInstrumentType }
     */
    public PaymentInstrumentType getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    /**
     * Sets the value of the paymentInstrumentType property.
     *
     * @param value allowed object is     {@link PaymentInstrumentType }
     */
    public void setPaymentInstrumentType(PaymentInstrumentType value) {
        this.paymentInstrumentType = value;
    }

    /**
     * Gets the value of the storedValueAccountID property.
     *
     * @return possible      object is     {@link StoredValueAccountID }
     */
    public StoredValueAccountID getStoredValueAccountID() {
        return storedValueAccountID;
    }

    /**
     * Sets the value of the storedValueAccountID property.
     *
     * @param value allowed object is     {@link StoredValueAccountID }
     */
    public void setStoredValueAccountID(StoredValueAccountID value) {
        this.storedValueAccountID = value;
    }

    /**
     * Gets the value of the protectedCardData property.
     *
     * @return possible      object is     {@link String }
     */
    public String getProtectedCardData() {
        return protectedCardData;
    }

    /**
     * Sets the value of the protectedCardData property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setProtectedCardData(String value) {
        this.protectedCardData = value;
    }
}
