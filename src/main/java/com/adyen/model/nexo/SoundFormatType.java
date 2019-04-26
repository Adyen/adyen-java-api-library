
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoundFormatType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SoundFormatType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SoundRef"/>
 *     &lt;enumeration value="MessageRef"/>
 *     &lt;enumeration value="Text"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "SoundFormatType")
@XmlEnum
public enum SoundFormatType {


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

    SoundFormatType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SoundFormatType fromValue(String v) {
        for (SoundFormatType c: SoundFormatType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
