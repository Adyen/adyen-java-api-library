package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for ColorType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ColorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="White"/&gt;
 *     &lt;enumeration value="Black"/&gt;
 *     &lt;enumeration value="Red"/&gt;
 *     &lt;enumeration value="Green"/&gt;
 *     &lt;enumeration value="Blue"/&gt;
 *     &lt;enumeration value="Yellow"/&gt;
 *     &lt;enumeration value="Magenta"/&gt;
 *     &lt;enumeration value="Cyan"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ColorType")
@XmlEnum
public enum ColorType {

    /**
     * White color type.
     */
    @XmlEnumValue("White")
    WHITE("White"),
    /**
     * Black color type.
     */
    @XmlEnumValue("Black")
    BLACK("Black"),
    /**
     * Red color type.
     */
    @XmlEnumValue("Red")
    RED("Red"),
    /**
     * Green color type.
     */
    @XmlEnumValue("Green")
    GREEN("Green"),
    /**
     * Blue color type.
     */
    @XmlEnumValue("Blue")
    BLUE("Blue"),
    /**
     * Yellow color type.
     */
    @XmlEnumValue("Yellow")
    YELLOW("Yellow"),
    /**
     * Magenta color type.
     */
    @XmlEnumValue("Magenta")
    MAGENTA("Magenta"),
    /**
     * Cyan color type.
     */
    @XmlEnumValue("Cyan")
    CYAN("Cyan");
    private final String value;

    ColorType(String v) {
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
     * From value color type.
     *
     * @param v the v
     * @return the color type
     */
    public static ColorType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
