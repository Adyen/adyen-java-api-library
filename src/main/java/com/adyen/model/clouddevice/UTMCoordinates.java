package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class UTMCoordinates {

  /** The Utm zone. */
  @JsonProperty("UTMZone")
  @Schema(
      description =
          "UTM grid zone combination of the longitude zone (1 to 60) and the latitude band (C to X, excluding I and O).")
  protected String utmZone;

  /** The Utm eastward. */
  @JsonProperty("UTMEastward")
  @Schema(description = "X-coordinate of the Universal Transverse Mercator coordinate system.")
  protected String utmEastward;

  /** The Utm northward. */
  @JsonProperty("UTMNorthward")
  @Schema(description = "Y-coordinate of the Universal Transverse Mercator coordinate system.")
  protected String utmNorthward;

  /**
   * Gets the value of the utmZone property.
   *
   * @return possible object is {@link String }
   */
  public String getUTMZone() {
    return utmZone;
  }

  /**
   * Sets the value of the utmZone property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUTMZone(String value) {
    this.utmZone = value;
  }

  /**
   * Gets the value of the utmEastward property.
   *
   * @return possible object is {@link String }
   */
  public String getUTMEastward() {
    return utmEastward;
  }

  /**
   * Sets the value of the utmEastward property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUTMEastward(String value) {
    this.utmEastward = value;
  }

  /**
   * Gets the value of the utmNorthward property.
   *
   * @return possible object is {@link String }
   */
  public String getUTMNorthward() {
    return utmNorthward;
  }

  /**
   * Sets the value of the utmNorthward property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUTMNorthward(String value) {
    this.utmNorthward = value;
  }
}
