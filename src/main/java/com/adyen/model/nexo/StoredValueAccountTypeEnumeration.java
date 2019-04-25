
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StoredValueAccountTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StoredValueAccountTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GiftCard"/>
 *     &lt;enumeration value="PhoneCard"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StoredValueAccountTypeEnumeration")
@XmlEnum
public enum StoredValueAccountTypeEnumeration {


    /**
     * Payment mean issued by retailers or banks as a substitute to a non-monetary gift.
     * 
     */
    @XmlEnumValue("GiftCard")
    GIFT_CARD("GiftCard"),

    /**
     * Stored value instrument used to pay telephone services (e.g. card or identifier).
     * 
     */
    @XmlEnumValue("PhoneCard")
    PHONE_CARD("PhoneCard"),

    /**
     * Other stored value instrument.
     * 
     */
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    StoredValueAccountTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StoredValueAccountTypeEnumeration fromValue(String v) {
        for (StoredValueAccountTypeEnumeration c: StoredValueAccountTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
