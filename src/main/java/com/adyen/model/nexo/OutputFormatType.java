
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutputFormatType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OutputFormatType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MessageRef"/>
 *     &lt;enumeration value="Text"/>
 *     &lt;enumeration value="XHTML"/>
 *     &lt;enumeration value="BarCode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "OutputFormatType")
@XmlEnum
public enum OutputFormatType {


    /**
     * Predefined message (of any format) on the POI or the Sale. The output is then a PredefinedContent data structure.
     *
     */
    @XmlEnumValue("MessageRef")
    MESSAGE_REF("MessageRef"),

    /**
     * Text message including control characters prefixed by an escape character. The DisplayOutput is then an OutputText data structure.
     *
     */
    @XmlEnumValue("Text")
    TEXT("Text"),

    /**
     * DisplayOutput uses the eXtensible HyperText Markup Language.
     *
     */
    XHTML("XHTML"),

    /**
     * Barcode type to print The output is then a OutputBarCode data structure.
     *
     */
    @XmlEnumValue("BarCode")
    BAR_CODE("BarCode");
    private final String value;

    OutputFormatType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OutputFormatType fromValue(String v) {
        for (OutputFormatType c: OutputFormatType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
