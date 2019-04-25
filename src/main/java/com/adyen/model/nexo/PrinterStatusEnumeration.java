
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrinterStatusEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrinterStatusEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="PaperLow"/>
 *     &lt;enumeration value="NoPaper"/>
 *     &lt;enumeration value="PaperJam"/>
 *     &lt;enumeration value="OutOfOrder"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PrinterStatusEnumeration")
@XmlEnum
public enum PrinterStatusEnumeration {


    /**
     * The printer is operational.
     * 
     */
    OK("OK"),

    /**
     * The printer is operational but paper roll is almost empty.
     * 
     */
    @XmlEnumValue("PaperLow")
    PAPER_LOW("PaperLow"),

    /**
     * Paper roll is empty, an operator must insert a new paper roll.
     * 
     */
    @XmlEnumValue("NoPaper")
    NO_PAPER("NoPaper"),

    /**
     * An operator must remove the paper jam manually.
     * 
     */
    @XmlEnumValue("PaperJam")
    PAPER_JAM("PaperJam"),

    /**
     * The printer is out of order.
     * 
     */
    @XmlEnumValue("OutOfOrder")
    OUT_OF_ORDER("OutOfOrder");
    private final String value;

    PrinterStatusEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PrinterStatusEnumeration fromValue(String v) {
        for (PrinterStatusEnumeration c: PrinterStatusEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
