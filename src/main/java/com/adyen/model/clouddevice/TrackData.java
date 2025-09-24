package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class TrackData {

  @JsonProperty("TrackValue")
  @Schema(description = "Card track content", minLength = 1, maxLength = 104)
  protected String trackValue;

  @JsonProperty("TrackNumb")
  @Schema(description = "Card track number")
  protected Integer trackNumb;

  @JsonProperty("TrackFormat")
  @Schema(description = "Card track format")
  protected TrackFormatType trackFormat;

  /**
   * Gets the value of the trackValue property.
   *
   * @return possible object is {@link String }
   */
  public String getTrackValue() {
    return trackValue;
  }

  /**
   * Sets the value of the trackValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTrackValue(String value) {
    this.trackValue = value;
  }

  /**
   * Gets the value of the trackNumb property.
   *
   * @return possible object is {@link Integer }
   */
  public int getTrackNumb() {
    if (trackNumb == null) {
      return 2;
    } else {
      return trackNumb;
    }
  }

  /**
   * Sets the value of the trackNumb property.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setTrackNumb(Integer value) {
    this.trackNumb = value;
  }

  /**
   * Gets the value of the trackFormat property.
   *
   * @return possible object is {@link TrackFormatType }
   */
  public TrackFormatType getTrackFormat() {
    if (trackFormat == null) {
      return TrackFormatType.ISO;
    } else {
      return trackFormat;
    }
  }

  /**
   * Sets the value of the trackFormat property.
   *
   * @param value allowed object is {@link TrackFormatType }
   */
  public void setTrackFormat(TrackFormatType value) {
    this.trackFormat = value;
  }
}
