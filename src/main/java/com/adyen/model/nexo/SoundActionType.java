package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;

/**
 * Java class for SoundActionType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="SoundActionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="StartSound"/&gt;
 *     &lt;enumeration value="StopSound"/&gt;
 *     &lt;enumeration value="SetDefaultVolume"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
public enum SoundActionType {

  /** Start the sound as specified in the messageType. */
  @SerializedName("StartSound")
  @Schema(description = "Start the sound as specified in the message.")
  START_SOUND("StartSound"),

  /** Stop the sound in progress. */
  @SerializedName("StopSound")
  @Schema(description = "Stop the sound in progress.")
  STOP_SOUND("StopSound"),

  /** Set the default volume of sounds. */
  @SerializedName("SetDefaultVolume")
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
  public String value() {
    return value;
  }

  /**
   * Returns the enum constant matching the given string, or {@code null} if no match is found.
   *
   * @param v string value
   * @return the SoundActionType, or {@code null} if no match is found.
   */
  public static SoundActionType fromValue(String v) {
    return Arrays.stream(values()).filter(s -> s.value.equals(v)).findFirst().orElse(null);
  }
}
