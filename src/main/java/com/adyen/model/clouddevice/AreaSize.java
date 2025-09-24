package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/** Size of an area. */
public class AreaSize {

  @JsonProperty("X")
  @Schema(description = "Abscissa of a point coordinates.")
  protected String x;

  @JsonProperty("Y")
  @Schema(description = "Ordinate of a point coordinates.")
  protected String y;

  /**
   * Gets x.
   *
   * @return the x
   */
  public String getX() {
    return x;
  }

  /**
   * Sets x.
   *
   * @param x the x
   */
  public void setX(String x) {
    this.x = x;
  }

  /**
   * Gets y.
   *
   * @return the y
   */
  public String getY() {
    return y;
  }

  /**
   * Sets y.
   *
   * @param y the y
   */
  public void setY(String y) {
    this.y = y;
  }
}
