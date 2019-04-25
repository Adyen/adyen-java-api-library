
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TokenRequestedTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TokenRequestedTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Transaction"/>
 *     &lt;enumeration value="Customer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TokenRequestedTypeEnumeration")
@XmlEnum
public enum TokenRequestedTypeEnumeration {


    /**
     * The token is generated to recognise a customer during the time of a transaction.
     * 
     */
    @XmlEnumValue("Transaction")
    TRANSACTION("Transaction"),

    /**
     * The token is generated to recognise a customer for a longer period.
     * 
     */
    @XmlEnumValue("Customer")
    CUSTOMER("Customer");
    private final String value;

    TokenRequestedTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TokenRequestedTypeEnumeration fromValue(String v) {
        for (TokenRequestedTypeEnumeration c: TokenRequestedTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
