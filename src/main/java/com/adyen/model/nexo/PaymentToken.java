package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Definition: Surrogate of the PAN (Primary Account Number) of the payment card to identify the payment mean of the customer. -- Usage: It allows, for a merchant, to identify the customer.
 *
 * <p>Java class for PaymentToken complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaymentToken"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="TokenRequested" use="required" type="{}TokenRequestedType" /&gt;
 *       &lt;attribute name="TokenValue" use="required" type="{}TokenValue" /&gt;
 *       &lt;attribute name="ExpiryDateTime" type="{}ExpiryDateTime" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentToken")
public class PaymentToken {

    /**
     * The Token requested.
     */
    @XmlElement(name = "TokenRequestedType", required = true)
    @Schema(description = "Type of token replacing the PAN of a payment card to identify the payment mean of the customer.")
    protected TokenRequestedType tokenRequestedType;
    /**
     * The Token value.
     */
    @XmlElement(name = "TokenValue", required = true)
    @Schema(description = "Payment token replacing the PAN of the payment card to identify the payment mean of the customer.")
    protected String tokenValue;
    /**
     * The Expiry date time.
     */
    @XmlElement(name = "ExpiryDateTime")
    @Schema(description = "Expiry date and time.")
    protected XMLGregorianCalendar expiryDateTime;

    /**
     * Gets the value of the tokenRequestedType property.
     *
     * @return possible      object is     {@link TokenRequestedType }
     */
    public TokenRequestedType getTokenRequestedType() {
        return tokenRequestedType;
    }

    /**
     * Sets the value of the tokenRequestedType property.
     *
     * @param value allowed object is     {@link TokenRequestedType }
     */
    public void setTokenRequestedType(TokenRequestedType value) {
        this.tokenRequestedType = value;
    }

    /**
     * Gets the value of the tokenValue property.
     *
     * @return possible      object is     {@link String }
     */
    public String getTokenValue() {
        return tokenValue;
    }

    /**
     * Sets the value of the tokenValue property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setTokenValue(String value) {
        this.tokenValue = value;
    }

    /**
     * Gets the value of the expiryDateTime property.
     *
     * @return possible      object is     {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getExpiryDateTime() {
        return expiryDateTime;
    }

    /**
     * Sets the value of the expiryDateTime property.
     *
     * @param value allowed object is     {@link XMLGregorianCalendar }
     */
    public void setExpiryDateTime(XMLGregorianCalendar value) {
        this.expiryDateTime = value;
    }

}
