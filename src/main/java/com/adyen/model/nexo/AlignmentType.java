package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for AlignmentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="AlignmentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Left"/&gt;
 *     &lt;enumeration value="Right"/&gt;
 *     &lt;enumeration value="Centred"/&gt;
 *     &lt;enumeration value="Justified"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "AlignmentType")
@XmlEnum
public enum AlignmentType {

    /**
     * Left alignment type.
     */
    @XmlEnumValue("Left")
    LEFT("Left"),
    /**
     * Right alignment type.
     */
    @XmlEnumValue("Right")
    RIGHT("Right"),
    /**
     * Centred alignment type.
     */
    @XmlEnumValue("Centred")
    CENTRED("Centred"),
    /**
     * Justified alignment type.
     */
    @XmlEnumValue("Justified")
    JUSTIFIED("Justified");
    private final String value;

    AlignmentType(String v) {
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
     * From value alignment type.
     *
     * @param v the v
     * @return the alignment type
     */
    public static AlignmentType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
