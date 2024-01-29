package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for TerminalEnvironmentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="TerminalEnvironmentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Attended"/&gt;
 *     &lt;enumeration value="SemiAttended"/&gt;
 *     &lt;enumeration value="Unattended"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TerminalEnvironmentType")
@XmlEnum
public enum TerminalEnvironmentType {


    /**
     * The Sale Terminal is managed by a Cashier through the Sale System. A Cashier Interface is provided by the POI System during the process of a request from the
     */
    @XmlEnumValue("Attended")
    @Schema(description = "The Sale Terminal is managed by a Cashier through the Sale System. A Cashier Interface is provided by the POI System during the process of a request from the")
    ATTENDED("Attended"),

    /**
     * Without a Cashier Interface. The POI Terminal is managed by the Customer through the Customer Interface. A Cashier could help the Cardholder during the
     */
    @XmlEnumValue("SemiAttended")
    @Schema(description = "Without a Cashier Interface. The POI Terminal is managed by the Customer through the Customer Interface. A Cashier could help the Cardholder during the")
    SEMI_ATTENDED("SemiAttended"),

    /**
     * The Sale Terminal is managed as a logical terminal without any Cashier Interface (typically a background process). The POI Terminal is managed by the Customer
     */
    @XmlEnumValue("Unattended")
    @Schema(description = "The Sale Terminal is managed as a logical terminal without any Cashier Interface (typically a background process). The POI Terminal is managed by the Customer")
    UNATTENDED("Unattended");
    private final String value;

    TerminalEnvironmentType(String v) {
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
     * From value terminal environment type.
     *
     * @param v the v
     * @return the terminal environment type
     */
    public static TerminalEnvironmentType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
