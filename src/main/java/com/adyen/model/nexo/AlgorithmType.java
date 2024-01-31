package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for AlgorithmType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="AlgorithmType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="id-retail-cbc-mac"/&gt;
 *     &lt;enumeration value="id-retail-cbc-mac-sha-256"/&gt;
 *     &lt;enumeration value="id-ukpt-wrap "/&gt;
 *     &lt;enumeration value="id-dukpt-wrap"/&gt;
 *     &lt;enumeration value="des-ede3-ecb"/&gt;
 *     &lt;enumeration value="des-ede3-cbc"/&gt;
 *     &lt;enumeration value="id-sha256"/&gt;
 *     &lt;enumeration value="sha256WithRSAEncryption"/&gt;
 *     &lt;enumeration value="rsaEncryption"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "AlgorithmType")
@XmlEnum
public enum AlgorithmType {


    /**
     * Retail CBC-MAC (cf. ISO 9807, ANSI X9.19) - (OID: iso(1) member-body(2) fr(250) type-org (1) gie-cb(79) algorithm(10) epas(1) 2)
     */
    @XmlEnumValue("id-retail-cbc-mac")
    ID_RETAIL_CBC_MAC("id-retail-cbc-mac"),

    /**
     * Retail-CBC-MAC with SHA-256  - (OID: iso(1) member-body(2) fr(250) type-org (1) gie-cb(79) algorithm(10) epas(1) 3)
     */
    @XmlEnumValue("id-retail-cbc-mac-sha-256")
    ID_RETAIL_CBC_MAC_SHA_256("id-retail-cbc-mac-sha-256"),

    /**
     * The UKPT or Master Session Key key encryption - (OID: iso(1) member-body(2) fr(250) type-org (1) gie-cb(79) algorithm(10) epas(1) 4)
     */
    @XmlEnumValue("id-ukpt-wrap ")
    ID_UKPT_WRAP("id-ukpt-wrap "),

    /**
     * DUKPT is specified in ANS X9.24-2004, Annex A, and ISO/DIS 13492-2006.  - (OID: iso(1) member-body(2) fr(250) type-org (1) gie-cb(79) algorithm(10) epas(1) 1)
     */
    @XmlEnumValue("id-dukpt-wrap")
    ID_DUKPT_WRAP("id-dukpt-wrap"),

    /**
     * Triple DES ECB encryption with double length key (112 Bit) as defined in FIPS PUB 46-3 - (OID: iso(1) member-body(2) fr(250) type-org (1) gie-cb(79)
     */
    @XmlEnumValue("des-ede3-ecb")
    DES_EDE_3_ECB("des-ede3-ecb"),

    /**
     * Triple DES CBC encryption with double length key (112 Bit) as defined in FIPS PUB 46-3 - (OID: iso(1) member-body(2) us(840) rsadsi(113549)
     */
    @XmlEnumValue("des-ede3-cbc")
    DES_EDE_3_CBC("des-ede3-cbc"),

    /**
     * Message Digest Algorithm SHA-256 as defined in FIPS 180-1 and 2 - (ISO20022 Label: SHA256)
     */
    @XmlEnumValue("id-sha256")
    ID_SHA_256("id-sha256"),

    /**
     * Signature Algorithms SHA-256 with RSA - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1) pkcs-1(1) 11)
     */
    @XmlEnumValue("sha256WithRSAEncryption")
    SHA_256_WITH_RSA_ENCRYPTION("sha256WithRSAEncryption"),

    /**
     * Key Transport Algorithm RSA - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1) pkcs-1(1) 1)
     */
    @XmlEnumValue("rsaEncryption")
    RSA_ENCRYPTION("rsaEncryption");
    private final String value;

    AlgorithmType(String v) {
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
     * From value algorithm type.
     *
     * @param v the v
     * @return the algorithm type
     */
    public static AlgorithmType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
