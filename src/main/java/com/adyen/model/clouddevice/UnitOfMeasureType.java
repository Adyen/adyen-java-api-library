package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

public enum UnitOfMeasureType {

  /** Case or Carton */
  @Schema(description = "Case or Carton")
  CASE("Case"),

  /** Foot */
  @Schema(description = "Foot")
  FOOT("Foot"),

  /** Gallon (UK) */
  @Schema(description = "Gallon (UK)")
  UK_GALLON("UKGallon"),

  /** Gallon (US) */
  @Schema(description = "Gallon (US)")
  US_GALLON("USGallon"),

  /** Gram */
  @Schema(description = "Gram")
  GRAM("Gram"),

  /** Inch */
  @Schema(description = "Inch")
  INCH("Inch"),

  /** Kilogram */
  @Schema(description = "Kilogram")
  KILOGRAM("Kilogram"),

  /** Pound */
  @Schema(description = "Pound")
  POUND("Pound"),

  /** Meter */
  @Schema(description = "Meter")
  METER("Meter"),

  /** Centimetre */
  @Schema(description = "Centimetre")
  CENTIMETRE("Centimetre"),

  /** Litre */
  @Schema(description = "Litre")
  LITRE("Litre"),

  /** Centilitre */
  @Schema(description = "Centilitre")
  CENTILITRE("Centilitre"),

  /** Ounce */
  @Schema(description = "Ounce")
  OUNCE("Ounce"),

  /** Quart */
  @Schema(description = "Quart")
  QUART("Quart"),

  /** Pint */
  @Schema(description = "Pint")
  PINT("Pint"),

  /** Mile */
  @Schema(description = "Mile")
  MILE("Mile"),

  /** Kilometre */
  @Schema(description = "Kilometre")
  KILOMETRE("Kilometre"),

  /** Yard */
  @Schema(description = "Yard")
  YARD("Yard"),

  /** Other unit than the previous one */
  @Schema(description = "Other unit than the previous one")
  OTHER("Other");
  private final String value;

  UnitOfMeasureType(String v) {
    value = v;
  }

  /**
   * Value string.
   *
   * @return the string
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the UnitOfMeasureType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static UnitOfMeasureType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
