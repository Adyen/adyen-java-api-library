
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 * &lt;complexType name="PaymentToken">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="TokenRequested" use="required" type="{}TokenRequestedType" />
 *       &lt;attribute name="TokenValue" use="required" type="{}TokenValue" />
 *       &lt;attribute name="ExpiryDateTime" type="{}ExpiryDateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentToken")
public class PaymentToken {

    @XmlAttribute(name = "TokenRequested", required = true)
    protected TokenRequestedType tokenRequested;
    @XmlAttribute(name = "TokenValue", required = true)
    protected String tokenValue;
    @XmlAttribute(name = "ExpiryDateTime")
    protected XMLGregorianCalendar expiryDateTime;

    /**
     * Gets the value of the tokenRequested property.
     *
     * @return
     *     possible object is
     *     {@link TokenRequestedType }
     *
     */
    public TokenRequestedType getTokenRequested() {
        return tokenRequested;
    }

    /**
     * Sets the value of the tokenRequested property.
     *
     * @param value
     *     allowed object is
     *     {@link TokenRequestedType }
     *
     */
    public void setTokenRequested(TokenRequestedType value) {
        this.tokenRequested = value;
    }

    /**
     * Gets the value of the tokenValue property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTokenValue() {
        return tokenValue;
    }

    /**
     * Sets the value of the tokenValue property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTokenValue(String value) {
        this.tokenValue = value;
    }

    /**
     * Gets the value of the expiryDateTime property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getExpiryDateTime() {
        return expiryDateTime;
    }

    /**
     * Sets the value of the expiryDateTime property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setExpiryDateTime(XMLGregorianCalendar value) {
        this.expiryDateTime = value;
    }

}
