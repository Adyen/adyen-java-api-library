package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for StoredValueTransactionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="StoredValueTransactionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Reserve"/&gt;
 *     &lt;enumeration value="Activate"/&gt;
 *     &lt;enumeration value="Load"/&gt;
 *     &lt;enumeration value="Unload"/&gt;
 *     &lt;enumeration value="Reverse"/&gt;
 *     &lt;enumeration value="Duplicate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "StoredValueTransactionType")
@XmlEnum
public enum StoredValueTransactionType {


    /**
     * Reserve the account (e.g. get an activation code)
     */
    @XmlEnumValue("Reserve")
    RESERVE("Reserve"),

    /**
     * Activate the account or the card
     */
    @XmlEnumValue("Activate")
    ACTIVATE("Activate"),

    /**
     * Load the account or the card with money
     */
    @XmlEnumValue("Load")
    LOAD("Load"),

    /**
     * Unload the account
     */
    @XmlEnumValue("Unload")
    UNLOAD("Unload"),

    /**
     * Reverse an activation or loading.
     */
    @XmlEnumValue("Reverse")
    REVERSE("Reverse"),

    /**
     * Duplicate the code or number provided by the loading or activation
     */
    @XmlEnumValue("Duplicate")
    DUPLICATE("Duplicate");
    private final String value;

    StoredValueTransactionType(String v) {
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
     * From value stored value transaction type.
     *
     * @param v the v
     * @return the stored value transaction type
     */
    public static StoredValueTransactionType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
