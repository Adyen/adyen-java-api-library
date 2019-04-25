
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyTransactionTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LoyaltyTransactionTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Award"/>
 *     &lt;enumeration value="Rebate"/>
 *     &lt;enumeration value="Redemption"/>
 *     &lt;enumeration value="AwardRefund"/>
 *     &lt;enumeration value="RebateRefund"/>
 *     &lt;enumeration value="RedemptionRefund"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LoyaltyTransactionTypeEnumeration")
@XmlEnum
public enum LoyaltyTransactionTypeEnumeration {


    /**
     * Direct or payment related award on a loyalty account. Award alone, award associated to a payment (may be with an additional award alone), award because of a
     * 
     */
    @XmlEnumValue("Award")
    AWARD("Award"),

    /**
     * Rebate on a total amount, sale item amount, or sale items
     * 
     */
    @XmlEnumValue("Rebate")
    REBATE("Rebate"),

    /**
     * Redemption on a loyalty account.
     * 
     */
    @XmlEnumValue("Redemption")
    REDEMPTION("Redemption"),

    /**
     * Refund of a loyalty award transaction.
     * 
     */
    @XmlEnumValue("AwardRefund")
    AWARD_REFUND("AwardRefund"),

    /**
     * Refund of a loyalty rebate transaction.
     * 
     */
    @XmlEnumValue("RebateRefund")
    REBATE_REFUND("RebateRefund"),

    /**
     * Refund of a loyalty redemption transaction.
     * 
     */
    @XmlEnumValue("RedemptionRefund")
    REDEMPTION_REFUND("RedemptionRefund");
    private final String value;

    LoyaltyTransactionTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoyaltyTransactionTypeEnumeration fromValue(String v) {
        for (LoyaltyTransactionTypeEnumeration c: LoyaltyTransactionTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
