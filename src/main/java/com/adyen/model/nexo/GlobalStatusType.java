
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GlobalStatusType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GlobalStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="Busy"/>
 *     &lt;enumeration value="Maintenance"/>
 *     &lt;enumeration value="Unreachable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "GlobalStatusType")
@XmlEnum
public enum GlobalStatusType {


    /**
     * The POI is ready to receive and process a request
     *
     */
    OK("OK"),

    /**
     * The POI Terminal cannot process a request because another processing is in progress.
     *
     */
    @XmlEnumValue("Busy")
    BUSY("Busy"),

    /**
     * The POI is in maintenance processing
     *
     */
    @XmlEnumValue("Maintenance")
    MAINTENANCE("Maintenance"),

    /**
     * The POI is unreachable or not responding
     *
     */
    @XmlEnumValue("Unreachable")
    UNREACHABLE("Unreachable");
    private final String value;

    GlobalStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GlobalStatusType fromValue(String v) {
        for (GlobalStatusType c: GlobalStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
