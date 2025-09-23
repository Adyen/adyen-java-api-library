package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Type of attribute of a distinguished name. */
public enum AttributeType {

  /** Common Name - (OID: joint-iso-ccitt(2) ds(5) 4 3) */
  ID_AT_COMMON_NAME("id-at-commonName"),

  /** Locality - (OID: joint-iso-ccitt(2) ds(5) 4 7) */
  ID_AT_LOCALITY_NAME("id-at-localityName"),

  /** Organization Name - (OID: joint-iso-ccitt(2) ds(5) 4 10) */
  ID_AT_ORGANIZATION_NAME("id-at-organizationName"),

  /** Organization Unit Name - (OID: joint-iso-ccitt(2) ds(5) 4 11) */
  ID_AT_ORGANIZATIONAL_UNIT_NAME("id-at-organizationalUnitName"),

  /** Country Name - (OID: joint-iso-ccitt(2) ds(5) 4 6) */
  ID_AT_COUNTRY_NAME("id-at-countryName");

  private final String value;

  AttributeType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the AttributeType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates an AttributeType from a string value.
   *
   * @param v the string value
   * @return the corresponding AttributeType
   */
  @JsonCreator
  public static AttributeType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}