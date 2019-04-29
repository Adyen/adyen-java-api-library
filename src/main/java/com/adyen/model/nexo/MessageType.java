
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MessageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Request"/>
 *     &lt;enumeration value="Response"/>
 *     &lt;enumeration value="Notification"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "MessageType")
@XmlEnum
public enum MessageType {


    /**
     * Request messageType that requires a response, except if the request messageType mentions explicitely that a response messageType is not expected.
     *
     */
    @XmlEnumValue("Request")
    REQUEST("Request"),

    /**
     * Response messageType, sent to answer to a request messageType.
     *
     */
    @XmlEnumValue("Response")
    RESPONSE("Response"),

    /**
     * Unsollicited notification messageType that does not require an answer.
     *
     */
    @XmlEnumValue("Notification")
    NOTIFICATION("Notification");
    private final String value;

    MessageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MessageType fromValue(String v) {
        for (MessageType c: MessageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
