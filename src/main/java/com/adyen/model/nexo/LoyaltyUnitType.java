
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyUnitType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoyaltyUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Point"/>
 *     &lt;enumeration value="Monetary"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "LoyaltyUnitType")
@XmlEnum
public enum LoyaltyUnitType {


    /**
     * The amount is expressed in point.
     *
     */
    @XmlEnumValue("Point")
    POINT("Point"),

    /**
     * The amount is expressed in a monetary value in a currency.
     *
     */
    @XmlEnumValue("Monetary")
    MONETARY("Monetary");
    private final String value;

    LoyaltyUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoyaltyUnitType fromValue(String v) {
        for (LoyaltyUnitType c: LoyaltyUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
