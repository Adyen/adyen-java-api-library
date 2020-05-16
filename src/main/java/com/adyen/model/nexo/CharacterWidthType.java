package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for CharacterWidthType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="CharacterWidthType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SingleWidth"/&gt;
 *     &lt;enumeration value="DoubleWidth"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "CharacterWidthType")
@XmlEnum
public enum CharacterWidthType {

    /**
     * Single width character width type.
     */
    @XmlEnumValue("SingleWidth")
    SINGLE_WIDTH("SingleWidth"),
    /**
     * Double width character width type.
     */
    @XmlEnumValue("DoubleWidth")
    DOUBLE_WIDTH("DoubleWidth");
    private final String value;

    CharacterWidthType(String v) {
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
     * From value character width type.
     *
     * @param v the v
     * @return the character width type
     */
    public static CharacterWidthType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
