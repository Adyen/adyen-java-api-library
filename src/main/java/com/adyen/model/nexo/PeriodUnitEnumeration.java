
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeriodUnitEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PeriodUnitEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Daily"/>
 *     &lt;enumeration value="Weekly"/>
 *     &lt;enumeration value="Monthly"/>
 *     &lt;enumeration value="Annual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PeriodUnitEnumeration")
@XmlEnum
public enum PeriodUnitEnumeration {


    /**
     * The day is the unit of the period.
     * 
     */
    @XmlEnumValue("Daily")
    DAILY("Daily"),

    /**
     * The week is the unit of the period.
     * 
     */
    @XmlEnumValue("Weekly")
    WEEKLY("Weekly"),

    /**
     * The month is the unit of the period.
     * 
     */
    @XmlEnumValue("Monthly")
    MONTHLY("Monthly"),

    /**
     * The year is the unit of the period.
     * 
     */
    @XmlEnumValue("Annual")
    ANNUAL("Annual");
    private final String value;

    PeriodUnitEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PeriodUnitEnumeration fromValue(String v) {
        for (PeriodUnitEnumeration c: PeriodUnitEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
