
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageClassEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MessageClassEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Service"/>
 *     &lt;enumeration value="Device"/>
 *     &lt;enumeration value="Event"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MessageClassEnumeration")
@XmlEnum
public enum MessageClassEnumeration {


    /**
     * A transaction message pair initiated by the Sale System, and requested to the POI System.
     * 
     */
    @XmlEnumValue("Service")
    SERVICE("Service"),

    /**
     * A device message pair either: Inside a Service request and response. This device message pair is initiated by the POI System, and sent to Sale System,
     * 
     */
    @XmlEnumValue("Device")
    DEVICE("Device"),

    /**
     * An unsolicited event notification by the POI System to the Sale System.
     * 
     */
    @XmlEnumValue("Event")
    EVENT("Event");
    private final String value;

    MessageClassEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MessageClassEnumeration fromValue(String v) {
        for (MessageClassEnumeration c: MessageClassEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
