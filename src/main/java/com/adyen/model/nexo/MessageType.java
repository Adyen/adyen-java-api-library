
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
     * Request message that requires a response, except if the request message mentions explicitely that a response message is not expected.
     *
     */
    @XmlEnumValue("Request")
    REQUEST("Request"),

    /**
     * Response message, sent to answer to a request message.
     *
     */
    @XmlEnumValue("Response")
    RESPONSE("Response"),

    /**
     * Unsollicited notification message that does not require an answer.
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
