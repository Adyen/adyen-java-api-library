package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for UnitOfMeasureType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="UnitOfMeasureType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Case"/&gt;
 *     &lt;enumeration value="Foot"/&gt;
 *     &lt;enumeration value="UKGallon"/&gt;
 *     &lt;enumeration value="USGallon"/&gt;
 *     &lt;enumeration value="Gram"/&gt;
 *     &lt;enumeration value="Inch"/&gt;
 *     &lt;enumeration value="Kilogram"/&gt;
 *     &lt;enumeration value="Pound"/&gt;
 *     &lt;enumeration value="Meter"/&gt;
 *     &lt;enumeration value="Centimetre"/&gt;
 *     &lt;enumeration value="Litre"/&gt;
 *     &lt;enumeration value="Centilitre"/&gt;
 *     &lt;enumeration value="Ounce"/&gt;
 *     &lt;enumeration value="Quart"/&gt;
 *     &lt;enumeration value="Pint"/&gt;
 *     &lt;enumeration value="Mile"/&gt;
 *     &lt;enumeration value="Kilometre"/&gt;
 *     &lt;enumeration value="Yard"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum UnitOfMeasureType {

  /** Case or Carton */
  @SerializedName("Case")
  @Schema(description = "Case or Carton")
  CASE("Case"),

  /** Foot */
  @SerializedName("Foot")
  @Schema(description = "Foot")
  FOOT("Foot"),

  /** Gallon (UK) */
  @SerializedName("UKGallon")
  @Schema(description = "Gallon (UK)")
  UK_GALLON("UKGallon"),

  /** Gallon (US) */
  @SerializedName("USGallon")
  @Schema(description = "Gallon (US)")
  US_GALLON("USGallon"),

  /** Gram */
  @SerializedName("Gram")
  @Schema(description = "Gram")
  GRAM("Gram"),

  /** Inch */
  @SerializedName("Inch")
  @Schema(description = "Inch")
  INCH("Inch"),

  /** Kilogram */
  @SerializedName("Kilogram")
  @Schema(description = "Kilogram")
  KILOGRAM("Kilogram"),

  /** Pound */
  @SerializedName("Pound")
  @Schema(description = "Pound")
  POUND("Pound"),

  /** Meter */
  @SerializedName("Meter")
  @Schema(description = "Meter")
  METER("Meter"),

  /** Centimetre */
  @SerializedName("Centimetre")
  @Schema(description = "Centimetre")
  CENTIMETRE("Centimetre"),

  /** Litre */
  @SerializedName("Litre")
  @Schema(description = "Litre")
  LITRE("Litre"),

  /** Centilitre */
  @SerializedName("Centilitre")
  @Schema(description = "Centilitre")
  CENTILITRE("Centilitre"),

  /** Ounce */
  @SerializedName("Ounce")
  @Schema(description = "Ounce")
  OUNCE("Ounce"),

  /** Quart */
  @SerializedName("Quart")
  @Schema(description = "Quart")
  QUART("Quart"),

  /** Pint */
  @SerializedName("Pint")
  @Schema(description = "Pint")
  PINT("Pint"),

  /** Mile */
  @SerializedName("Mile")
  @Schema(description = "Mile")
  MILE("Mile"),

  /** Kilometre */
  @SerializedName("Kilometre")
  @Schema(description = "Kilometre")
  KILOMETRE("Kilometre"),

  /** Yard */
  @SerializedName("Yard")
  @Schema(description = "Yard")
  YARD("Yard"),

  /** Other unit than the previous one */
  @SerializedName("Other")
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
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the UnitOfMeasureType, or {@code null} if no match is found.
   */
  public static UnitOfMeasureType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
