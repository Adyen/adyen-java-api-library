package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

public enum SoundFormatType {

  /** Preloaded sound File. */
  @Schema(description = "Preloaded sound File.")
  SOUND_REF("SoundRef"),

  /** Reference of a preloaded text to play. */
  @Schema(description = "Reference of a preloaded text to play.")
  MESSAGE_REF("MessageRef"),

  /** Text to play. */
  @Schema(description = "Text to play.")
  TEXT("Text");
  private final String value;

  SoundFormatType(String v) {
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
   * @return the SoundFormatType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static SoundFormatType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
