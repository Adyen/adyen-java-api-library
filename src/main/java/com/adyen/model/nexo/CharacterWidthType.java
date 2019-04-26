
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CharacterWidthType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CharacterWidthType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SingleWidth"/>
 *     &lt;enumeration value="DoubleWidth"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CharacterWidthType")
@XmlEnum
public enum CharacterWidthType {

    @XmlEnumValue("SingleWidth")
    SINGLE_WIDTH("SingleWidth"),
    @XmlEnumValue("DoubleWidth")
    DOUBLE_WIDTH("DoubleWidth");
    private final String value;

    CharacterWidthType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CharacterWidthType fromValue(String v) {
        for (CharacterWidthType c: CharacterWidthType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
