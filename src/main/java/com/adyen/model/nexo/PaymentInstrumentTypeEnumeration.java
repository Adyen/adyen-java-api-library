
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentInstrumentTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentInstrumentTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Card"/>
 *     &lt;enumeration value="Check"/>
 *     &lt;enumeration value="Mobile"/>
 *     &lt;enumeration value="StoredValue"/>
 *     &lt;enumeration value="Cash"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentInstrumentTypeEnumeration")
@XmlEnum
public enum PaymentInstrumentTypeEnumeration {


    /**
     * Payment card (credit or debit).
     * 
     */
    @XmlEnumValue("Card")
    CARD("Card"),

    /**
     * Paper check.
     * 
     */
    @XmlEnumValue("Check")
    CHECK("Check"),

    /**
     * Operator account accessed by a mobile phone.
     * 
     */
    @XmlEnumValue("Mobile")
    MOBILE("Mobile"),

    /**
     * Account accesed by a stored value instrument such as a card or a certificate.
     * 
     */
    @XmlEnumValue("StoredValue")
    STORED_VALUE("StoredValue"),

    /**
     * Cash managed by a cash handling system.
     * 
     */
    @XmlEnumValue("Cash")
    CASH("Cash");
    private final String value;

    PaymentInstrumentTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentInstrumentTypeEnumeration fromValue(String v) {
        for (PaymentInstrumentTypeEnumeration c: PaymentInstrumentTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
