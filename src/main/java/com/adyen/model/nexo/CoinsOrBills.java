package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Definition: Number of coins or bills of a given value. -- Usage: Indicates the remaining number of coins or bills of a given value in a cash handling device. When the cash handling machine does not have any more coins or bills of a certain value, the number must be equal to 0.
 *
 * <p>Java class for CoinsOrBills complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CoinsOrBills"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="UnitValue" use="required" type="{}SimpleAmountType" /&gt;
 *       &lt;attribute name="Number" use="required" type="{}Number" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoinsOrBills")
public class CoinsOrBills {

    /**
     * The Unit value.
     */
    @XmlElement(name = "UnitValue", required = true)
    @Schema(description = "Value of a coin or bill.")
    protected BigDecimal unitValue;
    /**
     * The Number.
     */
    @XmlElement(name = "Number", required = true)
    @Schema(description = "Number of elements")
    protected BigInteger number;

    /**
     * Gets the value of the unitValue property.
     *
     * @return possible      object is     {@link BigDecimal }
     */
    public BigDecimal getUnitValue() {
        return unitValue;
    }

    /**
     * Sets the value of the unitValue property.
     *
     * @param value allowed object is     {@link BigDecimal }
     */
    public void setUnitValue(BigDecimal value) {
        this.unitValue = value;
    }

    /**
     * Gets the value of the number property.
     *
     * @return possible      object is     {@link BigInteger }
     */
    public BigInteger getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     *
     * @param value allowed object is     {@link BigInteger }
     */
    public void setNumber(BigInteger value) {
        this.number = value;
    }

}
