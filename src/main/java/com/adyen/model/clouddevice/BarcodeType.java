package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/** Type of barcode. */
public enum BarcodeType {

  /** Ean 8 barcode type. */
  EAN_8("EAN8"),
  /** Ean 13 barcode type. */
  EAN_13("EAN13"),
  /** Upca barcode type. */
  UPCA("UPCA"),
  /** Code 25 barcode type. */
  CODE_25("Code25"),
  /** Code 128 barcode type. */
  CODE_128("Code128"),
  /** Pdf 417 barcode type. */
  PDF_417("PDF417"),
  /** Qrcode barcode type. */
  QRCODE("QRCode");

  private final String value;

  BarcodeType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the BarcodeType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a BarcodeType from a string value.
   *
   * @param v the string value
   * @return the corresponding BarcodeType
   */
  @JsonCreator
  public static BarcodeType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
