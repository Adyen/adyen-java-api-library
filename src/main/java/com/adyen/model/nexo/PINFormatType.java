package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for PINFormatType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="PINFormatType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ISO0"/&gt;
 *     &lt;enumeration value="ISO1"/&gt;
 *     &lt;enumeration value="ISO2"/&gt;
 *     &lt;enumeration value="ISO3"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "PINFormatType")
@XmlEnum
public enum PINFormatType {


    /**
     * ISO 0
     */
    @XmlEnumValue("ISO0")
    @Schema(description = "ISO 0")
    ISO_0("ISO0"),

    /**
     * ISO 1
     */
    @XmlEnumValue("ISO1")
    @Schema(description = "ISO 1")
    ISO_1("ISO1"),

    /**
     * ISO 2
     */
    @XmlEnumValue("ISO2")
    @Schema(description = "ISO 2")
    ISO_2("ISO2"),

    /**
     * ISO 3
     */
    @XmlEnumValue("ISO3")
    @Schema(description = "ISO 3")
    ISO_3("ISO3");
    private final String value;

    PINFormatType(String v) {
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
     * From value pin format type.
     *
     * @param v the v
     * @return the pin format type
     */
    public static PINFormatType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
