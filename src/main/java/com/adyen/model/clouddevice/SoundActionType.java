package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum SoundActionType {

  /** Start the sound as specified in the messageType. */
  @Schema(description = "Start the sound as specified in the message.")
  START_SOUND("StartSound"),

  /** Stop the sound in progress. */
  @Schema(description = "Stop the sound in progress.")
  STOP_SOUND("StopSound"),

  /** Set the default volume of sounds. */
  @Schema(description = "Set the default volume of sounds.")
  SET_DEFAULT_VOLUME("SetDefaultVolume");
  private final String value;

  SoundActionType(String v) {
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
   * @return the SoundActionType, or {@code null} if no match is found.
   */
  @JsonCreator
  public static SoundActionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
