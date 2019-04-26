
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PINRequestType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PINRequestType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PINVerify"/>
 *     &lt;enumeration value="PINVerifyOnly"/>
 *     &lt;enumeration value="PINEnter"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "PINRequestType")
@XmlEnum
public enum PINRequestType {


    /**
     * The PIN Entering and Verify.
     *
     */
    @XmlEnumValue("PINVerify")
    PIN_VERIFY("PINVerify"),

    /**
     * The PIN Verify only, the PIN is entered before and the PIN Block (encrypted PIN) is provided.
     *
     */
    @XmlEnumValue("PINVerifyOnly")
    PIN_VERIFY_ONLY("PINVerifyOnly"),

    /**
     * The PIN is entered by the Cardholder, encrypted by the POI, and provided as a result.
     *
     */
    @XmlEnumValue("PINEnter")
    PIN_ENTER("PINEnter");
    private final String value;

    PINRequestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PINRequestType fromValue(String v) {
        for (PINRequestType c: PINRequestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
