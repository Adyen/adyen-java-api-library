package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for PaymentInstrumentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="PaymentInstrumentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Card"/&gt;
 *     &lt;enumeration value="Check"/&gt;
 *     &lt;enumeration value="Mobile"/&gt;
 *     &lt;enumeration value="StoredValue"/&gt;
 *     &lt;enumeration value="Cash"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "PaymentInstrumentType")
@XmlEnum
public enum PaymentInstrumentType {


    /**
     * Payment card (credit or debit).
     */
    @XmlEnumValue("Card")
    CARD("Card"),

    /**
     * Paper check.
     */
    @XmlEnumValue("Check")
    CHECK("Check"),

    /**
     * Operator account accessed by a mobile phone.
     */
    @XmlEnumValue("Mobile")
    MOBILE("Mobile"),

    /**
     * Account accesed by a stored value instrument such as a card or a certificate.
     */
    @XmlEnumValue("StoredValue")
    STORED_VALUE("StoredValue"),

    /**
     * Cash managed by a cash handling system.
     */
    @XmlEnumValue("Cash")
    CASH("Cash");
    private final String value;

    PaymentInstrumentType(String v) {
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
     * From value payment instrument type.
     *
     * @param v the v
     * @return the payment instrument type
     */
    public static PaymentInstrumentType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
