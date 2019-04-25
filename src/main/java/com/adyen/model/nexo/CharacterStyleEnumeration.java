
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CharacterStyleEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CharacterStyleEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Normal"/>
 *     &lt;enumeration value="Bold"/>
 *     &lt;enumeration value="Italic"/>
 *     &lt;enumeration value="Underlined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CharacterStyleEnumeration")
@XmlEnum
public enum CharacterStyleEnumeration {

    @XmlEnumValue("Normal")
    NORMAL("Normal"),
    @XmlEnumValue("Bold")
    BOLD("Bold"),
    @XmlEnumValue("Italic")
    ITALIC("Italic"),
    @XmlEnumValue("Underlined")
    UNDERLINED("Underlined");
    private final String value;

    CharacterStyleEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CharacterStyleEnumeration fromValue(String v) {
        for (CharacterStyleEnumeration c: CharacterStyleEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
