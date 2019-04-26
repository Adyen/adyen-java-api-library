
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReversalReasonType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReversalReasonType">
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
@XmlType(name = "ReversalReasonType")
@XmlEnum
public enum ReversalReasonType {


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

    ReversalReasonType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReversalReasonType fromValue(String v) {
        for (ReversalReasonType c: ReversalReasonType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
