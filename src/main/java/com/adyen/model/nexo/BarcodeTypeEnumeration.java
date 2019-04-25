
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BarcodeTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BarcodeTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EAN8"/>
 *     &lt;enumeration value="EAN13"/>
 *     &lt;enumeration value="UPCA"/>
 *     &lt;enumeration value="Code25"/>
 *     &lt;enumeration value="Code128"/>
 *     &lt;enumeration value="PDF417"/>
 *     &lt;enumeration value="QRCODE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BarcodeTypeEnumeration")
@XmlEnum
public enum BarcodeTypeEnumeration {

    @XmlEnumValue("EAN8")
    EAN_8("EAN8"),
    @XmlEnumValue("EAN13")
    EAN_13("EAN13"),
    UPCA("UPCA"),
    @XmlEnumValue("Code25")
    CODE_25("Code25"),
    @XmlEnumValue("Code128")
    CODE_128("Code128"),
    @XmlEnumValue("PDF417")
    PDF_417("PDF417"),
    QRCODE("QRCODE");
    private final String value;

    BarcodeTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BarcodeTypeEnumeration fromValue(String v) {
        for (BarcodeTypeEnumeration c: BarcodeTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
