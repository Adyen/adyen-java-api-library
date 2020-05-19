package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for AccountType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="AccountType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Default"/&gt;
 *     &lt;enumeration value="Savings"/&gt;
 *     &lt;enumeration value="Checking"/&gt;
 *     &lt;enumeration value="CreditCard"/&gt;
 *     &lt;enumeration value="Universal"/&gt;
 *     &lt;enumeration value="Investment"/&gt;
 *     &lt;enumeration value="CardTotals"/&gt;
 *     &lt;enumeration value="EpurseCard"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "AccountType")
@XmlEnum
public enum AccountType {


    /**
     * Default account
     */
    @XmlEnumValue("Default")
    DEFAULT("Default"),

    /**
     * Savings account
     */
    @XmlEnumValue("Savings")
    SAVINGS("Savings"),

    /**
     * Checking account
     */
    @XmlEnumValue("Checking")
    CHECKING("Checking"),

    /**
     * Credit card account
     */
    @XmlEnumValue("CreditCard")
    CREDIT_CARD("CreditCard"),

    /**
     * Universal account
     */
    @XmlEnumValue("Universal")
    UNIVERSAL("Universal"),

    /**
     * Investment account
     */
    @XmlEnumValue("Investment")
    INVESTMENT("Investment"),

    /**
     * Card totals
     */
    @XmlEnumValue("CardTotals")
    CARD_TOTALS("CardTotals"),

    /**
     * e-Purse card account
     */
    @XmlEnumValue("EpurseCard")
    EPURSE_CARD("EpurseCard");
    private final String value;

    AccountType(String v) {
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
     * From value account type.
     *
     * @param v the v
     * @return the account type
     */
    public static AccountType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
