package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of output format. */
public enum OutputFormatType {

  /**
   * Predefined messageType (of any format) on the POI or the Sale. The output is then a
   * PredefinedContent data structure.
   */
  @Schema(
      description =
          "Predefined message (of any format) on the POI or the Sale. The output is then a PredefinedContent data structure. ")
  MESSAGE_REF("MessageRef"),

  /**
   * Text messageType including control characters prefixed by an escape character. The
   * DisplayOutput is then an OutputText data structure.
   */
  @Schema(
      description =
          "Text message including control characters prefixed by an escape character. The DisplayOutput is then an OutputText data structure.")
  TEXT("Text"),

  /** DisplayOutput uses the eXtensible HyperText Markup Language. */
  @Schema(description = "DisplayOutput uses the eXtensible HyperText Markup Language.")
  XHTML("XHTML"),

  /** Barcode type to print The output is then a OutputBarCode data structure. */
  @Schema(description = "Barcode type to print The output is then a OutputBarCode data structure.")
  BAR_CODE("BarCode");

  private final String value;

  OutputFormatType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the OutputFormatType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a OutputFormatType from a string value.
   *
   * @param v the string value
   * @return the corresponding OutputFormatType
   */
  @JsonCreator
  public static OutputFormatType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}