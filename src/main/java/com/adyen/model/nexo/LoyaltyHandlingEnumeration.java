
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyHandlingEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoyaltyHandlingEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Forbidden"/>
 *     &lt;enumeration value="Processed"/>
 *     &lt;enumeration value="Allowed"/>
 *     &lt;enumeration value="Proposed"/>
 *     &lt;enumeration value="Required"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LoyaltyHandlingEnumeration")
@XmlEnum
public enum LoyaltyHandlingEnumeration {


    /**
     * No loyalty card to read and loyalty transaction to process. Any attempt to enter a pure loyalty card is rejected.
     * 
     */
    @XmlEnumValue("Forbidden")
    FORBIDDEN("Forbidden"),

    /**
     * The loyalty transaction is already processed, no loyalty card or loyalty transaction to process.
     * 
     */
    @XmlEnumValue("Processed")
    PROCESSED("Processed"),

    /**
     * The loyalty is accepted, but the POI has not to require or ask a loyalty card. The loyalty is involved by the payment card (e.g. an hybrid or linked card).
     * 
     */
    @XmlEnumValue("Allowed")
    ALLOWED("Allowed"),

    /**
     * The loyalty is accepted, and the POI has to ask a loyalty card. If the Customer does not enter a loyalty card, no loyalty transaction is realised.
     * 
     */
    @XmlEnumValue("Proposed")
    PROPOSED("Proposed"),

    /**
     * The loyalty is required, and the POI refuses the processing of the message request if the cardholder does not entre a loyalty card
     * 
     */
    @XmlEnumValue("Required")
    REQUIRED("Required");
    private final String value;

    LoyaltyHandlingEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoyaltyHandlingEnumeration fromValue(String v) {
        for (LoyaltyHandlingEnumeration c: LoyaltyHandlingEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
