
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenericProfileEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GenericProfileEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Basic"/>
 *     &lt;enumeration value="Standard"/>
 *     &lt;enumeration value="Extended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GenericProfileEnumeration")
@XmlEnum
public enum GenericProfileEnumeration {


    /**
     * Protocol services that needs to be implemented by all the Sale and POI
     * 
     */
    @XmlEnumValue("Basic")
    BASIC("Basic"),

    /**
     * Protocol services involving interaction between Sale System and POI System as devices shared between the two Systems.
     * 
     */
    @XmlEnumValue("Standard")
    STANDARD("Standard"),

    /**
     * Complete Protocol services
     * 
     */
    @XmlEnumValue("Extended")
    EXTENDED("Extended");
    private final String value;

    GenericProfileEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GenericProfileEnumeration fromValue(String v) {
        for (GenericProfileEnumeration c: GenericProfileEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
