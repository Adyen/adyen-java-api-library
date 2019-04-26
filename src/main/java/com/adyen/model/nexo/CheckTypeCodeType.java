
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckTypeCodeType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CheckTypeCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Personal"/>
 *     &lt;enumeration value="Company"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CheckTypeCodeType")
@XmlEnum
public enum CheckTypeCodeType {

    @XmlEnumValue("Personal")
    PERSONAL("Personal"),
    @XmlEnumValue("Company")
    COMPANY("Company");
    private final String value;

    CheckTypeCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CheckTypeCodeType fromValue(String v) {
        for (CheckTypeCodeType c: CheckTypeCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
