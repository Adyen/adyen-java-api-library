
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeviceEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CashierDisplay"/>
 *     &lt;enumeration value="CustomerDisplay"/>
 *     &lt;enumeration value="CashierInput"/>
 *     &lt;enumeration value="CustomerInput"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeviceEnumeration")
@XmlEnum
public enum DeviceEnumeration {


    /**
     * Used by the POI System (or the Sale System when the device is managed by the POI Terminal), to display some information to the Cashier.
     * 
     */
    @XmlEnumValue("CashierDisplay")
    CASHIER_DISPLAY("CashierDisplay"),

    /**
     * Used by the Sale System (or the POI System when the device is managed by the Sale Terminal), to display some information to the Customer.
     * 
     */
    @XmlEnumValue("CustomerDisplay")
    CUSTOMER_DISPLAY("CustomerDisplay"),

    /**
     * Any kind of keyboard allowing all or part of the commands of the Input message request from the Sale System to the POI System (InputCommand data element). The
     * 
     */
    @XmlEnumValue("CashierInput")
    CASHIER_INPUT("CashierInput"),

    /**
     * Any kind of keyboard allowing all or part of the commands of the Input message request from the POI System to the Sale System (InputCommand data element). The
     * 
     */
    @XmlEnumValue("CustomerInput")
    CUSTOMER_INPUT("CustomerInput");
    private final String value;

    DeviceEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeviceEnumeration fromValue(String v) {
        for (DeviceEnumeration c: DeviceEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
