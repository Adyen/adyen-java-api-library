package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for VersionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="VersionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="v0"/&gt;
 *     &lt;enumeration value="v1"/&gt;
 *     &lt;enumeration value="v2"/&gt;
 *     &lt;enumeration value="v3"/&gt;
 *     &lt;enumeration value="v4"/&gt;
 *     &lt;enumeration value="v5"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "VersionType")
@XmlEnum
public enum VersionType {


    /**
     * Version 0
     */
    @XmlEnumValue("v0")
    V_0("v0"),

    /**
     * Version 1
     */
    @XmlEnumValue("v1")
    V_1("v1"),

    /**
     * Version 2
     */
    @XmlEnumValue("v2")
    V_2("v2"),

    /**
     * Version 3
     */
    @XmlEnumValue("v3")
    V_3("v3"),

    /**
     * Version 4
     */
    @XmlEnumValue("v4")
    V_4("v4"),

    /**
     * Version 5
     */
    @XmlEnumValue("v5")
    V_5("v5");
    private final String value;

    VersionType(String v) {
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
     * From value version type.
     *
     * @param v the v
     * @return the version type
     */
    public static VersionType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
