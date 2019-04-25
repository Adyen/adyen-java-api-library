
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyUnitEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoyaltyUnitEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Point"/>
 *     &lt;enumeration value="Monetary"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LoyaltyUnitEnumeration")
@XmlEnum
public enum LoyaltyUnitEnumeration {


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

    LoyaltyUnitEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoyaltyUnitEnumeration fromValue(String v) {
        for (LoyaltyUnitEnumeration c: LoyaltyUnitEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
