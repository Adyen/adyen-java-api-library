
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoundFormatEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SoundFormatEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SoundRef"/>
 *     &lt;enumeration value="MessageRef"/>
 *     &lt;enumeration value="Text"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SoundFormatEnumeration")
@XmlEnum
public enum SoundFormatEnumeration {


    /**
     * Preloaded sound File.
     * 
     */
    @XmlEnumValue("SoundRef")
    SOUND_REF("SoundRef"),

    /**
     * Reference of a preloaded text to play.
     * 
     */
    @XmlEnumValue("MessageRef")
    MESSAGE_REF("MessageRef"),

    /**
     * Text to play.
     * 
     */
    @XmlEnumValue("Text")
    TEXT("Text");
    private final String value;

    SoundFormatEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SoundFormatEnumeration fromValue(String v) {
        for (SoundFormatEnumeration c: SoundFormatEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
