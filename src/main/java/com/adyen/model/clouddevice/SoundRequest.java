package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigInteger;

public class SoundRequest {

  /** The Sound content. */
  @JsonProperty("SoundContent")
  @Schema(
      description =
          "Content of the Sound to play. --Rule: Absent if SoundAction is SetDefaultVolume, otherwise mandatory.")
  protected SoundContent soundContent;

  /** The Response mode. */
  @JsonProperty("ResponseMode")
  @Schema(description = "Message response awaited by the initiator of the Request")
  protected ResponseModeType responseMode;

  /** The Sound action. */
  @JsonProperty("SoundAction")
  @Schema(description = "Type of action to perform on the sound.")
  protected SoundActionType soundAction;

  /** The Sound volume. */
  @JsonProperty("SoundVolume")
  @Schema(
      description =
          "Volume of a sound, either in a pourcentage of the maximum volume, or 0 to mute. --Rule: Mandatory if SoundAction is SetDefaultVolume")
  protected BigInteger soundVolume;

  /**
   * Gets the value of the soundContent property.
   *
   * @return possible object is {@link SoundContent }
   */
  public SoundContent getSoundContent() {
    return soundContent;
  }

  /**
   * Sets the value of the soundContent property.
   *
   * @param value allowed object is {@link SoundContent }
   */
  public void setSoundContent(SoundContent value) {
    this.soundContent = value;
  }

  /**
   * Gets the value of the responseMode property.
   *
   * @return possible object is {@link ResponseModeType }
   */
  public ResponseModeType getResponseMode() {
    if (responseMode == null) {
      return ResponseModeType.NOT_REQUIRED;
    } else {
      return responseMode;
    }
  }

  /**
   * Sets the value of the responseMode property.
   *
   * @param value allowed object is {@link ResponseModeType }
   */
  public void setResponseMode(ResponseModeType value) {
    this.responseMode = value;
  }

  /**
   * Gets the value of the soundAction property.
   *
   * @return possible object is {@link SoundActionType }
   */
  public SoundActionType getSoundAction() {
    return soundAction;
  }

  /**
   * Sets the value of the soundAction property.
   *
   * @param value allowed object is {@link SoundActionType }
   */
  public void setSoundAction(SoundActionType value) {
    this.soundAction = value;
  }

  /**
   * Gets the value of the soundVolume property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getSoundVolume() {
    return soundVolume;
  }

  /**
   * Sets the value of the soundVolume property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setSoundVolume(BigInteger value) {
    this.soundVolume = value;
  }
}
