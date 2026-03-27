package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for OutputFormatType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="OutputFormatType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MessageRef"/&gt;
 *     &lt;enumeration value="Text"/&gt;
 *     &lt;enumeration value="XHTML"/&gt;
 *     &lt;enumeration value="BarCode"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum OutputFormatType {

  /**
   * Predefined messageType (of any format) on the POI or the Sale. The output is then a
   * PredefinedContent data structure.
   */
  @SerializedName("MessageRef")
  @Schema(
      description =
          "Predefined message (of any format) on the POI or the Sale. The output is then a PredefinedContent data structure. ")
  MESSAGE_REF("MessageRef"),

  /**
   * Text messageType including control characters prefixed by an escape character. The
   * DisplayOutput is then an OutputText data structure.
   */
  @SerializedName("Text")
  @Schema(
      description =
          "Text message including control characters prefixed by an escape character. The DisplayOutput is then an OutputText data structure.")
  TEXT("Text"),

  /** DisplayOutput uses the eXtensible HyperText Markup Language. */
  @SerializedName("XHTML")
  @Schema(description = "DisplayOutput uses the eXtensible HyperText Markup Language.")
  XHTML("XHTML"),

  /** Barcode type to print The output is then a OutputBarCode data structure. */
  @SerializedName("BarCode")
  @Schema(description = "Barcode type to print The output is then a OutputBarCode data structure.")
  BAR_CODE("BarCode");
  private final String value;

  OutputFormatType(String v) {
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
   * @return the OutputFormatType, or {@code null} if no match is found.
   */
  public static OutputFormatType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
