
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TerminalEnvironmentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TerminalEnvironmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Attended"/>
 *     &lt;enumeration value="SemiAttended"/>
 *     &lt;enumeration value="Unattended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "TerminalEnvironmentType")
@XmlEnum
public enum TerminalEnvironmentType {


    /**
     * The Sale Terminal is managed by a Cashier through the Sale System. A Cashier Interface is provided by the POI System during the process of a request from the
     *
     */
    @XmlEnumValue("Attended")
    ATTENDED("Attended"),

    /**
     * Without a Cashier Interface. The POI Terminal is managed by the Customer through the Customer Interface. A Cashier could help the Cardholder during the
     *
     */
    @XmlEnumValue("SemiAttended")
    SEMI_ATTENDED("SemiAttended"),

    /**
     * The Sale Terminal is managed as a logical terminal without any Cashier Interface (typically a background process). The POI Terminal is managed by the Customer
     *
     */
    @XmlEnumValue("Unattended")
    UNATTENDED("Unattended");
    private final String value;

    TerminalEnvironmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TerminalEnvironmentType fromValue(String v) {
        for (TerminalEnvironmentType c: TerminalEnvironmentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
