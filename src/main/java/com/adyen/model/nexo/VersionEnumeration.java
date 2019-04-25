
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VersionEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VersionEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="v0"/>
 *     &lt;enumeration value="v1"/>
 *     &lt;enumeration value="v2"/>
 *     &lt;enumeration value="v3"/>
 *     &lt;enumeration value="v4"/>
 *     &lt;enumeration value="v5"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VersionEnumeration")
@XmlEnum
public enum VersionEnumeration {


    /**
     * Version 0
     * 
     */
    @XmlEnumValue("v0")
    V_0("v0"),

    /**
     * Version 1
     * 
     */
    @XmlEnumValue("v1")
    V_1("v1"),

    /**
     * Version 2
     * 
     */
    @XmlEnumValue("v2")
    V_2("v2"),

    /**
     * Version 3
     * 
     */
    @XmlEnumValue("v3")
    V_3("v3"),

    /**
     * Version 4
     * 
     */
    @XmlEnumValue("v4")
    V_4("v4"),

    /**
     * Version 5
     * 
     */
    @XmlEnumValue("v5")
    V_5("v5");
    private final String value;

    VersionEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VersionEnumeration fromValue(String v) {
        for (VersionEnumeration c: VersionEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
