
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Savings"/>
 *     &lt;enumeration value="Checking"/>
 *     &lt;enumeration value="CreditCard"/>
 *     &lt;enumeration value="Universal"/>
 *     &lt;enumeration value="Investment"/>
 *     &lt;enumeration value="CardTotals"/>
 *     &lt;enumeration value="EpurseCard"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "AccountType")
@XmlEnum
public enum AccountType {


    /**
     * Default account
     *
     */
    @XmlEnumValue("Default")
    DEFAULT("Default"),

    /**
     * Savings account
     *
     */
    @XmlEnumValue("Savings")
    SAVINGS("Savings"),

    /**
     * Checking account
     *
     */
    @XmlEnumValue("Checking")
    CHECKING("Checking"),

    /**
     * Credit card account
     *
     */
    @XmlEnumValue("CreditCard")
    CREDIT_CARD("CreditCard"),

    /**
     * Universal account
     *
     */
    @XmlEnumValue("Universal")
    UNIVERSAL("Universal"),

    /**
     * Investment account
     *
     */
    @XmlEnumValue("Investment")
    INVESTMENT("Investment"),

    /**
     * Card totals
     *
     */
    @XmlEnumValue("CardTotals")
    CARD_TOTALS("CardTotals"),

    /**
     * e-Purse card account
     *
     */
    @XmlEnumValue("EpurseCard")
    EPURSE_CARD("EpurseCard");
    private final String value;

    AccountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccountType fromValue(String v) {
        for (AccountType c: AccountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
