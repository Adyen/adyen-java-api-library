package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * Definition: Common amount definition with currency -- Usage: Decimal unsigned amount with currency and amount before conversion.
 *
 * <p>Java class for Amount complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Amount"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="Decimal"&gt;
 *       &lt;attribute name="Currency" type="{}ISOCurrency3A" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Amount", propOrder = {
        "amountValue",
        "currency"
})
public class Amount {

    /**
     * The Value.
     */
    @XmlElement(name = "AmountValue")
    protected BigDecimal amountValue;
    /**
     * The Currency.
     */
    @XmlElement(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the amountValue property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getAmountValue() {
        return amountValue;
    }

    /**
     * Sets the value of the amountValue property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setAmountValue(BigDecimal value) {
        this.amountValue = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
