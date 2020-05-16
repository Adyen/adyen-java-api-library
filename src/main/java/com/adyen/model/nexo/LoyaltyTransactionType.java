package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for LoyaltyTransactionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="LoyaltyTransactionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Award"/&gt;
 *     &lt;enumeration value="Rebate"/&gt;
 *     &lt;enumeration value="Redemption"/&gt;
 *     &lt;enumeration value="AwardRefund"/&gt;
 *     &lt;enumeration value="RebateRefund"/&gt;
 *     &lt;enumeration value="RedemptionRefund"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "LoyaltyTransactionType")
@XmlEnum
public enum LoyaltyTransactionType {


    /**
     * Direct or payment related award on a loyalty account. Award alone, award associated to a payment (may be with an additional award alone), award because of a
     */
    @XmlEnumValue("Award")
    AWARD("Award"),

    /**
     * Rebate on a total amount, sale item amount, or sale items
     */
    @XmlEnumValue("Rebate")
    REBATE("Rebate"),

    /**
     * Redemption on a loyalty account.
     */
    @XmlEnumValue("Redemption")
    REDEMPTION("Redemption"),

    /**
     * Refund of a loyalty award transaction.
     */
    @XmlEnumValue("AwardRefund")
    AWARD_REFUND("AwardRefund"),

    /**
     * Refund of a loyalty rebate transaction.
     */
    @XmlEnumValue("RebateRefund")
    REBATE_REFUND("RebateRefund"),

    /**
     * Refund of a loyalty redemption transaction.
     */
    @XmlEnumValue("RedemptionRefund")
    REDEMPTION_REFUND("RedemptionRefund");
    private final String value;

    LoyaltyTransactionType(String v) {
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
     * From value loyalty transaction type.
     *
     * @param v the v
     * @return the loyalty transaction type
     */
    public static LoyaltyTransactionType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
