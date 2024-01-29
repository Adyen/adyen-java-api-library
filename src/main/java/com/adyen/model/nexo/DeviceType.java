package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for DeviceType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="DeviceType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CashierDisplay"/&gt;
 *     &lt;enumeration value="CustomerDisplay"/&gt;
 *     &lt;enumeration value="CashierInput"/&gt;
 *     &lt;enumeration value="CustomerInput"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "DeviceType")
@XmlEnum
public enum DeviceType {


    /**
     * Used by the POI System (or the Sale System when the device is managed by the POI Terminal), to display some information to the Cashier.
     */
    @XmlEnumValue("CashierDisplay")
    @Schema(description = "Used by the POI System (or the Sale System when the device is managed by the POI Terminal), to display some information to the Cashier.")
    CASHIER_DISPLAY("CashierDisplay"),

    /**
     * Used by the Sale System (or the POI System when the device is managed by the Sale Terminal), to display some information to the Customer.
     */
    @XmlEnumValue("CustomerDisplay")
    @Schema(description = "Used by the Sale System (or the POI System when the device is managed by the Sale Terminal), to display some information to the Customer.")
    CUSTOMER_DISPLAY("CustomerDisplay"),

    /**
     * Any kind of keyboard allowing all or part of the commands of the Input messageType request from the Sale System to the POI System (InputCommand data element). The
     */
    @XmlEnumValue("CashierInput")
    @Schema(description = "Any kind of keyboard allowing all or part of the commands of the Input message request from the Sale System to the POI System (InputCommand data element). The")
    CASHIER_INPUT("CashierInput"),

    /**
     * Any kind of keyboard allowing all or part of the commands of the Input messageType request from the POI System to the Sale System (InputCommand data element). The
     */
    @XmlEnumValue("CustomerInput")
    @Schema(description = "Any kind of keyboard allowing all or part of the commands of the Input message request from the POI System to the Sale System (InputCommand data element). The")
    CUSTOMER_INPUT("CustomerInput");
    private final String value;

    DeviceType(String v) {
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
     * From value device type.
     *
     * @param v the v
     * @return the device type
     */
    public static DeviceType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
