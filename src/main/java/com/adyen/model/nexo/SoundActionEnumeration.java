
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoundActionEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SoundActionEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="StartSound"/>
 *     &lt;enumeration value="StopSound"/>
 *     &lt;enumeration value="SetDefaultVolume"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SoundActionEnumeration")
@XmlEnum
public enum SoundActionEnumeration {


    /**
     * Start the sound as specified in the message.
     * 
     */
    @XmlEnumValue("StartSound")
    START_SOUND("StartSound"),

    /**
     * Stop the sound in progress.
     * 
     */
    @XmlEnumValue("StopSound")
    STOP_SOUND("StopSound"),

    /**
     * Set the default volume of sounds.
     * 
     */
    @XmlEnumValue("SetDefaultVolume")
    SET_DEFAULT_VOLUME("SetDefaultVolume");
    private final String value;

    SoundActionEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SoundActionEnumeration fromValue(String v) {
        for (SoundActionEnumeration c: SoundActionEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
