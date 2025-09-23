package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Location on the Earth specified by two numbers representing vertical and horizontal position.
 */
@JsonPropertyOrder({"Latitude", "Longitude"})
public class GeographicCoordinates {

  @JsonProperty("Latitude")
  @Schema(
      description = "Angular distance of a location on the earth south or north of the equator.")
  protected String latitude;

  @JsonProperty("Longitude")
  @Schema(
      description =
          "Angular measurement of the distance of a location on the earth east or west of the Greenwich observatory.")
  protected String longitude;

  /**
   * Gets latitude.
   *
   * @return the latitude
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * Sets latitude.
   *
   * @param latitude the latitude
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * Gets longitude.
   *
   * @return the longitude
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * Sets longitude.
   *
   * @param longitude the longitude
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }
}