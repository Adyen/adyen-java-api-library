
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContentTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContentTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="id-data"/>
 *     &lt;enumeration value="id-signedData"/>
 *     &lt;enumeration value="id-envelopedData"/>
 *     &lt;enumeration value="id-digestedData"/>
 *     &lt;enumeration value="id-encryptedData"/>
 *     &lt;enumeration value="id-ct-authData"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ContentTypeEnumeration")
@XmlEnum
public enum ContentTypeEnumeration {


    /**
     * Generic, non cryptographic, or unqualified data content - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1) pkcs7(7) 1)
     * 
     */
    @XmlEnumValue("id-data")
    ID_DATA("id-data"),

    /**
     * Signature CMS data content  - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1) pkcs7(7) 2)
     * 
     */
    @XmlEnumValue("id-signedData")
    ID_SIGNED_DATA("id-signedData"),

    /**
     * Encrypted CMS data content, with encryption key - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1) pkcs7(7) 3)
     * 
     */
    @XmlEnumValue("id-envelopedData")
    ID_ENVELOPED_DATA("id-envelopedData"),

    /**
     * Message digest CMS data content - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1) pkcs7(7) 5)
     * 
     */
    @XmlEnumValue("id-digestedData")
    ID_DIGESTED_DATA("id-digestedData"),

    /**
     * Encrypted CMS data content - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1) pkcs7(7) 6)
     * 
     */
    @XmlEnumValue("id-encryptedData")
    ID_ENCRYPTED_DATA("id-encryptedData"),

    /**
     * MAC CMS data content, with encryption key - (OID: iso(1) member- body(2) us(840) rsadsi(113549) pkcs(1) pkcs9(9) smime(16) ct(1) 2)
     * 
     */
    @XmlEnumValue("id-ct-authData")
    ID_CT_AUTH_DATA("id-ct-authData");
    private final String value;

    ContentTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContentTypeEnumeration fromValue(String v) {
        for (ContentTypeEnumeration c: ContentTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
