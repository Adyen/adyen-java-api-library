package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for AttributeType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="AttributeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="id-at-commonName"/&gt;
 *     &lt;enumeration value="id-at-localityName"/&gt;
 *     &lt;enumeration value="id-at-organizationName"/&gt;
 *     &lt;enumeration value="id-at-organizationalUnitName"/&gt;
 *     &lt;enumeration value="id-at-countryName"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "AttributeType")
@XmlEnum
public enum AttributeType {


    /**
     * Common Name - (OID: joint-iso-ccitt(2) ds(5) 4 3)
     */
    @XmlEnumValue("id-at-commonName")
    ID_AT_COMMON_NAME("id-at-commonName"),

    /**
     * Locality - (OID: joint-iso-ccitt(2) ds(5) 4 7)
     */
    @XmlEnumValue("id-at-localityName")
    ID_AT_LOCALITY_NAME("id-at-localityName"),

    /**
     * Organization Name - (OID: joint-iso-ccitt(2) ds(5) 4 10)
     */
    @XmlEnumValue("id-at-organizationName")
    ID_AT_ORGANIZATION_NAME("id-at-organizationName"),

    /**
     * Organization Unit Name - (OID: joint-iso-ccitt(2) ds(5) 4 11)
     */
    @XmlEnumValue("id-at-organizationalUnitName")
    ID_AT_ORGANIZATIONAL_UNIT_NAME("id-at-organizationalUnitName"),

    /**
     * Country Name - (OID: joint-iso-ccitt(2) ds(5) 4 6)
     */
    @XmlEnumValue("id-at-countryName")
    ID_AT_COUNTRY_NAME("id-at-countryName");
    private final String value;

    AttributeType(String v) {
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
     * From value attribute type.
     *
     * @param v the v
     * @return the attribute type
     */
    public static AttributeType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
