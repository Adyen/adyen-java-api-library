package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for GlobalStatusType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="GlobalStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="Busy"/&gt;
 *     &lt;enumeration value="Maintenance"/&gt;
 *     &lt;enumeration value="Unreachable"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "GlobalStatusType")
@XmlEnum
public enum GlobalStatusType {


    /**
     * The POI is ready to receive and process a request
     */
    OK("OK"),

    /**
     * The POI Terminal cannot process a request because another processing is in progress.
     */
    @XmlEnumValue("Busy")
    @Schema(description = "The POI Terminal cannot process a request because another processing is in progress.")
    BUSY("Busy"),

    /**
     * The POI is in maintenance processing
     */
    @XmlEnumValue("Maintenance")
    @Schema(description = "The POI is in maintenance processing")
    MAINTENANCE("Maintenance"),

    /**
     * The POI is unreachable or not responding
     */
    @XmlEnumValue("Unreachable")
    @Schema(description = "The POI is unreachable or not responding")
    UNREACHABLE("Unreachable");
    private final String value;

    GlobalStatusType(String v) {
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
     * From value global status type.
     *
     * @param v the v
     * @return the global status type
     */
    public static GlobalStatusType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
