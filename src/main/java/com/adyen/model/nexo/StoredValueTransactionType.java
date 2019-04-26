
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StoredValueTransactionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StoredValueTransactionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Reserve"/>
 *     &lt;enumeration value="Activate"/>
 *     &lt;enumeration value="Load"/>
 *     &lt;enumeration value="Unload"/>
 *     &lt;enumeration value="Reverse"/>
 *     &lt;enumeration value="Duplicate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "StoredValueTransactionType")
@XmlEnum
public enum StoredValueTransactionType {


    /**
     * Reserve the account (e.g. get an activation code)
     *
     */
    @XmlEnumValue("Reserve")
    RESERVE("Reserve"),

    /**
     * Activate the account or the card
     *
     */
    @XmlEnumValue("Activate")
    ACTIVATE("Activate"),

    /**
     * Load the account or the card with money
     *
     */
    @XmlEnumValue("Load")
    LOAD("Load"),

    /**
     * Unload the account
     *
     */
    @XmlEnumValue("Unload")
    UNLOAD("Unload"),

    /**
     * Reverse an activation or loading.
     *
     */
    @XmlEnumValue("Reverse")
    REVERSE("Reverse"),

    /**
     * Duplicate the code or number provided by the loading or activation
     *
     */
    @XmlEnumValue("Duplicate")
    DUPLICATE("Duplicate");
    private final String value;

    StoredValueTransactionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StoredValueTransactionType fromValue(String v) {
        for (StoredValueTransactionType c: StoredValueTransactionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
