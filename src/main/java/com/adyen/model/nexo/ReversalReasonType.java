package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for ReversalReasonType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ReversalReasonType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CustCancel"/&gt;
 *     &lt;enumeration value="MerchantCancel"/&gt;
 *     &lt;enumeration value="Malfunction"/&gt;
 *     &lt;enumeration value="Unable2Compl"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ReversalReasonType")
@XmlEnum
public enum ReversalReasonType {


    /**
     * Customer cancellation
     */
    @XmlEnumValue("CustCancel")
    @Schema(description = "Customer cancellation")
    CUST_CANCEL("CustCancel"),

    /**
     * Cashier cancellation
     */
    @XmlEnumValue("MerchantCancel")
    @Schema(description = "Cashier cancellation")
    MERCHANT_CANCEL("MerchantCancel"),

    /**
     * Suspected malfunction
     */
    @XmlEnumValue("Malfunction")
    @Schema(description = "Suspected malfunction")
    MALFUNCTION("Malfunction"),

    /**
     * Card acceptor device unable to complete transaction
     */
    @XmlEnumValue("Unable2Compl")
    @Schema(description = "Card acceptor device unable to complete transaction")
    UNABLE_2_COMPL("Unable2Compl");
    private final String value;

    ReversalReasonType(String v) {
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
     * From value reversal reason type.
     *
     * @param v the v
     * @return the reversal reason type
     */
    public static ReversalReasonType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
