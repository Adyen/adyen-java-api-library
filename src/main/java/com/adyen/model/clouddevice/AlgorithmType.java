package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Type of cryptographic algorithm */
public enum AlgorithmType {

  /**
   * Retail CBC-MAC (cf. ISO 9807, ANSI X9.19) - (OID: iso(1) member-body(2) fr(250) type-org (1)
   * gie-cb(79) algorithm(10) epas(1) 2)
   */
  ID_RETAIL_CBC_MAC("id-retail-cbc-mac"),

  /**
   * Retail-CBC-MAC with SHA-256 - (OID: iso(1) member-body(2) fr(250) type-org (1) gie-cb(79)
   * algorithm(10) epas(1) 3)
   */
  ID_RETAIL_CBC_MAC_SHA_256("id-retail-cbc-mac-sha-256"),

  /**
   * The UKPT or Master Session Key key encryption - (OID: iso(1) member-body(2) fr(250) type-org
   * (1) gie-cb(79) algorithm(10) epas(1) 4)
   */
  ID_UKPT_WRAP("id-ukpt-wrap "),

  /**
   * DUKPT is specified in ANS X9.24-2004, Annex A, and ISO/DIS 13492-2006. - (OID: iso(1)
   * member-body(2) fr(250) type-org (1) gie-cb(79) algorithm(10) epas(1) 1)
   */
  ID_DUKPT_WRAP("id-dukpt-wrap"),

  /**
   * Triple DES ECB encryption with double length key (112 Bit) as defined in FIPS PUB 46-3 - (OID:
   * iso(1) member-body(2) fr(250) type-org (1) gie-cb(79)
   */
  DES_EDE_3_ECB("des-ede3-ecb"),

  /**
   * Triple DES CBC encryption with double length key (112 Bit) as defined in FIPS PUB 46-3 - (OID:
   * iso(1) member-body(2) us(840) rsadsi(113549)
   */
  DES_EDE_3_CBC("des-ede3-cbc"),

  /** Message Digest Algorithm SHA-256 as defined in FIPS 180-1 and 2 - (ISO20022 Label: SHA256) */
  ID_SHA_256("id-sha256"),

  /**
   * Signature Algorithms SHA-256 with RSA - (OID: iso(1) member-body(2) us(840) rsadsi(113549)
   * pkcs(1) pkcs-1(1) 11)
   */
  SHA_256_WITH_RSA_ENCRYPTION("sha256WithRSAEncryption"),

  /**
   * Key Transport Algorithm RSA - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1)
   * pkcs-1(1) 1)
   */
  RSA_ENCRYPTION("rsaEncryption");

  private final String value;

  AlgorithmType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the AlgorithmType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates an AlgorithmType from a string value.
   *
   * @param v the string value
   * @return the corresponding AlgorithmType
   */
  @JsonCreator
  public static AlgorithmType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}