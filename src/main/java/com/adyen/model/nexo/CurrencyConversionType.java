
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Information related to a currency conversion -- Usage: A currency conversion occurred in the payment, and the merchant needs to know information related to this conversion (e.g. to print on the sale receipt)
 * 
 * <p>Java class for CurrencyConversionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrencyConversionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConvertedAmount" type="{}AmountType"/>
 *         &lt;element name="Commission" type="{}SimpleAmountType" minOccurs="0"/>
 *         &lt;element name="Declaration" type="{}DeclarationType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CustomerApprovedFlag" type="{}CustomerApprovedFlagType" default="true" />
 *       &lt;attribute name="Rate" type="{}RateType" />
 *       &lt;attribute name="Markup" type="{}MarkupType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyConversionType", propOrder = {
    "convertedAmount",
    "commission",
    "declaration"
})
public class CurrencyConversionType {

    @XmlElement(name = "ConvertedAmount", required = true)
    protected AmountType convertedAmount;
    @XmlElement(name = "Commission")
    protected BigDecimal commission;
    @XmlElement(name = "Declaration")
    protected String declaration;
    @XmlAttribute(name = "CustomerApprovedFlag")
    protected Boolean customerApprovedFlag;
    @XmlAttribute(name = "Rate")
    protected BigDecimal rate;
    @XmlAttribute(name = "Markup")
    protected BigDecimal markup;

    /**
     * Gets the value of the convertedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getConvertedAmount() {
        return convertedAmount;
    }

    /**
     * Sets the value of the convertedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setConvertedAmount(AmountType value) {
        this.convertedAmount = value;
    }

    /**
     * Gets the value of the commission property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCommission() {
        return commission;
    }

    /**
     * Sets the value of the commission property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCommission(BigDecimal value) {
        this.commission = value;
    }

    /**
     * Gets the value of the declaration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeclaration() {
        return declaration;
    }

    /**
     * Sets the value of the declaration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeclaration(String value) {
        this.declaration = value;
    }

    /**
     * Gets the value of the customerApprovedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCustomerApprovedFlag() {
        if (customerApprovedFlag == null) {
            return true;
        } else {
            return customerApprovedFlag;
        }
    }

    /**
     * Sets the value of the customerApprovedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCustomerApprovedFlag(Boolean value) {
        this.customerApprovedFlag = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRate(BigDecimal value) {
        this.rate = value;
    }

    /**
     * Gets the value of the markup property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMarkup() {
        return markup;
    }

    /**
     * Sets the value of the markup property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMarkup(BigDecimal value) {
        this.markup = value;
    }

}
