package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/** Type of response mode. */
public enum ResponseModeType {

  /** The Message Response is not required, except in case of error. */
  @Schema(description = "The Message Response is not required, except in case of error.")
  NOT_REQUIRED("NotRequired"),

  /** The Message Response is immediate, after taking into account the request. */
  @Schema(description = "The Message Response is immediate, after taking into account the request.")
  IMMEDIATE("Immediate"),

  /** The Print Response is required at the end of print. */
  @Schema(description = "The Print Response is required at the end of print.")
  PRINT_END("PrintEnd"),

  /** The Sound Response is required at the end of play. */
  @Schema(description = "The Sound Response is required at the end of play.")
  SOUND_END("SoundEnd");

  private final String value;

  ResponseModeType(String v) {
    value = v;
  }

  /**
   * Returns the string representation of the ResponseModeType.
   *
   * @return the string value
   */
  @JsonValue
  public String value() {
    return value;
  }

  /**
   * Creates a ResponseModeType from a string value.
   *
   * @param v the string value
   * @return the corresponding ResponseModeType
   */
  @JsonCreator
  public static ResponseModeType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}