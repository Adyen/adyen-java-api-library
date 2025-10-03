package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Type of content. */
public enum ContentType {

  /**
   * Generic, non cryptographic, or unqualified data content - (OID: iso(1) member-body(2) us(840)
   * rsadsi(113549) pkcs(1) pkcs7(7) 1)
   */
  ID_DATA("id-data"),

  /**
   * Signature CMS data content - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1)
   * pkcs7(7) 2)
   */
  ID_SIGNED_DATA("id-signedData"),

  /**
   * Encrypted CMS data content, with encryption key - (OID: iso(1) member-body(2) us(840)
   * rsadsi(113549) pkcs(1) pkcs7(7) 3)
   */
  ID_ENVELOPED_DATA("id-envelopedData"),

  /**
   * Message digest CMS data content - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1)
   * pkcs7(7) 5)
   */
  ID_DIGESTED_DATA("id-digestedData"),

  /**
   * Encrypted CMS data content - (OID: iso(1) member-body(2) us(840) rsadsi(113549) pkcs(1)
   * pkcs7(7) 6)
   */
  ID_ENCRYPTED_DATA("id-encryptedData"),

  /**
   * MAC CMS data content, with encryption key - (OID: iso(1) member- body(2) us(840) rsadsi(113549)
   * pkcs(1) pkcs9(9) smime(16) ct(1) 2)
   */
  ID_CT_AUTH_DATA("id-ct-authData");

  private final String value;

  ContentType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the ContentType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a ContentType from a string value.
   *
   * @param v the string value
   * @return the corresponding ContentType
   */
  @JsonCreator
  public static ContentType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
