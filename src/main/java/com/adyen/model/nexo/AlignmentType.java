
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlignmentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AlignmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Left"/>
 *     &lt;enumeration value="Right"/>
 *     &lt;enumeration value="Centred"/>
 *     &lt;enumeration value="Justified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "AlignmentType")
@XmlEnum
public enum AlignmentType {

    @XmlEnumValue("Left")
    LEFT("Left"),
    @XmlEnumValue("Right")
    RIGHT("Right"),
    @XmlEnumValue("Centred")
    CENTRED("Centred"),
    @XmlEnumValue("Justified")
    JUSTIFIED("Justified");
    private final String value;

    AlignmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AlignmentType fromValue(String v) {
        for (AlignmentType c: AlignmentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
