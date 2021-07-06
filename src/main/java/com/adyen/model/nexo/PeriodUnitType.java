package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for PeriodUnitType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="PeriodUnitType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Daily"/&gt;
 *     &lt;enumeration value="Weekly"/&gt;
 *     &lt;enumeration value="Monthly"/&gt;
 *     &lt;enumeration value="Annual"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "PeriodUnitType")
@XmlEnum
public enum PeriodUnitType {


    /**
     * The day is the unit of the period.
     */
    @XmlEnumValue("Daily")
    @Schema(description = "The day is the unit of the period.")
    DAILY("Daily"),

    /**
     * The week is the unit of the period.
     */
    @XmlEnumValue("Weekly")
    @Schema(description = "The week is the unit of the period.")
    WEEKLY("Weekly"),

    /**
     * The month is the unit of the period.
     */
    @XmlEnumValue("Monthly")
    @Schema(description = "The month is the unit of the period.")
    MONTHLY("Monthly"),

    /**
     * The year is the unit of the period.
     */
    @XmlEnumValue("Annual")
    @Schema(description = "The year is the unit of the period.")
    ANNUAL("Annual");
    private final String value;

    PeriodUnitType(String v) {
        value = v;
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value period unit type.
     *
     * @param v the v
     * @return the period unit type
     */
    public static PeriodUnitType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
