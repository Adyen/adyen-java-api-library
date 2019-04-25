
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CharacterWidthEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CharacterWidthEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SingleWidth"/>
 *     &lt;enumeration value="DoubleWidth"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CharacterWidthEnumeration")
@XmlEnum
public enum CharacterWidthEnumeration {

    @XmlEnumValue("SingleWidth")
    SINGLE_WIDTH("SingleWidth"),
    @XmlEnumValue("DoubleWidth")
    DOUBLE_WIDTH("DoubleWidth");
    private final String value;

    CharacterWidthEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CharacterWidthEnumeration fromValue(String v) {
        for (CharacterWidthEnumeration c: CharacterWidthEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
