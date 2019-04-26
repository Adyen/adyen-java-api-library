
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CharacterHeightType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CharacterHeightType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SingleHeight"/>
 *     &lt;enumeration value="DoubleHeight"/>
 *     &lt;enumeration value="HalfHeight"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CharacterHeightType")
@XmlEnum
public enum CharacterHeightType {

    @XmlEnumValue("SingleHeight")
    SINGLE_HEIGHT("SingleHeight"),
    @XmlEnumValue("DoubleHeight")
    DOUBLE_HEIGHT("DoubleHeight"),
    @XmlEnumValue("HalfHeight")
    HALF_HEIGHT("HalfHeight");
    private final String value;

    CharacterHeightType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CharacterHeightType fromValue(String v) {
        for (CharacterHeightType c: CharacterHeightType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
