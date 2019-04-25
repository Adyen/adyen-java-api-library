
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReversalReasonEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReversalReasonEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CustCancel"/>
 *     &lt;enumeration value="MerchantCancel"/>
 *     &lt;enumeration value="Malfunction"/>
 *     &lt;enumeration value="Unable2Compl"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReversalReasonEnumeration")
@XmlEnum
public enum ReversalReasonEnumeration {


    /**
     * Customer cancellation
     * 
     */
    @XmlEnumValue("CustCancel")
    CUST_CANCEL("CustCancel"),

    /**
     * Cashier cancellation
     * 
     */
    @XmlEnumValue("MerchantCancel")
    MERCHANT_CANCEL("MerchantCancel"),

    /**
     * Suspected malfunction
     * 
     */
    @XmlEnumValue("Malfunction")
    MALFUNCTION("Malfunction"),

    /**
     * Card acceptor device unable to complete transaction
     * 
     */
    @XmlEnumValue("Unable2Compl")
    UNABLE_2_COMPL("Unable2Compl");
    private final String value;

    ReversalReasonEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReversalReasonEnumeration fromValue(String v) {
        for (ReversalReasonEnumeration c: ReversalReasonEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
