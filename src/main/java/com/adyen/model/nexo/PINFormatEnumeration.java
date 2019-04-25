
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PINFormatEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PINFormatEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ISO0"/>
 *     &lt;enumeration value="ISO1"/>
 *     &lt;enumeration value="ISO2"/>
 *     &lt;enumeration value="ISO3"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PINFormatEnumeration")
@XmlEnum
public enum PINFormatEnumeration {


    /**
     * ISO 0
     * 
     */
    @XmlEnumValue("ISO0")
    ISO_0("ISO0"),

    /**
     * ISO 1
     * 
     */
    @XmlEnumValue("ISO1")
    ISO_1("ISO1"),

    /**
     * ISO 2
     * 
     */
    @XmlEnumValue("ISO2")
    ISO_2("ISO2"),

    /**
     * ISO 3
     * 
     */
    @XmlEnumValue("ISO3")
    ISO_3("ISO3");
    private final String value;

    PINFormatEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PINFormatEnumeration fromValue(String v) {
        for (PINFormatEnumeration c: PINFormatEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
