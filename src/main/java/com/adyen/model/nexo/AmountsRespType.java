
package com.adyen.model.nexo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Various amounts related to the payment response from the POI System. -- Usage: Amounts approved by the POI and the Acquirer for the payment and loyalty transaction, containing: The authorised amount to be paid The amount of the rebates The amount of financial fees The cash back part of the requested amount for a
 * 
 * <p>Java class for AmountsRespType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmountsRespType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" />
 *       &lt;attribute name="AuthorizedAmount" use="required" type="{}SimpleAmountType" />
 *       &lt;attribute name="TotalRebatesAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="TotalFeesAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="CashBackAmount" type="{}SimpleAmountType" />
 *       &lt;attribute name="TipAmount" type="{}SimpleAmountType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountsRespType")
public class AmountsRespType {

    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "AuthorizedAmount", required = true)
    protected BigDecimal authorizedAmount;
    @XmlAttribute(name = "TotalRebatesAmount")
    protected BigDecimal totalRebatesAmount;
    @XmlAttribute(name = "TotalFeesAmount")
    protected BigDecimal totalFeesAmount;
    @XmlAttribute(name = "CashBackAmount")
    protected BigDecimal cashBackAmount;
    @XmlAttribute(name = "TipAmount")
    protected BigDecimal tipAmount;

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the authorizedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAuthorizedAmount() {
        return authorizedAmount;
    }

    /**
     * Sets the value of the authorizedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAuthorizedAmount(BigDecimal value) {
        this.authorizedAmount = value;
    }

    /**
     * Gets the value of the totalRebatesAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalRebatesAmount() {
        return totalRebatesAmount;
    }

    /**
     * Sets the value of the totalRebatesAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalRebatesAmount(BigDecimal value) {
        this.totalRebatesAmount = value;
    }

    /**
     * Gets the value of the totalFeesAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalFeesAmount() {
        return totalFeesAmount;
    }

    /**
     * Sets the value of the totalFeesAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalFeesAmount(BigDecimal value) {
        this.totalFeesAmount = value;
    }

    /**
     * Gets the value of the cashBackAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCashBackAmount() {
        return cashBackAmount;
    }

    /**
     * Sets the value of the cashBackAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCashBackAmount(BigDecimal value) {
        this.cashBackAmount = value;
    }

    /**
     * Gets the value of the tipAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    /**
     * Sets the value of the tipAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTipAmount(BigDecimal value) {
        this.tipAmount = value;
    }

}
