package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for ResponseModeType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ResponseModeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NotRequired"/&gt;
 *     &lt;enumeration value="Immediate"/&gt;
 *     &lt;enumeration value="PrintEnd"/&gt;
 *     &lt;enumeration value="SoundEnd"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ResponseModeType")
@XmlEnum
public enum ResponseModeType {


    /**
     * The Message Response is not required, except in case of error.
     */
    @XmlEnumValue("NotRequired")
    @Schema(description = "The Message Response is not required, except in case of error.")
    NOT_REQUIRED("NotRequired"),

    /**
     * The Message Response is immediate, after taking into account the request.
     */
    @XmlEnumValue("Immediate")
    @Schema(description = "The Message Response is immediate, after taking into account the request.")
    IMMEDIATE("Immediate"),

    /**
     * The Print Response is required at the end of print.
     */
    @XmlEnumValue("PrintEnd")
    @Schema(description = "The Print Response is required at the end of print.")
    PRINT_END("PrintEnd"),

    /**
     * The Sound Response is required at the end of play.
     */
    @XmlEnumValue("SoundEnd")
    @Schema(description = "The Sound Response is required at the end of play.")
    SOUND_END("SoundEnd");
    private final String value;

    ResponseModeType(String v) {
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
     * From value response mode type.
     *
     * @param v the v
     * @return the response mode type
     */
    public static ResponseModeType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
