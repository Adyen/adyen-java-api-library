package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for MessageClassType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="MessageClassType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Service"/&gt;
 *     &lt;enumeration value="Device"/&gt;
 *     &lt;enumeration value="Event"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "MessageClassType")
@XmlEnum
public enum MessageClassType {


    /**
     * A transaction messageType pair initiated by the Sale System, and requested to the POI System.
     */
    @XmlEnumValue("Service")
    @Schema(description = "A transaction message pair initiated by the Sale System, and requested to the POI System.")
    SERVICE("Service"),

    /**
     * A device messageType pair either: Inside a Service request and response. This device messageType pair is initiated by the POI System, and sent to Sale System,
     */
    @XmlEnumValue("Device")
    @Schema(description = "A device message pair either: Inside a Service request and response. This device message pair is initiated by the POI System, and sent to Sale System,")
    DEVICE("Device"),

    /**
     * An unsolicited event notification by the POI System to the Sale System.
     */
    @XmlEnumValue("Event")
    @Schema(description = "An unsolicited event notification by the POI System to the Sale System.")
    EVENT("Event");
    private final String value;

    MessageClassType(String v) {
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
     * From value message class type.
     *
     * @param v the v
     * @return the message class type
     */
    public static MessageClassType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
