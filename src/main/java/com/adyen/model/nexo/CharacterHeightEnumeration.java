
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CharacterHeightEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CharacterHeightEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SingleHeight"/>
 *     &lt;enumeration value="DoubleHeight"/>
 *     &lt;enumeration value="HalfHeight"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CharacterHeightEnumeration")
@XmlEnum
public enum CharacterHeightEnumeration {

    @XmlEnumValue("SingleHeight")
    SINGLE_HEIGHT("SingleHeight"),
    @XmlEnumValue("DoubleHeight")
    DOUBLE_HEIGHT("DoubleHeight"),
    @XmlEnumValue("HalfHeight")
    HALF_HEIGHT("HalfHeight");
    private final String value;

    CharacterHeightEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CharacterHeightEnumeration fromValue(String v) {
        for (CharacterHeightEnumeration c: CharacterHeightEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
