package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for MessageType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="MessageType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Request"/&gt;
 *     &lt;enumeration value="Response"/&gt;
 *     &lt;enumeration value="Notification"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "MessageType")
@XmlEnum
public enum MessageType {


    /**
     * Request messageType that requires a response, except if the request messageType mentions explicitely that a response messageType is not expected.
     */
    @XmlEnumValue("Request")
    REQUEST("Request"),

    /**
     * Response messageType, sent to answer to a request messageType.
     */
    @XmlEnumValue("Response")
    RESPONSE("Response"),

    /**
     * Unsollicited notification messageType that does not require an answer.
     */
    @XmlEnumValue("Notification")
    NOTIFICATION("Notification");
    private final String value;

    MessageType(String v) {
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
     * From value message type.
     *
     * @param v the v
     * @return the message type
     */
    public static MessageType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
