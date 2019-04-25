
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CheckTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Personal"/>
 *     &lt;enumeration value="Company"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CheckTypeCodeEnumeration")
@XmlEnum
public enum CheckTypeCodeEnumeration {

    @XmlEnumValue("Personal")
    PERSONAL("Personal"),
    @XmlEnumValue("Company")
    COMPANY("Company");
    private final String value;

    CheckTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CheckTypeCodeEnumeration fromValue(String v) {
        for (CheckTypeCodeEnumeration c: CheckTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
