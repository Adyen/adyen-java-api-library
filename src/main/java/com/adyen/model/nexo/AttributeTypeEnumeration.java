
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttributeTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AttributeTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="id-at-commonName"/>
 *     &lt;enumeration value="id-at-localityName"/>
 *     &lt;enumeration value="id-at-organizationName"/>
 *     &lt;enumeration value="id-at-organizationalUnitName"/>
 *     &lt;enumeration value="id-at-countryName"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AttributeTypeEnumeration")
@XmlEnum
public enum AttributeTypeEnumeration {


    /**
     * Common Name - (OID: joint-iso-ccitt(2) ds(5) 4 3)
     * 
     */
    @XmlEnumValue("id-at-commonName")
    ID_AT_COMMON_NAME("id-at-commonName"),

    /**
     * Locality - (OID: joint-iso-ccitt(2) ds(5) 4 7)
     * 
     */
    @XmlEnumValue("id-at-localityName")
    ID_AT_LOCALITY_NAME("id-at-localityName"),

    /**
     * Organization Name - (OID: joint-iso-ccitt(2) ds(5) 4 10)
     * 
     */
    @XmlEnumValue("id-at-organizationName")
    ID_AT_ORGANIZATION_NAME("id-at-organizationName"),

    /**
     * Organization Unit Name - (OID: joint-iso-ccitt(2) ds(5) 4 11)
     * 
     */
    @XmlEnumValue("id-at-organizationalUnitName")
    ID_AT_ORGANIZATIONAL_UNIT_NAME("id-at-organizationalUnitName"),

    /**
     * Country Name - (OID: joint-iso-ccitt(2) ds(5) 4 6)
     * 
     */
    @XmlEnumValue("id-at-countryName")
    ID_AT_COUNTRY_NAME("id-at-countryName");
    private final String value;

    AttributeTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AttributeTypeEnumeration fromValue(String v) {
        for (AttributeTypeEnumeration c: AttributeTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
