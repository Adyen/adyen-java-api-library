
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrackFormatEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackFormatEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ISO"/>
 *     &lt;enumeration value="JIS-I"/>
 *     &lt;enumeration value="JIS-II"/>
 *     &lt;enumeration value="AAMVA"/>
 *     &lt;enumeration value="CMC-7"/>
 *     &lt;enumeration value="E-13B"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackFormatEnumeration")
@XmlEnum
public enum TrackFormatEnumeration {


    /**
     * ISO card track format - ISO 7813 - ISO 4909
     * 
     */
    ISO("ISO"),

    /**
     * Japenese track format I
     * 
     */
    @XmlEnumValue("JIS-I")
    JIS_I("JIS-I"),

    /**
     * Japenese track format II
     * 
     */
    @XmlEnumValue("JIS-II")
    JIS_II("JIS-II"),

    /**
     * American driver license
     * 
     */
    AAMVA("AAMVA"),

    /**
     * ((Magnetic Ink Character Recognition, using the CMC-7 font - ISO 1004) Line at the bottom of a check containing the bank account and the check number.
     * 
     */
    @XmlEnumValue("CMC-7")
    CMC_7("CMC-7"),

    /**
     * (Magnetic Ink Character Recognition, using the E-13B font) Line at the bottom of a check containing the bank account and the check number.
     * 
     */
    @XmlEnumValue("E-13B")
    E_13_B("E-13B");
    private final String value;

    TrackFormatEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TrackFormatEnumeration fromValue(String v) {
        for (TrackFormatEnumeration c: TrackFormatEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
