package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignaturePoint {

  /** The X. */
  @JsonProperty("X")
  @Schema(description = "Abscissa of a point coordinates.")
  protected String x;

  /** The Y. */
  @JsonProperty("Y")
  @Schema(description = "Ordinate of a point coordinates.")
  protected String y;

  /**
   * Gets the value of the x property.
   *
   * @return possible object is {@link String }
   */
  public String getX() {
    return x;
  }

  /**
   * Sets the value of the x property.
   *
   * @param value allowed object is {@link String }
   */
  public void setX(String value) {
    this.x = value;
  }

  /**
   * Gets the value of the y property.
   *
   * @return possible object is {@link String }
   */
  public String getY() {
    return y;
  }

  /**
   * Sets the value of the y property.
   *
   * @param value allowed object is {@link String }
   */
  public void setY(String value) {
    this.y = value;
  }
}
