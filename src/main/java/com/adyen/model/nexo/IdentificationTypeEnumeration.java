
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentificationTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IdentificationTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PAN"/>
 *     &lt;enumeration value="ISOTrack2"/>
 *     &lt;enumeration value="BarCode"/>
 *     &lt;enumeration value="AccountNumber"/>
 *     &lt;enumeration value="PhoneNumber"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IdentificationTypeEnumeration")
@XmlEnum
public enum IdentificationTypeEnumeration {


    /**
     * Standard card identification (card number)
     * 
     */
    PAN("PAN"),

    /**
     * ISO Track 2 including identification.
     * 
     */
    @XmlEnumValue("ISOTrack2")
    ISO_TRACK_2("ISOTrack2"),

    /**
     * Bar-code with a specific form of identification
     * 
     */
    @XmlEnumValue("BarCode")
    BAR_CODE("BarCode"),

    /**
     * Account number
     * 
     */
    @XmlEnumValue("AccountNumber")
    ACCOUNT_NUMBER("AccountNumber"),

    /**
     * A phone number identifies the account on which the phone card is assigned.
     * 
     */
    @XmlEnumValue("PhoneNumber")
    PHONE_NUMBER("PhoneNumber");
    private final String value;

    IdentificationTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IdentificationTypeEnumeration fromValue(String v) {
        for (IdentificationTypeEnumeration c: IdentificationTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
