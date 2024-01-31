package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for OutputFormatType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="OutputFormatType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MessageRef"/&gt;
 *     &lt;enumeration value="Text"/&gt;
 *     &lt;enumeration value="XHTML"/&gt;
 *     &lt;enumeration value="BarCode"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "OutputFormatType")
@XmlEnum
public enum OutputFormatType {


    /**
     * Predefined messageType (of any format) on the POI or the Sale. The output is then a PredefinedContent data structure.
     */
    @XmlEnumValue("MessageRef")
    @Schema(description = "Predefined message (of any format) on the POI or the Sale. The output is then a PredefinedContent data structure. ")
    MESSAGE_REF("MessageRef"),

    /**
     * Text messageType including control characters prefixed by an escape character. The DisplayOutput is then an OutputText data structure.
     */
    @XmlEnumValue("Text")
    @Schema(description = "Text message including control characters prefixed by an escape character. The DisplayOutput is then an OutputText data structure.")
    TEXT("Text"),

    /**
     * DisplayOutput uses the eXtensible HyperText Markup Language.
     */
    @XmlEnumValue("XHTML")
    @Schema(description = "DisplayOutput uses the eXtensible HyperText Markup Language.")
    XHTML("XHTML"),

    /**
     * Barcode type to print The output is then a OutputBarCode data structure.
     */
    @XmlEnumValue("BarCode")
    @Schema(description = "Barcode type to print The output is then a OutputBarCode data structure.")
    BAR_CODE("BarCode");
    private final String value;

    OutputFormatType(String v) {
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
     * From value output format type.
     *
     * @param v the v
     * @return the output format type
     */
    public static OutputFormatType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
