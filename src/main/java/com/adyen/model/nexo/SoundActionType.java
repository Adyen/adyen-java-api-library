package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for SoundActionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="SoundActionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="StartSound"/&gt;
 *     &lt;enumeration value="StopSound"/&gt;
 *     &lt;enumeration value="SetDefaultVolume"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "SoundActionType")
@XmlEnum
public enum SoundActionType {


    /**
     * Start the sound as specified in the messageType.
     */
    @XmlEnumValue("StartSound")
    @Schema(description = "Start the sound as specified in the message.")
    START_SOUND("StartSound"),

    /**
     * Stop the sound in progress.
     */
    @XmlEnumValue("StopSound")
    @Schema(description = "Stop the sound in progress.")
    STOP_SOUND("StopSound"),

    /**
     * Set the default volume of sounds.
     */
    @XmlEnumValue("SetDefaultVolume")
    @Schema(description = "Set the default volume of sounds.")
    SET_DEFAULT_VOLUME("SetDefaultVolume");
    private final String value;

    SoundActionType(String v) {
        value = v;
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value sound action type.
     *
     * @param v the v
     * @return the sound action type
     */
    public static SoundActionType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
